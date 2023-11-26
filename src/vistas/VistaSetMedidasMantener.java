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
import javax.swing.JSpinner;
import javax.swing.SpinnerNumberModel;

import control.ControladorSocio;
import modelo.Socio;
import modelo.VOs.SocioVo;
import modelo.moduloObjetivo.BajarPeso;
import modelo.moduloObjetivo.Mantener;

public class VistaSetMedidasMantener extends JFrame{

    private JSpinner unidades;

    public VistaSetMedidasMantener(Socio a, Mantener m, double min, double max) {
        super ("Arnold Fitness Center - Setear Medidas Objetivo");
		this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		this.setLayout(new BorderLayout());
		JPanel panel1=new JPanel();
		panel1.setLayout(new GridLayout(3,1,2,2));

        List<Double> listaDuracionM = Arrays.asList(min, max);
        Double[] doubleArrayM = listaDuracionM.toArray(new Double[0]);

        Container contDuracionEntrenamiento=new Container();
		contDuracionEntrenamiento.setLayout(new GridLayout(1,2,2,2));
		JLabel labelDuracionEntrenamiento=new JLabel("<html>Duracion Entrenamiento</html>");
		JComboBox<Double> duracionM = new JComboBox<>(doubleArrayM);
		duracionM.setSelectedItem(null);
		contDuracionEntrenamiento.add(labelDuracionEntrenamiento);
		contDuracionEntrenamiento.add(duracionM);
		panel1.add(contDuracionEntrenamiento);

        Container contPeso=new Container();
		contPeso.setLayout(new GridLayout(1,2,2,2));
		JLabel labelPeso=new JLabel("<html>Unidades (Kg)</html>");
		unidades=new JSpinner(new SpinnerNumberModel(0.0, null, null, 10));
		contPeso.add(labelPeso);
		contPeso.add(unidades);
		panel1.add(contPeso);


        Container contBotones=new Container();
		contBotones.setLayout(new GridLayout(1,1,2,4));

        JButton btnConfirmarObjetivo=new JButton("<html> Confirmar Duracion </html>");

        class HandlerBtnConfirmarObjetivo implements ActionListener{
            
			@Override
			public void actionPerformed(ActionEvent e) {
                double n = (double) unidades.getValue();
                Double dur = (Double) duracionM.getSelectedItem();
                double pesoSocio = a.getPeso();
                m.setDuracion(dur);
                m.setPesoInicial(pesoSocio);
                m.setTolerancia(n);
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
