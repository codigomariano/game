package ar.com.codigomariano.enums;

public enum OpcionBinaria implements Opcion{
	V("Verdadero"), 
	F("Falso");
	
	private String texto;
	
	private OpcionBinaria(String texto) {
		this.texto = texto;
	}
	
	@Override
	public String toString() {
		return this.name() + ". " + this.texto;	
	}
}
