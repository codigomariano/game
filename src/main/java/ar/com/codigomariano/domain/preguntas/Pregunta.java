package ar.com.codigomariano.domain.preguntas;

import ar.com.codigomariano.domain.Persistible;
import ar.com.codigomariano.enums.Categoria;
import ar.com.codigomariano.enums.Opcion;
import jakarta.persistence.Column;
import jakarta.persistence.DiscriminatorColumn;
import jakarta.persistence.DiscriminatorType;
import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.Inheritance;
import jakarta.persistence.InheritanceType;
import jakarta.persistence.Table;

@Entity
@Table(name = "PREGUNTAS")
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name = "discriminator", discriminatorType = DiscriminatorType.STRING)
@DiscriminatorValue(value = "PROFESIONAL")
public abstract class Pregunta<T> extends Persistible{
	private static final int DEFAULT_PUNTOS = 100;
	private static final String ERR_CODIGO_VACIO = "El código no puede estar vacío";
	private static final String ERR_TEXTO_VACIO = "El texto no puede estar vacío";
	private static final String ERR_CATEGORIA = "La categoría no puede ser nula";
	private static final String ERR_OPCION_CORRECTA = "La opción correcta no puede ser nula";
	
	@Column(name = "codigo")
	private String codigo;
	
	@Column(name = "texto")
	private String texto;
	
	@Column(name = "categoria_id")
	@Enumerated(EnumType.ORDINAL)
	private Categoria categoria;
	
	@Column(name = "opcion_correcta")
	@Enumerated(EnumType.STRING)
	private Opcion opcionCorrecta;
	
	private Opcion[] opciones;
	
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
		//this.opciones = inicializarOpciones();
	}
	
	
	
	
	public String getCodigo() {
		return codigo;
	}

	public void mostar() {
		System.out.println(this.texto);
	
		for(int i = 0; i<opciones.length; i++) {
			System.out.println(Opcion.values()[i] + ". " + this.opciones[i]);
		}
	}
		
	protected void asignar(Opcion opcion, T valor) {
		//this.opciones[opcion.ordinal()] = valor;
	}
	
	//protected abstract List<T> inicializarOpciones();

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
