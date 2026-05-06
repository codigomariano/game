package ar.com.codigomariano.repositories;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import ar.com.codigomariano.context.test.BaseContextTest;
import ar.com.codigomariano.domain.Usuario;
import ar.com.codigomariano.repositorios.UserRepository;

public class ClienteRepositoryTest extends BaseContextTest{
	@Autowired
	private UserRepository repository;
	
	@Test
	public void saveCliente() {
		Usuario usuario = new Usuario("blabl@hotmail.com");
		this.repository.save(usuario);
	}
}
