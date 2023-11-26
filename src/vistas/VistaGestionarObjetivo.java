package vistas;

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

import control.ControladorSocio;
import control.WindowManagerSingleton;
import modelo.VOs.SocioVo;



public class VistaGestionarObjetivo extends JFrame {

	private ControladorSocio cs;
	private SocioVo svo;

	public VistaGestionarObjetivo() {
		super("Arnold Fitness Center - Menu Socio");
		
		

		this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		this.setLayout(new BorderLayout());
		JPanel panel1 = new JPanel();
		panel1.setLayout(new GridLayout(1, 1, 2, 2));

		Container contBotones = new Container();
		contBotones.setLayout(new GridLayout(2, 1, 2, 4));

		// CONSTRUCCION DEL BOTON INICIAR SESION//
		JButton btnSeleccionarObjetivo = new JButton("<html> Seleccionar Objetivo </html>");
		JButton btnGestionarObjetivo = new JButton("<html> Actualizar Objetivo </html>");

		// CLASE INTERNA//
		class HandlerBtnSeleccionarObjetivo implements ActionListener {

			@Override
			public void actionPerformed(ActionEvent e) {
				WindowManagerSingleton.getInstance().disponibilizarVistaSeleccionarObjetivo();
			}
		}

		class HandlerBtnGestionarObjetivo implements ActionListener {

			@Override
			public void actionPerformed(ActionEvent e) {
				WindowManagerSingleton.getInstance().disponibilizarVistaActualizarObjetivo();
			}
		}

		// INSTANCIACION DEL MANEJADOR//
		HandlerBtnSeleccionarObjetivo handlerBtnSeleccionarObjetivo = new HandlerBtnSeleccionarObjetivo();
		HandlerBtnGestionarObjetivo handlerBtnGestionarObjetivo = new HandlerBtnGestionarObjetivo();

		// ASIGNACION DEL MANEJADOR AL BOTON//
		btnSeleccionarObjetivo.addActionListener(handlerBtnSeleccionarObjetivo);
		btnGestionarObjetivo.addActionListener(handlerBtnGestionarObjetivo);

		contBotones.add(btnSeleccionarObjetivo);
		contBotones.add(btnGestionarObjetivo);

		panel1.add(contBotones);

		this.add(panel1, BorderLayout.CENTER);
	}

	public void setCSocio(ControladorSocio cs) {
		this.cs = cs;
		this.svo = cs.getSocioVOActual();
	}


	private void disponibilizarVistaSeleccionarObjetivo() {
		WindowManagerSingleton.getInstance().disponibilizarVistaSeleccionarObjetivo();
	}

	private void disponibilizarVistaActualizarObjetivo() {
		WindowManagerSingleton.getInstance().disponibilizarVistaActualizarObjetivo();
	}
}
