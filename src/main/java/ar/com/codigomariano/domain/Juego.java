package ar.com.codigomariano.domain;

import java.util.ArrayList;

import ar.com.codigomariano.domain.preguntas.Pregunta;

public class Juego {
	private ArrayList<Usuario> usuarios;
	private ArrayList<Pregunta> preguntas;
	
	
	public Juego() {
		this.usuarios = new ArrayList<Usuario>();
		this.preguntas = new ArrayList<Pregunta>();
	}
	
	
	public boolean existeEmailRegistrado(String email) {
		return localizarEmail(email) != -1;
	}
	
	public Partida iniciarPartida(String email) {
		int posicion = localizarEmail(email);
		return new Partida(this.usuarios.get(posicion));
	}
	
	
	private int localizarEmail(String email) {
		int index = 0;
		int pos = -1;
		
		while(index < this.usuarios.size() && pos == -1) {
			Usuario u = this.usuarios.get(index);
			if(u.tieneEmail(email)) {
				pos = index;
			}
			
			index++;
		}
		
		return pos;
	}
	
	public void agregarUsuario(Usuario user) {
		this.usuarios.add(user);
	}
}
