package vistas;

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.GridLayout;
import java.awt.Window;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Arrays;
import java.util.List;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JSpinner;
import javax.swing.SpinnerNumberModel;

import control.ControladorObjetivo;
import control.ControladorSocio;
import control.WindowManagerSingleton;
import modelo.Socio;
import modelo.VOs.SocioVo;
import modelo.moduloObjetivo.BajarPeso;
import modelo.moduloObjetivo.Mantener;

public class VistaSetMedidasMantener extends JFrame {

    private JSpinner unidades;
    private double maxDuracion = 0;
    private double minDuracion = 0;
    private ControladorObjetivo co;
    private JComboBox<Double> duracionM;

    public VistaSetMedidasMantener() {
        super("Arnold Fitness Center - Setear Medidas Objetivo");
        this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        this.setLayout(new BorderLayout());
        JPanel panel1 = new JPanel();
        panel1.setLayout(new GridLayout(3, 1, 2, 2));

        List<Double> listaDuracionM = Arrays.asList(minDuracion, maxDuracion);
        Double[] doubleArrayM = listaDuracionM.toArray(new Double[0]);

        Container contDuracionEntrenamiento = new Container();
        contDuracionEntrenamiento.setLayout(new GridLayout(1, 2, 2, 2));
        JLabel labelDuracionEntrenamiento = new JLabel("<html>Duracion Entrenamiento</html>");
        duracionM = new JComboBox<>(doubleArrayM);
        duracionM.setSelectedItem(null);
        contDuracionEntrenamiento.add(labelDuracionEntrenamiento);
        contDuracionEntrenamiento.add(duracionM);
        panel1.add(contDuracionEntrenamiento);

        Container contPeso = new Container();
        contPeso.setLayout(new GridLayout(1, 2, 2, 2));
        JLabel labelPeso = new JLabel("<html>Unidades (Kg)</html>");
        unidades = new JSpinner(new SpinnerNumberModel(0.0, null, null, 10));
        contPeso.add(labelPeso);
        contPeso.add(unidades);
        panel1.add(contPeso);

        Container contBotones = new Container();
        contBotones.setLayout(new GridLayout(1, 1, 2, 4));

        JButton btnConfirmarObjetivo = new JButton("<html> Confirmar Duracion </html>");

        class HandlerBtnConfirmarObjetivo implements ActionListener {

            @Override
            public void actionPerformed(ActionEvent e) {
                double n = (double) unidades.getValue();
                Double dur = (Double) duracionM.getSelectedItem();
                co.setDuracionTolerancia(dur, n);
				// avisar que se creo todo bien
				JOptionPane.showMessageDialog(null, "Objetivo Seteado Correctamente", "Mensaje", JOptionPane.INFORMATION_MESSAGE);
				// volver a la vista de inicio de sesion
				WindowManagerSingleton.getInstance().disponibilizarVistaIniciarSesion();
				// cerrar la ventana
				dispose();
            }
        }

        // INSTANCIACION DEL MANEJADOR//
        HandlerBtnConfirmarObjetivo handlerBtnConfirmarObjetivo = new HandlerBtnConfirmarObjetivo();

        btnConfirmarObjetivo.addActionListener(handlerBtnConfirmarObjetivo);

        contBotones.add(btnConfirmarObjetivo);

        panel1.add(contBotones);

        this.add(panel1, BorderLayout.CENTER);
    }

	public void setCObjetivo(ControladorObjetivo co) {
		this.co = co;
	}

	public void setMaxDuracion(double maxDuracion) {
		this.maxDuracion = maxDuracion;
	}

	public void setMinDuracion(double minDuracion) {
		this.minDuracion = minDuracion;
	}

	public void actualizarDuracionComboBox(double max, double min) {
		duracionM.setModel(new DefaultComboBoxModel<>(new Double[]{min, max}));
        // Asegúrate de que la vista se redibuje
        repaint();
        revalidate();
	}


}
