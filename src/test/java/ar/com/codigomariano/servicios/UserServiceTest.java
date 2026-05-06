package ar.com.codigomariano.servicios;

import static org.junit.jupiter.api.Assertions.fail;

import org.junit.jupiter.api.Test;

import ar.com.codigomariano.domain.Usuario;
import ar.com.codigomariano.exceptions.EmailAlreadyExistsException;
import ar.com.codigomariano.helpers.EntityHelper;


public class UserServiceTest extends BaseServiceTest<UserService>{
	private static final String EXITING_EMAIL = "existing@email.com";
	
	@Test
	public void testSaveUsuarioSuccess() {
		Usuario usuario = EntityHelper.createValidUser();
		
		service().guardarUsuario(usuario);
	}
	
	
	@Test
	public void testSaveUsuarioWithDuplicateEmail() {
		Usuario user = new Usuario(EXITING_EMAIL);
		
		try {
			
			service().guardarUsuario(user);
			fail("El usuario no debería guardarse por tener un email repetido");
			
		}catch(EmailAlreadyExistsException e) {
			// Esto es lo esperado
		}
		
	}
}
