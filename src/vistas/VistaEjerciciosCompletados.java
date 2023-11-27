package vistas;

import java.awt.*;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

import control.ControladorObjetivo;

// import javafx.scene.text.Font; 

public class VistaEjerciciosCompletados extends JFrame {

    ControladorObjetivo co;



    public VistaEjerciciosCompletados() {
        initComponents();
    }

    private void initComponents() {
        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        // Crear y configurar componentes
        JLabel etiquetaTitulo = new JLabel("Ejercicios Completados");
        etiquetaTitulo.setFont(new Font("Arial", Font.BOLD, 18));
        etiquetaTitulo.setHorizontalAlignment(JLabel.CENTER);

        JTextField cuadroTexto = new JTextField("Día de entrenamiento completado");
        cuadroTexto.setFont(new Font("Arial", Font.PLAIN, 14));
        cuadroTexto.setHorizontalAlignment(JTextField.CENTER);
        cuadroTexto.setEditable(false);


        JButton botonCerrar = new JButton("Cerrar");
        botonCerrar.addActionListener(e -> cerrarVentana());

        // Configurar el diseño (layout) del frame
        setLayout(new BorderLayout());

        // Agregar componentes al frame
        add(etiquetaTitulo, BorderLayout.CENTER);
        add(botonCerrar, BorderLayout.SOUTH);

        // Configurar el tamaño del frame
        setSize(400, 300);

        // Centrar la ventana en la pantalla
        setLocationRelativeTo(null);
    }
    public void setCObjetivo(ControladorObjetivo co) {
        this.co = co;
    }

    private void cerrarVentana() {
        // Cerrar ventana
        co.cambiarDia();
        dispose();
    }
}
