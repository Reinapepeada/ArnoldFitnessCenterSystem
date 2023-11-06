package modelo;

import java.util.List;

import datos.GrupoMuscular;
import modelo.objetivo.ObjetivoStrategy;

public class Entrenamiento {
	private ObjetivoStrategy objetivo;
	private List<Ejercicio> ejercicios;
	private GrupoMuscular grupoMuscular;

	public Entrenamiento(
			ObjetivoStrategy objetivo,
			List<Ejercicio> ejercicios,
			GrupoMuscular grupoMuscular) {
		this.objetivo = objetivo;
		this.ejercicios = ejercicios;
		this.grupoMuscular = grupoMuscular;
	}

	public ObjetivoStrategy getObjetivo() {
		return objetivo;
	}

	public void setObjetivo(ObjetivoStrategy objetivo) {
		this.objetivo = objetivo;
	}

	public List<Ejercicio> getEjercicios() {
		return ejercicios;
	}

	public void setEjercicios(List<Ejercicio> ejercicios) {
		this.ejercicios = ejercicios;
	}

	public GrupoMuscular getGrupoMuscular() {
		return grupoMuscular;
	}

	public void setGrupoMuscular(GrupoMuscular grupoMuscular) {
		this.grupoMuscular = grupoMuscular;
	}

}