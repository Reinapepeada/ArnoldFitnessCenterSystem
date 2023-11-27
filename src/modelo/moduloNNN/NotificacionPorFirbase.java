package modelo.moduloNNN;

import modelo.moduloTrofeo.TrofeoObservador;

public class NotificacionPorFirbase implements StrategyNotificacion {
    private AdapterNotificacionFirebase adapter;

    public NotificacionPorFirbase( AdapterNotificacionFirebase adapter) {
        this.adapter = adapter;
    }
    @Override
    public void notificar(TrofeoObservador obs) {
        // TODO Auto-generated method stub
        adapter.enviaNotificacion(obs);
    }

}
