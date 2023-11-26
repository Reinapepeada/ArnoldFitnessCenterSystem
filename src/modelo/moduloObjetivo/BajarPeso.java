package modelo.moduloObjetivo;

import modelo.moduloMediciones.BalanzaSystemAdapter;
import modelo.moduloMediciones.Medida;
import modelo.Socio;

public class BajarPeso extends ObjetivoStrategy {
	private float pesoInicial;
	private float alturaInicial;
	public BajarPeso(double duracion,  float peso, float altura) {
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
	public boolean verificarObjetivo(Socio soc){
		// TODO - verificar con la medida actual contra la medida medida ideal
		BalanzaSystemAdapter balanza = new BalanzaSystemAdapter();
        Medida medidaActual = balanza.tomarMedidas(soc); // deberia ir la medida actual
		if(calcularMedidaIdeal() >= medidaActual.getBMi()){
			return true;
		}
		return false;
	}

	public String getNombreObjetivo(){
		return "BajarPeso";
		
	}

	public float getAlturaInicial(){
		return this.alturaInicial;
	}

	public float getPesoInicial() {
		return this.pesoInicial;
	}

	@Override
	public void chequearTrofeo() {
		// TODO Auto-generated method stub
	}
}
