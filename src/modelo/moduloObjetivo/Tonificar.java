package modelo.moduloObjetivo;
import modelo.Socio;
import modelo.enums.Exigencia;
import modelo.moduloMediciones.BalanzaSystemAdapter;
import modelo.moduloMediciones.Medida;


public class Tonificar extends ObjetivoStrategy {
    private double pesoInicial;
	private double alturaInicial;
    private double duracionEntrenamiento;
    private double durMaxima=2.5;
    private double durMinima=2;

    public Tonificar(double duracion,  double peso, double altura) {
        super(duracion, 4, 5);
        this.alturaInicial = altura;
        this.pesoInicial = peso;
        // this.duracionEntrenamiento = duracionEntrenamiento;
    }

    
    @Override
    public boolean medidaIdeal(Socio soc){
        BalanzaSystemAdapter balanza = new BalanzaSystemAdapter();
        Medida medidaActual = balanza.tomarMedidas(soc);

        if (medidaActual.getPorcentajeMusculo() >= calcularMasaIdeal() && medidaActual.getPorcentajeGrasa() <= calcularGrasaIdeal(soc)) {
            return true; 
        }
        return false;
    }
    public double calcularGrasaIdeal(Socio soc){
        if(soc.getSexo().equals("Masculino")){
            return (1.2 * calcularMasaIdeal()) + (0.23 * Integer.parseInt(soc.getEdad())) - 16.2;
        }else{
            return (1.2 * calcularMasaIdeal()) + (0.23 * Integer.parseInt(soc.getEdad())) - 5.4;
        }
    }
    public double calcularMasaIdeal(){
        return this.pesoInicial / (this.alturaInicial * this.alturaInicial);
    }

    @Override
    public boolean verificarObjetivo(Socio soc){
        return medidaIdeal(soc) ;
    }

    public String getNombreObjetivo(){
		return "Tonificar";
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
