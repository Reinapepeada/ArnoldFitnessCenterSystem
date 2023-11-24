package modelo.moduloTrofeo;

import modelo.moduloNNN.Notificador; 

public abstract class TrofeoObservador {
    private Notificador notificador;

    protected abstract void chequearTrofeo();
}
