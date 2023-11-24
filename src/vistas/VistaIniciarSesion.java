package Vistas;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

import Control.ControladorIniciarSesion;

public class VistaIniciarSesion extends JFrame {

    private JTextField usuario;
	private JPasswordField contrasena;
	
	public VistaIniciarSesion() {
		super ("Arnold Fitness Center - Inicio de sesion");
		this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		this.setLayout(new BorderLayout());
		JPanel panel1=new JPanel();
		panel1.setLayout(new GridLayout(3,1,2,2));
		
		Container contUsuario=new Container();
		contUsuario.setLayout(new GridLayout(3,2,2,2));
		JLabel labelUsuario=new JLabel("Usuario");
		usuario=new JTextField();
		contUsuario.add(labelUsuario);
		contUsuario.add(usuario);
		panel1.add(contUsuario);
		
		Container contPassword=new Container();
		contPassword.setLayout(new GridLayout(3,2,2,2));
		JLabel labelPassword=new JLabel("Contraseña");
		contrasena=new JPasswordField();
		contPassword.add(labelPassword);
		contPassword.add(contrasena);
		panel1.add(contPassword);
		
		
		Container contBotones=new Container();
		contBotones.setLayout(new GridLayout(4,2,2,4));
		
		//CONSTRUCCION DEL BOTON INICIAR SESION//
		JButton btnIniciarSesion=new JButton("Iniciar Sesion");
		JButton btnRegistrarse=new JButton("Registrarse");
		
		//CLASE INTERNA//
		class HandlerBtnIniciarSesion implements ActionListener{

			@Override
			public void actionPerformed(ActionEvent e) {
				ControladorIniciarSesion.autenticarUsuario(usuario, contrasena);
			}
		}
		
		class HandlerBtnRegistrarse implements ActionListener{

			@Override
			public void actionPerformed(ActionEvent e) {
				ControladorIniciarSesion.autenticarUsuario(usuario, contrasena);
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