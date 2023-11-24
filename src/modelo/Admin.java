package modelo;

public class Admin extends UsuarioArnold {

	private String dni;
	private String password;

    protected Admin(String dni, String password) {
        super(dni, password);
        //TODO Auto-generated constructor stub
    }
    
	public boolean soyEseCliente(String dni) {
		return this.dni.equals(dni);
	}

    public String obtenerDocumento() {
		return this.dni;
	}

    public boolean soyAdmin(){
		return true;
	}
}
