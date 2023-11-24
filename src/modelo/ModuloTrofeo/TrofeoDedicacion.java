package modelo.moduloTrofeo;

import modelo.moduloObjetivo.ObjetivoStrategy;

public class TrofeoDedicacion extends TrofeoObservador {
	private ObjetivoStrategy objetivo;
	
	@Override
	public void chequearTrofeo() {
		objetivo.chequearTrofeo();
	}
	
}