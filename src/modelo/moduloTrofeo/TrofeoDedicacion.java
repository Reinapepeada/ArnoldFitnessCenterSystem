package modelo.moduloTrofeo;

import modelo.moduloNNN.NotificacionPorFirbase;
import modelo.moduloNNN.Notificador;
import modelo.moduloObjetivo.ObjetivoStrategy;
import modelo.Socio;

public class TrofeoDedicacion extends TrofeoObservador {

	private String nombre;
    private ObjetivoStrategy objetivo;
    private Notificador notificador;

    public TrofeoDedicacion(String nombre, ObjetivoStrategy objetivo, Notificador notificador) {
        this.nombre = nombre;
        this.objetivo = objetivo;
        this.notificador = notificador;
    }

	
	@Override
	public void chequearTrofeo(Socio soc) {
		// como checkearr cada trofeo 
		// si se cumple se notifica al notificador
		if(objetivo.verificarObjetivo(soc)){
			notificador.notificar(this);
		}
	}

	public String getNombre() {
		return nombre;
	}
	
}