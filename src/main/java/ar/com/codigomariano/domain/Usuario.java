package ar.com.codigomariano.domain;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;

@Entity
@Table(name = "USUARIOS")
public class Usuario extends Persistible {
	private static final int EMAIL_MIN_CARACTERES = 15;
	private static final int EMAIL_MAX_CARACTERES = 75;
	
	@Column(name = "email")
	private String email;
	
	
	// Just for Hibernate 
	Usuario() {
		
	}
	
	public Usuario(String email) {
		setEmail(email);
	}
	
	public boolean tieneEmail(String email) {
		return this.email.equals(email);
	}
	
	
	@Override
	public String toString() {
		return "Usuario [ID="+getId()+" | EMAIL="+ this.email +"]";
	}
	
	private void setEmail(String email) {
		if(email == null || email.length() < EMAIL_MIN_CARACTERES || email.length() > EMAIL_MAX_CARACTERES) {
			throw new IllegalArgumentException("El mail del usuario debe tener entre "+EMAIL_MIN_CARACTERES+" y "+EMAIL_MAX_CARACTERES+" caracteres");
		}
		
		this.email = email;
	}
}
