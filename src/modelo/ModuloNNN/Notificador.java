package modelo.ModuloNNN;
public class Notificador{
    private StrategyNotificacion notificacion;
    
    public Notificador(StrategyNotificacion notificacion){
        this.notificacion = notificacion;
    }
    
    public void cambiarNotificacion(StrategyNotificacion notificacion){
        this.notificacion = notificacion;
    }

    public void notificar(String n){
        this.notificacion.notificar(n);
    }

}