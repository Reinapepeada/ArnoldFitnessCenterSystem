package control;

import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

import modelo.Socio;
import ar.edu.uade.modelo.Gimnasio;
import modelo.UsuarioArnold;
import modelo.excepciones.CredencialesInvalidasException;
import vistas.VistaAdmin;
import vistas.VistaSocio;

public class ControladorInicioSesion {
	
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

	private static void disponibilizarVistaSocio(String documento) {
		VistaSocio vCL = new VistaSocio(documento);
		vCL.setVisible(true);
		vCL.setSize(500, 500);
		vCL.setLocation(0, 0);
		
	}

	private static void disponibilizarVistaAdmin(int idAdm) {
		VistaAdmin vADM= new VistaAdmin(idAdm);
		vADM.setVisible(true);
		vADM.setSize(500, 500);
		vADM.setLocation(0, 0);
	}
}