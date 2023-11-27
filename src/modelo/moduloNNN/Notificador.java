package modelo.moduloNNN;

import modelo.moduloTrofeo.TrofeoDedicacion;
import modelo.moduloTrofeo.TrofeoObservador;

public class Notificador{
    private StrategyNotificacion notificacion;
    
    public Notificador(StrategyNotificacion notificacion){
        this.notificacion = notificacion;
    }
    
    public void cambiarNotificacion(StrategyNotificacion notificacion){
        this.notificacion = notificacion;
    }

    public void notificar(TrofeoObservador trofeo){
        this.notificacion.notificar(trofeo);
    }

}