package Modelo.ModuloNNN;
import java.util.List;

import Modelo.ModuloTrofeo.TrofeoObservador;

abstract class Observador {
    protected List<TrofeoObservador> observadores;

    abstract void notificar(String n);

    abstract void agregarObservador(TrofeoObservador obs);

    abstract void sacarNotificador(TrofeoObservador obs);
}
