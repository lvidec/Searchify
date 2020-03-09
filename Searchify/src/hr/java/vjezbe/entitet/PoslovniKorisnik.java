package hr.java.vjezbe.entitet;

/**
 * Predstavlja enititet poslovnog korisnika definiran nazivom i web adresom.
 * 
 * @author Leonardo
 *
 */
public class PoslovniKorisnik extends Korisnik {
	
	private String naziv; 
	private String web;

	/**
	 * Inicijalizira podatak o nazivu web adresi emailu i broju telefona.
	 * 
	 * @param naziv podatak o nazivu poslovnog korisnika.
	 * @param web podatak o web adresi poslovnog korisnika.
	 * @param email podatak o email adresi poslovnog korisnika.
	 * @param telefon podatak o broju telefona poslovnog korisnika.
	 */
	public PoslovniKorisnik(String naziv, String web, String email, String telefon, Long id) {
		super(email, telefon, id);
		this.naziv = naziv;
		this.web = web;
	}

	/**
	 * @return vraca podatke o poslovnom korisniku.
	 */
	@Override
	public String dohvatiKontakt() {
		return ("Naziv tvrtke: " + naziv + ", mail: " + super.getEmail() + ", tel: " + super.getTelefon() + ", web: " + web);
	}

	public String getNaziv() {
		return naziv;
	}

	public void setNaziv(String naziv) {
		this.naziv = naziv;
	}

	public String getWeb() {
		return web;
	}

	public void setWeb(String web) {
		this.web = web;
	}


	@Override
	public String toString() {
		return(naziv + ", " + super.getEmail() + ", " + super.getTelefon() + ", " + web);
	}
	
}
