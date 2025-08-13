package ar.com.codigomariano.domain.preguntas;

import ar.com.codigomariano.enums.Categoria;
import ar.com.codigomariano.enums.Opcion;

public class PreguntaMultiple extends Pregunta{
	private String[] opciones;
	

	public PreguntaMultiple(String cod, String text, Categoria categoria, Opcion correcta, int puntos) {
		super(cod, text, categoria, correcta, puntos);
		this.opciones = new String[Opcion.values().length];
	}

	
	public void sumarOpcion(Opcion opcion, String texto) {
		this.opciones[opcion.ordinal()] = texto;
	}

	@Override
	protected void mostarOpciones() {
		for (Opcion opcion : Opcion.values()) {
			System.out.println(opcion + ". " + this.opciones[opcion.ordinal()]);
		}
	}
}
