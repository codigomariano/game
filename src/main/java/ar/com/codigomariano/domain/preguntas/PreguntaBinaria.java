package ar.com.codigomariano.domain.preguntas;

import ar.com.codigomariano.domain.Juego;
import ar.com.codigomariano.enums.Categoria;
import ar.com.codigomariano.enums.OpcionBinaria;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.Table;

@Entity
@Table(name = "PREGUNTAS_BINARIAS")
public class PreguntaBinaria extends Pregunta {
	@Column(name = "opcion_correcta")
	@Enumerated(EnumType.ORDINAL)
	private OpcionBinaria correcta;
	
	
	// Just for Hibernate
	protected PreguntaBinaria() {
		super(); 
	}
	
	
	public PreguntaBinaria(String cod, String text, Categoria categoria, OpcionBinaria correcta) {
		this(cod, text, categoria, DEFAULT_PUNTOS, correcta);
	}
	
	public PreguntaBinaria(String cod, String text, Categoria categoria, int puntos, OpcionBinaria correcta) {
		super(cod, text, categoria, puntos);
		setCorrecta(correcta);
	}
	
	@Override
	protected void mostrarOpciones() {
		for (OpcionBinaria opcion : OpcionBinaria.values()) {
			System.out.println(opcion);
		}
	}


	private void setCorrecta(OpcionBinaria correcta) {
		if(correcta == null) throw new IllegalArgumentException(ERR_OPCION_CORRECTA);
		this.correcta = correcta;
	}
}
