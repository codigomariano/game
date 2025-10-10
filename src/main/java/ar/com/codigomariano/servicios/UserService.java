package ar.com.codigomariano.servicios;

import java.util.List;

import ar.com.codigomariano.domain.Usuario;

public interface UserService {

	public Usuario obtener(Long id);
	
	public void guardarUsuario(Usuario u);
	
	public List<Usuario> listAll();
	
}
