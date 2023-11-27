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
	public static ArrayList<EjercicioRealizado> ejercicioRealizados= new ArrayList<EjercicioRealizado>(); // lo usariamos para el trofeo de constacia 
	private ObjetivoStrategy objetivo;
	private ArrayList<Entrenamiento> entrenamientos= new ArrayList<Entrenamiento>();
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
<<<<<<< Updated upstream
		comenzarDia();
		return entrenamientos.get(diaActual);
=======
		Entrenamiento ent = entrenamientos.get(diaActual);
		comenzarDia();
		return ent;
>>>>>>> Stashed changes
	}

	public void registrarEjercicio(
			int series,
			int repeticiones,
			double peso,
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
		// Increment the day or reset if it exceeds the total number of days.
		if (diaActual == dias.size() - 1) {
			// If it's the last day, reset to the first day.
			this.diaActual = 0;
			// If it's the last day of the week, decrement the remaining weeks.
			if (semana > 0) {
				semana--;
			}
		} else {
			// Increment the day.
			this.diaActual++;
		}
	}
	
	public boolean verificarConstancia() {
		
		// este metodo lo usariamos para el trofeo de constacia
		// ver ejerciciosRealizados contra semana * dias * cantidad de ejercicios por entrenamiento 
		return semana * dias.size() * 5 == ejercicioRealizados.size();
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

	public void setEntrenamientos(ArrayList<Entrenamiento> entrenamientos) {
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

	public ArrayList<EjercicioRealizado> getEjerciciosRealizados() {
		return ejercicioRealizados;
	}
}