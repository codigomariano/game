package ar.com.codigomariano.domain;

import java.util.Date;

import ar.com.codigomariano.domain.preguntas.Pregunta;
import ar.com.codigomariano.enums.Categoria;

public class Partida {
	private final int CANT_PREGUNTAS = 10;
	private Usuario jugador;
	private Date fechaPartida;
	private Pregunta[][] preguntas;
	
	
	public Partida(Usuario jugador) {
		this.jugador = jugador;
		this.fechaPartida = new Date();
		this.preguntas = new Pregunta[Categoria.values().length][CANT_PREGUNTAS];
	}
	
	
	public void iniciar() {
		System.out.println("Se inició una partida para el jugador "+this.jugador+" a las "+this.fechaPartida);
	}
}
