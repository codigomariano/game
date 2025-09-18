package ar.com.codigomariano.domain.preguntas;

import ar.com.codigomariano.enums.Categoria;
import ar.com.codigomariano.enums.Opcion;
import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;

@Entity
@DiscriminatorValue(value = PreguntaMultiple.DISCRIMINATOR_VALUE)
public class PreguntaMultiple extends Pregunta<String>{
	public static final String DISCRIMINATOR_VALUE = "MULTIPLE";

	public PreguntaMultiple(String cod, String text, Categoria categoria, Opcion correcta) {
		super(cod, text, categoria, correcta);
	}
	
	public PreguntaMultiple(String cod, String text, Categoria categoria, Opcion correcta, int puntos) {
		super(cod, text, categoria, correcta, puntos);
	}

	public void sumarOpcion(Opcion o, String texto) {
		asignar(o, texto);
	}
	
	/*
	protected String[] inicializarOpciones() {
		return new String[Opcion.values().length];
	}
	*/
}
