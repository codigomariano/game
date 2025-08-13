package ar.com.codigomariano.domain.preguntas;

import ar.com.codigomariano.enums.Categoria;
import ar.com.codigomariano.enums.Opcion;

public class PreguntaBinaria extends Pregunta {
	private Boolean[] opciones;
	
	
	public PreguntaBinaria(String cod, String text, Categoria categoria, Opcion correcta, int puntos) {
		super(cod, text, categoria, correcta, puntos);
		this.opciones = new Boolean[] {Boolean.TRUE, Boolean.FALSE};
	}


	@Override
	protected void mostarOpciones() {
		for(int i = 0; i<opciones.length; i++) {
			System.out.println(Opcion.values()[i] + ". " + this.opciones[i]);
		}
	}
}
