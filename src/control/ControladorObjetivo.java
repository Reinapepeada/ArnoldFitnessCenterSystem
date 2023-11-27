package control;

import java.util.List;

import javax.swing.JComboBox;

import modelo.Ejercicio;
import modelo.Entrenamiento;
import modelo.Socio;
import modelo.VOs.SocioVo;
import modelo.enums.Dia;
import modelo.moduloObjetivo.BajarPeso;
import modelo.moduloObjetivo.Mantener;
import modelo.moduloObjetivo.ObjetivoStrategy;
import modelo.moduloObjetivo.Tonificar;
import modelo.moduloRutina.FactoryRutina;
import modelo.moduloRutina.Rutina;
import modelo.excepciones.RutinaInexistenteException;



public class ControladorObjetivo {

    ControladorSocio cs;
    ObjetivoStrategy os;
    Rutina r;

    public void asignarObjetivo(ObjetivoStrategy x) {
        
        Socio s = cs.getSocioActual();
        System.out.println(s.toString());
        s.setObjetivo(x);
        this.os = x;
    }   

    public Rutina getRutina() {
        return r;
    }

    public Entrenamiento getEntrenamientoDiario() {
        return r.entrenamientoDiario();
    }

    public void registrarEjercicio(int series, int repeticiones, double peso, Ejercicio indiceEjercicio) {
        r.registrarEjercicio(series, repeticiones, peso, indiceEjercicio);
    }

    public void getEjerciosRealizados() {
        r.getEjerciciosRealizados();
    }


    public void diseñarRutina(List<Dia> dias) {
        // try {
            this.r = FactoryRutina.crearRutina(os, dias);

        // } catch (RutinaInexistenteException e) {
        //     // Handle the exception here
        //     System.out.println("RutinaInexistenteException: " + e.getMessage());
        // }
    }

    public void setDuracionTolerancia(double duracionEntrenamiento, double tol) {
        os.setDuracion(duracionEntrenamiento);
        if (os instanceof Mantener) {
            ((Mantener) os).setTolerancia(tol);
        }
    }

    public void setDuracion(double duracionEntrenamiento) {
        os.setDuracion(duracionEntrenamiento);
    }

    ////////    GETTERS Y SETTERS    ////////

    public void setCSocio(ControladorSocio cs) {
        this.cs = cs;
        
    }

}