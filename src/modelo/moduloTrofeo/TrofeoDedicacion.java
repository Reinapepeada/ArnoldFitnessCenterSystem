package modelo.moduloTrofeo;

import modelo.moduloNNN.Notificador;
import modelo.moduloObjetivo.ObjetivoStrategy;

import javax.swing.JOptionPane;

import modelo.Socio;

public class TrofeoDedicacion extends TrofeoObservador {
	private String nombre;
    private ObjetivoStrategy objetivo;

    public TrofeoDedicacion(String nombre, ObjetivoStrategy objetivo, Notificador notificador) {
        super(notificador);
		this.nombre = nombre;
        this.objetivo = objetivo;
    }

	
	@Override
	public void chequearTrofeo(Socio soc) {
		// como checkearr cada trofeo 
		// si se cumple se notifica al notificador
		if(objetivo.verificarObjetivo(soc)){
			notificador.notificar(this.getNombre());
		}
	}

	public String getNombre() {
		return this.nombre;
	}
	


}