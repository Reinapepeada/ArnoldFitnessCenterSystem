package modelo.moduloRutina;

import java.util.ArrayList;
import java.util.List;

import modelo.Entrenamiento;
import modelo.enums.Dia;
import modelo.excepciones.RutinaInexistenteException;
import modelo.moduloObjetivo.ObjetivoStrategy;

public class FactoryRutina {
    public static Rutina crearRutina(ObjetivoStrategy objetivo,List<Dia> dias) throws RutinaInexistenteException {
        Rutina rut = null;
        switch (objetivo.getClass().getSimpleName()) {
            case "Tonificar":
            ArrayList<Entrenamiento> entrenamientos = new ArrayList();
                for (int i = 0; i < dias.size(); i++) {
                    //por cada iteracion crear un entrenamiento con cada grupo muscular 
                    Entrenamiento entrenamiento = new Entrenamiento(objetivo);
                    entrenamientos.add(entrenamiento);
                }
                rut = new Rutina(objetivo,dias);
                return rut;

            case "BajarPeso":
                rut = new Rutina(objetivo,dias);
                return rut;

            case "Mantener":
                
                rut = new Rutina(objetivo,dias);
                return rut;

            default:
                throw new RutinaInexistenteException("No existe la Rutina");
        }
    }
    
}
