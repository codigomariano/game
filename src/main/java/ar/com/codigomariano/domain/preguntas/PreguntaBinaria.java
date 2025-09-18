package ar.com.codigomariano.domain.preguntas;

import ar.com.codigomariano.enums.Categoria;
import ar.com.codigomariano.enums.Opcion;
import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;

@Entity
@DiscriminatorValue(value = PreguntaBinaria.DISCRIMINATOR_VALUE)
public class PreguntaBinaria extends Pregunta<Boolean> {
	public static final String DISCRIMINATOR_VALUE = "binaria";
	
	public PreguntaBinaria(String cod, String text, Categoria categoria, Opcion correcta) {
		super(cod, text, categoria, correcta);
	}
	
	public PreguntaBinaria(String cod, String text, Categoria categoria, Opcion correcta, int puntos) {
		super(cod, text, categoria, correcta, puntos);
	}

	/*
	protected Boolean[] inicializarOpciones() {
		return new Boolean[] {Boolean.TRUE, Boolean.FALSE};
	}
	*/
}
