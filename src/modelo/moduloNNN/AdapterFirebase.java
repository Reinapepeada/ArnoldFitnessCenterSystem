package modelo.moduloNNN;

import modelo.moduloTrofeo.TrofeoObservador;

public class AdapterFirebase implements AdapterNotificacionFirebase {
    
    @Override
    public void enviaNotificacion(String n) {
        // Implementation for sending a notification through Firebase
        System.out.println("Sending Firebase notification for trofeo: " + n);
    }
}
