
import control.WindowManagerSingleton;
import modelo.Socio;
import modelo.excepciones.SocioExistenteException;
import modelo.moduloObjetivo.BajarPeso;
import modelo.moduloObjetivo.Tonificar;
import modelo.Ejercicio;
import modelo.enums.Exigencia;
import modelo.enums.GrupoMuscular;
import modelo.excepciones.EjercicioExistenteException;

public class App {
    public static void main(String[] args) throws Exception {
        
        App app = new App();
        app.init();
        //INSTANCIAR RUTINAS DE TESTING
        Tonificar t = new Tonificar(2.5, 75.0, 175.0);
        BajarPeso bp = new BajarPeso(1.0, 85.0, 185.0);

        //INSTANCIAR USUARIOS
        try{
            //String nombre, String apellido, String email, String dni, String edad, String sexo, String password, Double altura, Double peso){
            //Usuario1
            Socio soc1 = new Socio();
            soc1.registrarSocio("Jake", "Peralta", "jperalta@uade.edu.ar", "40123456", "32", "Masculino", "Hola123", 175.0, 75.0);
            soc1.setObjetivo(t);
            
            //usuario2
            Socio soc2  = new Socio();
            soc2.registrarSocio("Raymond", "Holt", "rholt@uade.edu.ar", "20123456", "55", "Masculino", "Hola123", 185.0, 85.0);
            soc2.setObjetivo(bp);
        } catch (SocioExistenteException e) {
			e.printStackTrace();
		}

        //INSTANCIAR EJERCICIOS
        try{
            //EJERCICIOS TONIFICAR QUE NO ENTRAN
            Ejercicio ej16 = new Ejercicio();
            ej16.agregarEjercicio("Aperturas de Pecho", 5, 3, 5, 70, Exigencia.ALTA, GrupoMuscular.PECHO);
            
            Ejercicio ej17 = new Ejercicio();
            ej17.agregarEjercicio("Squat", 4, 5, 50, 0, Exigencia.MEDIA, GrupoMuscular.PIERNAS);

            //EJERCICIOS TONIFICAR QUE SI ENTRAN
            Ejercicio ej1 = new Ejercicio();
            ej1.agregarEjercicio("Pecho Plano", 2, 3, 5, 70, Exigencia.ALTA, GrupoMuscular.PECHO);
            
            Ejercicio ej2 = new Ejercicio();
            ej2.agregarEjercicio("Saltar Soga", 4, 5, 50, 0, Exigencia.ALTA, GrupoMuscular.PIERNAS);

            Ejercicio ej3 = new Ejercicio();
            ej3.agregarEjercicio("Curl Biceps", 2, 3, 10, 15, Exigencia.ALTA, GrupoMuscular.BRAZOS);

            Ejercicio ej4 = new Ejercicio();
            ej4.agregarEjercicio("Chin Ups", 3, 5, 5, 0, Exigencia.ALTA, GrupoMuscular.ESPALDA);

            Ejercicio ej5 = new Ejercicio();
            ej5.agregarEjercicio("Press Arnold", 2, 4, 10, 20, Exigencia.ALTA, GrupoMuscular.HOMBRO);
            
            //EJERCICIOS BAJARPESO QUE NO ENTRAN
            Ejercicio ej18 = new Ejercicio();
            ej18.agregarEjercicio("Aperturas EN T", 2, 3, 5, 70, Exigencia.ALTA, GrupoMuscular.PECHO);
            
            Ejercicio ej19 = new Ejercicio();
            ej19.agregarEjercicio("Sentadilla Bulgara", 1, 5, 50, 0, Exigencia.MEDIA, GrupoMuscular.PIERNAS);

            //EJERCICIOS BAJARPESO QUE SI ENTRAN
            Ejercicio ej6 = new Ejercicio();
            ej6.agregarEjercicio("Apertura de Pecho", 3, 3, 5, 70, Exigencia.ALTA, GrupoMuscular.PECHO);
            
            Ejercicio ej7 = new Ejercicio();
            ej7.agregarEjercicio("Prensa a 45", 4, 5, 50, 0, Exigencia.ALTA, GrupoMuscular.PIERNAS);

            Ejercicio ej8 = new Ejercicio();
            ej8.agregarEjercicio("Curl con Barra", 3, 3, 10, 15, Exigencia.ALTA, GrupoMuscular.BRAZOS);

            Ejercicio ej9 = new Ejercicio();
            ej9.agregarEjercicio("Remo", 3, 4, 5, 0, Exigencia.ALTA, GrupoMuscular.ESPALDA);

            Ejercicio ej10 = new Ejercicio();
            ej10.agregarEjercicio("Press Militar", 5, 4, 10, 20, Exigencia.ALTA, GrupoMuscular.HOMBRO);
            
            //EJERCICIOS MANTENER QUE NO ENTRAN
            Ejercicio ej20 = new Ejercicio();
            ej20.agregarEjercicio("Cruces de Polea", 5, 3, 5, 70, Exigencia.MEDIA, GrupoMuscular.PECHO);
            
            Ejercicio ej21 = new Ejercicio();
            ej21.agregarEjercicio("Step Up", 3, 5, 50, 0, Exigencia.ALTA, GrupoMuscular.PIERNAS);

            //EJERCICIOS MANTENER QUE SI ENTRAN
            Ejercicio ej11 = new Ejercicio();
            ej11.agregarEjercicio("Flexion de Arquero", 3, 3, 5, 70, Exigencia.BAJA, GrupoMuscular.PECHO);
            
            Ejercicio ej12 = new Ejercicio();
            ej12.agregarEjercicio("Deadlift", 4, 5, 50, 0, Exigencia.MEDIA, GrupoMuscular.PIERNAS);

            Ejercicio ej13 = new Ejercicio();
            ej13.agregarEjercicio("Spider", 3, 3, 10, 15, Exigencia.MEDIA, GrupoMuscular.BRAZOS);

            Ejercicio ej14 = new Ejercicio();
            ej14.agregarEjercicio("Dominadas", 3, 4, 5, 0, Exigencia.BAJA, GrupoMuscular.ESPALDA);

            Ejercicio ej15 = new Ejercicio();
            ej15.agregarEjercicio("YTWL", 5, 4, 2, 20, Exigencia.MEDIA, GrupoMuscular.HOMBRO);

            //ejercicos para perder peso

            Ejercicio ej22 = new Ejercicio();
            ej22.agregarEjercicio("Cruces de Polea", 5, 3, 5, 70, Exigencia.MEDIA, GrupoMuscular.PECHO);
            
            Ejercicio ej23 = new Ejercicio();
            ej23.agregarEjercicio("Step Up", 3, 5, 50, 0, Exigencia.ALTA, GrupoMuscular.PIERNAS);

            Ejercicio ej24 = new Ejercicio();
            ej24.agregarEjercicio("Flexion de Arquero", 3, 3, 5, 70, Exigencia.BAJA, GrupoMuscular.PECHO);

            Ejercicio ej25 = new Ejercicio();
            ej25.agregarEjercicio("Deadlift", 4, 5, 50, 0, Exigencia.MEDIA, GrupoMuscular.PIERNAS);

            Ejercicio ej26 = new Ejercicio();
            ej26.agregarEjercicio("Spider", 3, 3, 10, 15, Exigencia.MEDIA, GrupoMuscular.BRAZOS);

            Ejercicio ej27 = new Ejercicio();
            ej27.agregarEjercicio("Dominadas", 3, 4, 5, 0, Exigencia.BAJA, GrupoMuscular.ESPALDA);

            Ejercicio ej28 = new Ejercicio();
            ej28.agregarEjercicio("YTWL", 5, 4, 2, 20, Exigencia.MEDIA, GrupoMuscular.HOMBRO);
            
            Ejercicio ej29 = new Ejercicio();
            ej29.agregarEjercicio("Apertura de Pecho", 3, 3, 5, 70, Exigencia.ALTA, GrupoMuscular.PECHO);

            Ejercicio ej30 = new Ejercicio();
            ej30.agregarEjercicio("Prensa a 45", 4, 5, 50, 0, Exigencia.ALTA, GrupoMuscular.PIERNAS);

            Ejercicio ej31 = new Ejercicio();

            ej31.agregarEjercicio("Curl con Barra", 3, 3, 10, 15, Exigencia.ALTA, GrupoMuscular.BRAZOS);

            Ejercicio ej32 = new Ejercicio();
            ej32.agregarEjercicio("Remo", 3, 4, 5, 0, Exigencia.ALTA, GrupoMuscular.ESPALDA);

            Ejercicio ej33 = new Ejercicio();
            ej33.agregarEjercicio("Press Militar", 5, 4, 10, 20, Exigencia.ALTA, GrupoMuscular.HOMBRO);

            Ejercicio ej34 = new Ejercicio();
            ej34.agregarEjercicio("Apertura de Pecho", 3, 3, 5, 70, Exigencia.ALTA, GrupoMuscular.PECHO);
            
            Ejercicio ej35 = new Ejercicio();
            ej35.agregarEjercicio("Prensa a 45", 4, 5, 50, 0, Exigencia.ALTA, GrupoMuscular.PIERNAS);

            Ejercicio ej36 = new Ejercicio();
            ej36.agregarEjercicio("Curl con Barra", 3, 3, 10, 15, Exigencia.ALTA, GrupoMuscular.BRAZOS);

            Ejercicio ej37 = new Ejercicio();
            ej37.agregarEjercicio("Remo", 3, 4, 5, 0, Exigencia.ALTA, GrupoMuscular.ESPALDA);

            Ejercicio ej38 = new Ejercicio();
            ej38.agregarEjercicio("Press Militar", 5, 4, 10, 20, Exigencia.ALTA, GrupoMuscular.HOMBRO);

            Ejercicio ej39 = new Ejercicio();

            ej39.agregarEjercicio("Cruces de Polea", 5, 3, 5, 70, Exigencia.MEDIA, GrupoMuscular.PECHO);

            Ejercicio ej40 = new Ejercicio();
            ej40.agregarEjercicio("Step Up", 3, 5, 50, 0, Exigencia.ALTA, GrupoMuscular.PIERNAS);

            Ejercicio ej41 = new Ejercicio();
            ej41.agregarEjercicio("Flexion de Arquero", 3, 3, 5, 70, Exigencia.BAJA, GrupoMuscular.PECHO);

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
