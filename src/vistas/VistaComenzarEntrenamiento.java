package vistas;

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableModel;

import control.ControladorEjercicio;
import control.WindowManagerSingleton;
import modelo.Ejercicio;

public class VistaComenzarEntrenamiento extends JFrame{

    private JTable tablaEntrenamiento = new JTable();
	
	ControladorEjercicio ce;

public VistaComenzarEntrenamiento() {
    super("Arnold Fitness Center - Dia de Entrenamiento!");
    this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
    this.setLayout(new BorderLayout());
    JPanel panel1 = new JPanel();
    panel1.setLayout(new GridLayout(3, 1, 2, 2));

    panel1.add(new JLabel("Semana: " + "TBD" + " Dia: " + "TBD"));
    this.add(panel1, BorderLayout.NORTH);

    

    DefaultTableModel modeloTablaEntrenamiento = new DefaultTableModel() {
        @Override
        public boolean isCellEditable(int row, int column) {
            return false;
        }
    };

    Object[] titulos = { "Ejercicio", "Series", "Repeticiones", "Peso" };
    modeloTablaEntrenamiento.setColumnIdentifiers(titulos);

    tablaEntrenamiento.setModel(modeloTablaEntrenamiento);
    JScrollPane scrollTabla = new JScrollPane(tablaEntrenamiento);

    Container contBotones=new Container();
	contBotones.setLayout(new GridLayout(1,1,2,4));

    JButton btnDiaEntrenamiento = new JButton("<html> Día de entrenamiento </html>");

    class HandlerBtnDiaEntrenamiento implements ActionListener {
        @Override
         public void actionPerformed(ActionEvent e) {
            WindowManagerSingleton.getInstance().disponibilizarVistaDiaEntrenamiento();
        }
    }

    HandlerBtnDiaEntrenamiento handlerBtnDiaEntrenamiento = new HandlerBtnDiaEntrenamiento();

    btnDiaEntrenamiento.addActionListener(handlerBtnDiaEntrenamiento);

    contBotones.add(btnDiaEntrenamiento);
    panel1.add(scrollTabla);
    panel1.add(contBotones);
    this.add(panel1,BorderLayout.CENTER);

}

// Método para actualizar la tabla con la lista de ejercicios
    public void actualizarTabla(ArrayList<Ejercicio> ejercicios) {
        DefaultTableModel modeloTablaEntrenamiento = new DefaultTableModel() {
            @Override
            public boolean isCellEditable(int row, int column) {
                return false;
            }
        };

        Object[] titulos = { "Ejercicio", "Series", "Repeticiones", "Peso" };
        modeloTablaEntrenamiento.setColumnIdentifiers(titulos);

        for (Ejercicio ejercicio : ejercicios) {
            Object[] fila = { ejercicio.getNombre(), ejercicio.getSeries(), ejercicio.getRepeticiones(),
                    ejercicio.getPesoAsignado() };
            modeloTablaEntrenamiento.addRow(fila);
        }

        tablaEntrenamiento.setModel(modeloTablaEntrenamiento);
        repaint();
        revalidate();
    }

    // Método para establecer el controlador de ejercicios
    public void setControladorEjercicio(ControladorEjercicio ce) {
        this.ce=ce;
    }
}