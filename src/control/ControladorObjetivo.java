package control;

import javax.swing.JComboBox;

import modelo.VOs.SocioVo;
import modelo.moduloObjetivo.BajarPeso;
import modelo.moduloObjetivo.Mantener;
import modelo.moduloObjetivo.ObjetivoStrategy;
import modelo.moduloObjetivo.Tonificar;

public class ControladorObjetivo {

    ControladorSocio cs;
    ObjetivoStrategy os;

    public void setObjetivo(ObjetivoStrategy x) {
        cs.getSocioActual().setObjetivo(x);
        this.os = x;
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