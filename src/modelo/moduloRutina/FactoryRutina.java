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
        switch (objetivo.getClass().getSimpleName()) {
            case "Tonificar":
            for (int i = 0; i < dias.size(); i++) {
                //por cada iteracion crear un entrenamiento con cada grupo muscular 
                Entrenamiento entrenamiento = new Entrenamiento(objetivo);
                entrenamiento.asignarEjercicios();
                entrenamientos.add(entrenamiento);
            }
            Rutina rut = new Rutina(objetivo, dias);
            rut.setEntrenamientos(entrenamientos);
            return rut;
            case "BajarPeso":
                for (int i = 0; i < dias.size(); i++) {
                    //por cada iteracion crear un entrenamiento con cada grupo muscular 
                    Entrenamiento entrenamiento = new Entrenamiento(objetivo);
                    entrenamiento.asignarEjercicios();
                    entrenamientos.add(entrenamiento);
                }
                Rutina ruti = new Rutina(objetivo,dias);
                ruti.setEntrenamientos(entrenamientos);
                return ruti;
            case "Mantener":
                for (int i = 0; i < dias.size(); i++) {
                    //por cada iteracion crear un entrenamiento con cada grupo muscular 
                    Entrenamiento entrenamiento = new Entrenamiento(objetivo);
                    entrenamiento.asignarEjercicios();
                    entrenamientos.add(entrenamiento);
                }
                Rutina rutn = new Rutina(objetivo,dias);
                rutn.setEntrenamientos(entrenamientos);
                return rutn;
            default:
                throw new RutinaInexistenteException("No existe la Rutina");
        }
    }
    
}
