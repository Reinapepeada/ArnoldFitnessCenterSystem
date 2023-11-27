package vistas;

import control.ControladorSocio;
import modelo.Socio;
import modelo.VOs.SocioVo;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class VistaGestionarMedidas extends JFrame {

    private JTextField campoPeso;
    private JTextField campoAltura;
    private JTextField campoPorcentajeGrasa;
    private JTextField campoPorcentajeMusculo;
    private ControladorSocio cs;
    public VistaGestionarMedidas() {


        super("Ingreso de Medidas");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(300, 200);

        // Crear componentes
        JLabel labelPeso = new JLabel("Peso (kg):");
        JLabel labelAltura = new JLabel("Altura (cm):");
        JLabel labelPorcentajeGrasa = new JLabel("Porcentaje de Grasa:");
        JLabel labelPorcentajeMusculo = new JLabel("Porcentaje de Músculo:");

        campoPeso = new JTextField(10);
        campoAltura = new JTextField(10);
        campoPorcentajeGrasa = new JTextField(10);
        campoPorcentajeMusculo = new JTextField(10);

        JButton btnGuardar = new JButton("Guardar Medidas");

        // Configurar el diseño
        setLayout(new GridLayout(5, 2));

        // Agregar componentes al contenedor
        add(labelPeso);
        add(campoPeso);
        add(labelAltura);
        add(campoAltura);
        add(labelPorcentajeGrasa);
        add(campoPorcentajeGrasa);
        add(labelPorcentajeMusculo);
        add(campoPorcentajeMusculo);
        add(new JLabel()); // Espacio en blanco
        add(btnGuardar);

        // Manejador de eventos para el botón
        btnGuardar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                guardarMedidas();
                //cartel que indica que se guardaron las medidas
                JOptionPane.showMessageDialog(null, "Medidas guardadas con éxito");
            }
        });
    }

    private void guardarMedidas() {
        // Obtener los valores ingresados
        double peso = Double.parseDouble(campoPeso.getText());
        double altura = Double.parseDouble(campoAltura.getText());
        double porcentajeGrasa = Double.parseDouble(campoPorcentajeGrasa.getText());
        double porcentajeMusculo = Double.parseDouble(campoPorcentajeMusculo.getText());

        cs.registrarMedidaSocio(altura, peso, porcentajeGrasa, porcentajeMusculo);
    }

    public void setCSocio(ControladorSocio cs) {
        this.cs = cs;
    }
}


