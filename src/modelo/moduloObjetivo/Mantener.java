package modelo.moduloObjetivo;

import modelo.moduloMediciones.BalanzaSystemAdapter;
import modelo.moduloMediciones.Medida;
import modelo.Socio;

public class Mantener extends ObjetivoStrategy {
    private float pesoInicial;
    private float toleraciaVsPesoInicial;

	
    public Mantener(double duracion,  float peso,float tol){
        super(duracion, 2, 4);
        this.pesoInicial = peso;
        this.toleraciaVsPesoInicial = tol;
    }
    @Override
    public double calcularMedidaIdeal(){
        return this.getPesoInicial() + this.getToleraciaVsPesoInicial();
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
        

    public String getNombreObjetivo(){
		return "Mantener";
	}

    public float getPesoInicial() {
        return this.pesoInicial;
    }
    public float getToleraciaVsPesoInicial() {
        return this.toleraciaVsPesoInicial;
    }
	@Override
	public void chequearTrofeo() {
		// TODO Auto-generated method stub
		
	}

    
}
