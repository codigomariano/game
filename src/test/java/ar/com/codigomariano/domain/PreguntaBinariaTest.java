package ar.com.codigomariano.domain;

import ar.com.codigomariano.domain.preguntas.PreguntaBinaria;
import ar.com.codigomariano.helpers.EntityHelper;

public class PreguntaBinariaTest extends PreguntaTest<PreguntaBinaria> {

	@Override
	protected PreguntaBinaria createEntity() {
		return EntityHelper.createPreguntaBinaria();
	}

}
