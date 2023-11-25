
import control.ControladorSocio;
import modelo.Socio;
import modelo.excepciones.SocioExistenteException;
import vistas.VistaBienvenida;

public class App {
    public static void main(String[] args) throws Exception {

        try{
            //String nombre, String apellido, String email, String dni, String edad, String sexo, String password, Double altura, Double peso){
            Socio soc1 = new Socio();
            soc1.registrarSocio("Jake", "Peralta", "jperalta@uade.edu.ar", "40123456", "32", "Masculino", "Hola123", 75.0, 183.0);
            
        } catch (SocioExistenteException e) {
			e.printStackTrace();
		}
        //nombre, apellido, email, dni, edad, sexo, password, peso, altura
        
        VistaBienvenida vB = new VistaBienvenida();
		vB.setVisible(true);
		vB.setSize(500, 500);
		vB.setLocation(0, 0);
    }
}
