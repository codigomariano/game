package ar.com.codigomariano.servicios;

import org.junit.jupiter.api.Test;

import ar.com.codigomariano.domain.preguntas.PreguntaBinaria;
import ar.com.codigomariano.helpers.EntityHelper;

public class PreguntaServiceTest extends BaseServiceTest<PreguntaService>{

	
	@Test
	public void testSavePreguntaBinaria() {
		PreguntaBinaria pregunta = EntityHelper.createPreguntaBinaria();
		
		service().guardarPregunta(pregunta);
	}
}
