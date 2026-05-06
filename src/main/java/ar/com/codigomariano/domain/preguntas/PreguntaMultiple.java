package ar.com.codigomariano.domain.preguntas;

import java.util.ArrayList;
import java.util.List;

import ar.com.codigomariano.domain.Respuesta;
import ar.com.codigomariano.enums.Categoria;
import ar.com.codigomariano.enums.OpcionMultiple;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "PREGUNTAS_MULTIPLES")
public class PreguntaMultiple extends Pregunta{
	@OneToMany(cascade = CascadeType.ALL)
	@JoinColumn(name="pregunta_id", referencedColumnName = "ID", nullable = false)
	private List<Respuesta> respuestas;
	
	
	// Just for Hibernate
	protected PreguntaMultiple() {
		super(); 
	}
	

	public PreguntaMultiple(String cod, String text, Categoria categoria) {
		this(cod, text, categoria, DEFAULT_PUNTOS);
	}
	
	public PreguntaMultiple(String cod, String text, Categoria categoria, int puntos) {
		super(cod, text, categoria, puntos);
		this.respuestas = new ArrayList<Respuesta>();
	}
	
	public void agregarRespuesta(String texto) {
		this.respuestas.add(new Respuesta(texto));
	}
	
	public void agregarRespuestaCorrecta(String texto) {
		this.respuestas.add(new Respuesta(texto, Boolean.TRUE));
	}
	
	@Override
	protected void mostrarOpciones() {
		int index = 0;
	
		while(index < this.respuestas.size()) {
			Respuesta respuesta = this.respuestas.get(index);
			OpcionMultiple opcion = OpcionMultiple.values()[index];
			respuesta.mostrarRespuesta(opcion);
			
			index++;
		}
	}
}
