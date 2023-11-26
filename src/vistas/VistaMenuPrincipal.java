package vistas;

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

import control.ControladorAdmin;
import control.ControladorSocio;
import control.WindowManagerSingleton;
import modelo.Socio;
import modelo.VOs.SocioVo;

public class VistaMenuPrincipal extends JFrame {
	
	public VistaMenuPrincipal() {
		super ("Arnold Fitness Center - Menu Principal");
		this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		this.setLayout(new BorderLayout());
		JPanel panel1=new JPanel();
		panel1.setLayout(new GridLayout(1,1,2,2));

		Container contBotones=new Container();
		contBotones.setLayout(new GridLayout(2,1,2,4));
		
		//CONSTRUCCION DEL BOTON INICIAR SESION//
		JButton btnIniciarSesion=new JButton("<html> Menu Admin </html>");
		JButton btnRegistrarSocio=new JButton("<html> Menu Socio </html>");
		
		//CLASE INTERNA//
		class HandlerBtnIniciarSesion implements ActionListener{

			@Override
			public void actionPerformed(ActionEvent e) {
				ControladorAdmin.disponibilizarVistaMenuAdmin();
			}
		}
		
		class HandlerBtnRegistrarSocio implements ActionListener{

			@Override
			public void actionPerformed(ActionEvent e) {
				WindowManagerSingleton.getInstance().disponibilizarVistaMenuSocio();
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
