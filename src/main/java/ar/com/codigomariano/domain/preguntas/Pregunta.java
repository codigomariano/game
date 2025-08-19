package ar.com.codigomariano.domain.preguntas;

import ar.com.codigomariano.enums.Categoria;
import ar.com.codigomariano.enums.Opcion;

public abstract class Pregunta<T> {
	private static final int DEFAULT_PUNTOS = 100;
	private static final String ERR_CODIGO_VACIO = "El código no puede estar vacío";
	private static final String ERR_TEXTO_VACIO = "El texto no puede estar vacío";
	private static final String ERR_CATEGORIA = "La categoría no puede ser nula";
	private static final String ERR_OPCION_CORRECTA = "La opción correcta no puede ser nula";
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
		setCodigo(cod);
		setTexto(text);
		setCategoria(categoria);
		setOpcionCorrecta(correcta);
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

	public void setCodigo(String codigo) {
		if(codigo == null || codigo.isBlank()) throw new IllegalArgumentException(ERR_CODIGO_VACIO);
		this.codigo = codigo;
	}

	public void setTexto(String texto) {
		if(texto == null || texto.isBlank()) throw new IllegalArgumentException(ERR_TEXTO_VACIO);
		this.texto = texto;
	}

	public void setCategoria(Categoria categoria) {
		if(categoria == null) throw new IllegalArgumentException(ERR_CATEGORIA);
		this.categoria = categoria;
	}

	public void setOpcionCorrecta(Opcion opcionCorrecta) {
		if(opcionCorrecta == null) throw new IllegalArgumentException(ERR_OPCION_CORRECTA);
		this.opcionCorrecta = opcionCorrecta;
	}
	
	
	
}
