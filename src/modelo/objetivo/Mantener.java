package modelo.objetivo;

public class Mantener extends ObjetivoStrategy {
    private float pesoInicial;
    private float toleraciaVsPesoInicial;

	
    public Mantener(double duracion,  float peso,float tol){
        super(duracion, 2, 4);
        this.pesoInicial = peso;
        this.toleraciaVsPesoInicial = tol;
    }
    @Override
    public void calcularMedidaIdeal(){
        // TODO - calcular medida ideal
    }
    @Override
    public boolean verificarObjetivo(){
        return true;
    }

    public float getPesoInicial() {
        return this.pesoInicial;
    }
    public float getToleraciaVsPesoInicial() {
        return this.toleraciaVsPesoInicial;
    }

    
}
