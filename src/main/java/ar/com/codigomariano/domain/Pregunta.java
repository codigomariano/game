package ar.com.codigomariano.domain;

import ar.com.codigomariano.enums.Categoria;

public class Pregunta {
	private String codigo;
	private String texto;
	private Categoria categoria;
	
	
	
	public Pregunta(String cod, String text, Categoria categoria) {
		this.codigo = cod;
		this.texto = text;
		this.categoria = categoria;
	}
}
