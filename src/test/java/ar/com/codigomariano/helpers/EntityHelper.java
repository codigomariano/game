package ar.com.codigomariano.helpers;

import ar.com.codigomariano.domain.Usuario;
import ar.com.codigomariano.domain.preguntas.PreguntaBinaria;
import ar.com.codigomariano.enums.Categoria;
import ar.com.codigomariano.enums.Opcion;

public class EntityHelper {
	public static final String VALID_EMAIL = "mariano@codigomariano.com";
	
	
	
	public static final Usuario createValidUser() {
		return new Usuario(VALID_EMAIL);
	}
	
	public static final PreguntaBinaria createPreguntaBinaria() {
		return new PreguntaBinaria("C001", "Na es el símbolo atómico del Mercurio", Categoria.CIENCIA, Opcion.A);
	}
}
