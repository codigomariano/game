package ar.com.codigomariano.domain.preguntas;

import ar.com.codigomariano.enums.Categoria;
import ar.com.codigomariano.enums.Opcion;

public class PreguntaMultiple extends Pregunta<String>{


	public PreguntaMultiple(String cod, String text, Categoria categoria, Opcion correcta) {
		super(cod, text, categoria, correcta);
	}
	
	public PreguntaMultiple(String cod, String text, Categoria categoria, Opcion correcta, int puntos) {
		super(cod, text, categoria, correcta, puntos);
	}

	public void sumarOpcion(Opcion o, String texto) {
		asignar(o, texto);
	}
	
	@Override
	protected String[] inicializarOpciones() {
		return new String[Opcion.values().length];
	}
}
