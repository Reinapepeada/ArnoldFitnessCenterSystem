package Modelo;

public abstract class UsuarioArnold {

    private static int contador = 0;
	protected int id;
	private Object password;
	private String dni;
	
	protected UsuarioArnold(String dni, String password) {
		this.id = contador;
		contador++;
		this.dni = dni;
		this.password = password;
	}

	protected boolean soyEsteUsuario(String dni) {
		return this.dni == dni;
	}
	
	protected boolean soyEsteUsuario(String dni, String password) {
		return this.dni.equals(dni) && this.password.equals(password);
	}

	public String obtenerDNI() {
		return this.dni;
	}
    
}
