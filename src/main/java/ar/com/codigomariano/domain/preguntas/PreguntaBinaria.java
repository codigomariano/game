package ar.com.codigomariano.domain.preguntas;

import ar.com.codigomariano.enums.Categoria;
import ar.com.codigomariano.enums.Opcion;

public class PreguntaBinaria extends Pregunta<Boolean> {

	
	public PreguntaBinaria(String cod, String text, Categoria categoria, Opcion correcta) {
		super(cod, text, categoria, correcta);
	}
	
	public PreguntaBinaria(String cod, String text, Categoria categoria, Opcion correcta, int puntos) {
		super(cod, text, categoria, correcta, puntos);
	}

	
	@Override
	protected Boolean[] inicializarOpciones() {
		return new Boolean[] {Boolean.TRUE, Boolean.FALSE};
	}
}
