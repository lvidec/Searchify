package hr.java.vjezbe.entitet;

/**
 * Predstavlja entitet koji je definiran emailom i brojem telefona. 
 * 
 * @author Leonardo
 *
 */
public abstract class Korisnik extends Entitet{
	
	private String email;
	private String telefon;
	
	/**
	 * Inicijalizira podatak o emailu i broju telefona.
	 * 
	 * @param email podatak o email adresi.
	 * @param telefon podatak o broju telefona.
	 */
	public Korisnik(String email, String telefon, Long id) {
		super(id);
		this.email = email;
		this.telefon = telefon;
	}
	
	/**
	 * @return vraca podatke o nasljedjenim klasama.
	 */
	public abstract String dohvatiKontakt();
	
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getTelefon() {
		return telefon;
	}
	public void setTelefon(String telefon) {
		this.telefon = telefon;
	}
	
	
}
