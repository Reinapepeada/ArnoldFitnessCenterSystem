package vistas;

import javax.swing.*;

import control.ControladorObjetivo;
import control.WindowManagerSingleton;
import modelo.Ejercicio;
import modelo.Entrenamiento;

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
        inicializarComponentes(listaEjercicios);
    }

    private void inicializarComponentes(ArrayList<Ejercicio> lista) {
        if (lista.size() > 0) {
            JLabel labelEjercicio = new JLabel(obtenerTextoEjercicio(lista));
            JLabel labelRepeticiones = new JLabel(
                    "Repeticiones:\t  " + lista.get(indiceEjercicioActual).getRepeticiones());
            JLabel labelSeries = new JLabel("Series:\t  " + lista.get(indiceEjercicioActual).getSeries());
            JLabel labelPeso = new JLabel("Peso (kg):\t  " + lista.get(indiceEjercicioActual).getPesoAsignado());

            campoRepeticiones = new JTextField(10);
            campoSeries = new JTextField(10);
            campoPeso = new JTextField(10);

            JButton btnRegistrar = new JButton("Registrar Ejercicio");

            btnRegistrar.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    registrarEjercicio(lista);
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

            actualizarInfoEjercicioActual(lista);
        }
    }

    private String obtenerTextoEjercicio(ArrayList<Ejercicio> lista) {
        Ejercicio ejercicio = lista.get(indiceEjercicioActual);
        return "Ejercicio: " + ejercicio.getNombre();
    }

    private void actualizarInfoEjercicioActual(ArrayList<Ejercicio> lista) {
        Ejercicio ejercicioActual = lista.get(indiceEjercicioActual);
        campoRepeticiones.setText(String.valueOf(ejercicioActual.getRepeticiones()));
        campoSeries.setText(String.valueOf(ejercicioActual.getSeries()));
        campoPeso.setText(String.valueOf(ejercicioActual.getPesoAsignado()));

        JLabel labelEjercicio = (JLabel) getContentPane().getComponent(0);
        labelEjercicio.setText(obtenerTextoEjercicio(lista));

        JLabel labelRepeticiones = (JLabel) getContentPane().getComponent(2);
        labelRepeticiones.setText("Repeticiones:\t  " + lista.get(indiceEjercicioActual).getRepeticiones());

        JLabel labelSeries = (JLabel) getContentPane().getComponent(4);
        labelSeries.setText("Series:\t  " + lista.get(indiceEjercicioActual).getSeries());

        JLabel labelPeso = (JLabel) getContentPane().getComponent(6);
        labelPeso.setText("Peso (kg):\t  " + lista.get(indiceEjercicioActual).getPesoAsignado());
    }

    private void registrarEjercicio(ArrayList<Ejercicio> lista) {
        String repeticionesStr = campoRepeticiones.getText().trim();
        String seriesStr = campoSeries.getText().trim();
        String pesoStr = campoPeso.getText().trim();

        if (repeticionesStr.isEmpty() || seriesStr.isEmpty() || pesoStr.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Por favor, complete todos los campos.", "Error",
                    JOptionPane.ERROR_MESSAGE);
            return;
        }

        int repeticiones = Integer.parseInt(repeticionesStr);
        int series = Integer.parseInt(seriesStr);
        double peso = Double.parseDouble(pesoStr);

        Ejercicio ejercicioActual = lista.get(indiceEjercicioActual);
        ejercicioActual.setRepeticiones(repeticiones);
        ejercicioActual.setSeries(series);
        ejercicioActual.setPesoAsignado(peso);

        co.registrarEjercicio(series, repeticiones, peso, ejercicioActual);

        JOptionPane.showMessageDialog(this, "Ejercicio registrado correctamente.");

        indiceEjercicioActual++;

        if (indiceEjercicioActual < lista.size()) {
            JLabel labelEjercicio = (JLabel) getContentPane().getComponent(0);
            labelEjercicio.setText(obtenerTextoEjercicio(lista));
            actualizarInfoEjercicioActual(lista);
        } else {
            JOptionPane.showMessageDialog(this, "Se han registrado todos los ejercicios.");
            WindowManagerSingleton.getInstance().disponibilizarVistaMenuSocio();
            if (indiceEjercicioActual >= lista.size()) {
                int opcion = JOptionPane.showConfirmDialog(this, "¿Deseas reforzar la rutina?", "Reforzar Rutina",
                        JOptionPane.YES_NO_OPTION);
                if (opcion == JOptionPane.YES_OPTION) {
                    co.reforzarRutina();
                } 
                co.terminarDia();
                getContentPane().removeAll();
            }
        }
    }

    public void setCObjetivo(ControladorObjetivo co) {
        this.co = co;
    }

    public void setListaEjercicios(ArrayList<Ejercicio> lista) {

        
        getContentPane().removeAll();
        // Reiniciar el índice al setear una nueva lista de ejercicios
        indiceEjercicioActual = 0;
        inicializarComponentes(lista);
        revalidate();
        repaint();
    }
}