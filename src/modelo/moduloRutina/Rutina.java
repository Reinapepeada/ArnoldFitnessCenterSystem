package modelo.moduloRutina;

import java.util.List;

import modelo.Entrenamiento;
import modelo.Enums.Dia;
import modelo.moduloObjetivo.ObjetivoStrategy;

public class Rutina {
	private ObjetivoStrategy objetivo;
	private List<Entrenamiento> entrenamientos;
	private List<Dia> dias;
	private int semanas;

	public Rutina(ObjetivoStrategy objetivo,List<Dia> dias) {
		this.objetivo = objetivo;
		this.semanas = 4;
		this.dias = dias;
	}

	public void reforzarRutina() {
		if(this.semanas == 0){
			this.semanas +=4;
		}
	}

	public Entrenamiento entrenamientoDiario() {
		return entrenamientos.remove(0);
	}

	public void registrarEjercicio(
			int series,
			int repeticiones,
			float peso,
			boolean completado) {
				
	}

	public void comenzarDia() {
		// TODO - implement Rutina.comenzarDia

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