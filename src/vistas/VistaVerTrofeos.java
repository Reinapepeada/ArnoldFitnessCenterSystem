// package vistas;

// import java.awt.BorderLayout;
// import java.awt.Container;
// import java.awt.GridLayout;
// import java.util.ArrayList;

// import javax.swing.JFrame;
// import javax.swing.JPanel;
// import javax.swing.JScrollPane;
// import javax.swing.JTable;
// import javax.swing.table.DefaultTableModel;

// import control.ControladorSocio;
// import modelo.Ejercicio;
// import modelo.moduloTrofeo.Observado;
// import modelo.moduloTrofeo.TrofeoObservador;

// public class VistaVerTrofeos extends JFrame{

//     private JTable tablaTrofeos = new JTable();
//     private ControladorSocio cs;

//     public VistaVerTrofeos(){
//         super("Arnold Fitness Center - Listado Trofeos");
// 		this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
// 		this.setLayout(new BorderLayout());
// 		JPanel panel1 = new JPanel();
// 		panel1.setLayout(new GridLayout(1, 1, 2, 2));

//         DefaultTableModel modeloTablaTrofeos = new DefaultTableModel() {
//             @Override
//             public boolean isCellEditable(int row, int column) {
//                 return false;
//             }
//     };

//     Object[] titulos = { "Trofeo"};
//     modeloTablaTrofeos.setColumnIdentifiers(titulos);

//     tablaTrofeos.setModel(modeloTablaTrofeos);
//     JScrollPane scrollTabla = new JScrollPane(tablaTrofeos);

//     panel1.add(scrollTabla);
//     this.add(panel1,BorderLayout.CENTER);

//     }

//     public void actualizarTabla(ArrayList<TrofeoObservador> trofeos) {
//         DefaultTableModel modeloTablaTrofeos = new DefaultTableModel() {
//             @Override
//             public boolean isCellEditable(int row, int column) {
//                 return false;
//             }
//         };

//         Object[] titulos = { "Trofeo"};
//         modeloTablaTrofeos.setColumnIdentifiers(titulos);

//         for (TrofeoObservador trofeo : trofeos) {
//             Object[] fila = { trofeo.getNombre()};
//             modeloTablaTrofeos.addRow(fila);
//         }

//         tablaTrofeos.setModel(modeloTablaTrofeos);
//         repaint();
//         revalidate();
//     }

//     public void setCSocio(ControladorSocio cs) {
//     this.cs = cs;
//     }  

package vistas;
import java.awt.BorderLayout;
import java.awt.GridLayout;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import control.ControladorSocio;

public class VistaVerTrofeos extends JFrame {

    private JTable tablaTrofeos = new JTable();
    private DefaultTableModel modeloTablaTrofeos; // Cambio aquí
    private ControladorSocio cs;

    public VistaVerTrofeos() {
        super("Arnold Fitness Center - Listado Trofeos");
        this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        this.setLayout(new BorderLayout());

        modeloTablaTrofeos = new DefaultTableModel() {
            @Override
            public boolean isCellEditable(int row, int column) {
                return false;
            }
        };

        Object[] titulos = { "Tipo de Trofeo", "Cantidad" };
        modeloTablaTrofeos.setColumnIdentifiers(titulos);

        tablaTrofeos.setModel(modeloTablaTrofeos);
        JScrollPane scrollTabla = new JScrollPane(tablaTrofeos);

        JPanel panel1 = new JPanel();
        panel1.setLayout(new GridLayout(1, 1, 2, 2));
        panel1.add(scrollTabla);
        this.add(panel1, BorderLayout.CENTER);
    }

    public void actualizarTabla(int count) {
        // No necesitas crear un nuevo DefaultTableModel aquí
        // solo actualiza el modelo existente

        // Borra filas existentes
        modeloTablaTrofeos.setRowCount(0);

        Object[] fila = { "Trofeos Creidos", count };
        modeloTablaTrofeos.addRow(fila);

        // No es necesario llamar a setModel nuevamente
        // ya que el modelo está vinculado a la tabla desde el principio

        repaint();
        revalidate();
    }

    public void setCSocio(ControladorSocio cs) {
        this.cs = cs;
    }
}



