package ar.com.codigomariano.repositories;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import ar.com.codigomariano.context.test.BaseContextTest;
import ar.com.codigomariano.domain.Juego;
import ar.com.codigomariano.helpers.EntityHelper;
import ar.com.codigomariano.repositorios.JuegoRepository;

public class JuegoRepositoryTest extends BaseContextTest {
	@Autowired
	private JuegoRepository repository;
	
	
	@Test
	public void saveJuegoWithoutPlayersOrQuestions() {
		Juego juego = EntityHelper.createEmptyJuego();
		this.repository.save(juego);
	}
	
	@Test
	public void saveJuegoWithBinaryQuestions() {
		Juego juego = EntityHelper.createJuegoWithBinaryQuestions();
		this.repository.save(juego);
	}
	
	@Test
	public void saveJuegoWithMultipleQuestions() {
		Juego juego = EntityHelper.createJuegoWithMultipleQuestions();
		this.repository.save(juego);
	}
	
	@Test
	public void saveJuegoWithFullQuestions() {
		Juego juego = EntityHelper.createFullJuego();
		this.repository.save(juego);
	}
}
