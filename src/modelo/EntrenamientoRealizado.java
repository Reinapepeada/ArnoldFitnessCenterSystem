package modelo;

import java.util.ArrayList;

public class EntrenamientoRealizado {
    private ArrayList<EjercicioRealizado> EjerciciosRealizados;
    private boolean entrenamientoCumplido;
    private Entrenamiento entrenamiento;

    public EntrenamientoRealizado(Entrenamiento entrenamiento) {
        this.entrenamiento = entrenamiento;
        this.EjerciciosRealizados = new ArrayList<EjercicioRealizado>();
    }

    public void agregarEjercicioRealizado(EjercicioRealizado ejercicioRealizado) {
        this.EjerciciosRealizados.add(ejercicioRealizado);
    }

    public void setEntrenamientoCumplido() {
        for(Ejercicio ent : entrenamiento.getEjercicios()){
            for(EjercicioRealizado entR : EjerciciosRealizados){
                if(!entR.getEjercicio().equals(ent)){
                        this.entrenamientoCumplido = false;
                    }
                }
            }
        this.entrenamientoCumplido = true;
    }
}
