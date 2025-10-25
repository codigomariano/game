package ar.com.codigomariano.servicios;

import ar.com.codigomariano.domain.Usuario;

public interface UserService {

	public Usuario obtener(Long id);
	
	public void guardarUsuario(Usuario u);
	
	public boolean userExists(String email);
	
}
