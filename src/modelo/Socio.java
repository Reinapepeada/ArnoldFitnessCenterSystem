package modelo;

import java.util.List;

import control.ControladorSocio;
import modelo.excepciones.SocioExistenteException;
import modelo.VOs.SocioVo;
import modelo.enums.Objetivo;
import modelo.excepciones.CredencialesInvalidasException;
import modelo.moduloMediciones.Medida;
import modelo.moduloObjetivo.ObjetivoStrategy;
import modelo.moduloRutina.Rutina;

public class Socio {
	private String edad;
	private String nombre;
	private String apellido;
	private String dni;
	private String email;
	private String password;
	private String sexo;
	private Double altura;
	private Double peso;
	private float porcentajeGrasa;
	private float porcentajeMusculo;
	private List<Medida> medidas;
	private ObjetivoStrategy objetivo;
	private Rutina rutina;

	public Socio(String nombre, String apellido, String email, String dni, String edad, String sexo, String password,
			Double altura, Double peso) {

		this.nombre = nombre;
		this.apellido = apellido;
		this.email = email;
		this.dni = dni;
		this.edad = edad;
		this.password = password;
		this.sexo = sexo;
		this.altura = altura;
		this.peso = peso;
	}

	// Socio.registrarSocio("Jake", "Peralta", "jperalta@uade.edu.ar", "40123456",
	// "32", "Masculino", "Hola123", 75.0, 183.0);

	public Socio() {
	}

	public Socio registrarSocio(String nombre, String apellido, String email, String dni, String edad, String sexo,
			String password, Double altura, Double peso) throws SocioExistenteException {
		if (buscarSocio(dni) == null) {
			Socio socio = new Socio(nombre, apellido, email, dni, edad, sexo, password, altura, peso);
			ControladorSocio.usuarios.add(socio);
			// System.out.println("\nListado Usuarios: \n");
			// ControladorSocio.verListadoSocios(ControladorSocio.usuarios);
			return socio;
		}
		throw new SocioExistenteException("Error. Ya existe un Socio con el numero de documento ingresado.");
	}

	private Socio buscarSocio(String dni) {
		for (Socio socio : ControladorSocio.usuarios) {
			if (socio.soyEseSocio(dni)) {
				return socio;
			}
		}
		return null;
	}

	public boolean soyEseSocio(String dni) {
		return this.dni.equals(dni);
	}

	public Socio autenticarUsuario(String dni, String contrasena) throws CredencialesInvalidasException {
		for (Socio usr : ControladorSocio.usuarios) {
			if (usr.soyEsteUsuario(dni, contrasena)) {
				System.out.println("Socio: " + usr.getNombre());
				System.out.println("dni: " + dni);
				System.out.println("Password: " + usr.getPassword());
				return usr;
			}
		}
		throw new CredencialesInvalidasException("Las credenciales ingresadas son invalidas.");
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

	public double getAltura() {
		return this.altura;
	}

	public void setAltura(Double altura) {
		this.altura = altura;
	}

	public double getPeso() {
		return this.peso;
	}

	public void setPeso(Double peso) {
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

	public void registrarPeso(Double peso) {
		this.peso = peso;
	}

	public boolean soySocio() {
		return true;
	}

	public SocioVo getVO() {
		return new SocioVo(this.nombre, this.apellido, this.email, this.dni, this.edad, this.sexo, this.password,this.altura, this.peso);
	}
}
