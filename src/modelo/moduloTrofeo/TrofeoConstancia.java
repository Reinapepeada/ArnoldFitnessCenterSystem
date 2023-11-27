package modelo.moduloTrofeo;

import modelo.Socio;
import modelo.moduloNNN.Notificador;
import modelo.moduloRutina.Rutina;

public class TrofeoConstancia extends TrofeoObservador {
	private Rutina rutina;
	private String nombre;
	private Notificador notificador;

	public TrofeoConstancia(String nombre, Rutina rutina, Notificador notificador) {
		this.nombre = nombre;
		this.rutina = rutina;
		this.notificador = notificador;
	}

	@Override
	public void chequearTrofeo(Socio soc) {
		// TODO 
		// si se cumple se notifica al notificador
		// if(){
		// 	notificador.notificar(this);
		// }
	}
	
}
