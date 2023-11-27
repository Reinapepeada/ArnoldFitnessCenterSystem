package modelo.moduloTrofeo;

import java.time.LocalDate;

import javax.swing.JOptionPane;

import modelo.Socio;
import modelo.moduloMediciones.Medida;
import modelo.moduloNNN.Notificador;
public class TrofeoCreido extends TrofeoObservador {
	private Socio socio;
	private String nombre;
	
	public TrofeoCreido( Socio s) {
		this.nombre = "Trofeo Creido";
		this.socio = s;
	}

	@Override
	public boolean chequearTrofeo() {
		// TODO Auto-generated method stub
		int contadorVeces = 0; 
		for (Medida med : socio.getMedidas()) {
			LocalDate fechaMedida = med.getDate();
			// Check if the month of the medida is the same as the current month
			if (fechaMedida.getMonth() == LocalDate.now().getMonth()) {
				contadorVeces++;
				if(contadorVeces >= 3 ){
					
					JOptionPane.showMessageDialog(null, "¡Haz Recibido un Trofeo al creido!");
					socio.concederTrofeo(this);
					return true;
				}
			}
		}
		return false;
	}
	
	public String getNombre(){
		return this.nombre;
	}

}
