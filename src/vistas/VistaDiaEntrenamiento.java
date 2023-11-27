package vistas;

import javax.swing.*;

import modelo.Ejercicio;
import modelo.enums.Exigencia;
import modelo.enums.GrupoMuscular;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class VistaDiaEntrenamiento extends JFrame {

    private ArrayList<Ejercicio> listaEjercicios;
    private int indiceEjercicioActual;

    private JTextField campoRepeticiones;
    private JTextField campoSeries;
    private JTextField campoPeso;

    public VistaDiaEntrenamiento(ArrayList<Ejercicio> listaEjercicios) {
        super("Registro de Ejercicios");
        this.listaEjercicios = listaEjercicios;
        this.indiceEjercicioActual = 0;

        // Configuración de la interfaz gráfica
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(400, 200);

        // Creación de componentes
        JLabel labelEjercicio = new JLabel(obtenerTextoEjercicio());
        JLabel labelRepeticiones = new JLabel("Repeticiones:\t  "+listaEjercicios.get(indiceEjercicioActual).getRepeticiones());
        JLabel labelSeries = new JLabel("Series:\t  "   +listaEjercicios.get(indiceEjercicioActual).getSeries());
        JLabel labelPeso = new JLabel("Peso (kg):\t  "  +listaEjercicios.get(indiceEjercicioActual).getPesoAsignado());

        campoRepeticiones = new JTextField(10);
        campoSeries = new JTextField(10);
        campoPeso = new JTextField(10);

        JButton btnRegistrar = new JButton("Registrar Ejercicio");

        // Manejador de eventos para el botón Registrar
        btnRegistrar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                registrarEjercicio();
            }
        });

        // Configuración del diseño
        setLayout(new GridLayout(5, 2));

        // Agregando componentes al contenedor
        add(labelEjercicio);
        add(new JLabel()); // Espacio en blanco
        add(labelRepeticiones);
        add(campoRepeticiones);
        add(labelSeries);
        add(campoSeries);
        add(labelPeso);
        add(campoPeso);
        add(new JLabel()); // Espacio en blanco
        add(btnRegistrar);

        // Mostrar la ventana
        setVisible(true);
    }

    private String obtenerTextoEjercicio() {
        Ejercicio ejercicio = listaEjercicios.get(indiceEjercicioActual);
        return "Ejercicio: " + ejercicio.getNombre();
    }

    private void registrarEjercicio() {
        // Obtener los valores ingresados
        String repeticionesStr = campoRepeticiones.getText().trim();
        String seriesStr = campoSeries.getText().trim();
        String pesoStr = campoPeso.getText().trim();

        // Validar que los campos no estén vacíos
        if (repeticionesStr.isEmpty() || seriesStr.isEmpty() || pesoStr.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Por favor, complete todos los campos.", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }

        // Convertir las cadenas a números
        int repeticiones = Integer.parseInt(repeticionesStr);
        int series = Integer.parseInt(seriesStr);
        double peso = Double.parseDouble(pesoStr);

        // Actualizar el ejercicio actual
        Ejercicio ejercicioActual = listaEjercicios.get(indiceEjercicioActual);
        ejercicioActual.setRepeticiones(repeticiones);
        ejercicioActual.setSeries(series);
        ejercicioActual.setPesoAsignado(peso);

        // Mostrar mensaje de éxito (puedes cambiar esto según tus necesidades)
        JOptionPane.showMessageDialog(this, "Ejercicio registrado correctamente.");

        // Pasar al próximo ejercicio
        indiceEjercicioActual++;

        // Verificar si se completaron todos los ejercicios
        if (indiceEjercicioActual < listaEjercicios.size()) {
            // Actualizar la etiqueta con el nuevo ejercicio
            JLabel labelEjercicio = (JLabel) getContentPane().getComponent(0);
            labelEjercicio.setText(obtenerTextoEjercicio());
        } else {
            // Mostrar mensaje de que se han registrado todos los ejercicios
            JOptionPane.showMessageDialog(this, "Se han registrado todos los ejercicios.");
            // Puedes decidir qué hacer a partir de aquí, como cerrar la ventana o reiniciar el proceso, según tus necesidades.
        }
    }

    // Método principal para probar la vista
    public static void main(String[] args) {
        // Crear una lista de ejercicios (puedes personalizar esto según tus necesidades)
        ArrayList<Ejercicio> listaEjercicios = new ArrayList<>();
        listaEjercicios.add(new Ejercicio("Flexion de Arquero", 3, 3, 5, 70, Exigencia.BAJA, GrupoMuscular.PECHO));
        listaEjercicios.add(new Ejercicio("sentadilla libre", 3, 3, 5, 70, Exigencia.BAJA, GrupoMuscular.PECHO));
        // Crear la vista de registro de ejercicios
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new VistaDiaEntrenamiento(listaEjercicios);
            }
        });
    }
}
