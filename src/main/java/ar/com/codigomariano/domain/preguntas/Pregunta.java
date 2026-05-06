package ar.com.codigomariano.domain.preguntas;

import ar.com.codigomariano.domain.Persistible;
import ar.com.codigomariano.enums.Categoria;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.Inheritance;
import jakarta.persistence.InheritanceType;
import jakarta.persistence.Table;

@Entity
@Table(name = "PREGUNTAS")
@Inheritance(strategy = InheritanceType.JOINED)
public abstract class Pregunta extends Persistible{
	protected static final int DEFAULT_PUNTOS = 100;
	private static final String ERR_CODIGO_VACIO = "El código no puede estar vacío";
	private static final String ERR_TEXTO_VACIO = "El texto no puede estar vacío";
	private static final String ERR_CATEGORIA = "La categoría no puede ser nula";
	protected static final String ERR_OPCION_CORRECTA = "La opción correcta no puede ser nula";

	@Column(name = "codigo")
	private String codigo;
	
	@Column(name = "texto")
	private String texto;
	
	@Column(name = "categoria_id")
	@Enumerated(EnumType.ORDINAL)
	private Categoria categoria;
	
	@Column(name = "puntos")
	private int puntos;
	
	
	// Just for Hibernate
	protected Pregunta() {
		super();
	}
	
	public Pregunta(String cod, String text, Categoria categoria) {
		this(cod, text, categoria, DEFAULT_PUNTOS);
	}
	
	public Pregunta(String cod, String text, Categoria categoria, int puntos) {
		setCodigo(cod);
		setTexto(text);
		setCategoria(categoria);
		setPuntos(puntos);
	}
	
	
	public String getCodigo() {
		return codigo;
	}

	public void mostar() {
		System.out.println(this.texto);
		
		mostrarOpciones();
	}
		
	protected abstract void mostrarOpciones();
	
	
	private void setCodigo(String codigo) {
		if(codigo == null || codigo.isBlank()) throw new IllegalArgumentException(ERR_CODIGO_VACIO);
		this.codigo = codigo;
	}

	private void setTexto(String texto) {
		if(texto == null || texto.isBlank()) throw new IllegalArgumentException(ERR_TEXTO_VACIO);
		this.texto = texto;
	}

	private void setCategoria(Categoria categoria) {
		if(categoria == null) throw new IllegalArgumentException(ERR_CATEGORIA);
		this.categoria = categoria;
	}
	
	private void setPuntos(int puntos) {
		this.puntos = puntos;
	}
}
