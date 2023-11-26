package modelo;

import java.util.ArrayList;
import java.util.List;

import control.ControladorEjercicio;
import modelo.enums.Exigencia;
import modelo.enums.GrupoMuscular;
import modelo.moduloObjetivo.ObjetivoStrategy;


public class Entrenamiento {
	private ObjetivoStrategy objetivo;
	private List<Ejercicio> ejercicios;

	public Entrenamiento(ObjetivoStrategy objetivo) {
		this.objetivo = objetivo;
	}

	public void reforzarEntrenamiento(){
		for (Ejercicio ejercicio : ejercicios) {
			ejercicio.setSeries(ejercicio.getSeries() + 1);
			ejercicio.setRepeticiones(ejercicio.getRepeticiones() + 4);
			ejercicio.setPesoAsignado(ejercicio.getPesoAsignado() + 5);
		}
	
	}

	public ObjetivoStrategy getObjetivo() {
		return objetivo;
	}
	public void asignarEjercicios(){
		ejercicios = new ArrayList<Ejercicio>();
			switch (objetivo.getClass().getSimpleName()) {
            case "Tonificar":
				for (Ejercicio ejercicio : ControladorEjercicio.ejercicios) {
					if(ejercicio.getNivelAerobico() <=4 && ejercicio.getExigenciaMuscular() == Exigencia.ALTA && !estaGrupo(ejercicio.getGrupoMuscular())){
						ejercicios.add(ejercicio);
					}
				}
            case "BajarPeso":
				for (Ejercicio ejercicio : ControladorEjercicio.ejercicios) {
					if((ejercicio.getNivelAerobico() >=3 && !estaGrupo(ejercicio.getGrupoMuscular()))){
						ejercicios.add(ejercicio);
					}
				}

            case "Mantener":
				for (Ejercicio ejercicio : ControladorEjercicio.ejercicios) {
					if(((ejercicio.getNivelAerobico() >=2 || ejercicio.getNivelAerobico() <=4)  && (ejercicio.getExigenciaMuscular() == Exigencia.MEDIA || ejercicio.getExigenciaMuscular() == Exigencia.BAJA) && !estaGrupo(ejercicio.getGrupoMuscular()))){
						ejercicios.add(ejercicio);
					}
				}
            
		}

	}

	private boolean estaGrupo(GrupoMuscular grupoMuscular) {
		for (Ejercicio ejercicio : ejercicios) {
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
		return ejercicios;
	}

	public void setEjercicios(List<Ejercicio> ejercicios) {
		this.ejercicios = ejercicios;
	} 
}