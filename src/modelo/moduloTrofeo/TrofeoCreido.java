package modelo.moduloTrofeo;

import modelo.Socio;
import modelo.moduloNNN.Notificador;
public class TrofeoCreido extends TrofeoObservador {
	private Socio socio;
	private String nombre;
	
	public TrofeoCreido(Notificador notificador, Socio s) {
		super(notificador);
		this.nombre = " Trofeo Creido";
		this.socio = s;
	}

	@Override
	public void chequearTrofeo(Socio soc) {
		// TODO 
		// si se cumple se notifica al notificador
		if(socio.verificarTrofeo()){
			notificador.notificar(this.getNombre());
		}
	}
	public String getNombre(){
		return this.nombre;
	}

}
