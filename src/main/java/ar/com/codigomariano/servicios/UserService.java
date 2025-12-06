package ar.com.codigomariano.servicios;

import java.util.List;

import ar.com.codigomariano.domain.Usuario;
import ar.com.codigomariano.dtos.UsuarioDTO;

public interface UserService {

	public Usuario obtener(Long id);
	
	public Usuario obtener(String email);
	
	public void guardarUsuario(Usuario u);
	
	public boolean userExists(String email);
	
	public List<UsuarioDTO> listAll();
	
}
