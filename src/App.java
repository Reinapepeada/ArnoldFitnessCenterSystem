
import vistas.VistaIniciarSesion;
import control.ControladorSocio;
import modelo.roles.Socio;


public class App {
    public static void main(String[] args) throws Exception {
        // TODO code application logic here
        Socio soc1 = new Socio(23,"jose","nada","33333333","ejemplo@gmaiul.com","hola","masculino",1.80,80);

        ControladorSocio.usuarios.add(soc1);
        System.out.println(ControladorSocio.usuarios.toString());
        
    //     VistaInicioSesion vi = new VistaInicioSesion();
	// 	vi.setVisible(true);
	// 	vi.setSize(500, 500);
	// 	vi.setLocation(0, 0);
    }
}
