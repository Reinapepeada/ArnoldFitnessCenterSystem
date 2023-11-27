package modelo.moduloTrofeo;

import modelo.Socio;
import modelo.moduloNNN.Notificador; 

public abstract class TrofeoObservador {
    private Notificador notificador;

    public abstract void chequearTrofeo(Socio soc);
}
