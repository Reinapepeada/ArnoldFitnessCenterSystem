package Vistas;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class VistaSocio extends JFrame {

    	public VistaSocio(String documento) {
		super ("Arnold Fitness Center - Cliente");
		this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		this.setLayout(new BorderLayout());
		JPanel panel1=new JPanel();
		panel1.setLayout(new GridLayout(1,1,2,2));
		
		Container contBotones=new Container();
		contBotones.setLayout(new GridLayout(2,1,2,2));
		
		JButton btnReservarClase = new JButton("Reservar Clase");
		JButton btnHistoricoReservas = new JButton("Historico de Reservas");
		
		class HandlerBtnReservarClase implements ActionListener {
			@Override
			public void actionPerformed(ActionEvent e) {
				ReservarClaseController.disponibilizarVistaSeleccionSede(documento);
			}
		}
		
		class HandlerBtnHistoricoReservas implements ActionListener {
			@Override
			public void actionPerformed(ActionEvent e) {
				JOptionPane.showMessageDialog(null, "Vista en construcciÃ³n. Disculpe las molestias.");
			}
		}
		
		HandlerBtnReservarClase handlerBtnReservarClase = new HandlerBtnReservarClase();
		HandlerBtnHistoricoReservas handlerBtnHistoricoReservas = new HandlerBtnHistoricoReservas();
		btnReservarClase.addActionListener(handlerBtnReservarClase);
		btnHistoricoReservas.addActionListener(handlerBtnHistoricoReservas);
		
		contBotones.add(btnReservarClase);
		contBotones.add(btnHistoricoReservas);
		this.add(contBotones);
	
	}
    
}
