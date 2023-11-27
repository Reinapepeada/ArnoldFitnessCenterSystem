package modelo.moduloObjetivo;

import modelo.moduloMediciones.BalanzaSystemAdapter;
import modelo.moduloMediciones.Medida;
import modelo.Socio;

public class BajarPeso extends ObjetivoStrategy {
	private double pesoInicial;
	private double alturaInicial;
	private double duracionEntrenamiento;
	private double durMaxima=1.5;
    private double durMinima=1;

	public BajarPeso(double duracion,  double peso, double altura) {
		super(duracion, 0, 3);
		this.pesoInicial = peso;
		this.alturaInicial = altura;
		// this.duracionEntrenamiento = duracionEntrenamiento;
	}
	
	@Override
	public boolean medidaIdeal(Socio soc) {
        // TODO - verificar con la medida actual contra la medida medida ideal
		BalanzaSystemAdapter balanza = new BalanzaSystemAdapter();
        Medida medidaActual = balanza.tomarMedidas(soc); // deberia ir la medida actual
		if(calcularBMI() >= medidaActual.getBMi()){
			return true;
		}
		return false;
	}
	public double calcularBMI(){
		return this.getPesoInicial() / (this.getAlturaInicial() * this.getAlturaInicial());
	}

	@Override
	public boolean verificarObjetivo(Socio soc){
		return medidaIdeal(soc);
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
