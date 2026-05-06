package ar.com.codigomariano.domain;

import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.fail;

import org.junit.jupiter.api.Test;

import ar.com.codigomariano.helpers.EntityHelper;

public class UsuarioEntityTest {

	
	@Test
	public void testTieneEmailSuccess() {
		Usuario u = EntityHelper.createValidUser();
		
		assertTrue(u.tieneEmail(EntityHelper.VALID_EMAIL));
	}
	
	@Test
	public void testUsuarioConEmailIncorrecto() {
			try {
				
				Usuario u = new Usuario(null);
				fail("El usuario no se puede crear con email en nulo. Algo no se validó!");
				
			}catch(RuntimeException ex) {
				// Ok. Es lo esperado
			}	
	}
	
	@Test
	public void testUsuarioConEmailVacio() {
			try {
				
				Usuario u = new Usuario("");
				fail("El usuario no se puede crear con email en nulo. Algo no se validó!");
				
			}catch(RuntimeException ex) {
				// Ok. Es lo esperado
			}	
	}
	
	@Test
	public void testUsuarioConEmailConLongitudMinimaInvalida() {
			try {
				
				Usuario u = new Usuario("sf");
				fail("El usuario no se puede crear con email en nulo. Algo no se validó!");
				
			}catch(RuntimeException ex) {
				System.out.println("Ok. El test está correcto!");
				// Ok. Es lo esperado... los usuarios no se puede crear con emails con 2 caractesrs
			}	
	}
}
