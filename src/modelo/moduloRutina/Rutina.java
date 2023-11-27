package modelo.moduloRutina;

import java.util.ArrayList;
import java.util.List;

import modelo.EjercicioRealizado;
import modelo.Entrenamiento;
import modelo.EntrenamientoRealizado;
import modelo.Socio;
import modelo.enums.Dia;
import modelo.moduloObjetivo.ObjetivoStrategy;
import modelo.moduloTrofeo.Observado;
import modelo.moduloTrofeo.TrofeoObservador;

// import modelo.Entrenamiento;

public class Rutina extends Observado{
	private ArrayList<TrofeoObservador> observadores = new ArrayList<TrofeoObservador>();
	private ArrayList<EjercicioRealizado> ejercicioRealizados;
	private ObjetivoStrategy objetivo;
	private List<Entrenamiento> entrenamientos;
	private List<Dia> dias;
	private int diaEntre; // valor de la posicion del entrenamiento, cunado se llega al limete se resetea y se se pasa a la proxima semana
	private int semanas;

	public Rutina(ObjetivoStrategy objetivo, List<Dia> dias) {
		this.objetivo = objetivo;
		this.dias = dias;
	}

	public void reforzarRutina() {
		if(semanas == 0){
			// cambiar valores de peso,series y repeticiones 
			for (Entrenamiento ent : entrenamientos) {
				ent.reforzarEntrenamiento();
			}
			semanas +=4;
		}
	}

	public Entrenamiento entrenamientoDiario() {
		// TODO - implement Rutina.entrenamientoDiario
		// revisar: que hace el Entrenamiento diario 
		// devolver el entrenamiento del dia
		return entrenamientos.get(diaEntre);
	}

	public void registrarEjercicio(
			int series,
			int repeticiones,
			float peso,
			boolean completado
			) {
		// Entrenamiento 
		// TODO - implement Rutina.registrarEjercicio
		// registrar un ejercicio Realizado
		// crear un ejercicio realizado y agregarlo a la lista de ejercicios realizados del entrenamiento del dia
		
	}

	public void comenzarDia() {
		// crear el entrenamiento realizado del dia 
		EntrenamientoRealizado entRealizado = new EntrenamientoRealizado(entrenamientoDiario());

	}
	
	public boolean verificarConstancia(){
		// TODO Auto-generated method stub
		
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
			// necesito saber como recuperar el socio 
		}
	}
}