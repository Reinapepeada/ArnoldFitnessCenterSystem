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
import modelo.enums.Objetivo;
import modelo.excepciones.CredencialesInvalidasException;
import modelo.excepciones.SocioExistenteException;
import modelo.moduloObjetivo.BajarPeso;
import modelo.moduloObjetivo.Mantener;
import modelo.moduloObjetivo.ObjetivoStrategy;
import modelo.moduloObjetivo.Tonificar;
import vistas.VistaActualizarObjetivo;
import vistas.VistaComenzarEntrenamiento;
import vistas.VistaGestionarMedidas;
import vistas.VistaGestionarObjetivo;
import vistas.VistaIniciarSesion;
import vistas.VistaMenuPrincipal;
import vistas.VistaMenuSocio;
import vistas.VistaRegistrarSocio;
import vistas.VistaSeleccionarObjetivo;
import vistas.VistaSetMedidasObjetivo;
import vistas.VistaSetMedidasMantener;
import vistas.VistaSetMedidasTonificar;

public class ControladorSocio {
    public static ArrayList<Socio> usuarios = new ArrayList<Socio>();
	Socio a = new Socio();
	
		public void autenticarUsuario(JTextField dni, JPasswordField contrasena)  {
		String usr = dni.getText();
        //System.out.println("DNI: "+usr);
		String password = new String(contrasena.getPassword());
        //System.out.println("Password: "+password);
		
		try {
			a = a.autenticarUsuario(usr, password);
			JOptionPane.showMessageDialog(null, "¡Bienvenido a Gym Buddy!");
			//VistaInicioSesion vistaInicioSesion = (VistaInicioSesion) SwingUtilities.getWindowAncestor(usuario);
		    //vistaInicioSesion.setVisible(false);
			verListadoSocios(usuarios);
			disponibilizarVistaMenuPrincipal(null);

		} catch (CredencialesInvalidasException e) {
			//e.printStackTrace();
			JOptionPane.showMessageDialog(null, e.getMessage());
		}
	}

    public void registrarSocio(SocioVo svo) {
		
		try {
			a.registrarSocio(svo.getNombre(), svo.getApellido(), svo.getEmail(), svo.getDni(), svo.getEdad(), svo.getSexo(), svo.getPassword(), svo.getAltura(), svo.getPeso());
			JOptionPane.showMessageDialog(null, "¡El Socio se ha creado con Exito!");
			System.out.println("a.registrarSocio(svo...) peso: "+a.getPeso());
			disponibilizarVistaSeleccionarObjetivo(a);
		}
		catch (SocioExistenteException e) {
			JOptionPane.showMessageDialog(null, e.getMessage());
		}
	}

	public void verListadoSocios(ArrayList <Socio> usuarios){
		for(Socio a : usuarios){
			System.out.println("Socio: "+a.getNombre()+" - DNI: "+a.getDni()+" - Password: -"+a.getPassword()+"-"+ "Peso: "+a.getPeso());
	  }

	}


	public void setObjetivo(Objetivo obj){
		a.setObjetivo(null);
	}
	
	public void setMedidasObjetivo(Socio a, JComboBox<Object> objetivoCombo){
		String obj = (String) objetivoCombo.getSelectedItem();
		switch (obj) {
			case "BajarPeso":
				BajarPeso os = new BajarPeso(0, a.getPeso(), a.getAltura());
				VistaSetMedidasObjetivo vSMBP = new VistaSetMedidasObjetivo(this, a, os, 1.0,1.5);
				vSMBP.setVisible(true);
				vSMBP.setSize(500,500);
				vSMBP.setLocation(0,0);
				break;
			case "Mantener":
				Mantener m = new Mantener(0, a.getPeso(), 0);
				VistaSetMedidasMantener vSMM = new VistaSetMedidasMantener(a, m, 2.0,2.5);
				vSMM.setVisible(true);
				vSMM.setSize(500,500);
				vSMM.setLocation(0,0);
				break;
			case "Tonificar":
				Tonificar t = new Tonificar(0, a.getPeso(), a.getAltura());
				VistaSetMedidasObjetivo vSMT = new VistaSetMedidasObjetivo(this, a, t, 0.75,1.2);
				vSMT.setVisible(true);
				vSMT.setSize(500,500);
				vSMT.setLocation(0,0);
				break;
			default:
				break;
		}
		    
	}
 	
	//VISTAS

	public void disponibilizarVistaMenuPrincipal(Socio a) {
		VistaMenuPrincipal vMAS = new VistaMenuPrincipal(this, a);
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

	public void disponibilizarVistaMenuSocio(Socio a) {
		VistaMenuSocio vMS = new VistaMenuSocio(this, a);
		vMS.setVisible(true);
		vMS.setSize(500, 500);
		vMS.setLocation(0, 0);
	}
	
	public void disponibilizarVistaGestionarMedidas(Socio a) {
		VistaGestionarMedidas vGM = new VistaGestionarMedidas(this, a);
		vGM.setVisible(true);
		vGM.setSize(500, 500);
		vGM.setLocation(0, 0);
	}

	public void disponibilizarVistaComenzarEntrenamiento() {
		VistaComenzarEntrenamiento vCE = new VistaComenzarEntrenamiento(this, a);
		vCE.setVisible(true);
		vCE.setSize(500, 500);
		vCE.setLocation(0, 0);
	}

	public void disponibilizarVistaGestionarObjetivo(Socio a) {
		VistaGestionarObjetivo vGO = new VistaGestionarObjetivo(this, a);
		vGO.setVisible(true);
		vGO.setSize(500, 500);
		vGO.setLocation(0, 0);
	}

	public void disponibilizarVistaSeleccionarObjetivo(Socio a) {
		VistaSeleccionarObjetivo vSO = new VistaSeleccionarObjetivo(this, a);
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