package ar.com.codigomariano.domain;

import ar.com.codigomariano.enums.Categoria;
import ar.com.codigomariano.enums.Opcion;

public class PreguntaBinaria extends Pregunta {
	private final int CANT_OPCIONES = 2; 
	private Boolean[] opciones;
	
	
	public PreguntaBinaria(String cod, String text, Categoria categoria, Opcion correcta, int puntos) {
		super(cod, text, categoria, correcta, puntos);
		this.opciones = new Boolean[CANT_OPCIONES];
	}

}
