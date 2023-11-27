package modelo.moduloTrofeo;

import java.util.ArrayList;

public abstract class Observado {
    private ArrayList<TrofeoObservador> observadores;

    public abstract void agregarObservador(TrofeoObservador obs);
    public abstract void sacarbservador(TrofeoObservador obs);
    public abstract void notificar();
    
}
