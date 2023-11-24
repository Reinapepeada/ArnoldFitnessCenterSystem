package control;

import java.util.List;

import javax.swing.JComboBox;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

import modelo.roles.UsuarioArnold;
import modelo.excepciones.SocioExistenteException;

public class ControladorSocio {

    public static List<UsuarioArnold> usuarios;

    public static void crearCliente(JTextField usuario, JTextField contrasena, JTextField nombre, JTextField documento, JComboBox<Plan> plan) {
    String usrCliente = usuario.getText();
    String passCliente = contrasena.getText();
    String nombreCliente = nombre.getText();
    String documentoCliente = documento.getText();
    
	try {
        supertlon.crearCliente(usrCliente, passCliente, nombreCliente, documentoCliente);
        JOptionPane.showMessageDialog(null, "Â¡El cliente se ha creado con Ã©xito!");
        //VistaCreacionCliente vistaCreacionCliente = (VistaCreacionCliente) SwingUtilities.getWindowAncestor(nombre);
        //vistaCreacionCliente.setVisible(false);
        //VistaCreacionUsuario vistaCreacionUsuario = (VistaCreacionUsuario) SwingUtilities.getWindowAncestor(usuario);
        //vistaCreacionUsuario.setVisible(false);
		}
		catch (SocioExistenteException e) {
			JOptionPane.showMessageDialog(null, e.getMessage());
		}	
	}
}