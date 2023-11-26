package modelo.moduloObjetivo;

public class BajarPeso extends ObjetivoStrategy {
	private double pesoInicial;
	private double alturaInicial;

	public BajarPeso(double duracion,  double peso, double altura) {
		super(duracion, 0, 3);
		this.pesoInicial = peso;
		this.alturaInicial = altura;
	}
	
	@Override
	public double calcularMedidaIdeal() {
        // Fórmula del IMC: peso / (altura^2)
        return this.getPesoInicial() / (this.getAlturaInicial() * this.getAlturaInicial());
	}

	@Override
	public boolean verificarObjetivo(){
		// TODO - verificar con la medida actual contra la medida medida ideal
		// como hacemos para acceder a la medida actual
		int medidaActual = 0; // deberia ir la medida actual
		if(calcularMedidaIdeal() < medidaActual){
			return true;
		}
		return false;
	}

	public String getNombreObjetivo(){
		return "BajarPeso";
	}

	public double getAlturaInicial(){
		return this.alturaInicial;
	}

	public double getPesoInicial() {
		return this.pesoInicial;
	}

	@Override
	public void chequearTrofeo() {
		// TODO Auto-generated method stub
	}
}
