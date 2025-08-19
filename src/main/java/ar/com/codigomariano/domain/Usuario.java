package ar.com.codigomariano.domain;

public class Usuario {
	private static final int EMAIL_MIN_CARACTERES = 15;
	private static final int EMAIL_MAX_CARACTERES = 75;
	private static int next_id = 1;
	private Integer id;
	private String email;
	
	
	public Usuario(String email) {
		this.id = next_id;
		setEmail(email);
		next_id++;
	}
	
	public boolean tieneEmail(String email) {
		return this.email.equals(email);
	}
	
	
	@Override
	public String toString() {
		return "Usuario [ID="+this.id+" | EMAIL="+ this.email +"]";
	}
	
	private void setEmail(String email) {
		if(email == null || email.length() < EMAIL_MIN_CARACTERES || email.length() > EMAIL_MAX_CARACTERES) {
			throw new IllegalArgumentException("El mail del usuario debe tener entre "+EMAIL_MIN_CARACTERES+" y "+EMAIL_MAX_CARACTERES+" caracteres");
		}
		
		this.email = email;
	}
}
