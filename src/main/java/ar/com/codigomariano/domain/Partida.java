package ar.com.codigomariano.domain;

import java.util.ArrayList;
import java.util.Date;

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
	
}
