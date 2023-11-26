package vistas;

import java.awt.BorderLayout;
import java.awt.Container;

import javax.swing.JFrame;
import javax.swing.JPanel;


public class WindowManager {
	private static WindowManagerSingleton instancia;
	private JFrame frame;
	private JPanel currentWindow;

	private WindowManager() {
		frame = new JFrame("Supertlon GYM");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		JPanel buttonPanel = new JPanel();

		Container contentPane = frame.getContentPane();
		contentPane.add(buttonPanel, BorderLayout.NORTH);

		frame.setSize(800, 500);
		
		frame.setVisible(true);
	}

	public void switchWindow(JPanel newWindow) {
		if (currentWindow != null) {
			frame.getContentPane().remove(currentWindow);
		}
		currentWindow = newWindow;
		frame.getContentPane().add(currentWindow, BorderLayout.CENTER);
		frame.getContentPane().validate();
		frame.getContentPane().repaint();
	};

	public static WindowManagerSingleton getInstance() {
		if (instancia == null) {
			instancia = new WindowManagerSingleton();
		}
		return instancia;
	}

} 
