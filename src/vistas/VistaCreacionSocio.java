package vistas;

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import control.ControladorSocio;
import modelo.moduloObjetivo.BajarPeso;
import modelo.moduloObjetivo.Mantener;
import modelo.moduloObjetivo.Tonificar;

public class VistaCreacionSocio extends JFrame {
	
	private JTextField nombre;
	private JTextField documento;

    String [] obj = {"BajarPeso", "Tonificar", "Mantener"};

	public VistaCreacionSocio(JTextField usuario, JTextField contrasena) {
		super ("Arnold Fitness Center - Crear Cliente");
		this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		this.setLayout(new BorderLayout());
		JPanel panel1=new JPanel();
		panel1.setLayout(new GridLayout(4,2,2,2));
		
		Container contNombre=new Container();
		contNombre.setLayout(new GridLayout(1,2,2,2));
		JLabel labelNombre=new JLabel("Nombre");
		nombre=new JTextField();
		contNombre.add(labelNombre);
		contNombre.add(nombre);
		panel1.add(contNombre);
		
		
		Container contDocumento=new Container();
		contDocumento.setLayout(new GridLayout(1,2,2,2));
		JLabel labelDocumento=new JLabel("Documento");
		documento=new JTextField();
		contDocumento.add(labelDocumento);
		contDocumento.add(documento);
		panel1.add(contDocumento);
		
		Container contObjetivo=new Container();
		contObjetivo.setLayout(new GridLayout(1,2,2,2));
		JLabel labelObjetivo=new JLabel("Objetivo");
		final JComboBox objetivos = new JComboBox<>(obj);
		objetivos.setSelectedItem(null);
		contObjetivo.add(labelObjetivo);
		contObjetivo.add(objetivos);
		panel1.add(contObjetivo);
		
		Container contBotones=new Container();
		contBotones.setLayout(new GridLayout(4,2,2,2));
		
		//CONSTRUCCION DEL BOTON PARA CONTINUAR CONSTRUCCIÃ“N DEL PERFIL//
		JButton btnConfirmar=new JButton("Confirmar CreaciÃ³n");
		
		//CLASE INTERNA//
		
		class HandlerBtnConfirmar implements ActionListener{
			@Override
			public void actionPerformed(ActionEvent e) {
				
				ControladorSocio.crearSocio(usuario, contrasena, nombre, documento, objetivos);
				
				}
			}
				
		//INSTANCIACION DEL MANEJADOR//
		HandlerBtnConfirmar handlerBtnConfirmar=new HandlerBtnConfirmar();
				
		//ASIGNACION DEL MANEJADOR AL BOTON//
		btnConfirmar.addActionListener(handlerBtnConfirmar);
		
		
		contBotones.add(btnConfirmar);
		
		panel1.add(contBotones);
		
		this.add(panel1, BorderLayout.CENTER);
	}

}
