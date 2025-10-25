package ar.com.codigomariano.repositorios;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import ar.com.codigomariano.domain.Usuario;

@Repository
public interface UserRepository extends JpaRepository<Usuario, Long>{

	List<Usuario> findByEmail(String email);
	
}
