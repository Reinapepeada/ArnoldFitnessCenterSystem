
import control.ControladorAdmin;
import control.ControladorEjercicio;
import control.ControladorObjetivo;
import control.ControladorSocio;
import modelo.Socio;
import modelo.VOs.SocioVo;
import modelo.excepciones.SocioExistenteException;
import vistas.VistaBienvenida;
import vistas.VistaIniciarSesion;
import vistas.VistaRegistrarSocio;

public class App {
    public static void main(String[] args) throws Exception {
        
        try{
            //String nombre, String apellido, String email, String dni, String edad, String sexo, String password, Double altura, Double peso){
            //Usuario1
            Socio soc1 = new Socio();
            soc1.registrarSocio("Jake", "Peralta", "jperalta@uade.edu.ar", "40123456", "32", "Masculino", "Hola123", 175.0, 75.0);
            //SocioVo svo1 = new SocioVo("Jake", "Peralta", "jperalta@uade.edu.ar", "40123456", "32", "Masculino", "Hola123", 175, 75);
            //cs.registrarSocio(svo1);
            
            //usuario2
            Socio soc2  = new Socio();
            soc2.registrarSocio("Raymond", "Holt", "rholt@uade.edu.ar", "20123456", "55", "Masculino", "Hola123", 185.0, 85.0);
            //SocioVo svo2 = new SocioVo("Raymond", "Holt", "rholt@uade.edu.ar", "20123456", "55", "Masculino", "Hola123", 185, 85);
            //cs.registrarSocio(svo2);
        } catch (SocioExistenteException e) {
			e.printStackTrace();
		}
        
        //INSTANCIAR CONTROLADORES
        ControladorAdmin ca = new ControladorAdmin();
        ControladorEjercicio ce = new ControladorEjercicio();
        ControladorObjetivo co = new ControladorObjetivo();
        ControladorSocio cs = new ControladorSocio();

        //INSTANCIAR VISTAS
        VistaBienvenida vB = new VistaBienvenida();
		vB.setVisible(true);
		vB.setSize(500, 500);
		vB.setLocation(0, 0);

        VistaIniciarSesion vIC = new VistaIniciarSesion(cs);
        vIC.setVisible(false);
        vIC.setSize(500, 500);
        vIC.setLocation(0, 0);
            
    
        VistaRegistrarSocio vREG= new VistaRegistrarSocio(cs);
        vREG.setVisible(false);
        vREG.setSize(500, 500);
        vREG.setLocation(0, 0);

    }
}
