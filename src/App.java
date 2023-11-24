
import modelo.Socio;
import vistas.VistaBienvenida;
import vistas.VistaIniciarSesion;

public class App {
    public static void main(String[] args) throws Exception {

        //Socio soc1 = new Socio(0, null, null, null, null, null, null, 0, 0);
        
        VistaBienvenida vB = new VistaBienvenida();
		vB.setVisible(true);
		vB.setSize(500, 500);
		vB.setLocation(0, 0);
    }
}
