package modelo.moduloRutina;

import java.util.ArrayList;
import java.util.List;

import modelo.Entrenamiento;
import modelo.enums.Dia;
import modelo.enums.GrupoMuscular;
import modelo.excepciones.RutinaInexistenteException;
import modelo.moduloObjetivo.ObjetivoStrategy;

public class FactoryRutina {
    public static Rutina crearRutina(ObjetivoStrategy objetivo, List<Dia> dias) {
        ArrayList<Entrenamiento> entrenamientos = new ArrayList<Entrenamiento>();
        Rutina rut = null;
        System.out.println(dias.size());

        if (dias.size() < 5) {
            System.out.println("dias.size() < 5");
            for (int i = 0; i < dias.size(); i++) {
                // por cada iteracion crear un entrenamiento con cada grupo muscular
                Entrenamiento entrenamiento = new Entrenamiento(objetivo);
                entrenamiento.asignarEjerciciosMixtos();
                entrenamientos.add(entrenamiento);
            }
            rut = new Rutina(objetivo, dias);
            rut.setEntrenamientos(entrenamientos);
            return rut;
        }
        if (dias.size() == 5) {
            System.out.println("dias.size() == 5");
            for (GrupoMuscular grupoMuscular : GrupoMuscular.values()) {
                // por cada iteracion crear un entrenamiento con cada grupo muscular
                Entrenamiento entrenamiento = new Entrenamiento(objetivo);
                entrenamiento.asignarEjerciciosPorMusculo(grupoMuscular);
                entrenamientos.add(entrenamiento);
            }
            rut = new Rutina(objetivo, dias);
            rut.setEntrenamientos(entrenamientos);
            return rut;
        } else {
            System.out.println("else");
            // hay que repetir los grupos musculares teniendo encuenta que si se pasa de 5
            // dias se repiten los grupos musculares
            for (int i = 0; i < dias.size(); i++) {
                GrupoMuscular grupoMuscular = GrupoMuscular.values()[i % GrupoMuscular.values().length];

                // Crear un entrenamiento con el grupo muscular actual
                Entrenamiento entrenamiento = new Entrenamiento(objetivo);
                entrenamiento.asignarEjerciciosPorMusculo(grupoMuscular);
                entrenamientos.add(entrenamiento);
            }
            rut = new Rutina(objetivo, dias);
            rut.setEntrenamientos(entrenamientos);
            return rut;
        }

    }

}
