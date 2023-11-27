package modelo.moduloTrofeo;

import java.util.ArrayList;

import modelo.Socio;

public abstract class Observado {
    private ArrayList<TrofeoObservador> observadores;

    public abstract void agregarObservador(TrofeoObservador obs);
    public abstract void sacarbservador(TrofeoObservador obs);
    public abstract void notificar(Socio soc);
    
}
