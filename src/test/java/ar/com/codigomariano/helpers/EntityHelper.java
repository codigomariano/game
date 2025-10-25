package ar.com.codigomariano.helpers;

import ar.com.codigomariano.domain.Usuario;

public class EntityHelper {
	public static final String VALID_EMAIL = "mariano@codigomariano.com";
	
	
	
	public static final Usuario createValidUser() {
		return new Usuario(VALID_EMAIL);
	}
}
