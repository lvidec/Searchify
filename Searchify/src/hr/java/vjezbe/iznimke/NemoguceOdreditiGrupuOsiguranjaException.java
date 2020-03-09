package hr.java.vjezbe.iznimke;


public class NemoguceOdreditiGrupuOsiguranjaException extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = -2291535264076831445L;
	
	
	public NemoguceOdreditiGrupuOsiguranjaException() {
		super("Previše kw, ne mogu odrediti grupu osiguranja.");
	}
	
	public NemoguceOdreditiGrupuOsiguranjaException(String message) {
		super(message);
	}
	
	public NemoguceOdreditiGrupuOsiguranjaException(String message, Throwable cause) {
		super(message, cause);
	}
	
	public NemoguceOdreditiGrupuOsiguranjaException(Throwable cause) {
		super(cause);
	}

}
