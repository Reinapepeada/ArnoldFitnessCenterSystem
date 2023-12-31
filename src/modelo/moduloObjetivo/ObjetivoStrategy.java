package modelo.moduloObjetivo;

import java.util.ArrayList;
import java.util.List;

import modelo.moduloRutina.Rutina;
import modelo.moduloTrofeo.Observado;
import modelo.moduloTrofeo.TrofeoDedicacion;
import modelo.moduloTrofeo.TrofeoObservador;
import modelo.Ejercicio;
import modelo.enums.Exigencia;
import modelo.Socio;

public abstract class ObjetivoStrategy extends Observado {
	private ArrayList<TrofeoObservador> observadores = new ArrayList<TrofeoObservador>();
	private double duracion;
	private int nAerobicMin;
	private int nAerobicMax;
	private Rutina rutina;
	private ArrayList<Exigencia> exigencias= new ArrayList<Exigencia>(); 
	private double durMaxima;
    private double durMinima;
	private Socio soc;
	
	protected ObjetivoStrategy(double duracion, int nMin, int nMax){
		this.duracion = duracion;
		this.nAerobicMin = nMin;
		this.nAerobicMax = nMax;
	}
	
	//metodos para implemetar en los objetivos 
	abstract boolean medidaIdeal(Socio soc);
	public abstract boolean verificarObjetivo(Socio soc);

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
		return exigencias;
	}
	public void setExigenciaAlta() {
		this.exigencias.add(Exigencia.ALTA);
	}
	public void setExigenciaMedia() {
		this.exigencias.add(Exigencia.MEDIA);
	}

	public void setExigenciaBaja() {
		this.exigencias.add(Exigencia.BAJA);
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

    public void setTolerancia(double tol) {
    }

	public double getDurMaxima() {
		return durMaxima;
	}
	public double getDurMinima() {
		return durMinima;
	}

	//Implementacion de observadores 
	@Override
	public void agregarObservador(TrofeoObservador trofeo) {
		observadores.add(trofeo);
	}
	@Override
	public void sacarbservador(TrofeoObservador trofeo) {
		observadores.remove(trofeo);
	}

    // public Object getSemanasCumplidas() {
        
	// 	return ;
    // }

    

	
}
