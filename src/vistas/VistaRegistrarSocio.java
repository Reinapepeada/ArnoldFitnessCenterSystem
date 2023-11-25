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
import javax.swing.JPasswordField;
import javax.swing.JSpinner;
import javax.swing.JTextField;
import javax.swing.SpinnerNumberModel;

import control.ControladorSocio;
import modelo.VOs.SocioVo;

public class VistaRegistrarSocio extends JFrame{
	
	private JTextField nombre;
    private JTextField apellido;
	private JTextField email;
	private JTextField dni;
	private JTextField edad;
    private JTextField sexo;
	private JPasswordField password;
    private JSpinner peso;
	private JSpinner altura;

	public VistaRegistrarSocio(ControladorSocio cs) {
		super ("Arnold Fitness Center - Registrarse");
		this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		this.setLayout(new BorderLayout());
		JPanel panel1=new JPanel();
		panel1.setLayout(new GridLayout(10,1,2,2));
		
		Container contNombre=new Container();
		contNombre.setLayout(new GridLayout(1,2,2,2));
		JLabel labelNombre=new JLabel("<html>Nombre</html>");
		nombre=new JTextField();
		contNombre.add(labelNombre);
		contNombre.add(nombre);
		panel1.add(contNombre);
		
		Container contApellido=new Container();
		contApellido.setLayout(new GridLayout(1,2,2,2));
		JLabel labelApellido=new JLabel("<html>Apellido</html>");
		apellido=new JTextField();
		contApellido.add(labelApellido);
		contApellido.add(apellido);
		panel1.add(contApellido);

		Container contEmail=new Container();
		contEmail.setLayout(new GridLayout(1,2,2,2));
		JLabel labelEmail=new JLabel("<html>Email</html>");
		email=new JTextField();
		contEmail.add(labelEmail);
		contEmail.add(email);
		panel1.add(contEmail);

		Container contDNI=new Container();
		contDNI.setLayout(new GridLayout(1,2,2,2));
		JLabel labelDNI=new JLabel("<html>DNI</html>");
		dni=new JTextField();
		contDNI.add(labelDNI);
		contDNI.add(dni);
		panel1.add(contDNI);

		Container contEdad=new Container();
		contEdad.setLayout(new GridLayout(1,2,2,2));
		JLabel labelEdad=new JLabel("<html>Edad</html>");
		edad=new JTextField();
		contEdad.add(labelEdad);
		contEdad.add(edad);
		panel1.add(contEdad);

        Container contSexo=new Container();
		contSexo.setLayout(new GridLayout(1,2,2,2));
		JLabel labelSexo=new JLabel("<html>Sexo</html>");
		sexo=new JTextField();
		contSexo.add(labelSexo);
		contSexo.add(sexo);
		panel1.add(contSexo);

		Container contPassword = new Container();
		contPassword.setLayout(new GridLayout(1,2,2,2));
		JLabel labelPassword = new JLabel("<html>Password</html>");
		password = new JPasswordField();
		contPassword.add(labelPassword);
		contPassword.add(password);
		panel1.add(contPassword);		

        Container contPeso=new Container();
		contPeso.setLayout(new GridLayout(1,2,2,2));
		JLabel labelPeso=new JLabel("<html>Peso (Kg)</html>");
		peso=new JSpinner(new SpinnerNumberModel(0.0, null, null, 10));
		contPeso.add(labelPeso);
		contPeso.add(peso);
		panel1.add(contPeso);

        Container contAltura=new Container();
		contAltura.setLayout(new GridLayout(1,2,2,2));
		JLabel labelAltura=new JLabel("<html>Altura (cm)</html>");
		altura=new JSpinner(new SpinnerNumberModel(0.0, null, null, 10));
		contAltura.add(labelAltura);
		contAltura.add(altura);
		panel1.add(contAltura);
		
		/* 
		Container contObjetivo=new Container();
		contObjetivo.setLayout(new GridLayout(1,2,2,2));
		JLabel labelObjetivo=new JLabel("Objetivo");
		Objetivo[] opcionesObjetivo = Objetivo.values();
		objetivo = new JComboBox<>(opcionesObjetivo);
		objetivo.setSelectedItem(null);
		contObjetivo.add(labelObjetivo);
		contObjetivo.add(objetivo);
		panel1.add(contObjetivo);
		*/
		Container contBotones = new Container();
        contBotones.setLayout(new GridLayout(1,1,2,2));
		
		//CONSTRUCCION DEL BOTON PARA CONFIRMAR CREACION DE SEDE//
		JButton btnRegistrarSocio=new JButton("<html>Registrarme</html>");
		
		//CLASE INTERNA//
		
		class HandlerRegistrarSocio implements ActionListener{
			@Override
			public void actionPerformed(ActionEvent e) {

				String nombreSocio = nombre.getText();
				String apellidoSocio = apellido.getText();
				String emailSocio = email.getText();
				String dniSocio = dni.getText();
				String edadSocio = edad.getText();
				String sexoSocio = sexo.getText();
				String passwordSocio = new String(password.getPassword());
				double pesoSocio = (double) peso.getValue();
				double alturaSocio = (double) altura.getValue();
				
				SocioVo svo = new SocioVo(nombreSocio, apellidoSocio, emailSocio, dniSocio, edadSocio, sexoSocio, passwordSocio, pesoSocio, alturaSocio);
				cs.registrarSocio(svo);
				}
			}
				
		//INSTANCIACION DEL MANEJADOR//
		HandlerRegistrarSocio handlerBtnRegistrarSocio=new HandlerRegistrarSocio();
				
		//ASIGNACION DEL MANEJADOR AL BOTON//
		btnRegistrarSocio.addActionListener(handlerBtnRegistrarSocio);
		
		contBotones.add(btnRegistrarSocio);
		
		panel1.add(contBotones);
		
		this.add(panel1, BorderLayout.CENTER);
	}
}
