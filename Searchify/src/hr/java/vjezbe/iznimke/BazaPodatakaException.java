package hr.java.vjezbe.iznimke;

public class BazaPodatakaException extends Exception {

	private static final long serialVersionUID = 6186263838409046177L;
	
	public BazaPodatakaException() {
		super("Neuspjesno spajanje na bazu podataka.");
	}
	
	public BazaPodatakaException(String message) {
		super(message);
	}
	
	public BazaPodatakaException(String message, Throwable cause) {
		super(message, cause);
	}
	
	public BazaPodatakaException(Throwable cause) {
		super(cause);
	}
}
