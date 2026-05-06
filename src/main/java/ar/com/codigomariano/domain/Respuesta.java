package ar.com.codigomariano.domain;

import ar.com.codigomariano.enums.OpcionMultiple;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;

@Entity
@Table(name = "RESPUESTAS")
public class Respuesta extends Persistible {
	protected static final String ERR_TEXTO = "El texto de la respuesta no puede ser nulo";

	@Column(name = "TEXTO")
	private String texto;
	
	@Column(name = "CORRECTA")
	private Boolean correcta;
	
	
	// Just for Hibernate
	protected Respuesta() {
		super();
	}
	
	public Respuesta(String texto) {
		this(texto, Boolean.FALSE);
	}
	
	public Respuesta(String texto, Boolean esCorrecta) {
		setTexto(texto);
		this.correcta = esCorrecta;
	}

	public void mostrarRespuesta(OpcionMultiple opcion) {
		System.out.println(opcion + ". " + this.texto);
	}
	
	private void setTexto(String texto) {
		if(texto == null || texto.isBlank()) throw new IllegalArgumentException(ERR_TEXTO);
		this.texto = texto;
	}
}
