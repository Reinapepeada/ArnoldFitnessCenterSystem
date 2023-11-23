package modelo.ModuloTrofeo;
import modelo.ModuloNNN.Notificador; 

public abstract class TrofeoObservador {
    private Notificador notificador;

    protected abstract void chequearTrofeo();
}
