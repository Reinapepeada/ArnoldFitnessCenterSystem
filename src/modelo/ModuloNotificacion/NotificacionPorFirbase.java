

public class NotificacionPorFirbase implements StrategyNotificacion {
    private AdapterNotificacionFirebase adapter;
    public void notificar(){
        adapter.enviaNotificacion();
    }

}
