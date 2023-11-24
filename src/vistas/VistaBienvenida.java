package vistas;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import control.ControladorIniciarSesion;
import control.ControladorRegistrarSocio;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class VistaBienvenida extends JFrame {

	public VistaBienvenida() {
		super("¡Bienvenido a Arnold Fitness Center!");
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.setLayout(new BorderLayout());

		// Título de bienvenida
		JLabel lblTitulo = new JLabel("¡Bienvenido a Arnold Fitness Center!");
		lblTitulo.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblTitulo.setHorizontalAlignment(SwingConstants.CENTER);
		this.add(lblTitulo, BorderLayout.NORTH);

		JPanel panel1 = new JPanel();
		panel1.setLayout(new GridLayout(1, 2, 2, 2));

		Container contBotones = new Container();
		contBotones.setLayout(new GridLayout(2, 1, 2, 4));

		// CONSTRUCCION DEL BOTON INICIAR SESION//
		JButton btnIniciarSesion = new JButton("<html><span style='font-size:10px'>Iniciar Sesión</span></html>");
		JButton btnRegistrarSocio = new JButton("<html><span style='font-size:10px'>Registrarse</span></html>");

		// Estilo de los botones
		btnIniciarSesion.setBackground(new Color(59, 89, 182));
		btnIniciarSesion.setForeground(Color.WHITE);
		btnIniciarSesion.setFocusPainted(false);
		btnIniciarSesion.setFont(new Font("Tahoma", Font.BOLD, 10));

		btnRegistrarSocio.setBackground(new Color(59, 89, 182));
		btnRegistrarSocio.setForeground(Color.WHITE);
		btnRegistrarSocio.setFocusPainted(false);
		btnRegistrarSocio.setFont(new Font("Tahoma", Font.BOLD, 10));

		Dimension buttonSize = new Dimension(250, 100); // Ajusta estos valores según tus necesidades
		btnIniciarSesion.setPreferredSize(buttonSize);
		btnRegistrarSocio.setPreferredSize(buttonSize);

		// CLASE INTERNA//
		class HandlerBtnIniciarSesion implements ActionListener {

			@Override
			public void actionPerformed(ActionEvent e) {
				ControladorIniciarSesion.disponibilizarVistaIniciarSesion();
			}
		}

		class HandlerBtnRegistrarSocio implements ActionListener {

			@Override
			public void actionPerformed(ActionEvent e) {
				ControladorRegistrarSocio.disponibilizarVistaRegistrarSocio();
			}
		}

		// INSTANCIACION DEL MANEJADOR//
		HandlerBtnIniciarSesion handlerBtnIniciarSesion = new HandlerBtnIniciarSesion();
		HandlerBtnRegistrarSocio handlerBtnRegistrarSocio = new HandlerBtnRegistrarSocio();

		// ASIGNACION DEL MANEJADOR AL BOTON//
		btnIniciarSesion.addActionListener(handlerBtnIniciarSesion);
		btnRegistrarSocio.addActionListener(handlerBtnRegistrarSocio);

		contBotones.add(btnIniciarSesion);
		contBotones.add(btnRegistrarSocio);
		contBotones.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));

		panel1.add(contBotones);

		this.add(panel1, BorderLayout.CENTER);
		this.setSize(800, 500); // Ajusta estos valores según tus necesidades
		this.setVisible(true);
	}
}
