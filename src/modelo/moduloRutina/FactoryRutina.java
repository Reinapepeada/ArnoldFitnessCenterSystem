package modelo.moduloRutina;

import java.util.ArrayList;
import java.util.List;

import modelo.Entrenamiento;
import modelo.enums.Dia;
import modelo.excepciones.RutinaInexistenteException;
import modelo.moduloObjetivo.ObjetivoStrategy;

public class FactoryRutina {
    public static Rutina crearRutina(ObjetivoStrategy objetivo,List<Dia> dias) throws RutinaInexistenteException {
        switch (objetivo.getClass().getSimpleName()) {
            case "Tonificar":
            ArrayList<Entrenamiento> entrenamientos = new ArrayList();
                for (int i = 0; i < dias.size(); i++) {
                    //por cada iteracion crear un entrenamiento con cada grupo muscular 
                    Entrenamiento entrenamiento = new Entrenamiento(objetivo);
                    entrenamientos.add(entrenamiento);
                }
                Rutina rut = new Rutina(objetivo,dias);
                return rut;
            case "BajarPeso":
                Rutina ruti = new Rutina(objetivo,dias);
                return ruti;
            case "Mantener":
                
                Rutina rutn = new Rutina(objetivo,dias);
                return rutn;
            default:
                throw new RutinaInexistenteException("No existe la Rutina");
        }
    }
    
}
