package modelo.moduloNNN;
import java.util.List;

import modelo.moduloTrofeo.TrofeoObservador;

abstract class Observador {
    protected List<TrofeoObservador> observadores;

    abstract void notificar(String n);

    abstract void agregarObservador(TrofeoObservador obs);

    abstract void sacarNotificador(TrofeoObservador obs);
}
