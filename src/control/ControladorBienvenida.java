package control;

import vistas.VistaIniciarSesion;
import vistas.VistaRegistrarSocio;
public class ControladorBienvenida {

	ControladorSocio cs = new ControladorSocio();

	private void disponibilizarVistaInicioSesion() {
		VistaIniciarSesion vIC = new VistaIniciarSesion(cs);
		vIC.setVisible(true);
		vIC.setSize(500, 500);
		vIC.setLocation(0, 0);
		
	}

	private void disponibilizarVistaRegistrarSocio() {
		VistaRegistrarSocio vREG= new VistaRegistrarSocio(cs);
		vREG.setVisible(true);
		vREG.setSize(500, 500);
		vREG.setLocation(0, 0);
	}
}