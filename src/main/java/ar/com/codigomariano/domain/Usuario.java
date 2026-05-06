package ar.com.codigomariano.domain;

import java.io.UncheckedIOException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;

import ar.com.codigomariano.enums.Permiso;
import jakarta.persistence.CollectionTable;
import jakarta.persistence.Column;
import jakarta.persistence.ElementCollection;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.Table;

@Entity
@Table(name = "USUARIOS")
public class Usuario extends Persistible {
	private static final int EMAIL_MIN_CARACTERES = 15;
	private static final int EMAIL_MAX_CARACTERES = 75;
	
	@Column(name = "email")
	private String email;
	
	@Enumerated(EnumType.ORDINAL)
	@ElementCollection(targetClass = Permiso.class)
	@CollectionTable(name = "PERMISOS_USUARIOS", joinColumns = @JoinColumn(name = "USUARIO_ID"))
	@Column(name = "PERMISO_ID")
	private List<Permiso> permisos;
	
	
	// Just for Hibernate 
	Usuario() {
		
	}
	
	public Usuario(String email) {
		setEmail(email);
		this.permisos = new ArrayList<Permiso>();
		this.permisos.add(Permiso.JUGADOR);
	}
	
	public boolean tieneEmail(String email) {
		return this.email.equals(email);
	}
	
	public void convertirEnAdministrador() {
		this.permisos.add(Permiso.ADMINISTRADOR);
	}
	
	public List<GrantedAuthority> collectAuthorities() {
		List<GrantedAuthority> credentials = new ArrayList<GrantedAuthority>();
		
		for (Permiso permiso : this.permisos) {
			credentials.add(new SimpleGrantedAuthority(permiso.securityName()));
		}
		
		return credentials;
	}
	
	public String getEmail() {
		return email;
	}

	@Override
	public String toString() {
		return "Usuario [ID="+getId()+" | EMAIL="+ this.email +"]";
	}
	
	public void setEmail(String email) {
		if(email == null || email.isBlank() || email.length() < EMAIL_MIN_CARACTERES || email.length() > EMAIL_MAX_CARACTERES) {
			throw new RuntimeException("El mail del usuario debe tener entre "+EMAIL_MIN_CARACTERES+" y "+EMAIL_MAX_CARACTERES+" caracteres");
		}
		
		this.email = email;
	}
}
