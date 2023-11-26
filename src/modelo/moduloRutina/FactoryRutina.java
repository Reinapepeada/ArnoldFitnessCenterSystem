package modelo.moduloRutina;

import java.util.List;

import modelo.enums.Dia;
import modelo.excepciones.RutinaInexistenteException;
import modelo.moduloObjetivo.ObjetivoStrategy;

public class FactoryRutina {
    public static Rutina crearRutina(ObjetivoStrategy objetivo,List<Dia> dias) throws RutinaInexistenteException {
        Rutina rut = null;
        switch (objetivo.getClass().getSimpleName()) {
            case "Tonificar":
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
