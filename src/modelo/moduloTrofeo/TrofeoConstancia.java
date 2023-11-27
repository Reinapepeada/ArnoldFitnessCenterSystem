package modelo.moduloTrofeo;

import javax.swing.JOptionPane;
import javax.swing.JPopupMenu;

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
			setTrofeo(this);
			JOptionPane.showMessageDialog(null, "¡Haz Recibido un Trofeo a la Constancia!");
		}
	}

	public String getNombre(){
		return this.nombre;
	}
	
	public void setTrofeo(TrofeoObservador trofeo){
		Observado.observadores.add(trofeo.getNombre());
	}

}
