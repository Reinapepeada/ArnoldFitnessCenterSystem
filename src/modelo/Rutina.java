package modelo;

import java.util.List;

import datos.Dia;
import modelo.objetivo.ObjetivoStrategy;

public class Rutina {
	private ObjetivoStrategy objetivo;
	private List<Entrenamiento> entrenamientos;
	private List<Dia> dias;
	private int semanas;

	public Rutina(ObjetivoStrategy objetivo) {
		this.objetivo = objetivo;
	}

	public void reforzarRutina() {
	}

	public Entrenamiento entrenamientoDiario() {
		return null;
	}

	public void registrarEjercicio(
			int series,
			int repeticiones,
			float peso,
			boolean completado) {
	}

	public void comenzarDia() {
	}

	public ObjetivoStrategy getObjetivo() {
		return objetivo;
	}

	public void setObjetivo(ObjetivoStrategy objetivo) {
		this.objetivo = objetivo;
	}

	public List<Entrenamiento> getEntrenamientos() {
		return entrenamientos;
	}

	public void setEntrenamientos(List<Entrenamiento> entrenamientos) {
		this.entrenamientos = entrenamientos;
	}

	public List<Dia> getDias() {
		return dias;
	}

	public void setDias(List<Dia> dias) {
		this.dias = dias;
	}

	public int getSemanas() {
		return semanas;
	}

	public void setSemanas(int semanas) {
		this.semanas = semanas;
	}
}