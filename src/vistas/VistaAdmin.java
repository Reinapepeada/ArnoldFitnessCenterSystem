package vistas;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class VistaAdmin extends JFrame{

     public VistaAdmin() {

        super ("Arnold Fitness Center - Administrativo");
        this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        this.setLayout(new BorderLayout());
        JPanel panel1 = new JPanel();
        panel1.setLayout(new GridLayout(1,1,2,2));

        Container contBotones = new Container();
        contBotones.setLayout(new GridLayout(2,1,2,2));

        //CONSTRUCCION DE BOTONES PARA EL ADMINISTRATIVO//
          JButton btnGestionarCliente = new JButton("<html> Gestionar Cliente </html>");
          JButton btnGestionarSede = new JButton("<html> Gestionar Sede </html>");

          //CLASES INTERNAS//
          class HandlerBtnGestionarCliente implements ActionListener{
              @Override
              public void actionPerformed(ActionEvent e) {
                  //GestionarClienteController.disponibilizarVistaGestionarCliente();
              }
          }

          class HandlerBtnGestionarSede implements ActionListener{
              @Override
              public void actionPerformed(ActionEvent e) {
                  //GestionarSedeController.disponibilizarVistaSeleccionSede(idAdm);
              }
          }

          //INSTANCIACION DE MANEJADORES//
          HandlerBtnGestionarCliente handlerBtnGestionarCliente =new HandlerBtnGestionarCliente();
          HandlerBtnGestionarSede handlerBtnGestionarSede = new HandlerBtnGestionarSede();

          //ASIGNACION DE MANEJADORES A BOTONES//
          btnGestionarCliente.addActionListener(handlerBtnGestionarCliente);
          btnGestionarSede.addActionListener(handlerBtnGestionarSede);

          contBotones.add(btnGestionarCliente);    
          contBotones.add(btnGestionarSede);    

          panel1.add(contBotones);

          this.add(panel1,BorderLayout.CENTER);
    }
}