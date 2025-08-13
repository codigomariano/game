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
	
	public boolean tieneEmail(String email) {
		return this.email.equals(email);
	}
	
	
	@Override
	public String toString() {
		return "Usuario [ID="+this.id+" | EMAIL="+ this.email +"]";
	}
}
