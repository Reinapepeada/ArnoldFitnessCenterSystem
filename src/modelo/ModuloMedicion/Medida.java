package modelo.ModuloMedicion;

public class Medida {
    private double bmi;
    private double porcetajeGrasa;
    private double porcentajeMusculo;
    private double altura;
    private double peso;
    private AdapterMedida medicion;

    //Metodos de acceso y modifiacion
    private boolean authUsuario(String email, String psw){
        // TODO - implement Medida.authUsuario
        return false;
    }

    public double getAltura(){
        return this.altura;
    }
    public double getPeso(){
        return this.peso;
    }
    public double getBMI(){
        return this.bmi;
    }
    public double getPorcentajeGrasa(){
        return this.porcetajeGrasa;
    }   
    public double getPorcentajeMusculo(){
        return this.porcentajeMusculo;
    }


}
