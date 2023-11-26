package control;

import java.awt.BorderLayout;
import java.awt.Container;

import javax.swing.JFrame;
import javax.swing.JPanel;

import modelo.VOs.SocioVo;
import vistas.VistaActualizarObjetivo;
import vistas.VistaBienvenida;
import vistas.VistaComenzarEntrenamiento;
import vistas.VistaGestionarMedidas;
import vistas.VistaGestionarObjetivo;
import vistas.VistaIniciarSesion;
import vistas.VistaMenuPrincipal;
import vistas.VistaMenuSocio;
import vistas.VistaRegistrarSocio;
import vistas.VistaSeleccionarObjetivo;
import vistas.VistaSetMedidasMantener;
import vistas.VistaSetMedidasObjetivo;

public class WindowManagerSingleton {
	
	//vistas
	private static WindowManagerSingleton instance;
	private VistaBienvenida vBienvenida;
	private VistaIniciarSesion vIniciarSesion;
	private VistaSeleccionarObjetivo vSeleccionarObjetivo;
	private VistaGestionarObjetivo vGestionarObjetivo;
	private VistaActualizarObjetivo vActualizarObjetivo;
	private VistaGestionarMedidas vGestionarMedidas;
	private VistaMenuPrincipal vMenuPrincipal;
	private VistaRegistrarSocio vRegistrarSocio;
	private VistaMenuSocio vMenuSocio;
	private VistaSetMedidasMantener vSetMedidasMantener;
	private VistaSetMedidasObjetivo vSetMedidasObjetivo;
	private VistaComenzarEntrenamiento vComenzarEntrenamiento;

	// controladores
	private ControladorSocio cs;
	private ControladorAdmin ca;
	private ControladorEjercicio ce;
	private ControladorObjetivo co;

	private WindowManagerSingleton() {
		//instanciamos los controladores
		cs = new ControladorSocio();
		ca = new ControladorAdmin();
		ce = new ControladorEjercicio();
		co = new ControladorObjetivo();

		//instanciamos las vistas

		vBienvenida = new VistaBienvenida();
		vIniciarSesion = new VistaIniciarSesion(cs);
		vSeleccionarObjetivo = new VistaSeleccionarObjetivo();
		vGestionarObjetivo = new VistaGestionarObjetivo();
		vActualizarObjetivo = new VistaActualizarObjetivo();
		vGestionarMedidas = new VistaGestionarMedidas();
		vMenuPrincipal = new VistaMenuPrincipal();
		vRegistrarSocio = new VistaRegistrarSocio();
		vMenuSocio = new VistaMenuSocio();
		vSetMedidasMantener = new VistaSetMedidasMantener();
		vSetMedidasObjetivo = new VistaSetMedidasObjetivo();
		vComenzarEntrenamiento = new VistaComenzarEntrenamiento();
	}

	public static WindowManagerSingleton getInstance() {
		if (instance == null) {
			instance = new WindowManagerSingleton();
		}
		return instance;
	}
	



public void setCS(ControladorSocio cs) {
	this.cs = cs;
}

public void setCA(ControladorAdmin ca) {
	this.ca = ca;
}

public void setCE(ControladorEjercicio ce) {
	this.ce = ce;
}

public void setCO(ControladorObjetivo co) {
	this.co = co;
}

//// setter vistas

public void setVBienvenida(VistaBienvenida vBienvenida) {
	this.vBienvenida = vBienvenida;
}

public void setVIniciarSesion(VistaIniciarSesion vIniciarSesion) {
	this.vIniciarSesion = vIniciarSesion;
}

public void setVSeleccionarObjetivo(VistaSeleccionarObjetivo vSeleccionarObjetivo) {
	this.vSeleccionarObjetivo = vSeleccionarObjetivo;
}

public void setVGestionarObjetivo(VistaGestionarObjetivo vGestionarObjetivo) {
	this.vGestionarObjetivo = vGestionarObjetivo;
}

public void setVActualizarObjetivo(VistaActualizarObjetivo vActualizarObjetivo) {
	this.vActualizarObjetivo = vActualizarObjetivo;
}

public void setVGestionarMedidas(VistaGestionarMedidas vGestionarMedidas) {
	this.vGestionarMedidas = vGestionarMedidas;
}

public void setVMenuPrincipal(VistaMenuPrincipal vMenuPrincipal) {
	this.vMenuPrincipal = vMenuPrincipal;
}

public void setVRegistrarSocio(VistaRegistrarSocio vRegistrarSocio) {
	this.vRegistrarSocio = vRegistrarSocio;
}

public void setVMenuSocio(VistaMenuSocio vMenuSocio) {
	this.vMenuSocio = vMenuSocio;
}

public void setVSetMedidasMantener(VistaSetMedidasMantener vSetMedidasMantener) {
	this.vSetMedidasMantener = vSetMedidasMantener;
}

public void setVSetMedidasObjetivo(VistaSetMedidasObjetivo vSetMedidasObjetivo) {
	this.vSetMedidasObjetivo = vSetMedidasObjetivo;
}

public void setVComenzarEntrenamiento(VistaComenzarEntrenamiento vComenzarEntrenamiento) {
	this.vComenzarEntrenamiento = vComenzarEntrenamiento;
}

//// getter vistas



/////////////////////////////////////////////////////////

// disponibilizar vistas

// VISTAS

	public void disponibilizarVistaMenuPrincipal() {
		
		vMenuPrincipal.setVisible(true);
		vMenuPrincipal.setSize(500, 500);
		vMenuPrincipal.setLocation(0, 0);
	}

	public void disponibilizarVistaIniciarSesion() {
		
		vIniciarSesion.setVisible(true);
		vIniciarSesion.setSize(500, 500);
		vIniciarSesion.setLocation(0, 0);

	}

	public void disponibilizarVistaRegistrarSocio() {
		vRegistrarSocio.setVisible(true);
		vRegistrarSocio.setSize(500, 500);
		vRegistrarSocio.setLocation(0, 0);

	}

	public void disponibilizarVistaMenuSocio() {
		vMenuSocio.setVisible(true);
		vMenuSocio.setSize(500, 500);
		vMenuSocio.setLocation(0, 0);
	}

	public void disponibilizarVistaGestionarMedidas() {
		vGestionarMedidas.setVisible(true);
		vGestionarMedidas.setSize(500, 500);
		vGestionarMedidas.setLocation(0, 0);
	}

	public void disponibilizarVistaComenzarEntrenamiento() {
	   vComenzarEntrenamiento.setVisible(true);
	   vComenzarEntrenamiento.setSize(500, 500);
	   vComenzarEntrenamiento.setLocation(0, 0);
	}

	public void disponibilizarVistaGestionarObjetivo() {
		vGestionarObjetivo.setCSocio(cs);
		vGestionarObjetivo.setVisible(true);
		vGestionarObjetivo.setSize(500, 500);
		vGestionarObjetivo.setLocation(0, 0);
	}

	public void disponibilizarVistaSeleccionarObjetivo() {
		vSeleccionarObjetivo.setVisible(true);
		vSeleccionarObjetivo.setSize(500, 500);
		vSeleccionarObjetivo.setLocation(0, 0);
	}

	public void disponibilizarVistaActualizarObjetivo() {
		vActualizarObjetivo.setVisible(true);
		vActualizarObjetivo.setSize(500, 500);
		vActualizarObjetivo.setLocation(0, 0);
	}

	public void disponibilizarVistaSetMedidasObjetivo(double max, double min) {
		vSetMedidasObjetivo.setMaxDuracion(max);
		vSetMedidasObjetivo.setMinDuracion(min);
		vSetMedidasObjetivo.setVisible(true);
		vSetMedidasObjetivo.setSize(500, 500);
		vSetMedidasObjetivo.setLocation(0, 0);
	}

	public void disponibilizarVistaSetMedidasMantener(double max, double min) {
		vSetMedidasMantener.setMaxDuracion(max);
		vSetMedidasMantener.setMinDuracion(min);
		vSetMedidasMantener.setVisible(true);
		vSetMedidasMantener.setSize(500, 500);
		vSetMedidasMantener.setLocation(0, 0);
	}

	public void disponibilizarVistaBienvenida() {
		vBienvenida.setVisible(true);
		vBienvenida.setSize(500, 500);
		vBienvenida.setLocation(0, 0);
	}



// ocultar vistas


}




	


