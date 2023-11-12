package modelo.objetivo;

public class BajarPeso extends ObjetivoStrategy {
	private float pesoInicial;
	private float alturaInicial;
	public BajarPeso(double duracion,  float peso, float altura) {
		super(duracion, 0, 3);
		this.pesoInicial = peso;
		this.alturaInicial = altura;
		
	}

	
	@Override
	public void calcularMedidaIdeal(){
		// TODO - 
	}

	@Override
	public boolean verificarObjetivo(){
		return true;
	}

	public float getAlturaInicial(){
		return this.alturaInicial;
	}

	public float getPesoInicial() {
		return this.pesoInicial;
	}
}
