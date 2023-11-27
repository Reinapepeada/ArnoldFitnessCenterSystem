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
import modelo.EjercicioRealizado;
import modelo.Entrenamiento;
import modelo.Socio;
import modelo.moduloRutina.Rutina;

public class VistaEjerciciosCompletados extends JFrame {

	private JTable tablaEjerciciosRealizados = new JTable();
	
	ControladorEjercicio ce;

	public VistaEjerciciosCompletados() {
		super("Arnold Fitness Center - Ejercicios Completados");
		this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		this.setLayout(new BorderLayout());
		JPanel panel1 = new JPanel();
		panel1.setLayout(new GridLayout(2, 1, 2, 2));

		JPanel panelCentral = new JPanel();
		panelCentral.setLayout(new BorderLayout());

		this.add(panelCentral, BorderLayout.CENTER);

		DefaultTableModel modelotablaEjerciciosRealizados = new DefaultTableModel() {
			@Override
			public boolean isCellEditable(int row, int column) {
				return false;
			}
		};

		Object[] titulos = { "Ejercicio", "Series", "Repeticiones", "Peso" };
		modelotablaEjerciciosRealizados.setColumnIdentifiers(titulos);

		/* MATRIZ DE EJERCICIOS */
		for (EjercicioRealizado ej : Rutina.ejercicioRealizados){ // esto va a tener que iterar sobre el listado de ejercicios de rutina, segun el dia
			Object[] fila = new Object[4];
			fila[0] = ej.getNombre();
			fila[1] = ej.getSeries();
			fila[2] = ej.getRepeticiones();
			fila[3] = ej.getPeso();
            
			modelotablaEjerciciosRealizados.addRow(fila);
        }
		tablaEjerciciosRealizados.setModel(modelotablaEjerciciosRealizados);
		JScrollPane scrollTabla = new JScrollPane(tablaEjerciciosRealizados);

		panelCentral.add(scrollTabla, BorderLayout.CENTER);
	}

	public void setCEjercicio(ControladorEjercicio ce) {
		this.ce = ce;
		// refrescar tabla
		repaint();
        revalidate();

	}

}
