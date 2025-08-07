package ar.com.codigomariano.domain;

public class Usuario {
	private static int next_id = 1;
	private Integer id;
	private String email;
	
	
	public Usuario(String email) {
		this.id = next_id;
		this.email= email;
		next_id++;
	}
}
