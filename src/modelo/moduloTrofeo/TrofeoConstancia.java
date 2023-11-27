package modelo.moduloTrofeo;

import javax.swing.JOptionPane;
import javax.swing.JPopupMenu;

import modelo.Socio;
import modelo.moduloNNN.Notificador;
import modelo.moduloRutina.Rutina;

public class TrofeoConstancia extends TrofeoObservador {
	private Rutina rutina;
	private String nombre;

	public TrofeoConstancia(Rutina rutina) {
		this.nombre = "Trofeo Constancia";
		this.rutina = rutina;
	}

	@Override
	public boolean chequearTrofeo() {
		// TODO 
		// si se cumple se notifica al notificador
		if(rutina.verificarConstancia()){
			notificador.notificar(this.getNombre());
		}
		return true;
	}

	public String getNombre(){
		return this.nombre;
	}

}
