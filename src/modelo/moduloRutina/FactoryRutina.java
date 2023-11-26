package modelo.moduloRutina;

import java.util.ArrayList;
import java.util.List;

import modelo.Entrenamiento;
import modelo.enums.Dia;
import modelo.excepciones.RutinaInexistenteException;
import modelo.moduloObjetivo.ObjetivoStrategy;

public class FactoryRutina {
    public static Rutina crearRutina(ObjetivoStrategy objetivo,List<Dia> dias) throws RutinaInexistenteException {
        ArrayList<Entrenamiento> entrenamientos = new ArrayList<Entrenamiento>();
        Rutina rut = null;
        switch (objetivo.getClass().getSimpleName()) {
            case "Tonificar":
            for (int i = 0; i < dias.size(); i++) {
                //por cada iteracion crear un entrenamiento con cada grupo muscular 
                Entrenamiento entrenamiento = new Entrenamiento(objetivo);
                entrenamiento.asignarEjercicios();
                entrenamientos.add(entrenamiento);
            }
            rut = new Rutina(objetivo, dias);
            rut.setEntrenamientos(entrenamientos);
            return rut;
            case "BajarPeso":
                for (int i = 0; i < dias.size(); i++) {
                    //por cada iteracion crear un entrenamiento con cada grupo muscular 
                    Entrenamiento entrenamiento = new Entrenamiento(objetivo);
                    entrenamiento.asignarEjercicios();
                    entrenamientos.add(entrenamiento);
                }
                rut = new Rutina(objetivo,dias);
                rut.setEntrenamientos(entrenamientos);
                return rut;
            case "Mantener":
                for (int i = 0; i < dias.size(); i++) {
                    //por cada iteracion crear un entrenamiento con cada grupo muscular 
                    Entrenamiento entrenamiento = new Entrenamiento(objetivo);
                    entrenamiento.asignarEjercicios();
                    entrenamientos.add(entrenamiento);
                }
                rut = new Rutina(objetivo,dias);
                rut.setEntrenamientos(entrenamientos);
                return rut;
            default:
                throw new RutinaInexistenteException("No existe la Rutina");
        }
    }
    
}
