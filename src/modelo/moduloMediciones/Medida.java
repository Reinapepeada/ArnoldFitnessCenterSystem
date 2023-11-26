package modelo.moduloMediciones;

public class Medida {
    private double porcetajeGrasa;
    private double porcentajeMusculo;
    private double altura;
    private double peso;
    private AdapterMedida medicion;

    //Constructor
    public Medida(double altura, double peso,double porcetajeGrasa, double porcentajeMusculo, AdapterMedida medicion) {
        this.altura = altura;
        this.peso = peso;
        this.porcetajeGrasa = porcetajeGrasa;
        this.porcentajeMusculo = porcentajeMusculo;
        this.medicion = medicion;
    }
    // public Medida(){
    //     this.medicion = new BalanzaSystemAdapter();
    // }


    //Metodos de acceso y modifiacion
    public double getAltura(){
        return this.altura;
    }
    public double getPeso(){
        return this.peso;
    }
    public double getPorcentajeGrasa(){
        return this.porcetajeGrasa;
    }   
    public double getPorcentajeMusculo(){
        return this.porcentajeMusculo;
    }

    public double getBMi(){
        return this.getPeso() / (this.getAltura() * this.getAltura());
    }


}
