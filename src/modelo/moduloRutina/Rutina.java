package modelo.moduloRutina;

import java.util.ArrayList;
import java.util.List;

import modelo.Ejercicio;
import modelo.EjercicioRealizado;
import modelo.Entrenamiento;
import modelo.Socio;
import modelo.enums.Dia;
import modelo.moduloObjetivo.ObjetivoStrategy;
import modelo.moduloTrofeo.Observado;
import modelo.moduloTrofeo.TrofeoObservador;

// import modelo.Entrenamiento;

public class Rutina extends Observado{
	private ArrayList<TrofeoObservador> observadores = new ArrayList<TrofeoObservador>();
	private ArrayList<EjercicioRealizado> ejercicioRealizados; // lo usariamos para el trofeo de constacia 
	private ObjetivoStrategy objetivo;
	private List<Entrenamiento> entrenamientos;
	private List<Dia> dias;
	private int diaActual;
	private int semanas;
	private int semana;

	public Rutina(ObjetivoStrategy objetivo, List<Dia> dias) {
		this.objetivo = objetivo;
		this.dias = dias;
		this.semanas = 4;
		this.semana = 4;
	}

	public void reforzarRutina() {
		if (semanas == 0) {
			// cambiar valores de peso,series y repeticioes 
			for (Entrenamiento ent : entrenamientos) {
				ent.reforzarEntrenamiento();
			}
			semanas += 4;
			semana +=4;
		}
	}

	public Entrenamiento entrenamientoDiario() {
		// TODO - implement Rutina.entrenamientoDiario
		// revisar: que hace el Entrenamiento diario 
		// devolver el entrenamiento del dia
		return entrenamientos.get(diaActual);
	}

	public void registrarEjercicio(
			int series,
			int repeticiones,
			float peso,
			boolean completado,
			Ejercicio ejercicio
			) {
		// Entrenamiento 
		// TODO - implement Rutina.registrarEjercicio
		// registrar un ejercicio Realizado
		// crear un ejercicio realizado y agregarlo a la lista de ejercicios realizados del entrenamiento del dia
		EjercicioRealizado ej = new EjercicioRealizado(entrenamientoDiario(), repeticiones, peso, ejercicio, series);
		ejercicioRealizados.add(ej);
	}

	public void comenzarDia() {
		//aumetar dia  
		if (diaActual == dias.size()){
			this.diaActual = 0;
		}else{
			this.diaActual ++;
		}
	}
	
	public boolean verificarConstancia(){
		// TODO Auto-generated method stub
		// este metodo lo usariamos para el trofeo de constacia
		// ver ejerciciosRealizados contra semana * dias * cantidad de ejercicios por entrenamiento 
		if (semana * dias.size() * 5 == ejercicioRealizados.size()){
			return true;
		}

		return false;

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


	//Implementacion de observadores 
	@Override
	public void agregarObservador(TrofeoObservador obs) {
		// Agrega observadores 
		observadores.add(obs);
	}

	@Override
	public void sacarbservador(TrofeoObservador obs) {
		// Elimina observadores
		observadores.remove(obs);
	}

	@Override
	public void notificar(Socio soc) {
		for (TrofeoObservador trofeoObservador : observadores) {
			trofeoObservador.chequearTrofeo(soc); 
		}
	}

	public String toString() {
		return "Rutina [objetivo=" + objetivo + ", entrenamientos=" + entrenamientos + ", dias=" + dias + ", diaEntre="
				+ diaActual + ", semanas=" + semanas + "]";
	}
}