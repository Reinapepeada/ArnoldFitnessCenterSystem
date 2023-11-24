package control;

import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

import modelo.excepciones.CredencialesInvalidasException;
import modelo.roles.Socio;
import modelo.roles.UsuarioArnold;
import vistas.VistaAdmin;
import vistas.VistaIniciarSesion;
import vistas.VistaRegistrarSocio;
import vistas.VistaSocio;

public class ControladorBienvenida {

	private static void disponibilizarVistaInicioSesion(String documento) {
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