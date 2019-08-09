package apifechas.controllers;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import apifechas.models.Periodo;
import apifechas.services.IApiFechaService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

@RestController
@RequestMapping("/apiFecha")
@Api(tags = "Apis de Fechas", description = "Metodos para consultar periodos")
public class ApiFechaController {

	@Autowired
	@Qualifier("apiFechaServiceImpl")
	private IApiFechaService apiFechaService;

	@GetMapping("/generarFechasFaltantes/")
	@ApiOperation(value = "Servicio de Obtener Periodos Faltantes", notes = "Retorna entrada y periodos faltantes")
	@ApiResponses({ @ApiResponse(code = HttpServletResponse.SC_OK, message = "OK"),
			@ApiResponse(code = HttpServletResponse.SC_INTERNAL_SERVER_ERROR, message = "INTERNAL ERROR SERVER"),
			@ApiResponse(code = HttpServletResponse.SC_UNAUTHORIZED, message = "UNAUTHORIZED"),
			@ApiResponse(code = HttpServletResponse.SC_FORBIDDEN, message = "FORBIDDEN"),
			@ApiResponse(code = HttpServletResponse.SC_NOT_FOUND, message = "ELEMENTO NOT FOUND") })
	public ResponseEntity<Periodo> fechasFaltantes() {
		Periodo periodo = this.apiFechaService.generarFechasFaltantes();
		if (periodo == null) {
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		}
		return new ResponseEntity<>(periodo, HttpStatus.OK);
	}

}
