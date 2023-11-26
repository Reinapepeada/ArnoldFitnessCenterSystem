package vistas;

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.GridLayout;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableModel;

import control.ControladorSocio;
import modelo.Socio;

public class VistaComenzarEntrenamiento extends JFrame{

    private JTable tablaDesgaste= new JTable();

    public VistaComenzarEntrenamiento(ControladorSocio cs, Socio a) {
        super ("Arnold Fitness Center - Dia de Entrenamiento!");
		this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		this.setLayout(new BorderLayout());
		JPanel panel1=new JPanel();
		panel1.setLayout(new GridLayout(2,1,2,2));

        panel1.add(new JLabel("Semana: "+"TBD"+" Dia: "+"TBD"));
		this.add(panel1,BorderLayout.NORTH);

        JPanel panelCentral=new JPanel();
		panelCentral.setLayout(new BorderLayout());
		
		this.add(panelCentral,BorderLayout.CENTER);
		
		DefaultTableModel modeloTablaDesgasteArticulos= new DefaultTableModel() {
		@Override
        public boolean isCellEditable(int row, int column) {
            return false;
        }
		};

        Object[] titulos= {"Ejercicio", "Series", "Repeticiones", "Peso"};
		modeloTablaDesgasteArticulos.setColumnIdentifiers(titulos);

        JLabel LabelEjercicio = new JLabel("<html> Ejercicio: </html>");
		JLabel LabelSeries = new JLabel("<html> Series: </html>");
        JLabel LabelRepeticiones = new JLabel("<html> Repeticiones: </html>");
        JLabel LabelPeso = new JLabel("<html> Peso: </html>");

        /*MATRIZ DE EJERCICIOS*/

        LabelEjercicio.setHorizontalAlignment(SwingConstants.CENTER);
        LabelSeries.setHorizontalAlignment(SwingConstants.CENTER);
        LabelRepeticiones.setHorizontalAlignment(SwingConstants.CENTER);
        LabelPeso.setHorizontalAlignment(SwingConstants.CENTER);
    }

}
