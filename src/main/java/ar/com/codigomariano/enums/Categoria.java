package ar.com.codigomariano.enums;

public enum Categoria {
	GEOGRAFIA("geography"),
	ARTE_Y_LITERATURA("art"),
	ENTRETENIMIENTO("entertainment"),
	CIENCIA("nature"),
	DEPORTES("leisure"),
	HISTORIA("history");

	private String key;
	
	
	private Categoria(String clave) {
		this.key = clave;
	}
	
	public String key() {
		return this.key;
	}
}
