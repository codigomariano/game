package ar.com.codigomariano.servicios;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ar.com.codigomariano.domain.Usuario;
import ar.com.codigomariano.enums.Opcion;
import ar.com.codigomariano.repositorios.UserRepository;

@Service
public class UserServiceImp implements UserService{
	@Autowired
	private UserRepository repository;
	
	
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
			Optional<Usuario> result = this.repository.findByEmail(email);
			exists = result.isPresent();
		}
		
		return exists;

	@Override
	public List<Usuario> listAll() {
		return this.repository.findAll();
	}

	@Override
	public Usuario obtener(String email) {
		Optional<Usuario> user = this.repository.findByEmail(email);
		return (user.isPresent() ? user.get() : null);
	}
}
