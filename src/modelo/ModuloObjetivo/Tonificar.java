package modelo.moduloObjetivo;

public class Tonificar extends ObjetivoStrategy {
    private double porcenInitGrsa;
    private double porcenInitMus;
    private double pesoInicial;
	private double alturaInicial;

    public Tonificar(double duracion,  double peso, double altura) {
        super(duracion, 4, 5);
        this.pesoInicial = peso;
		this.alturaInicial = altura;
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
