package ar.com.codigomariano.domain;

import java.util.ArrayList;

import ar.com.codigomariano.domain.preguntas.Pregunta;
import ar.com.codigomariano.exceptions.EmailNotFoundException;

public class Juego {
	private ArrayList<Usuario> usuarios;
	private ArrayList<Pregunta> preguntas;
	
	
	public Juego() {
		this.usuarios = new ArrayList<Usuario>();
		this.preguntas = new ArrayList<Pregunta>();
	}
	
	
	public Partida iniciarPartida(String email) throws EmailNotFoundException {
		int posicion = localizarEmail(email);
		return new Partida(this.usuarios.get(posicion));
	}
	
	
	private int localizarEmail(String email) throws EmailNotFoundException {
		int index = 0;
		int pos = -1;
		
		while(index < this.usuarios.size() && pos == -1) {
			Usuario u = this.usuarios.get(index);
			if(u.tieneEmail(email)) {
				pos = index;
			}
			
			index++;
		}
		
		if(pos == -1) throw new EmailNotFoundException(email);
		
		return pos;
	}
	
	public void agregarUsuario(Usuario user) {
		this.usuarios.add(user);
	}
}
