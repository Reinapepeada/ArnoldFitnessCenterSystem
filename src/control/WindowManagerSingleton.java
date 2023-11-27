package control;

import java.awt.BorderLayout;
import java.awt.Container;
import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.JPanel;

import modelo.Ejercicio;
import modelo.VOs.SocioVo;
import vistas.VistaActualizarObjetivo;
import vistas.VistaBienvenida;
import vistas.VistaComenzarEntrenamiento;
import vistas.VistaConfgDiasRutina;
import vistas.VistaEjerciciosCompletados;
import vistas.VistaDiaEntrenamiento;
import vistas.VistaGestionarMedidas;
import vistas.VistaGestionarObjetivo;
import vistas.VistaIniciarSesion;
import vistas.VistaMenuSocio;
import vistas.VistaRegistrarSocio;
import vistas.VistaSeleccionarObjetivo;
import vistas.VistaSetMedidasMantener;
import vistas.VistaSetMedidasObjetivo;
import vistas.VistaVerTrofeos;



public class WindowManagerSingleton {

	// vistas
	private static WindowManagerSingleton instance;
	private VistaBienvenida vBienvenida;
	private VistaIniciarSesion vIniciarSesion;
	private VistaSeleccionarObjetivo vSeleccionarObjetivo;
	private VistaGestionarObjetivo vGestionarObjetivo;
	private VistaActualizarObjetivo vActualizarObjetivo;
	private VistaGestionarMedidas vGestionarMedidas;
	private VistaRegistrarSocio vRegistrarSocio;
	private VistaMenuSocio vMenuSocio;
	private VistaSetMedidasMantener vSetMedidasMantener;
	private VistaSetMedidasObjetivo vSetMedidasObjetivo;
	private VistaComenzarEntrenamiento vComenzarEntrenamiento;
	private VistaConfgDiasRutina vConfgDiasRutina;
	private VistaEjerciciosCompletados vEjsCompletados;
	// vista de dia de entrenamiento
	private VistaDiaEntrenamiento vDiaEntrenamiento;
	private VistaVerTrofeos vVerTrofeos;

	// controladores
	private ControladorSocio cs;
	private ControladorEjercicio ce;
	private ControladorObjetivo co;

	private WindowManagerSingleton() {
		// instanciamos los controladores
		cs = new ControladorSocio();
		ce = new ControladorEjercicio();
		co = new ControladorObjetivo();

		// instanciamos las vistas

		vBienvenida = new VistaBienvenida();
		vIniciarSesion = new VistaIniciarSesion();
		vSeleccionarObjetivo = new VistaSeleccionarObjetivo();
		vGestionarObjetivo = new VistaGestionarObjetivo();
		vActualizarObjetivo = new VistaActualizarObjetivo();
		vGestionarMedidas = new VistaGestionarMedidas();
		vRegistrarSocio = new VistaRegistrarSocio();
		vMenuSocio = new VistaMenuSocio();
		vSetMedidasMantener = new VistaSetMedidasMantener();
		vSetMedidasObjetivo = new VistaSetMedidasObjetivo();
		vComenzarEntrenamiento = new VistaComenzarEntrenamiento();
		vConfgDiasRutina = new VistaConfgDiasRutina();
		vEjsCompletados = new VistaEjerciciosCompletados();
		vVerTrofeos = new VistaVerTrofeos();

		//instanciamos la vista de dia de entrenamiento
		vDiaEntrenamiento = new VistaDiaEntrenamiento();

		// seteamos los controladores en las vistas
		vRegistrarSocio.setCSocio(cs);
		//
		vIniciarSesion.setCSocio(cs);
		//
		vSeleccionarObjetivo.setCSocio(cs);
		vSeleccionarObjetivo.setCObjetivo(co);
		//
		vGestionarObjetivo.setCSocio(cs);
		//
		vSetMedidasObjetivo.setCObjetivo(co);
		vSetMedidasMantener.setCObjetivo(co);
		// vista de conf dias de rutina
		vConfgDiasRutina.setCObjetivo(co);

		// vista de dia de entrenamiento
				
		vDiaEntrenamiento.setCObjetivo(co);

		// vista registrar medida set controlador
		vGestionarMedidas.setCSocio(cs);

		vVerTrofeos.setCSocio(cs);

		// // vista comenzar un entrenamiento del dia
		// vComenzarEntrenamiento.setCEjercicio(ce);
		
		// seteamos los controladores en los controladores
		co.setCSocio(cs);
	
		
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

	public void setCE(ControladorEjercicio ce) {
		this.ce = ce;
	}

	public void setCO(ControladorObjetivo co) {
		this.co = co;
	}

	

	//// getter vistas



	/////////////////////////////////////////////////////////

	// disponibilizar vistas

	// VISTAS


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
		vComenzarEntrenamiento.actualizarTabla(co.getEjerciciosDia());
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
		vSeleccionarObjetivo.actualizarControladorSocio(cs);
		vSeleccionarObjetivo.setSize(500, 500);
		vSeleccionarObjetivo.setLocation(0, 0);
		vSeleccionarObjetivo.setVisible(true);
	}

	public void disponibilizarVistaActualizarObjetivo() {
		vActualizarObjetivo.setSize(500, 500);
		vActualizarObjetivo.setLocation(0, 0);
		vActualizarObjetivo.setVisible(true);
	}

	public void disponibilizarVistaSetMedidasObjetivo(double max, double min) {
		vSetMedidasObjetivo.actualizarDuracionComboBox(max, min);
		vSetMedidasObjetivo.setVisible(true);
		vSetMedidasObjetivo.setSize(500, 500);
		vSetMedidasObjetivo.setLocation(0, 0);
	}

	public void disponibilizarVistaSetMedidasMantener(double max, double min) {
		vSetMedidasMantener.actualizarDuracionComboBox(max, min);
		vSetMedidasMantener.setVisible(true);
		vSetMedidasMantener.setSize(500, 500);
		vSetMedidasMantener.setLocation(0, 0);
	}

	public void disponibilizarVistaBienvenida() {
		vBienvenida.setVisible(true);
		vBienvenida.setSize(500, 500);
		vBienvenida.setLocation(0, 0);
	}

	public void disponibilizarVistaConfgDiasRutina() {
		vConfgDiasRutina.setVisible(true);
		vConfgDiasRutina.setSize(500, 500);
		vConfgDiasRutina.setLocation(0, 0);
	}

	public void disponibilizarVistaEjerciciosCompeltados() {
		vEjsCompletados.actualizarTabla(co.getEjerciosRealizados());
		vEjsCompletados.setVisible(true);
		vEjsCompletados.setSize(500, 500);
		vEjsCompletados.setLocation(0, 0);

	}
	public void disponibilizarVistaDiaEntrenamiento() {
		vDiaEntrenamiento.setCObjetivo(co);
		vDiaEntrenamiento.setListaEjercicios(co.getEjerciciosDia());
		vDiaEntrenamiento.setVisible(true);
		vDiaEntrenamiento.setSize(500, 500);
		vDiaEntrenamiento.setLocation(0, 0);
	}

	public void disponibilizarVistaVerTrofeos() {
		vVerTrofeos.setCSocio(cs);
		vVerTrofeos.actualizarTabla(cs.countTrofeos());
		vVerTrofeos.setVisible(true);
		vVerTrofeos.setSize(500, 500);
		vVerTrofeos.setLocation(0, 0);
	}
}
