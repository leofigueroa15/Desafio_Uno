package apifechas.models;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Periodo implements Serializable {

	private static final long serialVersionUID = 1L;

	private Long id = null;

	private LocalDate fechaCreacion = null;

	private LocalDate fechaFin = null;

	private List<LocalDate> fechas = null;

	private List<LocalDate> fechasFaltantes = null;

	public Periodo() {

	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Periodo fechaCreacion(LocalDate fechaCreacion) {
		this.fechaCreacion = fechaCreacion;
		return this;
	}

	public LocalDate getFechaCreacion() {
		return fechaCreacion;
	}

	public void setFechaCreacion(LocalDate fechaCreacion) {
		this.fechaCreacion = fechaCreacion;
	}

	public Periodo fechaFin(LocalDate fechaFin) {
		this.fechaFin = fechaFin;
		return this;
	}

	public LocalDate getFechaFin() {
		return fechaFin;
	}

	public void setFechaFin(LocalDate fechaFin) {
		this.fechaFin = fechaFin;
	}

	public Periodo fechas(List<LocalDate> fechas) {
		this.fechas = fechas;
		return this;
	}

	public Periodo addFechasItem(LocalDate fechasItem) {
		if (this.fechas == null) {
			this.fechas = new ArrayList<>();
		}
		this.fechas.add(fechasItem);
		return this;
	}

	public List<LocalDate> getFechas() {
		return fechas;
	}

	public void setFechas(List<LocalDate> fechas) {
		this.fechas = fechas;
	}

	public List<LocalDate> getFechasFaltantes() {
		if (fechasFaltantes == null) {
			fechasFaltantes = new ArrayList<>();
		}
		return fechasFaltantes;
	}

	public void setFechasFaltantes(List<LocalDate> fechasFaltantes) {
		this.fechasFaltantes = fechasFaltantes;
	}

}
