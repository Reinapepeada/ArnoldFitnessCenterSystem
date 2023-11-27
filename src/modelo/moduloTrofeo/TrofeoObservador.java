package modelo.moduloTrofeo;

import modelo.Socio;
import modelo.moduloNNN.Notificador; 

public abstract class TrofeoObservador {
    protected Notificador notificador;

    // Constructor
    public TrofeoObservador(Notificador notificador) {
        this.notificador = notificador;
    }

    public abstract void chequearTrofeo(Socio soc);
}
