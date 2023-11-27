package modelo.moduloObjetivo;

import modelo.moduloMediciones.BalanzaSystemAdapter;
import modelo.moduloMediciones.Medida;

import java.util.ArrayList;

import modelo.Socio;
import modelo.enums.Exigencia;

public class BajarPeso extends ObjetivoStrategy {
	private double pesoInicial;
	private double alturaInicial;
	private double duracionEntrenamiento;
	private double pesoIdeal;
	private double durMaxima=1.5;
    private double durMinima=1;
	private ArrayList<Exigencia> exigencias;

	public BajarPeso(double duracion,  double peso, double altura) {
		super(duracion, 0, 3);
		this.setExigenciaBaja();
		this.setExigenciaMedia();
		this.setExigenciaAlta();
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
