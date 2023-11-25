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
import modelo.VOs.SocioVo;

public class VistaGestionarObjetivo extends JFrame {

    public VistaGestionarObjetivo(ControladorSocio cs, SocioVo svo) {

        super ("Arnold Fitness Center - Menu Socio");
		this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		this.setLayout(new BorderLayout());
		JPanel panel1=new JPanel();
		panel1.setLayout(new GridLayout(1,1,2,2));

		Container contBotones=new Container();
		contBotones.setLayout(new GridLayout(2,1,2,4));
		
		//CONSTRUCCION DEL BOTON INICIAR SESION//
		JButton btnSeleccionarObjetivo=new JButton("<html> Seleccionar Objetivo </html>");
		JButton btnGestionarObjetivo=new JButton("<html> Actualizar Objetivo </html>");

        //CLASE INTERNA//
		class HandlerBtnSeleccionarObjetivo implements ActionListener{

			@Override
			public void actionPerformed(ActionEvent e) {
				cs.disponibilizarVistaSeleccionarObjetivo(svo);
			}
		}
		
		class HandlerBtnGestionarObjetivo implements ActionListener{

			@Override
			public void actionPerformed(ActionEvent e) {
				cs.disponibilizarVistaActualizarObjetivo();
			}
		}

		//INSTANCIACION DEL MANEJADOR//
		HandlerBtnSeleccionarObjetivo handlerBtnSeleccionarObjetivo = new HandlerBtnSeleccionarObjetivo();
		HandlerBtnGestionarObjetivo handlerBtnGestionarObjetivo = new HandlerBtnGestionarObjetivo();
		
		//ASIGNACION DEL MANEJADOR AL BOTON//
		btnSeleccionarObjetivo.addActionListener(handlerBtnSeleccionarObjetivo);
		btnGestionarObjetivo.addActionListener(handlerBtnGestionarObjetivo);
		
		contBotones.add(btnSeleccionarObjetivo);
		contBotones.add(btnGestionarObjetivo);
		
		panel1.add(contBotones);
		
	    this.add(panel1,BorderLayout.CENTER);
    }

}
