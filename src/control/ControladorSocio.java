package control;

import java.util.List;

import javax.swing.JComboBox;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JSpinner;
import javax.swing.JTextField;

import modelo.Socio;
import modelo.UsuarioArnold;
import modelo.enums.Objetivo;
import modelo.excepciones.SocioExistenteException;
import modelo.moduloObjetivo.ObjetivoStrategy;
import vistas.VistaAdmin;
import vistas.VistaRegistrarSocio;

public class ControladorSocio {
    private Socio socio;
    public static List<Socio> usuarios;

    public ControladorSocio(){

    }

     public static void registrarSocio(JTextField nombre, JTextField apellido, JTextField email, JTextField dni, JTextField edad, JTextField sexo, JPasswordField password, JSpinner peso, JSpinner altura, JComboBox<Objetivo> objetivo) {
        String nombreSocio = nombre.getText();
        String apellidoSocio = apellido.getText();
		String emailSocio = email.getText();
		String dniSocio = dni.getText();
		String edadSocio = edad.getText();
        String sexoSocio = sexo.getText();
		String passwordSocio = new String(password.getPassword());
        float pesoSocio = (float) peso.getValue();
		float alturaSocio = (float) altura.getValue();
        ObjetivoStrategy objetivoSocio = (ObjetivoStrategy) objetivo.getSelectedItem();

		try {
			Socio.registrarSocio(nombreSocio, apellidoSocio, emailSocio, dniSocio, edadSocio, sexoSocio, passwordSocio, pesoSocio, alturaSocio, objetivoSocio);
			JOptionPane.showMessageDialog(null, "¡El cliente se ha creado con Exito!");
			//VistaCreacionCliente vistaCreacionCliente = (VistaCreacionCliente) SwingUtilities.getWindowAncestor(nombre);
			//vistaCreacionCliente.setVisible(false);
			//VistaCreacionUsuario vistaCreacionUsuario = (VistaCreacionUsuario) SwingUtilities.getWindowAncestor(usuario);
			//vistaCreacionUsuario.setVisible(false);
		}
		catch (SocioExistenteException e) {
			JOptionPane.showMessageDialog(null, e.getMessage());
		}
	}

	public static void disponivilizarVistaRegistrarSocio() {
		VistaRegistrarSocio vRS = new VistaRegistrarSocio();
		vRS.setVisible(true);
		vRS.setSize(500, 500);
		vRS.setLocation(0, 0);
		
	}

	private static void disponibilizarVistaAdmin(int idAdm) {
		VistaAdmin vADM= new VistaAdmin(idAdm);
		vADM.setVisible(true);
		vADM.setSize(500, 500);
		vADM.setLocation(0, 0);
	}


}