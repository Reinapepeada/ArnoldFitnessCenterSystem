package modelo.ModuloObjetivo;

public class Tonificar extends ObjetivoStrategy {
    private double porcenInitGrsa;
    private double porcenInitMus;

    public Tonificar(double duracion,  float peso, float altura) {
        super(duracion, 4, 5);
    }

    
    @Override
    public double calcularMedidaIdeal(){
    	// TODO -
        return 0;
    }

    @Override
    public boolean verificarObjetivo(){
        // TODO -
        if(calcularMedidaIdeal() != 0){
            return true;
        }
    	return false;
    }


	@Override
	public void chequearTrofeo() {
		// TODO Auto-generated method stub
		
	}
}
