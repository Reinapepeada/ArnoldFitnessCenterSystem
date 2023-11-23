package Control;

import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

import Modelo.Socio;
import Modelo.UsuarioArnold;
import Modelo.Excepciones.CredencialesInvalidasException;
import Vistas.VistaAdmin;
import Vistas.VistaIniciarSesion;
import Vistas.VistaRegistrarSocio;
import Vistas.VistaSocio;
import ar.edu.uade.modelo.Gimnasio;

public class ControladorBienvenida {
	
	static Gimnasio supertlon = Gimnasio.getInstancia();
	
	public static void autenticarUsuario(JTextField usuario, JPasswordField contrasena)  {
		String usr = usuario.getText();
		String password = new String(contrasena.getPassword());
		Socio usrA;
		try {
			usrA = usrA.autenticarUsuario(usr, password);
			JOptionPane.showMessageDialog(null, "¡Bienvenido a Gimnasio Supertlon!");
			//VistaInicioSesion vistaInicioSesion = (VistaInicioSesion) SwingUtilities.getWindowAncestor(usuario);
		    //vistaInicioSesion.setVisible(false);
			if (usrA.soyAdmin()){
				int idAdm = usrA.obtenerId();
				disponibilizarVistaAdmin(idAdm);
			}else if(usrA.soySocio()) {
				Socio socio = (Socio) usrA;
				String documento = socio.getDni();
				disponibilizarVistaSocio(documento);
			}
		} catch (CredencialesInvalidasException e) {
			//e.printStackTrace();
			JOptionPane.showMessageDialog(null, e.getMessage());
		}
	}

	private static void disponibilizarVistaInicioSesion(String documento) {
		VistaIniciarSesion vIC = new VistaIniciarSesion();
		vIC.setVisible(true);
		vIC.setSize(500, 500);
		vIC.setLocation(0, 0);
		
	}

	private static void disponibilizarVistaRegistrarse(int idAdm) {
		VistaRegistrarSocio vREG= new VistaRegistrarSocio(null);
		vREG.setVisible(true);
		vREG.setSize(500, 500);
		vREG.setLocation(0, 0);
	}
}