package modelo.moduloObjetivo;
import modelo.Socio;
import modelo.moduloMediciones.BalanzaSystemAdapter;
import modelo.moduloMediciones.Medida;


public class Tonificar extends ObjetivoStrategy {
    private double porcenInitGrsa;
    private double porcenInitMus;
    private double peso;
    private double altura;

    public Tonificar(double duracion,  float peso, float altura,double porcenInitGrsa,double porcenInitMus) {
        super(duracion, 4, 5);
        this.porcenInitGrsa = porcenInitGrsa;
        this.porcenInitMus = porcenInitMus;
        this.altura = altura;
        this.peso = peso;
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

        if (medidaActual.getPorcentajeMusculo() >= nivelIdealMuscular && medidaActual.getPorcentajeGrasa() <= nivelIdealGrasa) {
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
