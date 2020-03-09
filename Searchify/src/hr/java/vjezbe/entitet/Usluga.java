package hr.java.vjezbe.entitet;

import java.math.BigDecimal;

/**
 * Predstavlja entitet usluga.
 * 
 * @author Leonardo
 *
 */
public class Usluga extends Artikl {
	
	/**
	 * Inicijalizira podatak o naslovu, opisu i cijeni usluge.
	 * 
	 * @param naslov podatak o naslovu usluge.				
	 * @param opis podatak o opisu usluge.
	 * @param cijena podatak o cijeni usluge.
	 */
	public Usluga(String naslov, String opis, BigDecimal cijena, Stanje stanje, Long id) {
		super(naslov, opis, cijena, stanje, id);
	}

	/**
	 * 
	 * @return vraca podatke o usluzi.
	 */
	@Override
	public String tekstOglasa() {
		return "Naslov usluge: " + super.getNaslov() + "\n"
			+ "Opis usluge: " + super.getOpis() + "\n"
			+ "Cijena usluge: " + super.getCijena();
	}

	@Override
	public int hashCode() {
		return super.hashCode();
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (!super.equals(obj))
			return false;
		if (getClass() != obj.getClass())
			return false;
		return true;
	}
	
	@Override
	public String toString() {
		return super.getNaslov() + 
			", " + super.getOpis() +
			", " + super.getCijena();	
		}
	
}
