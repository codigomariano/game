package ar.com.codigomariano.servicios;

import org.junit.jupiter.api.Test;

import ar.com.codigomariano.domain.Juego;
import ar.com.codigomariano.helpers.EntityHelper;

public class JuegoServiceTest extends BaseServiceTest<JuegoService> {

	@Test
	public void testSaveJuegoSuccess() {
		Juego juego = EntityHelper.createEmptyJuego();
		
		service().save(juego);
	}
	
	
	@Test
	public void testSaveJuegoWithBinaryQuestions() {
		Juego juego = EntityHelper.createFullJuego();
		
		service().save(juego);
	}
}
