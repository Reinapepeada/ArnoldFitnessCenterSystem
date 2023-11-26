package vistas;

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Arrays;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import control.ControladorObjetivo;
import control.ControladorSocio;
import modelo.Socio;
import modelo.VOs.SocioVo;
import modelo.enums.Objetivo;
import modelo.moduloObjetivo.BajarPeso;
import modelo.moduloObjetivo.Mantener;
import modelo.moduloObjetivo.ObjetivoStrategy;
import modelo.moduloObjetivo.Tonificar;

public class VistaSeleccionarObjetivo extends JFrame{

    private JComboBox<Object> objetivoCombo;
    private JTextField duracionEntrenamiento;

    BajarPeso instanciaBP = new BajarPeso(0,0,0);
    Mantener instanciaM = new Mantener(2,0,0);
    Tonificar instanciaT = new Tonificar(4,0,0);

	ControladorSocio cs;
	ControladorObjetivo co;

    public VistaSeleccionarObjetivo() {
        super ("Arnold Fitness Center - Seleccionar Objetivo");
		this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		this.setLayout(new BorderLayout());
		JPanel panel1=new JPanel();
		panel1.setLayout(new GridLayout(2,1,2,2));

        Container contObjetivo=new Container();
		contObjetivo.setLayout(new GridLayout(1,2,2,2));
		JLabel labelObjetivo=new JLabel("<html>Seleccionar Objetivo</html>");
		objetivoCombo = new JComboBox<>(new Object[]{instanciaBP.getNombreObjetivo(), instanciaM.getNombreObjetivo(), instanciaT.getNombreObjetivo()});
		objetivoCombo.setSelectedItem(null);
		contObjetivo.add(labelObjetivo);
		contObjetivo.add(objetivoCombo);
		panel1.add(contObjetivo);

        Container contBotones=new Container();
		contBotones.setLayout(new GridLayout(1,1,2,4));

        JButton btnConfirmarObjetivo=new JButton("<html> Confirmar Objetivo </html>");

        class HandlerBtnConfirmarObjetivo implements ActionListener{

			@Override
			public void actionPerformed(ActionEvent e) {
                
                System.out.println("Objetivo Seleccionado: "+objetivoCombo.getSelectedItem());
                String obj=(String)objetivoCombo.getSelectedItem();
				co.setMedidasObjetivo(obj);
			}
		}

        //INSTANCIACION DEL MANEJADOR//
		HandlerBtnConfirmarObjetivo handlerBtnConfirmarObjetivo = new HandlerBtnConfirmarObjetivo();

        btnConfirmarObjetivo.addActionListener(handlerBtnConfirmarObjetivo);

        contBotones.add(btnConfirmarObjetivo);
		
		panel1.add(contBotones);
		
	    this.add(panel1,BorderLayout.CENTER);
    }

	

	public void setCSocio(ControladorSocio cs) {
		this.cs = cs;
	}

	public void setCO(ControladorObjetivo co) {
		this.co = co;
	}

}

//svo.getNombre(), svo.getApellido(), svo.getEmail(), svo.getDni(), svo.getEdad(), svo.getSexo(), svo.getPassword(), svo.getPeso(), svo.getAltura()