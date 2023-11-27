package modelo;

public class EjercicioRealizado {
    private Entrenamiento entrenamiento;
    private int repeticiones;
    private double peso;
    private Ejercicio ejercicio;
    private int series;

    public EjercicioRealizado(Entrenamiento entrenamiento, int repeticiones, double peso, Ejercicio ejercicio, int series) {
        this.entrenamiento = entrenamiento;
        this.repeticiones = repeticiones;
        this.peso = peso;
        this.ejercicio = ejercicio;
        this.series = series;
    }
    
    public Ejercicio getEjercicio() {
        return this.ejercicio;
    }

    public void setEjercicio(Ejercicio ejercicio) {
        this.ejercicio = ejercicio;
    }

    public int getRepeticiones() {
        return this.repeticiones;
    }

    public void setRepeticiones(int repeticiones) {
        this.repeticiones = repeticiones;
    }

    public double getPesoAsignado() {
        return this.peso;
    }

    public void setPesoAsignado(double peso) {
        this.peso = peso;
    }

    public int getSeries() {

        return this.series;
    }

    public void setSeries(int series) {
        this.series = series;
    }

    public Entrenamiento getEntrenamiento() {
        return this.entrenamiento;
    }

    public void setEntrenamiento(Entrenamiento entrenamiento) {
        this.entrenamiento = entrenamiento;
    }

    public String getNombre() {
        return this.ejercicio.getNombre();
    }

}
