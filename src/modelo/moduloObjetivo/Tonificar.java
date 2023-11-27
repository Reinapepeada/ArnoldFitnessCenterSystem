package modelo.moduloObjetivo;
import modelo.Socio;
import modelo.enums.Exigencia;
import modelo.moduloMediciones.BalanzaSystemAdapter;
import modelo.moduloMediciones.Medida;


public class Tonificar extends ObjetivoStrategy {
    private double porcentajeGrsa;
    private double porcentjesMus;
    private double pesoInicial;
	private double alturaInicial;
    private double duracionEntrenamiento;
    private double pesoIdeal;
    private double durMaxima=2.5;
    private double durMinima=2;

    public Tonificar(double duracion,  double peso, double altura, double porcenInitGrsa, double porcenInitMus) {
        super(duracion, 4, 5);
        this.setExigenciaAlta();
        this.porcentajeGrsa = porcenInitGrsa;
        this.porcentjesMus = porcenInitMus;
        this.alturaInicial = altura;
        this.pesoInicial = peso;
    }

    
    @Override
    public double calcularMedidaIdeal(){
    	// TODO -
        return 0;
    }

    @Override
    public boolean verificarObjetivo(Socio soc){
        // TODO -
        BalanzaSystemAdapter balanza = new BalanzaSystemAdapter();
        Medida medidaActual = balanza.tomarMedidas(soc);

        if (medidaActual.getPorcentajeMusculo() >= porcentjesMus && medidaActual.getPorcentajeGrasa() <= porcentajeGrsa) {
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
