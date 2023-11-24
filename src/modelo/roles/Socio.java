package modelo.roles;

import java.util.List;

import Control.ControladorSocio;
import Modelo.Excepciones.SocioExistenteException;
import Modelo.Excepciones.CredencialesInvalidasException;
import Modelo.ModuloMediciones.Medida;
import Modelo.ModuloObjetivo.ObjetivoStrategy;

public class Socio extends UsuarioArnold {
	private String edad;
	private String nombre;
	private String apellido;
	private String dni;
	private String email;
	private String password;
	private String sexo;
	private float altura;
	private float peso;
	private float porcentajeGrasa;
	private float porcentajeMusculo;
	private List<Medida> medidas;
	private ObjetivoStrategy objetivo;
	private Rutina rutina;

	public Socio(String nombre, String apellido, String email, String dni, String edad, String password, String sexo, float altura, float peso, ObjetivoStrategy objetivo){
		super(dni, password);
		this.edad = edad;
		this.nombre = nombre;
		this.apellido = apellido;
		this.email = email;
		this.sexo = sexo;
		this.altura = altura;
		this.peso = peso;
	}

	//registrarSocio(nombreSocio, apellidoSocio, emailSocio, dniSocio, edadSocio, sexoSocio, passwordSocio, pesoSocio, alturaSocio, objetivoSocio);

	public static void registrarSocio(String nombre, String apellido, String email, String dni, String edad, String sexo, String password, float peso, float altura, ObjetivoStrategy objetivo) throws SocioExistenteException{
		
		if (buscarSocio(dni) == null) {
			Socio socio = new Socio(nombre, apellido, email, dni, edad, sexo, password, peso, altura, objetivo);
			ControladorSocio.usuarios.add(socio);
			return;
		}
		throw new SocioExistenteException("Error. Ya existe un Socio con el numero de documento ingresado.");
	}

	private static Socio buscarSocio(String dni) {
		for (Socio socio: ControladorSocio.usuarios) {
			if (socio.soyEseSocio(dni)) {
				return socio;
			}
		}
		return null;
	}

	public boolean soyEseSocio(String dni) {
		return this.dni.equals(dni);
	}

	public UsuarioArnold autenticarUsuario(String usuario, String contrasena) throws CredencialesInvalidasException {
	for (UsuarioArnold usr: ControladorSocio.usuarios) {
		if (usr.soyEsteUsuario(usuario, contrasena)) {
			return usr;
		}
	}
	throw new CredencialesInvalidasException("Las credenciales ingresadas son invÃ¡lidas.");
	}



	public String getEdad() {
		return this.edad;
	}

	public void setEdad(String edad) {
		this.edad = edad;
	}

	public String getNombre() {
		return this.nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getApellido() {
		return this.apellido;
	}

	public void setApellido(String apellido) {
		this.apellido = apellido;
	}

	public String getDni() {
		return this.dni;
	}

	public void setDni(String dni) {
		this.dni = dni;
	}

	public String getEmail() {
		return this.email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return this.password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getSexo() {
		return this.sexo;
	}

	public void setSexo(String sexo) {
		this.sexo = sexo;
	}

	public float getAltura() {
		return this.altura;
	}

	public void setAltura(float altura) {
		this.altura = altura;
	}

	public float getPeso() {
		return this.peso;
	}

	public void setPeso(float peso) {
		this.peso = peso;
	}

	public float getPorcentajeGrasa() {
		return this.porcentajeGrasa;
	}

	public void setPorcentajeGrasa(float porcentajeGrasa) {
		this.porcentajeGrasa = porcentajeGrasa;
	}

	public float getPorcentajeMusculo() {
		return this.porcentajeMusculo;
	}

	public void setPorcentajeMusculo(float porcentajeMusculo) {
		this.porcentajeMusculo = porcentajeMusculo;
	}

	public List<Medida> getMedidas() {
		return this.medidas;
	}

	public void setMedidas(List<Medida> medidas) {
		this.medidas = medidas;
	}

	public ObjetivoStrategy getObjetivo() {
		return this.objetivo;
	}

	public void setObjetivo(ObjetivoStrategy objetivo) {
		this.objetivo = objetivo;
	}

	public Rutina getRutina() {
		return this.rutina;
	}

	public void setRutina(Rutina rutina) {
		this.rutina = rutina;
	}

	public void cambiarObjetivo(ObjetivoStrategy objetivo) {
		this.objetivo = objetivo;
	}

	public void registrarPeso(float peso) {
		this.peso = peso;
	}

	public boolean soySocio() {
		return true;
	}
}