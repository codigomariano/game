package ar.com.codigomariano.exceptions;

public class EmailNotFoundException extends Exception {
	private static final long serialVersionUID = 6865668440207910722L;

	
	public EmailNotFoundException(String email) {
		super("El mail solicitado ["+email+"] no existe");
	}
}
