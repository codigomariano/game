package ar.com.codigomariano.domain.preguntas;

import ar.com.codigomariano.enums.Categoria;
import ar.com.codigomariano.enums.Opcion;

public abstract class Pregunta<T> {
	private static final int DEFAULT_PUNTOS = 100;
	private String codigo;
	private String texto;
	private Categoria categoria;
	private Opcion opcionCorrecta;
	private T[] opciones;
	private int puntos;
	
	
	
	public Pregunta(String cod, String text, Categoria categoria, Opcion correcta) {
		this(cod, text, categoria, correcta, DEFAULT_PUNTOS);
	}
	
	public Pregunta(String cod, String text, Categoria categoria, Opcion correcta, int puntos) {
		this.codigo = cod;
		this.texto = text;
		this.categoria = categoria;
		this.opcionCorrecta = correcta;
		this.puntos = puntos;
		this.opciones = inicializarOpciones();
	}
	
	
	public void mostar() {
		System.out.println(this.texto);
		
		for(int i = 0; i<opciones.length; i++) {
			System.out.println(Opcion.values()[i] + ". " + this.opciones[i]);
		}
	}
		
	protected void asignar(Opcion opcion, T valor) {
		this.opciones[opcion.ordinal()] = valor;
	}
	
	protected abstract T[] inicializarOpciones();
	
}
