package ar.com.codigomariano.servicios;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;

@SpringBootTest
@ActiveProfiles(value = "test")
public abstract class BaseServiceTest<S> {
	@Autowired
	private S service;
	
	
	protected S service() {
		return this.service;
	}
}
