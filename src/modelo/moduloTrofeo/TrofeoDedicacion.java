package modelo.moduloTrofeo;

import modelo.moduloNNN.Notificador;
import modelo.moduloObjetivo.ObjetivoStrategy;

import javax.swing.JOptionPane;

import modelo.Socio;

public class TrofeoDedicacion extends TrofeoObservador {
	private String nombre;
    private ObjetivoStrategy objetivo;
	

    public TrofeoDedicacion(String nombre, ObjetivoStrategy objetivo) {
		this.nombre = nombre;
        this.objetivo = objetivo;
    }

	
	@Override
	// public boolean chequearTrofeo() {
	// 	 if(objetivo.cumplioObjetivo()){
	// 		JOptionPane.showMessageDialog(null, "¡Haz Recibido un Trofeo a la Dedicacion!");
	// 		objetivo.concederTrofeo(this);
	// 		return true;
	// 	}
// }

	public String getNombre() {
		return this.nombre;
	}


	@Override
	public boolean chequearTrofeo() {
		// TODO Auto-generated method stub
		throw new UnsupportedOperationException("Unimplemented method 'chequearTrofeo'");
	}
	


}