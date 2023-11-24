package control;

import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JSpinner;
import javax.swing.JTextField;

import modelo.Socio;
import modelo.excepciones.SocioExistenteException;
import vistas.VistaRegistrarSocio;

public class ControladorRegistrarSocio {
	
    public static void registrarSocio(JTextField nombre, JTextField apellido, JTextField email, JTextField dni, JTextField edad, JTextField sexo, JPasswordField password, JSpinner peso, JSpinner altura) {
        String nombreSocio = nombre.getText();
        String apellidoSocio = apellido.getText();
		String emailSocio = email.getText();
		String dniSocio = dni.getText();
		String edadSocio = edad.getText();
        String sexoSocio = sexo.getText();
		String passwordSocio = new String(password.getPassword());
        Double pesoSocio = (Double) peso.getValue();
		Double alturaSocio = (Double) altura.getValue();

		try {
			Socio.registrarSocio(nombreSocio, apellidoSocio, emailSocio, dniSocio, edadSocio, sexoSocio, passwordSocio, pesoSocio, alturaSocio);
			JOptionPane.showMessageDialog(null, "¡El Socio se ha creado con Exito!");
			//disponibilizarVistaRegistrarSocio();
			//VistaCreacionCliente vistaCreacionCliente = (VistaCreacionCliente) SwingUtilities.getWindowAncestor(nombre);
			//vistaCreacionCliente.setVisible(false);
			//VistaCreacionUsuario vistaCreacionUsuario = (VistaCreacionUsuario) SwingUtilities.getWindowAncestor(usuario);
			//vistaCreacionUsuario.setVisible(false);
		}
		catch (SocioExistenteException e) {
			JOptionPane.showMessageDialog(null, e.getMessage());
		}
	}

	public static void disponibilizarVistaRegistrarSocio() {
		VistaRegistrarSocio vRS = new VistaRegistrarSocio();
		vRS.setVisible(true);
		vRS.setSize(500, 500);
		vRS.setLocation(0, 0);
		
	}

}