package vistas;

import java.awt.BorderLayout;
import java.awt.GridLayout;

import javax.swing.JFrame;
import javax.swing.JPanel;

import control.ControladorSocio;

public class VistaVerTrofeos extends JFrame{

    private ControladorSocio cs;

    public VistaVerTrofeos(){
        super("Arnold Fitness Center - Listado Trofeos");
		this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		this.setLayout(new BorderLayout());
		JPanel panel1 = new JPanel();
		panel1.setLayout(new GridLayout(1, 1, 2, 2));

    }

    public void setCSocio(ControladorSocio cs) {
    this.cs = cs;
    }

}
