package apifechas.services;

import java.io.BufferedWriter;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.time.LocalDate;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import apifechas.models.Periodo;

@Service("apiFechaServiceImpl")
public class ApiFechaServiceImpl implements IApiFechaService {

	@Autowired
	RestTemplate restTemplate;

	@Bean
	public RestTemplate rest() {
		return new RestTemplate();
	}

	@Override
	public Periodo generarFechasFaltantes() {
		Periodo periodo = restTemplate.getForObject("http://127.0.0.1:8080/periodos/api", Periodo.class);
		LocalDate fechaActual = periodo.getFechaCreacion();
		do {
			if (!periodo.getFechas().contains(fechaActual)) {
				periodo.getFechasFaltantes().add(fechaActual);
			}
			fechaActual = fechaActual.plusMonths(1);
		} while (fechaActual.isBefore(periodo.getFechaFin().plusMonths(1)));
		escribirFichero(periodo);

		return periodo;
	}

	private void escribirFichero(Periodo periodo) {
		Gson gson = new GsonBuilder().setPrettyPrinting().create();
		Path path = Paths.get("outputfile.json");
		try (BufferedWriter br = Files.newBufferedWriter(path, Charset.defaultCharset(), StandardOpenOption.CREATE)) {
			br.write(gson.toJson(periodo));
			br.newLine();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
