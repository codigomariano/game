package ar.com.codigomariano.domain.preguntas;

import ar.com.codigomariano.enums.Categoria;
import ar.com.codigomariano.enums.Opcion;

public abstract class Pregunta {
	private String codigo;
	private String texto;
	private Categoria categoria;
	private Opcion opcionCorrecta;
	private int puntos;
	
	
	public Pregunta(String cod, String text, Categoria categoria, Opcion correcta, int puntos) {
		this.codigo = cod;
		this.texto = text;
		this.categoria = categoria;
		this.opcionCorrecta = correcta;
		this.puntos = puntos;
	}
	
	
	public void mostar() {
		System.out.println(this.texto);
		mostarOpciones();
	}
	
	protected abstract void mostarOpciones();
}
