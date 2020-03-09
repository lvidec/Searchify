package hr.java.vjezbe.entitet;

/**
 * Predstavlja enititet privatnog korisnika definiran imenom i prezimenom.
 * 
 * @author Leonardo
 *
 */
public class PrivatniKorisnik extends Korisnik {

	private String ime;
	private String prezime;

	/**
	 * Inicijalizira podatak o imenu, prezimenu, emailu i broju telefona.
	 * 
	 * @param ime podatak o imenu privatnog korisnika.
	 * @param prezime podatak o prezimenu privatnog korisnika.
	 * @param email podatak o email adresi privatnog korisnika.
	 * @param telefon podatak o broju telefona privatnog korisnika.
	 */
	public PrivatniKorisnik(String ime, String prezime, String email, String telefon, Long id) {
		super(email, telefon, id);
		this.ime = ime;
		this.prezime = prezime;
	}


	/**
	 * @return vraca podatke o privatnom korisniku.
	 */
	@Override
	public String dohvatiKontakt() {
		return ("Osobni podaci prodavatelja: " + ime + " " + prezime + ", mail:" + super.getEmail() + ", tel:" + super.getTelefon());
	}

	public String getIme() {
		return ime;
	}

	public void setIme(String ime) {
		this.ime = ime;
	}

	public String getPrezime() {
		return prezime;
	}

	public void setPrezime(String prezime) {
		this.prezime = prezime;
	}

	@Override
	public String toString() {
		return(ime + ", " + prezime + ", " + super.getEmail() + ", " + super.getTelefon());
	}
	
	
}
