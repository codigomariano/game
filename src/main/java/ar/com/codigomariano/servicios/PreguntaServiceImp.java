package ar.com.codigomariano.servicios;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ar.com.codigomariano.domain.preguntas.Pregunta;
import ar.com.codigomariano.repositorios.PreguntaRepository;

@Service
public class PreguntaServiceImp implements PreguntaService {
	@Autowired
	private PreguntaRepository repository;
	
	
	@Override
	public void guardarPregunta(Pregunta<?> pregunta) {
		this.repository.save(pregunta);
	}
}
