package ar.com.codigomariano.domain;

import ar.com.codigomariano.enums.Categoria;
import ar.com.codigomariano.enums.Opcion;

public class PreguntaMultiple extends Pregunta{
	private String[] opciones;
	

	public PreguntaMultiple(String cod, String text, Categoria categoria, Opcion correcta, int puntos) {
		super(cod, text, categoria, correcta, puntos);
		this.opciones = new String[Opcion.values().length];
	}
}
