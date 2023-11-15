package modelo;

import datos.Exigencia;
import datos.GrupoMuscular;

public class Ejercicio {
	private String nombre;
	private int nivelAerobico;
	private int duracion;
	private int series;
	private int repeticiones;
	private int pesoAsignado;
	private Exigencia exigenciaMuscular;
	private GrupoMuscular grupoMuscular;

	public Ejercicio(
			String nombre,
			int nivelAerobico,
			int duracion,
			int series,
			int repeticiones,
			int pesoAsignado,
			Exigencia exigenciaMuscular,
			GrupoMuscular grupoMuscular) {
		this.nombre = nombre;
		this.nivelAerobico = nivelAerobico;
		this.duracion = duracion;
		this.series = series;
		this.repeticiones = repeticiones;
		this.pesoAsignado = pesoAsignado;
		this.exigenciaMuscular = exigenciaMuscular;
		this.grupoMuscular = grupoMuscular;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public int getNivelAerobico() {
		return nivelAerobico;
	}

	public void setNivelAerobico(int nivelAerobico) {
		this.nivelAerobico = nivelAerobico;
	}

	public int getDuracion() {
		return duracion;
	}

	public void setDuracion(int duracion) {
		this.duracion = duracion;
	}

	public int getSeries() {
		return series;
	}

	public void setSeries(int series) {
		this.series = series;
	}

	public int getRepeticiones() {
		return repeticiones;
	}

	public void setRepeticiones(int repeticiones) {
		this.repeticiones = repeticiones;
	}

	public int getPesoAsignado() {
		return pesoAsignado;
	}

	public void setPesoAsignado(int pesoAsignado) {
		this.pesoAsignado = pesoAsignado;
	}

	public Exigencia getExigenciaMuscular() {
		return exigenciaMuscular;
	}

	public void setExigenciaMuscular(Exigencia exigenciaMuscular) {
		this.exigenciaMuscular = exigenciaMuscular;
	}

	public GrupoMuscular getGrupoMuscular() {
		return grupoMuscular;
	}

	public void setGrupoMuscular(GrupoMuscular grupoMuscular) {
		this.grupoMuscular = grupoMuscular;
	}
}