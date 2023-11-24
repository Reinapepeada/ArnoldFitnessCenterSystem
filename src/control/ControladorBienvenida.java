package control;

import vistas.VistaIniciarSesion;
import vistas.VistaRegistrarSocio;

public class ControladorBienvenida {

	private static void disponibilizarVistaInicioSesion() {
		VistaIniciarSesion vIC = new VistaIniciarSesion();
		vIC.setVisible(true);
		vIC.setSize(500, 500);
		vIC.setLocation(0, 0);
		
	}

	private static void disponibilizarVistaRegistrarSocio() {
		VistaRegistrarSocio vREG= new VistaRegistrarSocio();
		vREG.setVisible(true);
		vREG.setSize(500, 500);
		vREG.setLocation(0, 0);
	}
}