package ar.com.codigomariano.domain;

import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

import ar.com.codigomariano.helpers.EntityHelper;

public class UsuarioEntityTest {

	
	@Test
	public void testTieneEmailSuccess() {
		Usuario u = EntityHelper.createValidUser();
		
		assertTrue(u.tieneEmail(EntityHelper.VALID_EMAIL));
	}
}
