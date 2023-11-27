package control;

import java.awt.Container;
import java.awt.List;
import java.util.ArrayList;

import javax.swing.JComboBox;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.plaf.basic.BasicInternalFrameUI;

import modelo.Entrenamiento;
import modelo.Socio;
import modelo.VOs.SocioVo;
import modelo.excepciones.CredencialesInvalidasException;
import modelo.excepciones.SocioExistenteException;


public class ControladorSocio {
	public static final ArrayList<Socio> usuarios = new ArrayList<Socio>();

	private Socio a = new Socio();

	public void autenticarUsuario(JTextField dni, JPasswordField contrasena) {
		String usr = dni.getText();
		// System.out.println("DNI: "+usr);
		String password = new String(contrasena.getPassword());
		// System.out.println("Password: "+password);

		try {
			a=a.autenticarUsuario(usr, password);
			JOptionPane.showMessageDialog(null, "¡Bienvenido a Gym Buddy!");
			// VistaInicioSesion vistaInicioSesion = (VistaInicioSesion)
			// SwingUtilities.getWindowAncestor(usuario);
			// vistaInicioSesion.setVisible(false);
			verListadoSocios(usuarios);
			WindowManagerSingleton.getInstance().disponibilizarVistaMenuSocio();

		} catch (CredencialesInvalidasException e) {
			e.printStackTrace();
			JOptionPane.showMessageDialog(null, e.getMessage());
		}
	}

	public void registrarSocio(SocioVo svo) {

		try {
			a=a.registrarSocio(svo.getNombre(), svo.getApellido(), svo.getEmail(), svo.getDni(), svo.getEdad(), svo.getSexo(), svo.getPassword(), svo.getAltura(), svo.getPeso());
			JOptionPane.showMessageDialog(null, "¡El Socio se ha creado con Exito!");
			
		} catch (SocioExistenteException e) {
			JOptionPane.showMessageDialog(null, e.getMessage());
		}
	}

	public void verListadoSocios(ArrayList<Socio> usuarios) {
		for (Socio x : usuarios) {
			System.out.println("Socio: " + x.getNombre() + " - DNI: " + x.getDni() + " - Password: -" + x.getPassword() + "-" + "Peso: " + x.getPeso());
		}

	}


	public SocioVo getSocioVOActual() {
		return a.getVO();
	}

	public Socio getSocioActual() {
		System.out.println("getSocioActual: "+this.a);
		return this.a;
	}

}