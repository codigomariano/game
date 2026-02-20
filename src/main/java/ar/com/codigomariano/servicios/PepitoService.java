package ar.com.codigomariano.servicios;

import org.springframework.security.core.Authentication;

import ar.com.codigomariano.domain.Usuario;

public class PepitoService implements JWTService{

	@Override
	public String buildToken(Usuario usuario) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean isValidToken(String token) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public Authentication buildAuthentication(String token) {
		// TODO Auto-generated method stub
		return null;
	}

}
