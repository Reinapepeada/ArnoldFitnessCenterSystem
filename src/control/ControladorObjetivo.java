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

    public void setMedidasObjetivo(String obj) {
        SocioVo vo = cs.getSocioVOActual();
        switch (obj) {
            case "BajarPeso":
                BajarPeso bp = new BajarPeso(0, vo.getPeso(), vo.getAltura());
                setObjetivo(bp);
                // invoco la vista para setear las medidas
                WindowManagerSingleton w=WindowManagerSingleton.getInstance();
                w.disponibilizarVistaSetMedidasObjetivo(os.getDurMaxima(),os.getDurMinima());
                break;
            case "Mantener":
                Mantener m = new Mantener(0, vo.getPeso(), 0);
                setObjetivo(m);
                // invoco la vista para setear las medidas
                WindowManagerSingleton w2=WindowManagerSingleton.getInstance();
                w2.disponibilizarVistaSetMedidasMantener(os.getDurMaxima(),os.getDurMinima());
                break;
            case "Tonificar":
                Tonificar t = new Tonificar(0, vo.getPeso(), vo.getAltura());
                setObjetivo(t);
                // invoco la vista para setear las medidas
                WindowManagerSingleton w3=WindowManagerSingleton.getInstance();
                w3.disponibilizarVistaSetMedidasObjetivo(os.getDurMaxima(),os.getDurMinima());
                break;
            default:
                break;
        }
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