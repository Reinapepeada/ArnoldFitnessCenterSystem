package Modelo;

public abstract class UsuarioArnold {

    private static int contador = 0;
	protected int id;
	protected String usuario;
	protected String contrasena;
	
	protected UsuarioArnold(String usuario, String contrasena) {
		this.id = contador;
		contador++;
		this.usuario = usuario;
		this.contrasena = contrasena;
	}

	protected boolean soyEsteUsuario(int id) {
		return this.id == id;
	}
	
	protected boolean soyEsteUsuario(String usuario, String contrasena) {
		return this.usuario.equals(usuario) && this.contrasena.equals(contrasena);
	}
	
	public boolean soyAdmin(){
		return false;
	}
	
	public boolean soySocio() {
		return false;
	}

	public int obtenerId() {
		return this.id;
	}
    
}
