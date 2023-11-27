package modelo.moduloTrofeo;

import modelo.Socio;
import modelo.moduloNNN.NotificacionPorFirbase;
import modelo.moduloNNN.Notificador;

public class TrofeoCreido extends TrofeoObservador {
	private Socio socio;
	private String nombre;
	private Notificador notificador ;
	public TrofeoCreido(String nombre, Socio socio, Notificador notificador) {
		this.nombre = nombre;
		this.socio = socio;
		this.notificador = notificador;
	}

	@Override
	public void chequearTrofeo(Socio soc) {
		// TODO 
		// si se cumple se notifica al notificador
		if(socio.verificarTrofeo()){
			notificador.notificar(this);
		}
	}
	public String getNombre(){
		return this.nombre;
	}
}
