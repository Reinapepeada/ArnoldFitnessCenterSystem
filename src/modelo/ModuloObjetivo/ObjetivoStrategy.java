package modelo.moduloObjetivo;

import java.util.List;

import modelo.Rutina;
import modelo.enums.Exigencia;
import modelo.moduloTrofeo.TrofeoObservador;

public abstract class ObjetivoStrategy extends TrofeoObservador {
	private double duracion;
	private int nAerobicMin;
	private int nAerobicMax;
	private Rutina rutina;
	private List<Exigencia> exigencia;

	protected ObjetivoStrategy(double duracion, int nMin, int nMax){
		this.duracion = duracion;
		this.nAerobicMin = nMin;
		this.nAerobicMax = nMax;
	}

	//metodos para implemetar en los objetivos 
	abstract double calcularMedidaIdeal();

	abstract boolean verificarObjetivo();
	
	@Override
	protected abstract void chequearTrofeo();
	
	
	

	public double getDuracion() {
		return duracion;
	}

	public void setDuracion(double duracion) {
		this.duracion = duracion;
	}

	public Rutina getRutina() {
		return rutina;
	}

	public void setRutina(Rutina rutina) {
		this.rutina = rutina;
	}

	public List<Exigencia> getExigencia() {
		return exigencia;
	}
	public void setExigencia(List<Exigencia> exigencia) {
		this.exigencia = exigencia;
	}
	public int getnAerobicMin() {
		return nAerobicMin;
	}
	public void setnAerobicMin(int nAerobicMin) {
		this.nAerobicMin = nAerobicMin;
	}
	public int getnAerobicMax() {
		return nAerobicMax;
	}
	public void setnAerobicMax(int nAerobicMax) {
		this.nAerobicMax = nAerobicMax;
	}
}
