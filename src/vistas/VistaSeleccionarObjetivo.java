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

import control.ControladorSocio;
import modelo.enums.Objetivo;
import modelo.moduloObjetivo.BajarPeso;
import modelo.moduloObjetivo.Mantener;
import modelo.moduloObjetivo.ObjetivoStrategy;
import modelo.moduloObjetivo.Tonificar;

public class VistaSeleccionarObjetivo extends JFrame{

    private JComboBox<Object> objetivoCombo;
    private JComboBox<Double> duracionBP;
    private JTextField duracionEntrenamiento;

    BajarPeso instanciaBP = new BajarPeso(0,0,0);
    Mantener instanciaM = new Mantener(2,0,0);
    Tonificar instanciaT = new Tonificar(4,0,0);

    public VistaSeleccionarObjetivo(ControladorSocio cs) {
        super ("Arnold Fitness Center - Seleccionar Objetivo");
		this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		this.setLayout(new BorderLayout());
		JPanel panel1=new JPanel();
		panel1.setLayout(new GridLayout(6,1,2,2));

        Container contObjetivo=new Container();
		contObjetivo.setLayout(new GridLayout(1,2,2,2));
		JLabel labelObjetivo=new JLabel("<html>Seleccionar Objetivo</html>");
		objetivoCombo = new JComboBox<>(new Object[]{instanciaBP.getNombreObjetivo(), instanciaM.getNombreObjetivo(), instanciaT.getNombreObjetivo()});
		objetivoCombo.setSelectedItem(null);
		contObjetivo.add(labelObjetivo);
		contObjetivo.add(objetivoCombo);
		panel1.add(contObjetivo);

        

        List<Double> ListaDuracionBP = Arrays.asList(1.0, 1.5);
        Double[] doubleArrayBP = ListaDuracionBP.toArray(new Double[0]);

        Container contDuracionEntrenamiento=new Container();
		contDuracionEntrenamiento.setLayout(new GridLayout(1,2,2,2));
		JLabel labelDuracionEntrenamiento=new JLabel("<html>Duracion Entrenamiento</html>");
		JComboBox<Double> duracionBP = new JComboBox<>(doubleArrayBP);
		duracionBP.setSelectedItem(null);
		contDuracionEntrenamiento.add(labelDuracionEntrenamiento);
		contDuracionEntrenamiento.add(duracionBP);
		panel1.add(contDuracionEntrenamiento);


        List<Double> duracionM = Arrays.asList(2.0, 2.5);
        Double[] doubleArrayM = duracionM.toArray(new Double[0]);

        Container contDuracionEntrenamiento=new Container();
		contDuracionEntrenamiento.setLayout(new GridLayout(1,2,2,2));
		JLabel labelDuracionEntrenamiento=new JLabel("<html>Duracion Entrenamiento</html>");
		JComboBox<Double> duracionBP = new JComboBox<>(doubleArrayBP);
		duracionBP.setSelectedItem(null);
		contDuracionEntrenamiento.add(labelDuracionEntrenamiento);
		contDuracionEntrenamiento.add(duracionBP);
		panel1.add(contDuracionEntrenamiento);

        List<Double> duracionT = Arrays.asList(0.75, 1.2);
        Double[] doubleArrayT = duracionT.toArray(new Double[0]);


        Container contBotones=new Container();
		contBotones.setLayout(new GridLayout(1,1,2,4));

        JButton btnConfirmarObjetivo=new JButton("<html> Confirmar Objetivo </html>");

        class HandlerBtnConfirmarObjetivo implements ActionListener{

			@Override
			public void actionPerformed(ActionEvent e) {
				//cs.setObjetivo();
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
