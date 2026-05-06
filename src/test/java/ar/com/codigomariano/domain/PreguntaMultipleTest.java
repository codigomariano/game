package ar.com.codigomariano.domain;

import ar.com.codigomariano.domain.preguntas.PreguntaMultiple;
import ar.com.codigomariano.helpers.EntityHelper;

public class PreguntaMultipleTest extends PreguntaTest<PreguntaMultiple> {

	@Override
	protected PreguntaMultiple createEntity() {
		return EntityHelper.createPreguntaMultiple();
	}

}
