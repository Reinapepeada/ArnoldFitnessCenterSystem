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
import control.WindowManagerSingleton;
import modelo.Socio;
import modelo.VOs.SocioVo;


public class VistaMenuSocio extends JFrame{

    /*
     * Socio tiene que poder:
     * 1. Seleccionar Objetivo
     * 2. Actualizar Objetivo
     * 3. Pesarse
     * 4. Registrar Masa Muscular
     * 5. Registrar Grasa Corporal
     * 6. Reforzar Rutina
     * 7. BOTON "COMENZAR ENTRENAMIENTO DEL DIA"
     *    Muestra ejercicios del dia, series, repeticiones y peso
     *    Debe poder ingresar a cada ejercicio para registrar la cantidad de series, repeticiones y peso
     *    Debe poder marcar el ejercicio com ocompletado
     * 
     * BOTONES
     * 1. Gestionar Objetivo - Check
     * 2. Gestionar Medidas - Check
     * 3. COMENZAR ENTRENAMIENTO DEL DIA - Check
     */

	public VistaMenuSocio() {
		
        super ("Arnold Fitness Center - Menu Socio");
		this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		this.setLayout(new BorderLayout());
		JPanel panel1=new JPanel();
		panel1.setLayout(new GridLayout(1,1,2,2));

		Container contBotones=new Container();
		contBotones.setLayout(new GridLayout(3,1,2,4));
		
		//CONSTRUCCION DEL BOTON INICIAR SESION//
		JButton btnGestionarObjetivo=new JButton("<html> Actualizar Objetivo </html>");
		JButton btnGestionarMedidas=new JButton("<html> Gestionar Medidas </html>");
		JButton btnComenzarEntrenamiento=new JButton("<html> Comenzar Entrenamiento del Dia! </html>");
		
        //CLASE INTERNA//
		class HandlerBtnGestionarObjetivo implements ActionListener{

			@Override
			public void actionPerformed(ActionEvent e) {
				WindowManagerSingleton.getInstance().disponibilizarVistaSeleccionarObjetivo();
			}
		}
		
		class HandlerBtnGestionarMedidas implements ActionListener{

			@Override
			public void actionPerformed(ActionEvent e) {
				WindowManagerSingleton.getInstance().disponibilizarVistaGestionarMedidas();
			}
		}

        class HandlerBtnComenzarEntrenamiento implements ActionListener{

			@Override
			public void actionPerformed(ActionEvent e) {
				WindowManagerSingleton.getInstance().disponibilizarVistaComenzarEntrenamiento();
			}
		}

		//INSTANCIACION DEL MANEJADOR//
		HandlerBtnGestionarObjetivo handlerBtnGestionarObjetivo = new HandlerBtnGestionarObjetivo();
		HandlerBtnGestionarMedidas handlerBtnGestionarMedidas = new HandlerBtnGestionarMedidas();
        HandlerBtnComenzarEntrenamiento handlerBtnComenzarEntrenamiento = new HandlerBtnComenzarEntrenamiento();
		
		//ASIGNACION DEL MANEJADOR AL BOTON//
		btnGestionarObjetivo.addActionListener(handlerBtnGestionarObjetivo);
		btnGestionarMedidas.addActionListener(handlerBtnGestionarMedidas);
        btnComenzarEntrenamiento.addActionListener(handlerBtnComenzarEntrenamiento);
		
		contBotones.add(btnGestionarObjetivo);
		contBotones.add(btnGestionarMedidas);
        contBotones.add(btnComenzarEntrenamiento);
		
		panel1.add(contBotones);
		
	    this.add(panel1,BorderLayout.CENTER);

	}
}


