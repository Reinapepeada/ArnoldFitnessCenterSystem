package vistas;

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.GridLayout;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableModel;

import control.ControladorEjercicio;
import control.ControladorSocio;
import modelo.Ejercicio;
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

        /*MATRIZ DE EJERCICIOS*/

		for(Ejercicio ej : ControladorEjercicio.ejercicios) { // esto va a tener que iterar sobre el listado de ejercicios de rutina, segun el dia
			Object[] fila=new Object[4];
            fila[0] = ej.getNombre();
            fila[1] = ej.getSeries();
            fila[2] = ej.getRepeticiones();
            fila[3] = ej.getPesoAsignado();
			/* 
            TipoArticuloView ta= av.obtenerTipoArticulo();
			fila[0]= ta;
			if (ta.obtenerTipoAmortizacion().equals("USO")){
				fila[1]= av.obtenerEstadoDesgaste() + " USOS PENDIENTES";
			}else {
				fila[1]= av.obtenerEstadoDesgaste() + " DIAS PENDIENTES";
			}
			*/
			modeloTablaDesgasteArticulos.addRow(fila);
		}
		tablaDesgaste.setModel(modeloTablaDesgasteArticulos);
		JScrollPane scrollTabla=new JScrollPane(tablaDesgaste);
		
		
		
		panelCentral.add(scrollTabla,BorderLayout.CENTER);
    }

    public VistaComenzarEntrenamiento() {
    }

}
