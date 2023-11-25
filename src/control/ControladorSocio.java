package control;

import java.util.ArrayList;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

import modelo.Socio;
import modelo.VOs.SocioVo;
import modelo.enums.Objetivo;
import modelo.excepciones.CredencialesInvalidasException;
import modelo.excepciones.SocioExistenteException;
import vistas.VistaActualizarObjetivo;
import vistas.VistaComenzarEntrenamiento;
import vistas.VistaGestionarMedidas;
import vistas.VistaGestionarObjetivo;
import vistas.VistaIniciarSesion;
import vistas.VistaMenuPrincipal;
import vistas.VistaMenuSocio;
import vistas.VistaRegistrarSocio;
import vistas.VistaSeleccionarObjetivo;

public class ControladorSocio {
    public static ArrayList<Socio> usuarios = new ArrayList<Socio>();
	Socio a = new Socio();
	
		public void autenticarUsuario(JTextField dni, JPasswordField contrasena)  {
		String usr = dni.getText();
        System.out.println("DNI: "+usr);
		String password = new String(contrasena.getPassword());
        System.out.println("Password: "+password);
		
		try {
			a.autenticarUsuario(usr, password);
			JOptionPane.showMessageDialog(null, "¡Bienvenido a Gimnasio Supertlon!");
			//VistaInicioSesion vistaInicioSesion = (VistaInicioSesion) SwingUtilities.getWindowAncestor(usuario);
		    //vistaInicioSesion.setVisible(false);
			disponibilizarVistaMenuPrincipal();

		} catch (CredencialesInvalidasException e) {
			//e.printStackTrace();
			JOptionPane.showMessageDialog(null, e.getMessage());
		}
	}

    public void registrarSocio(SocioVo svo) {
		
		try {
			a.registrarSocio(svo.getNombre(), svo.getApellido(), svo.getEmail(), svo.getDni(), svo.getEdad(), svo.getSexo(), svo.getPassword(), svo.getPeso(), svo.getAltura());
			JOptionPane.showMessageDialog(null, "¡El Socio se ha creado con Exito!");
			
			//VistaCreacionCliente vistaCreacionCliente = (VistaCreacionCliente) SwingUtilities.getWindowAncestor(nombre);
			//vistaCreacionCliente.setVisible(false);
			//VistaCreacionUsuario vistaCreacionUsuario = (VistaCreacionUsuario) SwingUtilities.getWindowAncestor(usuario);
			//vistaCreacionUsuario.setVisible(false);
		}
		catch (SocioExistenteException e) {
			JOptionPane.showMessageDialog(null, e.getMessage());
		}
	}

	public void verListadoSocios(ArrayList <Socio> usuarios){
		for(Socio socio : usuarios){
			System.out.println("Socio: "+socio.getNombre()+" - DNI: "+socio.getDni()+" - Password: -"+socio.getPassword()+"-");
	  }

	}


	public void setObjetivo(Objetivo obj){
		a.setObjetivo(null);
	}


	//VISTAS

	public void disponibilizarVistaMenuPrincipal() {
		VistaMenuPrincipal vMAS = new VistaMenuPrincipal(this);
		vMAS.setVisible(true);
		vMAS.setSize(500,500);
		vMAS.setLocation(0,0);
	}

	public void disponibilizarVistaIniciarSesion() {
		VistaIniciarSesion vIS = new VistaIniciarSesion(this);
		vIS.setVisible(true);
		vIS.setSize(500, 500);
		vIS.setLocation(0, 0);
		
	}

	public void disponibilizarVistaRegistrarSocio() {
		VistaRegistrarSocio vRS = new VistaRegistrarSocio(this);
		vRS.setVisible(true);
		vRS.setSize(500, 500);
		vRS.setLocation(0, 0);
		
	}

	public void disponibilizarVistaMenuSocio() {
		VistaMenuSocio vMS = new VistaMenuSocio(this);
		vMS.setVisible(true);
		vMS.setSize(500, 500);
		vMS.setLocation(0, 0);
	}
	
	public void disponibilizarVistaGestionarObjetivo() {
		VistaGestionarObjetivo vGO = new VistaGestionarObjetivo(this);
		vGO.setVisible(true);
		vGO.setSize(500, 500);
		vGO.setLocation(0, 0);
	}

	public void disponibilizarVistaGestionarMedidas() {
		VistaGestionarMedidas vGM = new VistaGestionarMedidas(this);
		vGM.setVisible(true);
		vGM.setSize(500, 500);
		vGM.setLocation(0, 0);
	}

	public void disponibilizarVistaComenzarEntrenamiento() {
		VistaComenzarEntrenamiento vCE = new VistaComenzarEntrenamiento(this);
		vCE.setVisible(true);
		vCE.setSize(500, 500);
		vCE.setLocation(0, 0);
	}

	public void disponibilizarVistaSeleccionarObjetivo() {
		VistaSeleccionarObjetivo vSO = new VistaSeleccionarObjetivo(this);
		vSO.setVisible(true);
		vSO.setSize(500, 500);
		vSO.setLocation(0, 0);
	}

    public void disponibilizarVistaActualizarObjetivo() {
		VistaActualizarObjetivo vAO = new VistaActualizarObjetivo(this);
		vAO.setVisible(true);
		vAO.setSize(500, 500);
		vAO.setLocation(0, 0);
    }
}