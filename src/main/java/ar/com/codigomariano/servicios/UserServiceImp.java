package ar.com.codigomariano.servicios;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ar.com.codigomariano.domain.Usuario;
import ar.com.codigomariano.dtos.UsuarioDTO;
import ar.com.codigomariano.repositorios.UserRepository;

@Service
public class UserServiceImp implements UserService{
	@Autowired
	private UserRepository repository;
	
	private ModelMapper mapper = new ModelMapper();
	
	
	public Usuario obtener(Long id) {
		Optional<Usuario> user = this.repository.findById(id);
		return user.get();
	}
	
	public void guardarUsuario(Usuario u) {
		this.repository.save(u);
	}

	@Override
	public boolean userExists(String email) {
		boolean exists = false;
		
		if(email != null) {
			List<Usuario> usuarios = this.repository.findByEmail(email);
			exists = ! usuarios.isEmpty();
		}
		
		return exists;
	}

	@Override
	public List<UsuarioDTO> listAll() {
		List<Usuario> usuario = this.repository.findAll();
		List<UsuarioDTO> usuariosDTO = new ArrayList<UsuarioDTO>();
		
		for (Usuario user : usuario) {
			usuariosDTO.add(mapper.map(user, UsuarioDTO.class));
		}
		
		return usuariosDTO;
	}
}
