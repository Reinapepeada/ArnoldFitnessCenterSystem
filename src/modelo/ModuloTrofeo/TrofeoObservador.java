package Modelo.ModuloTrofeo;
import Modelo.ModuloNNN.Notificador; 

public abstract class TrofeoObservador {
    private Notificador notificador;

    protected abstract void chequearTrofeo();
}
