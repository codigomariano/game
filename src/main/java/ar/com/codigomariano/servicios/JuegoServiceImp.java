package ar.com.codigomariano.servicios;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ar.com.codigomariano.domain.Juego;
import ar.com.codigomariano.repositorios.JuegoRepository;

@Service
public class JuegoServiceImp implements JuegoService {
	@Autowired
	private JuegoRepository repository;

	
	@Override
	public void save(Juego juego) {
		this.repository.save(juego);
	}
}
