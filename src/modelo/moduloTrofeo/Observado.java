package modelo.moduloTrofeo;

import java.util.ArrayList;

import modelo.Socio;

public abstract class Observado {
    public static ArrayList<String> observadores = new ArrayList<String>();

    public abstract void agregarObservador(TrofeoObservador obs);
    public abstract void sacarbservador(TrofeoObservador obs);
    public abstract void notificar(Socio soc);
    public abstract void setTrofeo();
}
