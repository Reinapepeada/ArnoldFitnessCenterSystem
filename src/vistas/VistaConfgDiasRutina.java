package vistas;

import javax.swing.*;

import control.ControladorObjetivo;
import control.ControladorSocio;
import control.WindowManagerSingleton;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;
import modelo.enums.Dia; // Asegúrate de tener importado correctamente tu enum

public class VistaConfgDiasRutina extends JFrame {
    ControladorObjetivo co;

    private List<Dia> diasSeleccionados = new ArrayList<>();

    public VistaConfgDiasRutina() {
        super("Elija los días de la semana para entrenar");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(300, 200);

        // Crear un JLabel para indicar al usuario
        JLabel label = new JLabel("Seleccione los días de la semana:");
        label.setFont(new Font("Arial", Font.BOLD, 14)); // Cambiar el tamaño y el estilo de la fuente

        // Crear un panel con un GridLayout
        JPanel panel = new JPanel(new GridLayout(Dia.values().length, 1));

        // Crear JCheckBox para cada día de la semana
        for (Dia dia : Dia.values()) {
            JCheckBox checkBox = new JCheckBox(dia.toString());
            checkBox.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    actualizarDiasSeleccionados();
                }
            });
            panel.add(checkBox);
        }

        // Agregar el label y el panel al contenedor
        Container container = getContentPane();
        container.setLayout(new BorderLayout());
        container.add(label, BorderLayout.NORTH);
        container.add(panel, BorderLayout.CENTER);


        // Botón para registrar los días seleccionados
        JButton registrarDiasBtn = new JButton("Registrar Días Seleccionados");
        registrarDiasBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                registrarDiasSeleccionados();
            }
        });
        container.add(registrarDiasBtn, BorderLayout.SOUTH);
    }

    private void actualizarDiasSeleccionados() {
        diasSeleccionados.clear();

        // Get the panel where the checkboxes are added
        JPanel panel = (JPanel) getContentPane().getComponent(1);

        // Iterate through the checkboxes and add the selected days to the list
        Component[] components = panel.getComponents();
        for (Component component : components) {
            if (component instanceof JCheckBox) {
                JCheckBox checkBox = (JCheckBox) component;
                if (checkBox.isSelected()) {
                    String diaSeleccionado = checkBox.getText();
                    Dia dia = Dia.valueOf(diaSeleccionado);
                    diasSeleccionados.add(dia);
                }
            }
        }

        // Print debug messages
        System.out.println("Días seleccionados: " + diasSeleccionados);
    }


    private void registrarDiasSeleccionados() {
       
            co.diseñarRutina(diasSeleccionados);
            // avisar que se creo todo bien
            JOptionPane.showMessageDialog(null, "¡Rutina Diseñada a tu medida!", "Mensaje", JOptionPane.INFORMATION_MESSAGE);

            System.out.println("Rutina: " + co.getRutina().toString());
            // volver a la vista de inicio de sesion
            WindowManagerSingleton.getInstance().disponibilizarVistaIniciarSesion();
        
    }

    // Método para obtener el ArrayList con los días seleccionados
    public List<Dia> getDiasSeleccionados() {
        return new ArrayList<>(diasSeleccionados);
    }

    public void setCObjetivo(ControladorObjetivo co) {
        this.co = co;
    }

}