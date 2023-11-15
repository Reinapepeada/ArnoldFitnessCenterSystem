package modelo.ModuloObjetivo;

public class Tonificar extends ObjetivoStrategy {
    public Tonificar(double duracion,  float peso, float altura) {
        super(duracion, 4, 5);
    }

    
    @Override
    public void calcularMedidaIdeal(){
    	// TODO 

    }

    @Override
    public boolean verificarObjetivo(){
    	return true;
    }
}
