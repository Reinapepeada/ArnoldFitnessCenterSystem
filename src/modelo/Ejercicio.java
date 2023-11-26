package modelo;

import control.ControladorEjercicio;
import modelo.enums.Exigencia;
import modelo.enums.GrupoMuscular;
import modelo.excepciones.EjercicioExistenteException;

public class Ejercicio {
	private String nombre;
	private int nivelAerobico;
	private int series;
	private int repeticiones;
	private int pesoAsignado;
	private Exigencia exigenciaMuscular;
	private GrupoMuscular grupoMuscular;

	public Ejercicio(String nombre,	int nivelAerobico, int series,  int repeticiones, int pesoAsignado, Exigencia exigenciaMuscular, GrupoMuscular grupoMuscular) {
		this.nombre = nombre;
		this.nivelAerobico = nivelAerobico;
		this.series = series;
		this.repeticiones = repeticiones;
		this.pesoAsignado = pesoAsignado;
		this.exigenciaMuscular = exigenciaMuscular;
		this.grupoMuscular = grupoMuscular;
	}

	public Ejercicio() {
	}

	public void agregarEjercicio(String nombre, int nivelAerobico, int series, int repeticiones, int pesoAsignado, Exigencia exigenciuaMuscular, GrupoMuscular grupoMuscular) throws EjercicioExistenteException {
        if(buscarEjercicio(nombre)==null){
            Ejercicio ejercicio = new Ejercicio(nombre, nivelAerobico, series, repeticiones, pesoAsignado, exigenciuaMuscular, grupoMuscular);
            ControladorEjercicio.ejercicios.add(ejercicio);
            return;
        }
        throw new EjercicioExistenteException("Error, El ejercicio ya existe.");
    }

	private Ejercicio buscarEjercicio(String nombre) {
		for (Ejercicio ejercicio: ControladorEjercicio.ejercicios) {
			if (ejercicio.soyEseEjercicio(nombre)) {
				return ejercicio;
			}
		}
		return null;
	}
	
	public boolean soyEseEjercicio(String nombre) {
		return this.nombre.equals(nombre.toUpperCase());
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