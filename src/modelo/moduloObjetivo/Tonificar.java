package modelo.moduloObjetivo;

public class Tonificar extends ObjetivoStrategy {
    private double porcenInitGrsa;
    private double porcenInitMus;

    public Tonificar(double duracion,  float peso, float altura,double porcenInitGrsa,double porcenInitMus) {
        super(duracion, 4, 5);
        this.porcenInitGrsa = porcenInitGrsa;
        this.porcenInitMus = porcenInitMus;
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

    public String getNombreObjetivo(){
		return "Tonificar";
	}

	@Override
	public void chequearTrofeo() {
		// TODO Auto-generated method stub
		
	}
}
