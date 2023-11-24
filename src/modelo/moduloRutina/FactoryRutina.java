package modelo.moduloRutina;

import java.util.List;

import modelo.Enums.Dia;
import modelo.Excepciones.RutinaInexistenteException;
import modelo.ModuloObjetivo.ObjetivoStrategy;

public class FactoryRutina {
    public static Rutina crearRutina(ObjetivoStrategy objetivo,List<Dia> dias) throws RutinaInexistenteException {
        switch (objetivo.getClass().getSimpleName()) {
            case "Tonificar":
                
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
