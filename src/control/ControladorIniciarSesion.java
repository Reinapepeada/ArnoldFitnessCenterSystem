package Control;

import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

import modelo.roles.Socio;
import modelo.roles.UsuarioArnold;
import modelo.excepciones.CredencialesInvalidasException;
import vistas.VistaAdmin;
import vistas.VistaIniciarSesion;
import vistas.VistaSocio;

public class ControladorIniciarSesion {
	
	
	public static void autenticarUsuario(JTextField dni, JPasswordField contrasena)  {
		String usr = dni.getText();
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

	public static void disponibilizarVistaIniciarSesion() {
		VistaIniciarSesion vIS = new VistaIniciarSesion();
		vIS.setVisible(true);
		vIS.setSize(500, 500);
		vIS.setLocation(0, 0);
		
	}

	public static void disponibilizarVistaSocio(String dni) {
	VistaSocio vCL = new VistaSocio(dni);
	vCL.setVisible(true);
	vCL.setSize(500, 500);
	vCL.setLocation(0, 0);
		
	}

	public static void disponibilizarVistaAdmin(int idAdm) {
		VistaAdmin vADM= new VistaAdmin(idAdm);
		vADM.setVisible(true);
		vADM.setSize(500, 500);
		vADM.setLocation(0, 0);
	}
}