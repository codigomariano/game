package ar.com.codigomariano.servicios;

import org.junit.jupiter.api.Test;

import ar.com.codigomariano.domain.Usuario;
import ar.com.codigomariano.helpers.EntityHelper;


public class UserServiceTest extends BaseServiceTest<UserService>{

	
	@Test
	public void testSaveUsuarioSuccess() {
		Usuario usuario = EntityHelper.createValidUser();
		
		service().guardarUsuario(usuario);
	}
}
