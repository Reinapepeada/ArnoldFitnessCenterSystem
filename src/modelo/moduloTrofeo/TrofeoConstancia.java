package modelo.moduloTrofeo;

import modelo.moduloNNN.Notificador;
import modelo.moduloRutina.Rutina;

public class TrofeoConstancia extends TrofeoObservador {
	private Rutina rutina;
	private String nombre;
	private Notificador notificador;

	@Override
	public void chequearTrofeo(Socio soc) {
		// TODO 
		// si se cumple se notifica al notificador
		if(){
			notificador.notificar(this);
		}
	}
	
}
