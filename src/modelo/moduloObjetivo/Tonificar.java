package modelo.moduloObjetivo;

public class Tonificar extends ObjetivoStrategy {
    private double porcenInitGrsa;
    private double porcenInitMus;
    private double pesoInicial;
	private double alturaInicial;
    private double duracionEntrenamiento;
    private double pesoIdeal;
    private double durMaxima=2.5;
    private double durMinima=2;

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

    public void setDuracionEntrenamiento(double duracionEntrenamiento) {
        this.duracionEntrenamiento = duracionEntrenamiento;
    }

    public double getDurMaxima() {
		return durMaxima;
	}

	
	public double getDurMinima() {
		return durMinima;
	}

}
