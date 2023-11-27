package modelo.moduloTrofeo;

import modelo.Socio;
import modelo.moduloNNN.Notificador;
import modelo.moduloRutina.Rutina;

public class TrofeoConstancia extends TrofeoObservador {
	private Rutina rutina;
	private String nombre;

	public TrofeoConstancia(Rutina rutina, Notificador notificador) {
		super(notificador);
		this.nombre = "Trofeo Constancia";
		this.rutina = rutina;
	}

	@Override
	public void chequearTrofeo(Socio soc) {
		// TODO 
		// si se cumple se notifica al notificador
		if(rutina.verificarConstancia()){
			notificador.notificar(this.getNombre());
		}
	}

	public String getNombre(){
		return this.nombre;
	}
	
}
