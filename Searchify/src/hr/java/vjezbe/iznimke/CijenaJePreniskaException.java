package hr.java.vjezbe.iznimke;

/**
 * Predstavlja entitet CijenaJePreniskaException.
 * 
 * @author Leonardo
 *
 */
public class CijenaJePreniskaException extends RuntimeException {	
	
	private static final long serialVersionUID = 5894707001144404924L;
	
	public CijenaJePreniskaException() {
		super("Cijena ne smije biti manja od 10000kn");
	}
	
	public CijenaJePreniskaException(String message) {
		super(message);
	}
	
	public CijenaJePreniskaException(String message, Throwable cause) {
		super(message, cause);
	}
	
	public CijenaJePreniskaException(Throwable cause) {
		super(cause);
	}

}
