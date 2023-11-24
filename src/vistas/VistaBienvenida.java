package Vistas;

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import Control.ControladorIniciarSesion;
import Control.ControladorRegistrarSocio;

public class VistaBienvenida extends JFrame {
	
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
		JButton btnRegistrarse=new JButton("<html> Registrarse </html>");
		
		//CLASE INTERNA//
		class HandlerBtnIniciarSesion implements ActionListener{

			@Override
			public void actionPerformed(ActionEvent e) {
				ControladorIniciarSesion.disponibilizarVistaIniciarSesion();
			}
		}
		
		class HandlerBtnRegistrarse implements ActionListener{

			@Override
			public void actionPerformed(ActionEvent e) {
				ControladorRegistrarSocio.disponibilizarVistaRegistrarSocio();
			}
		}

		//INSTANCIACION DEL MANEJADOR//
		HandlerBtnIniciarSesion handlerBtnIniciarSesion = new HandlerBtnIniciarSesion();
		HandlerBtnRegistrarse handlerBtnRegistrarse = new HandlerBtnRegistrarse();
		
		//ASIGNACION DEL MANEJADOR AL BOTON//
		btnIniciarSesion.addActionListener(handlerBtnIniciarSesion);
		btnRegistrarse.addActionListener(handlerBtnRegistrarse);
		
		contBotones.add(btnIniciarSesion);
		contBotones.add(btnRegistrarse);
		
		panel1.add(contBotones);
		
	    this.add(panel1,BorderLayout.CENTER);

	}

    
}