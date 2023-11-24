package control;

import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

import modelo.Socio;
import modelo.excepciones.CredencialesInvalidasException;
import vistas.VistaIniciarSesion;
import vistas.VistaMenuAdminSocio;

public class ControladorIniciarSesion {
	
	public static void autenticarUsuario(JTextField dni, JPasswordField contrasena)  {
		String usr = dni.getText();
		String password = new String(contrasena.getPassword());
		Socio a;
		try {
			a = Socio.autenticarUsuario(usr, password);
			JOptionPane.showMessageDialog(null, "¡Bienvenido a Gimnasio Supertlon!");
			//VistaInicioSesion vistaInicioSesion = (VistaInicioSesion) SwingUtilities.getWindowAncestor(usuario);
		    //vistaInicioSesion.setVisible(false);
			if (a.soySocio()){
				disponibilizarVistaMenuAdminSocio();
			}
		} catch (CredencialesInvalidasException e) {
			//e.printStackTrace();
			JOptionPane.showMessageDialog(null, e.getMessage());
		}
	}

	private static void disponibilizarVistaMenuAdminSocio() {
		VistaMenuAdminSocio vMAS = new VistaMenuAdminSocio();
		vMAS.setVisible(true);
		vMAS.setSize(500,500);
		vMAS.setLocation(0,0);
	}

	public static void disponibilizarVistaIniciarSesion() {
		VistaIniciarSesion vIS = new VistaIniciarSesion();
		vIS.setVisible(true);
		vIS.setSize(500, 500);
		vIS.setLocation(0, 0);
		
	}

}