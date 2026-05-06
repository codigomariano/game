package ar.com.codigomariano.servicios;

import org.springframework.beans.factory.annotation.Autowired;

import ar.com.codigomariano.context.test.BaseContextTest;

public abstract class BaseServiceTest<S> extends BaseContextTest{
	@Autowired
	private S service;
	
	
	protected S service() {
		return this.service;
	}
}
