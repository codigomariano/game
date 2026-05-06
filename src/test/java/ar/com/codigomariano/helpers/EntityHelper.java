package ar.com.codigomariano.helpers;

import java.util.Random;

import ar.com.codigomariano.domain.Juego;
import ar.com.codigomariano.domain.Usuario;
import ar.com.codigomariano.domain.preguntas.PreguntaBinaria;
import ar.com.codigomariano.domain.preguntas.PreguntaMultiple;
import ar.com.codigomariano.enums.Categoria;
import ar.com.codigomariano.enums.OpcionBinaria;

public class EntityHelper {
	public static final Random random = new Random(System.currentTimeMillis());
	public static final String VALID_EMAIL = "mariano@codigomariano.com";
	public static final String RESPUESTA_RANDOM = "respuesta random";
	
	
	public static final Usuario createValidUser() {
		return new Usuario(VALID_EMAIL);
	}
	
	public static final Juego createEmptyJuego() {
		return new Juego();
	}
	
	public static final Juego createJuegoWithBinaryQuestions() {
		int cant = random.nextInt(1, 10);
		Juego juego = new Juego();
		
		for(int i = 0; i < cant; i++) {
			juego.agregarPregunta(createPreguntaBinaria());
		}
		
		return juego;
	}
	
	public static final Juego createJuegoWithMultipleQuestions() {
		int cant = random.nextInt(1, 10);
		Juego juego = new Juego();
		
		for(int i = 0; i < cant; i++) {
			juego.agregarPregunta(createPreguntaMultiple());
		}
		
		return juego;
	}
	
	public static final Juego createFullJuego() {
		int cant = random.nextInt(1, 15);
		Juego juego = new Juego();
		
		for(int i = 0; i < cant; i++) {
			if((i % 2) == 0) {
				juego.agregarPregunta(createPreguntaMultiple());				
			} else {
				juego.agregarPregunta(createPreguntaBinaria());
			}
		}
		
		return juego;
	}
	
	public static final PreguntaBinaria createPreguntaBinaria() {
		return new PreguntaBinaria("C001", "Na es el símbolo atómico del Mercurio", Categoria.CIENCIA, OpcionBinaria.F);
	}
	
	public static final PreguntaMultiple createPreguntaMultiple() {
		PreguntaMultiple multiple = new PreguntaMultiple("C001", "Na es el símbolo atómico del Mercurio", Categoria.CIENCIA);
		
		multiple.agregarRespuestaCorrecta(RESPUESTA_RANDOM + " " + random.nextLong());
		multiple.agregarRespuesta(RESPUESTA_RANDOM + " " + random.nextLong());
		multiple.agregarRespuesta(RESPUESTA_RANDOM + " " + random.nextLong());
		multiple.agregarRespuesta(RESPUESTA_RANDOM + " " + random.nextLong());
		
		return multiple;
	}
}
