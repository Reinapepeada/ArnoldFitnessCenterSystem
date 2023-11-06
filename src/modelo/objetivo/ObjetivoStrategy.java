package modelo.objetivo;

import modelo.Rutina;

public abstract class ObjetivoStrategy {
	private double duracion;
	private int exigenciaMinima;
	private int exigenciaMaxima;
	private Rutina rutina;

	public void calcularMedidaIdeal() {
	}

	public boolean verificarObjetivo() {
		return true;    
	}

	public double getDuracion() {
		return duracion;
	}

	public void setDuracion(double duracion) {
		this.duracion = duracion;
	}

	public int getExigenciaMinima() {
		return exigenciaMinima;
	}

	public void setExigenciaMinima(int exigenciaMinima) {
		this.exigenciaMinima = exigenciaMinima;
	}

	public int getExigenciaMaxima() {
		return exigenciaMaxima;
	}

	public void setExigenciaMaxima(int exigenciaMaxima) {
		this.exigenciaMaxima = exigenciaMaxima;
	}

	public Rutina getRutina() {
		return rutina;
	}

	public void setRutina(Rutina rutina) {
		this.rutina = rutina;
	}
}
