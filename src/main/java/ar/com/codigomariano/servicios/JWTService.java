package ar.com.codigomariano.servicios;

import org.springframework.security.core.Authentication;

import ar.com.codigomariano.domain.Usuario;

public interface JWTService {
	public String PREFIX_TOKEN = "Bearer";
	
	public String buildToken(Usuario usuario);
		
	public boolean isValidToken(String token);
	
	Authentication buildAuthentication(String token);

}
