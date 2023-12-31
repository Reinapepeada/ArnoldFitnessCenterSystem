package modelo;

import java.util.ArrayList;
import java.util.List;

import control.ControladorEjercicio;
import modelo.enums.Exigencia;
import modelo.enums.GrupoMuscular;
import modelo.moduloObjetivo.ObjetivoStrategy;

public class Entrenamiento {
	private ObjetivoStrategy objetivo;
	private ArrayList<Ejercicio> ejerciciosEntrenamiento= new ArrayList<Ejercicio>();

	public Entrenamiento(ObjetivoStrategy objetivo) {
		this.objetivo = objetivo;
	}

	public void reforzarEntrenamiento() {
		for (Ejercicio ejercicio : ejerciciosEntrenamiento) {
			ejercicio.setSeries(ejercicio.getSeries() + 1);
			ejercicio.setRepeticiones(ejercicio.getRepeticiones() + 4);
			ejercicio.setPesoAsignado(ejercicio.getPesoAsignado() + 5);
		}

	}

	public ObjetivoStrategy getObjetivo() {
		return objetivo;
	}

	public void asignarEjerciciosPorMusculo(GrupoMuscular grupoMuscular) {
		// TODO - implement Entrenamiento.asignarEjercicios
		ejerciciosEntrenamiento = new ArrayList<Ejercicio>();
		//guardar en una
		for (Ejercicio ejercicio : ControladorEjercicio.ejercicios) {
			if (ejercicio.getNivelAerobico() >= objetivo.getnAerobicMin() 
				&& ejercicio.getNivelAerobico() <= objetivo.getnAerobicMax() 
				&& objetivo.getExigencia().contains(ejercicio.getExigenciaMuscular()) 
				&& ejercicio.getGrupoMuscular() == grupoMuscular) {
				ejerciciosEntrenamiento.add(ejercicio);
				System.out.println("Agregue Ejercicio por Musculo");
			}
			if (ejerciciosEntrenamiento.size() == 5) {
				break;
			}
		}

	}

	public void asignarEjerciciosMixtos() {
		// TODO - implement Entrenamiento.asignarEjercicios
		try{
			ejerciciosEntrenamiento = new ArrayList<Ejercicio>();
			for (Ejercicio ejercicio : ControladorEjercicio.ejercicios) {
				System.out.println("ejercicio.getNivelAerobico: "+ejercicio.getNivelAerobico());
				System.out.println("objetivo.getnAerobicMin(): "+ objetivo.getnAerobicMin());
				System.out.println("objetivo.getnAerobicMax(): "+ objetivo.getnAerobicMax());
				System.out.println("objetivo.getExigencia().contains(ejercicio.getExigenciaMuscular()): "+ objetivo.getExigencia().contains(ejercicio.getExigenciaMuscular()));
				System.out.println("!estaGrupo(ejercicio.getGrupoMuscular()): "+ !estaGrupo(ejercicio.getGrupoMuscular()));
				if (ejercicio.getNivelAerobico() >= objetivo.getnAerobicMin()
					&& ejercicio.getNivelAerobico() <= objetivo.getnAerobicMax()
					&& objetivo.getExigencia().contains(ejercicio.getExigenciaMuscular())
					&& !estaGrupo(ejercicio.getGrupoMuscular())) {
					ejerciciosEntrenamiento.add(ejercicio);
					System.out.println("Agregue Ejercicio Mixto");
				}
			}
		}catch(Exception e){
			throw new RuntimeException("No se pudo asignar los ejercicios");
		}

	}

	private boolean estaGrupo(GrupoMuscular grupoMuscular) {
		for (Ejercicio ejercicio : ejerciciosEntrenamiento) {
			if (grupoMuscular == ejercicio.getGrupoMuscular()) {
				return true;
			}
		}
		return false;
	}

	public void setObjetivo(ObjetivoStrategy objetivo) {
		this.objetivo = objetivo;
	}

	public ArrayList<Ejercicio> getEjercicios() {
		return ejerciciosEntrenamiento;
	}

	public void setEjercicios(ArrayList<Ejercicio> ejercicios) {
		this.ejerciciosEntrenamiento = ejercicios;
	}
}