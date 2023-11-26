
import control.ControladorAdmin;
import control.ControladorEjercicio;
import control.ControladorObjetivo;
import control.ControladorSocio;
import control.WindowManagerSingleton;
import modelo.Socio;
import modelo.excepciones.SocioExistenteException;
import vistas.VistaActualizarObjetivo;
import vistas.VistaBienvenida;
import vistas.VistaGestionarMedidas;
import vistas.VistaGestionarObjetivo;
import vistas.VistaIniciarSesion;
import vistas.VistaMenuPrincipal;
import vistas.VistaMenuSocio;
import vistas.VistaRegistrarSocio;
import vistas.VistaSeleccionarObjetivo;

public class App {
    public static void main(String[] args) throws Exception {
        
        App app = new App();
        app.init();
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


    }

    public void init() {

                //instanciamos el WindowManager
                WindowManagerSingleton wm = WindowManagerSingleton.getInstance();
                wm.disponibilizarVistaBienvenida();
                

	}
}
