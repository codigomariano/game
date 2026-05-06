package ar.com.codigomariano.exceptions;

public class EmailAlreadyExistsException extends RuntimeException {
	private static final long serialVersionUID = -8651811039580154456L;

	
	public EmailAlreadyExistsException(String email) {
		super("El email " + email + " ya se encuentra registrado");
	}
}
