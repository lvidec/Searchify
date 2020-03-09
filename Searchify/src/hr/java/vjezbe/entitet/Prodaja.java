package hr.java.vjezbe.entitet;

import java.time.LocalDate;

/**
 * Predstavlja entitet Prodaja koji je definiran artiklom korisnikom te datumom objave.
 * 
 * @author Leonardo
 *
 */
public class Prodaja extends Entitet {
	
	Artikl artikl;
	Korisnik korisnik;
	LocalDate datumObjave;

		
	/**
	 * Inicijalizira podatak o artiklu korisniku te datumu objave.
	 * 
	 * @param artikl podatak o artiklu prodaje.
	 * @param korisnik podatak o korisniku prodaje.
	 * @param datumObjave podatak o datumu prodaje.
	 */
	public Prodaja(Artikl artikl, Korisnik korisnik, LocalDate datumObjave, Long id) {
		super(id);
		this.artikl = artikl;
		this.korisnik = korisnik;
		this.datumObjave = datumObjave;
	}
	
	public Artikl getArtikl() {
		return artikl;
	}
	public void setArtikl(Artikl artikl) {
		this.artikl = artikl;
	}
	public Korisnik getKorisnik() {
		return korisnik;
	}
	public void setKorisnik(Korisnik korisnik) {
		this.korisnik = korisnik;
	}
	public LocalDate getDatumObjave() {
		return datumObjave;
	}
	public void setDatumObjave(LocalDate datumObjave) {
		this.datumObjave = datumObjave;
	}
	
	
	@Override
	public String toString() {
		return "Oglas: " + artikl.toString() + "\nProdavatelj: " + korisnik.toString() + "\nDatum objave: " + datumObjave.toString();
	}
	
}
