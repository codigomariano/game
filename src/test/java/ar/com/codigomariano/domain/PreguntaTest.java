package ar.com.codigomariano.domain;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import org.junit.jupiter.api.Test;

import ar.com.codigomariano.domain.preguntas.Pregunta;


public abstract class PreguntaTest<T extends Pregunta<?>> {

	@Test
	public void testCodigoNotNull() {
		T p = createEntity();
		assertNotNull(p.getCodigo());
	}

	
	@Test
	public void testMostrarDatos() {
		T p = createEntity();
		assertEquals(expectedText(), p.toString());
	}
	
	abstract T createEntity();
	
	abstract String expectedText();
}
