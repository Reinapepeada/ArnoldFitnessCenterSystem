package vistas;

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import control.ControladorObjetivo;
import control.ControladorSocio;
import control.WindowManagerSingleton;
import modelo.VOs.SocioVo;
import modelo.moduloObjetivo.BajarPeso;
import modelo.moduloObjetivo.Mantener;
import modelo.moduloObjetivo.Tonificar;

public class VistaSeleccionarObjetivo extends JFrame {

	private JComboBox<Object> objetivoCombo;

	BajarPeso instanciaBP = new BajarPeso(0, 0, 0);
	Mantener instanciaM = new Mantener(2, 0, 0);
	Tonificar instanciaT = new Tonificar(4, 0, 0,0,0);

	ControladorSocio cs;
	ControladorObjetivo co;

	public VistaSeleccionarObjetivo() {
        super ("Arnold Fitness Center - Seleccionar Objetivo");
		this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		this.setLayout(new BorderLayout());
		JPanel panel1=new JPanel();
		panel1.setLayout(new GridLayout(2,1,2,2));

        Container contObjetivo=new Container();
		contObjetivo.setLayout(new GridLayout(1,2,2,2));
		JLabel labelObjetivo=new JLabel("<html>Seleccionar Objetivo</html>");
		objetivoCombo = new JComboBox<>(new Object[]{instanciaBP.getNombreObjetivo(), instanciaM.getNombreObjetivo(), instanciaT.getNombreObjetivo()});
		objetivoCombo.setSelectedItem(null);
		contObjetivo.add(labelObjetivo);
		contObjetivo.add(objetivoCombo);
		panel1.add(contObjetivo);

        Container contBotones=new Container();
		contBotones.setLayout(new GridLayout(1,1,2,4));

        JButton btnConfirmarObjetivo=new JButton("<html> Confirmar Objetivo </html>");

        class HandlerBtnConfirmarObjetivo implements ActionListener{
			
			@Override
			public void actionPerformed(ActionEvent e) {
				SocioVo vo = cs.getSocioVOActual();
				System.out.println(vo);
				String obj=(String)objetivoCombo.getSelectedItem();
				
				switch (obj) {
					case "BajarPeso":
					BajarPeso bp = new BajarPeso(0, vo.getPeso(), vo.getAltura());
					//System.out.println(co);
					//System.out.println(bp);
					co.asignarObjetivo(bp);
					// invoco la vista para setear las medidas
					WindowManagerSingleton w=WindowManagerSingleton.getInstance();
					w.disponibilizarVistaSetMedidasObjetivo(bp.getDurMaxima(),bp.getDurMinima());
					break;
					case "Mantener":
					Mantener m = new Mantener(0, vo.getPeso(), 0);
					co.asignarObjetivo(m);
					// invoco la vista para setear las medidas
					WindowManagerSingleton w2=WindowManagerSingleton.getInstance();
					w2.disponibilizarVistaSetMedidasMantener(m.getDurMaxima(),m.getDurMinima());
					break;
					case "Tonificar":
					Tonificar t = new Tonificar(0, vo.getPeso(), vo.getAltura(),0,0);
					co.asignarObjetivo(t);
					// invoco la vista para setear las medidas
					WindowManagerSingleton w3=WindowManagerSingleton.getInstance();
					w3.disponibilizarVistaSetMedidasObjetivo(t.getDurMaxima(),t.getDurMinima());
					break;
					default:
					break;
				}
			}
		}
        //INSTANCIACION DEL MANEJADOR//
		HandlerBtnConfirmarObjetivo handlerBtnConfirmarObjetivo = new HandlerBtnConfirmarObjetivo();
		
		btnConfirmarObjetivo.addActionListener(handlerBtnConfirmarObjetivo);
		
		contBotones.add(btnConfirmarObjetivo);
		
		panel1.add(contBotones);
		
	    this.add(panel1,BorderLayout.CENTER);
    }
	public void setCSocio(ControladorSocio cs) {
		this.cs = cs;
	}
	
	public void setCObjetivo(ControladorObjetivo co) {
		this.co = co;
	}
}