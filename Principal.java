// Definir la clase que representa el sistema
class ArnoldFitnessCenterSystem {
    private String nombre;

    ArnoldFitnessCenterSystem() {
        this.nombre = "Arnold Fitness Center";
    }

    public void iniciar() {
        System.out.println("Bienvenido a " + this.nombre);
    }

}

public class Principal {
    public static void main(String[] args) {
        ArnoldFitnessCenterSystem sistema = new ArnoldFitnessCenterSystem();
        sistema.iniciar();
    }
}
