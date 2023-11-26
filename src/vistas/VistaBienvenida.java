package vistas;

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import control.ControladorSocio;
import control.WindowManagerSingleton;

public class VistaBienvenida extends JFrame {

	private ControladorSocio cs ;
	
	public VistaBienvenida() {
		super ("Arnold Fitness Center - Bienvenido!");
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.setLayout(new BorderLayout());
		JPanel panel1=new JPanel();
		panel1.setLayout(new GridLayout(1,1,2,2));

		Container contBotones=new Container();
		contBotones.setLayout(new GridLayout(2,1,2,4));
		
		//CONSTRUCCION DEL BOTON INICIAR SESION//
		JButton btnIniciarSesion=new JButton("<html> Iniciar Sesion </html>");
		JButton btnRegistrarSocio=new JButton("<html> Registrarse </html>");
		
		//CLASE INTERNA//
		class HandlerBtnIniciarSesion implements ActionListener{

			@Override
			public void actionPerformed(ActionEvent e) {
				WindowManagerSingleton.getInstance().disponibilizarVistaIniciarSesion();
			}
		}
		
		class HandlerBtnRegistrarSocio implements ActionListener{

			@Override
			public void actionPerformed(ActionEvent e) {
				WindowManagerSingleton.getInstance().disponibilizarVistaRegistrarSocio();
			}
		}

		//INSTANCIACION DEL MANEJADOR//
		HandlerBtnIniciarSesion handlerBtnIniciarSesion = new HandlerBtnIniciarSesion();
		HandlerBtnRegistrarSocio handlerBtnRegistrarSocio = new HandlerBtnRegistrarSocio();
		
		//ASIGNACION DEL MANEJADOR AL BOTON//
		btnIniciarSesion.addActionListener(handlerBtnIniciarSesion);
		btnRegistrarSocio.addActionListener(handlerBtnRegistrarSocio);
		
		contBotones.add(btnIniciarSesion);
		contBotones.add(btnRegistrarSocio);
		
		panel1.add(contBotones);
		
	    this.add(panel1,BorderLayout.CENTER);

	}

    
}
