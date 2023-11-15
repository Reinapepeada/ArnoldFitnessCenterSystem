package modelo.ModuloObjetivo;

import java.util.List;

import modelo.Rutina;
import modelo.Enums.Exigencia;
import modelo.Trofeo.TrofeoIObservador;

public abstract class ObjetivoStrategy {
	private double duracion;
	private int nAerobicMin;
	private int nAerobicMax;
	private Rutina rutina;
	private List<Exigencia> exigencia;
	private List<TrofeoIObservador> observadores;

	protected ObjetivoStrategy(double duracion, int nMin, int nMax){
		this.duracion = duracion;
		this.nAerobicMin = nMin;
		this.nAerobicMax = nMax;
	}

	public void calcularMedidaIdeal() {
		// TODO - implement ObjetivoStrategy.calcularMedidaIdeal
		throw new UnsupportedOperationException();
	}

	public boolean verificarObjetivo() {
		// TODO - implement ObjetivoStrategy.verificarObjetivo
		throw new UnsupportedOperationException();
		
	}

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
	public List<TrofeoIObservador> getObservadores() {
		return observadores;
	}
	public void setObservadores(List<TrofeoIObservador> observadores) {
		this.observadores = observadores;
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
