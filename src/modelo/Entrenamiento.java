package modelo;

import java.util.ArrayList;
import java.util.List;

import control.ControladorEjercicio;
import modelo.enums.Exigencia;
import modelo.enums.GrupoMuscular;
import modelo.moduloObjetivo.ObjetivoStrategy;
import modelo.moduloRutina.Rutina;

public class Entrenamiento {
	private ObjetivoStrategy objetivo;
	private List<Ejercicio> ejerciciosEntrenamiento;

	public Entrenamiento(ObjetivoStrategy objetivo) {
		this.objetivo = objetivo;
	}

	public ObjetivoStrategy getObjetivo() {
		return objetivo;
	}
	public void asignarEjercicios(){
		// TODO - implement Entrenamiento.asignarEjercicios
		ejerciciosEntrenamiento = new ArrayList<Ejercicio>();
		switch (objetivo.getClass().getSimpleName()) {
            case "Tonificar":
				for (Ejercicio ejercicio : ControladorEjercicio.ejercicios) {
					if(ejercicio.getNivelAerobico() <=4 && ejercicio.getExigenciaMuscular() == Exigencia.ALTA && !estaGrupo(ejercicio.getGrupoMuscular())){
						ejerciciosEntrenamiento.add(ejercicio);
					}
				}
            case "BajarPeso":
				for (Ejercicio ejercicio : ControladorEjercicio.ejercicios) {
					if((ejercicio.getNivelAerobico() >=3 && !estaGrupo(ejercicio.getGrupoMuscular()))){
						ejerciciosEntrenamiento.add(ejercicio);
					}
				}

            case "Mantener":
				for (Ejercicio ejercicio : ControladorEjercicio.ejercicios) {
					if(((ejercicio.getNivelAerobico() >=2 || ejercicio.getNivelAerobico() <=4)  && (ejercicio.getExigenciaMuscular() == Exigencia.MEDIA || ejercicio.getExigenciaMuscular() == Exigencia.BAJA) && !estaGrupo(ejercicio.getGrupoMuscular()))){
						ejerciciosEntrenamiento.add(ejercicio);
					}
				}
		}
	}

	private boolean estaGrupo(GrupoMuscular grupoMuscular) {
		for (Ejercicio ejercicio : ejerciciosEntrenamiento) {
			if(grupoMuscular == ejercicio.getGrupoMuscular()){
				return true;
			}
		}
		return false;
	}

	public void setObjetivo(ObjetivoStrategy objetivo) {
		this.objetivo = objetivo;
	}

	public List<Ejercicio> getEjercicios() {
		return ejerciciosEntrenamiento;
	}

	public void setEjercicios(List<Ejercicio> ejercicios) {
		this.ejerciciosEntrenamiento = ejercicios;
	} 
}