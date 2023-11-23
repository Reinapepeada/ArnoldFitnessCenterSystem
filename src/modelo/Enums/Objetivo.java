package Modelo.Enums;

public enum Objetivo {
	BajarPeso (1),
	Tonificar (2),
	Mantener (3);
	
	private int valorObjetivo;
	
	Objetivo (int valorObjetivo){
		this.valorObjetivo = valorObjetivo;
	}
	
	public int obtenerCostoMembresia() {
		return this.valorObjetivo;
	}
}


