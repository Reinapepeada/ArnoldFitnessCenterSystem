public class Notificador{
    private StrategyNotificacion notificacion;
    
    public Notificador(StrategyNotificacion notificacion){
        this.notificacion = notificacion;
    }
    
    public void cambiarNotificacion(StrategyNotificacion notificacion){
        this.notificacion = notificacion;
    }

    public void notificar(){
        this.notificacion.notificar();
    }

}