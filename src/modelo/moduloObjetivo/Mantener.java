package modelo.moduloObjetivo;

import modelo.moduloMediciones.BalanzaSystemAdapter;
import modelo.moduloMediciones.Medida;
import modelo.Socio;
import modelo.enums.Exigencia;

public class Mantener extends ObjetivoStrategy {
    private double pesoInicial;
    private double toleraciaVsPesoInicial;
    private double tolerancia;
    private double duracionEntrenamiento;
    private double durMaxima=1.3;
    private double durMinima=0.8;

	
    public Mantener(double duracion,  double pesoInicial, double tol){
        super(duracion, 2, 4);
        this.setExigenciaBaja();
        this.setExigenciaMedia();
        this.pesoInicial = pesoInicial;
        this.toleraciaVsPesoInicial = tol;
        // this.duracionEntrenamiento = duracionEntrenamiento;
    }

    @Override
    public boolean medidaIdeal(Socio soc) {
        BalanzaSystemAdapter balanza = new BalanzaSystemAdapter();
        Medida medidaActual = balanza.tomarMedidas(soc); // deberia ir la medida actual
        if(medidaActual.getPeso() > pesoInicial - toleraciaVsPesoInicial && medidaActual.getPeso() < pesoInicial + toleraciaVsPesoInicial ){
            return true;
        }
        return false;
    }

    @Override
    public boolean verificarObjetivo(Socio soc) {
       // TODO - verificar si el peso actual esta entre el rango pasado por parametro 
        // como hacemos para acceder a la medida actual
        return medidaIdeal(soc);
        
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
	
    public void setDuracionEntrenamiento(double duracionEntrenamiento) {
        this.duracionEntrenamiento = duracionEntrenamiento;
    }

    public double getDurMaxima() {
		return durMaxima;
	}
	
	public double getDurMinima() {
		return durMinima;
	}

    @Override
    public void setTrofeo() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'setTrofeo'");
    }

    @Override
    public String getNombre() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'getNombre'");
    }

}