
import control.ControladorAdmin;
import control.ControladorEjercicio;
import control.ControladorObjetivo;
import control.ControladorSocio;
import control.WindowManagerSingleton;
import modelo.Socio;
import modelo.excepciones.SocioExistenteException;
import vistas.VistaActualizarObjetivo;
import modelo.Ejercicio;
import modelo.Entrenamiento;
import modelo.Socio;
import modelo.VOs.SocioVo;
import modelo.enums.Exigencia;
import modelo.enums.GrupoMuscular;
import modelo.excepciones.EjercicioExistenteException;
import modelo.excepciones.SocioExistenteException;
import modelo.moduloObjetivo.ObjetivoStrategy;
import modelo.moduloObjetivo.Tonificar;
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

        try{
            Ejercicio ej1 = new Ejercicio();
            ej1.agregarEjercicio("Pecho Plano", 2, 3, 5, 70, Exigencia.ALTA, GrupoMuscular.PECHO);
            
            Ejercicio ej2 = new Ejercicio();
            ej2.agregarEjercicio("Saltar Soga", 8, 5, 50, 0, Exigencia.BAJA, GrupoMuscular.PIERNAS);

            Ejercicio ej3 = new Ejercicio();
            ej3.agregarEjercicio("Curl Biceps", 2, 3, 10, 15, Exigencia.ALTA, GrupoMuscular.BRAZOS);

            Ejercicio ej4 = new Ejercicio();
            ej4.agregarEjercicio("Chin Ups", 3, 5, 5, 0, Exigencia.ALTA, GrupoMuscular.ESPALDA);

            Ejercicio ej5 = new Ejercicio();
            ej5.agregarEjercicio("Press Arnold", 1, 4, 10, 20, Exigencia.ALTA, GrupoMuscular.HOMBRO);
        } catch (EjercicioExistenteException e){
            e.printStackTrace();
        }


    }

    public void init() {

                //instanciamos el WindowManager
                WindowManagerSingleton wm = WindowManagerSingleton.getInstance();
                wm.disponibilizarVistaBienvenida();
                

	}
}
