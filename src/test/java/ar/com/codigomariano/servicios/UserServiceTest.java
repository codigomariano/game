package ar.com.codigomariano.servicios;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import ar.com.codigomariano.domain.Usuario;
import ar.com.codigomariano.helpers.EntityHelper;

@SpringBootTest
public class UserServiceTest {
	@Autowired
	private UserService servicio;
	
	@Test
	public void testSaveUsuarioSuccess() {
		Usuario usuario = EntityHelper.createValidUser();
		
		this.servicio.guardarUsuario(usuario);
	}
}
