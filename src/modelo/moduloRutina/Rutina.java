package modelo.moduloRutina;

import java.util.List;

import modelo.Entrenamiento;
import modelo.enums.Dia;
import modelo.moduloObjetivo.ObjetivoStrategy;
import modelo.Entrenamiento;

public class Rutina {
	private ObjetivoStrategy objetivo;
	private List<Entrenamiento> entrenamientos;
	private List<Dia> dias;
	private int diaActual;
	private int semanas;

	public Rutina(ObjetivoStrategy objetivo, List<Dia> dias) {
		this.objetivo = objetivo;
		this.dias = dias;
	}

	public void reforzarRutina() {
		if (semanas == 0) {
			// cambiar valores de peso,series y repeticiones 
			for (Entrenamiento ent : entrenamientos) {
				ent.reforzarEntrenamiento();
			}
			semanas += 4;
		}
	}

	public Entrenamiento entrenamientoDiario() {
		Entrenamiento ent = entrenamientos.remove(diaActual);
		return ent;
	}

	

	public void comenzarDia() {
		this.diaActual += 1;


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

	public String toString() {
		return "Rutina [objetivo=" + objetivo + ", entrenamientos=" + entrenamientos + ", dias=" + dias + ", diaEntre="
				+ diaActual + ", semanas=" + semanas + "]";
	}
}