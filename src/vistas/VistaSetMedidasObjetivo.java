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

import control.ControladorSocio;
import modelo.Socio;
import modelo.VOs.SocioVo;
import modelo.moduloObjetivo.BajarPeso;
import modelo.moduloObjetivo.ObjetivoStrategy;

public class VistaSetMedidasObjetivo extends JFrame{
	private JComboBox<Double> duracion;
    public VistaSetMedidasObjetivo(ControladorSocio controladorSocio, Socio a, ObjetivoStrategy os, double min, double max) {
        super ("Arnold Fitness Center - Setear Medidas Objetivo");
		this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		this.setLayout(new BorderLayout());
		JPanel panel1=new JPanel();
		panel1.setLayout(new GridLayout(2,1,2,2));

        List<Double> ListaDuracion = Arrays.asList(min, max);
        Double[] doubleArray = ListaDuracion.toArray(new Double[0]);

        Container contDuracionEntrenamiento=new Container();
		contDuracionEntrenamiento.setLayout(new GridLayout(1,2,2,2));
		JLabel labelDuracionEntrenamiento=new JLabel("<html>Duracion Entrenamiento</html>");
		duracion = new JComboBox<>(new Double[]{min, max});
		duracion.setSelectedItem(null);
		contDuracionEntrenamiento.add(labelDuracionEntrenamiento);
		contDuracionEntrenamiento.add(duracion);
		panel1.add(contDuracionEntrenamiento);
		
        Container contBotones=new Container();
		contBotones.setLayout(new GridLayout(1,1,2,4));

        JButton btnConfirmarObjetivo=new JButton("<html> Confirmar Duracion </html>");

        class HandlerBtnConfirmarObjetivo implements ActionListener{

			@Override
			public void actionPerformed(ActionEvent e) {
				double pesoSocio = a.getPeso();
            	double alturaSocio= a.getAltura();
            	Double dur = (Double) duracion.getSelectedItem();
				System.out.println("Duracion Seleccionada: "+dur);
               	BajarPeso bp = new BajarPeso(dur, alturaSocio, pesoSocio);
			   	a.setObjetivo(bp);
			}
		}

        //INSTANCIACION DEL MANEJADOR//
		HandlerBtnConfirmarObjetivo handlerBtnConfirmarObjetivo = new HandlerBtnConfirmarObjetivo();

        btnConfirmarObjetivo.addActionListener(handlerBtnConfirmarObjetivo);

        contBotones.add(btnConfirmarObjetivo);
		
		panel1.add(contBotones);
		
	    this.add(panel1,BorderLayout.CENTER);

    }

}
