

public class NotificacionPorFirbase implements StrategyNotificacion {
    private AdapterNotificacionFirebase adapter;
    public void notificar(String n){
        adapter.enviaNotificacion(n);
    }

}
