package modelo.moduloTrofeo;

import modelo.Socio;
import modelo.moduloNNN.Notificador; 

public abstract class TrofeoObservador {
    protected Notificador notificador;

    // Constructor
    public TrofeoObservador() {
        this.notificador = notificador;
    }

    public abstract boolean chequearTrofeo();

    public abstract String getNombre();
}
