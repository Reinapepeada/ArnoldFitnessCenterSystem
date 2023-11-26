package modelo.VOs;


public class SocioVo{
    private String edad;
	private String nombre;
	private String apellido;
	private String dni;
	private String email;
	private String password;
	private String sexo;
	private Double altura;
	private Double peso;

    public SocioVo(String nombre, String apellido, String email, String dni, String edad, String sexo, String password, Double altura, Double peso) {
        this.edad = edad;
        this.nombre = nombre;
        this.apellido = apellido;
        this.dni = dni;
        this.email = email;
        this.password = password;
        this.sexo = sexo;
        this.altura = altura;
        this.peso = peso;
    }

    public SocioVo() {
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
        this.nombre = nombre.toUpperCase();
    }

    public String getApellido() {
        return this.apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido.toUpperCase();
    }

    public String getDni() {
        return this.dni;
    }

    public void setDni(String dni) {
        this.dni = dni.toUpperCase();
    }

    public String getEmail() {
        return this.email;
    }

    public void setEmail(String email) {
        this.email = email.toUpperCase();
    }

    public String getPassword() {
        return this.password;
    }

    public void setPassword(String password) {
        this.password = password.toUpperCase();
    }

    public String getSexo() {
        return this.sexo;
    }

    public void setSexo(String sexo) {
        this.sexo = sexo.toUpperCase();
    }

    public Double getPeso(){
        return this.peso;
    }

    public void setPeso(Double peso){
        this.peso = peso;
    }

    public Double getAltura(){
        return this.altura;
    }

    public void setAltura(Double altura){
        this.altura = altura;
    }
}