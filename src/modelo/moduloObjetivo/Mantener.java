package modelo.moduloObjetivo;

import modelo.moduloMediciones.BalanzaSystemAdapter;
import modelo.moduloMediciones.Medida;
import modelo.Socio;

public class Mantener extends ObjetivoStrategy {
    private double pesoInicial;
    private double toleraciaVsPesoInicial;
    private double tolerancia;
    private double duracionEntrenamiento;
    private double durMaxima=1.3;
    private double durMinima=0.8;

	
    public Mantener(double duracion,  double pesoInicial, double tol){
        super(duracion, 2, 4);
        this.pesoInicial = pesoInicial;
        this.toleraciaVsPesoInicial = tol;
    }

    @Override
    public double calcularMedidaIdeal() {
        return this.getPesoInicial();
    }

    @Override
    public boolean verificarObjetivo(Socio soc) {
       // TODO - verificar si el peso actual esta entre el rango pasado por parametro 
        // como hacemos para acceder a la medida actual
        BalanzaSystemAdapter balanza = new BalanzaSystemAdapter();
        Medida medidaActual = balanza.tomarMedidas(soc); // deberia ir la medida actual
        if(medidaActual.getPeso() > pesoInicial - toleraciaVsPesoInicial && medidaActual.getPeso() < pesoInicial + toleraciaVsPesoInicial ){
            return true;
        }
        return false;
    }
        

    public void setTolerancia(double tolerancia){
        this.tolerancia = tolerancia;
    }

    public double getTolerancia(){
        return this.tolerancia;
    }

    public void setPesoInicial(double pesoInicial){
        this.pesoInicial = pesoInicial;
    }

    public String getNombreObjetivo(){
		return "Mantener";
	}

    public double getPesoInicial() {
        return this.pesoInicial;
    }
    public double getToleraciaVsPesoInicial() {
        return this.toleraciaVsPesoInicial;
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
