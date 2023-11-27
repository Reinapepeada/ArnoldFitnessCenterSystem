package vistas;

import javax.swing.*;

import control.ControladorObjetivo;
import control.WindowManagerSingleton;
import modelo.Ejercicio;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class VistaDiaEntrenamiento extends JFrame {

    private ArrayList<Ejercicio> listaEjercicios = new ArrayList<>();
    private int indiceEjercicioActual;
    private ControladorObjetivo co;
    
    private JTextField campoRepeticiones;
    private JTextField campoSeries;
    private JTextField campoPeso;

    public VistaDiaEntrenamiento() {
        super("Registro de Ejercicios");
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        setSize(300, 200);
        this.indiceEjercicioActual = 0;
        inicializarComponentes();
    }

    private void inicializarComponentes() {
        if (listaEjercicios.size() > 0) {
            JLabel labelEjercicio = new JLabel(obtenerTextoEjercicio());
            JLabel labelRepeticiones = new JLabel("Repeticiones:\t  " + listaEjercicios.get(indiceEjercicioActual).getRepeticiones());
            JLabel labelSeries = new JLabel("Series:\t  " + listaEjercicios.get(indiceEjercicioActual).getSeries());
            JLabel labelPeso = new JLabel("Peso (kg):\t  " + listaEjercicios.get(indiceEjercicioActual).getPesoAsignado());

            campoRepeticiones = new JTextField(10);
            campoSeries = new JTextField(10);
            campoPeso = new JTextField(10);

            JButton btnRegistrar = new JButton("Registrar Ejercicio");

            btnRegistrar.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    registrarEjercicio();
                }
            });

            setLayout(new GridLayout(5, 2));

            add(labelEjercicio);
            add(new JLabel());
            add(labelRepeticiones);
            add(campoRepeticiones);
            add(labelSeries);
            add(campoSeries);
            add(labelPeso);
            add(campoPeso);
            add(new JLabel());
            add(btnRegistrar);

            actualizarInfoEjercicioActual();
        }
    }

    private String obtenerTextoEjercicio() {
        Ejercicio ejercicio = listaEjercicios.get(indiceEjercicioActual);
        return "Ejercicio: " + ejercicio.getNombre();
    }

    private void actualizarInfoEjercicioActual() {
        Ejercicio ejercicioActual = listaEjercicios.get(indiceEjercicioActual);
        campoRepeticiones.setText(String.valueOf(ejercicioActual.getRepeticiones()));
        campoSeries.setText(String.valueOf(ejercicioActual.getSeries()));
        campoPeso.setText(String.valueOf(ejercicioActual.getPesoAsignado()));

        JLabel labelEjercicio = (JLabel) getContentPane().getComponent(0);
        labelEjercicio.setText(obtenerTextoEjercicio());

        JLabel labelRepeticiones = (JLabel) getContentPane().getComponent(2);
        labelRepeticiones.setText("Repeticiones:\t  " + listaEjercicios.get(indiceEjercicioActual).getRepeticiones());

        JLabel labelSeries = (JLabel) getContentPane().getComponent(4);
        labelSeries.setText("Series:\t  " + listaEjercicios.get(indiceEjercicioActual).getSeries());

        JLabel labelPeso = (JLabel) getContentPane().getComponent(6);
        labelPeso.setText("Peso (kg):\t  " + listaEjercicios.get(indiceEjercicioActual).getPesoAsignado());
    }

    private void registrarEjercicio() {
        String repeticionesStr = campoRepeticiones.getText().trim();
        String seriesStr = campoSeries.getText().trim();
        String pesoStr = campoPeso.getText().trim();

        if (repeticionesStr.isEmpty() || seriesStr.isEmpty() || pesoStr.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Por favor, complete todos los campos.", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }

        int repeticiones = Integer.parseInt(repeticionesStr);
        int series = Integer.parseInt(seriesStr);
        double peso = Double.parseDouble(pesoStr);

        Ejercicio ejercicioActual = listaEjercicios.get(indiceEjercicioActual);
        ejercicioActual.setRepeticiones(repeticiones);
        ejercicioActual.setSeries(series);
        ejercicioActual.setPesoAsignado(peso);

        co.registrarEjercicio(series, repeticiones, peso,ejercicioActual);
        

        JOptionPane.showMessageDialog(this, "Ejercicio registrado correctamente.");

        indiceEjercicioActual++;

        if (indiceEjercicioActual < listaEjercicios.size()) {
            JLabel labelEjercicio = (JLabel) getContentPane().getComponent(0);
            labelEjercicio.setText(obtenerTextoEjercicio());
            actualizarInfoEjercicioActual();
        } else {
            JOptionPane.showMessageDialog(this, "Se han registrado todos los ejercicios.");
            WindowManagerSingleton.getInstance().disponibilizarVistaMenuSocio();
        }
    }

    public void setCObjetivo(ControladorObjetivo co) {
        this.co = co;
    }

    public void setListaEjercicios(ArrayList<Ejercicio> lista) {
        this.listaEjercicios = lista;
        getContentPane().removeAll();
        inicializarComponentes();
        repaint();
        revalidate();
    }
}