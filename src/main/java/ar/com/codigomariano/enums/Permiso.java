package ar.com.codigomariano.enums;

public enum Permiso {
	ADMINISTRADOR,
	JUGADOR;
	
	public String securityName() {
		return "ROLE_" + name();
	}
}
