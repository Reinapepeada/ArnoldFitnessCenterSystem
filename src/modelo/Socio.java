package modelo;

import java.util.List;

import modelo.objetivo.ObjetivoStrategy;
import modelo.trofeo.Trofeo;

public class Socio {
	private int edad;
	private String nombre;
	private String apellido;
	private String dni;
	private String email;
	private String password;
	private String Sexo;
	private float altura;
	private float peso;
	private float porcentajeGrasa;
	private float porcentajeMusculo;
	private List<Medida> medidas;
	private List<Trofeo> trofeos;
	private ObjetivoStrategy objetivo;
	private Rutina rutina;

	public int getEdad() {
		return edad;
	}

	public void setEdad(int edad) {
		this.edad = edad;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getApellido() {
		return apellido;
	}

	public void setApellido(String apellido) {
		this.apellido = apellido;
	}

	public String getDni() {
		return dni;
	}

	public void setDni(String dni) {
		this.dni = dni;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getSexo() {
		return Sexo;
	}

	public void setSexo(String sexo) {
		Sexo = sexo;
	}

	public float getAltura() {
		return altura;
	}

	public void setAltura(float altura) {
		this.altura = altura;
	}

	public float getPeso() {
		return peso;
	}

	public void setPeso(float peso) {
		this.peso = peso;
	}

	public float getPorcentajeGrasa() {
		return porcentajeGrasa;
	}

	public void setPorcentajeGrasa(float porcentajeGrasa) {
		this.porcentajeGrasa = porcentajeGrasa;
	}

	public float getPorcentajeMusculo() {
		return porcentajeMusculo;
	}

	public void setPorcentajeMusculo(float porcentajeMusculo) {
		this.porcentajeMusculo = porcentajeMusculo;
	}

	public List<Medida> getMedidas() {
		return medidas;
	}

	public void setMedidas(List<Medida> medidas) {
		this.medidas = medidas;
	}

	public List<Trofeo> getTrofeos() {
		return trofeos;
	}

	public void setTrofeos(List<Trofeo> trofeos) {
		this.trofeos = trofeos;
	}

	public ObjetivoStrategy getObjetivo() {
		return objetivo;
	}

	public void setObjetivo(ObjetivoStrategy objetivo) {
		this.objetivo = objetivo;
	}

	public Rutina getRutina() {
		return rutina;
	}

	public void setRutina(Rutina rutina) {
		this.rutina = rutina;
	}

	public Socio() {
	}

	public void cambiarObjetivo(ObjetivoStrategy objetivo) {
		this.objetivo = objetivo;
	}

	public void registrarPeso(float peso) {
		this.peso = peso;
	}
}
