package hr.java.vjezbe.entitet;

import java.math.BigDecimal;

import hr.java.vjezbe.iznimke.CijenaJePreniskaException;
import hr.java.vjezbe.iznimke.NemoguceOdreditiGrupuOsiguranjaException;

/**
 * Prestavlja entitet koji je definiran naslovom, opisom i cijenom.
 * 
 * @author Leonardo
 *
 */
public abstract class Artikl extends Entitet{
	
	private String naslov;
	private String opis;
	private BigDecimal cijena;
	private Stanje stanje;
	
	/**
	 * Inicijalizira podatak o naslovu, opisu te cijeni.
	 * 
	 * @param naslov podatak o naslovu artikla.
	 * @param opis podatak o opisu artikla
	 * @param cijena podatak o cijeni artikla
	 * @param stanje podatak o stanju artikla
	 */
	
	public Artikl(String naslov, String opis, BigDecimal cijena, Stanje stanje, Long id) {
		super(id);
		this.naslov = naslov;
		this.opis = opis;
		this.cijena = cijena;
		this.stanje = stanje;
	}
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((cijena == null) ? 0 : cijena.hashCode());
		result = prime * result + ((naslov == null) ? 0 : naslov.hashCode());
		result = prime * result + ((opis == null) ? 0 : opis.hashCode());
		result = prime * result + ((stanje == null) ? 0 : stanje.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Artikl other = (Artikl) obj;
		if (cijena == null) {
			if (other.cijena != null)
				return false;
		} else if (!cijena.equals(other.cijena))
			return false;
		if (naslov == null) {
			if (other.naslov != null)
				return false;
		} else if (!naslov.equals(other.naslov))
			return false;
		if (opis == null) {
			if (other.opis != null)
				return false;
		} else if (!opis.equals(other.opis))
			return false;
		if (stanje != other.stanje)
			return false;
		return true;
	}

	/**
	 *
	 * 
	 * @return Vraca podatke o nasljedjenim klasama. 
	 * 
	 * @throws NemoguceOdreditiGrupuOsiguranjaException provjerava da li je moguce odraditi grupu osiguranja.
	 * @throws CijenaJePreniskaException provjerava da li je cijena bez poraza veca od 5000kn.
	 */
	public abstract String tekstOglasa();
	


	public String getNaslov() {
		return naslov;
	}

	public void setNaslov(String naslov) {
		this.naslov = naslov;
	}

	public String getOpis() {
		return opis;
	}

	public void setOpis(String opis) {
		this.opis = opis;
	}

	public BigDecimal getCijena() {
		return cijena;
	}

	public void setCijena(BigDecimal cijena) {
		this.cijena = cijena;
	}

	public Stanje getStanje() {
		return stanje;
	}

	public void setStanje(Stanje stanje) {
		this.stanje = stanje;
	}
	
	
	
	
}

	