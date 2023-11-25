package modelo;

public class EjercicioRealizado {
    private Entrenamiento entrenamiento;
    private int repeticiones;
    private float peso;
    private Ejercicio ejercicio;
    private int series;

    public Entrenamiento getEntrenamiento() {
        return entrenamiento;
    }

    public int getRepeticiones() {
        return repeticiones;
    }

    public float getPeso() {
        return peso;
    }

    public Ejercicio getEjercicio() {
        return ejercicio;
    }

    public int getSeries() {
        return series;
    }

    public EjercicioRealizado(Entrenamiento entrenamiento, int repeticiones, float peso, Ejercicio ejercicio, int series) {
        this.entrenamiento = entrenamiento;
        this.repeticiones = repeticiones;
        this.peso = peso;
        this.ejercicio = ejercicio;
        this.series = series;
    }

}
