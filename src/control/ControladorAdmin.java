package control;

import vistas.VistaMenuAdmin;
import vistas.VistaMenuSocio;

public class ControladorAdmin {

    public static void disponibilizarVistaMenuAdmin() {
        VistaMenuAdmin vMA = new VistaMenuAdmin();
		vMA.setVisible(true);
		vMA.setSize(500, 500);
		vMA.setLocation(0, 0);
    }

}
