package hr.java.vjezbe.entitet;

import java.math.BigDecimal;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import hr.java.vjezbe.iznimke.NemoguceOdreditiGrupuOsiguranjaException;

/**
 * Prestavlja entitet koji je definiran snagom te nasljedjenim varijablama od klase Artikl.
 * 
 * @author Leonardo
 *
 */
public class Automobil extends Artikl implements Vozilo {
	
	private static final Logger logger = LoggerFactory.getLogger(NemoguceOdreditiGrupuOsiguranjaException.class);

	private BigDecimal snagaKs = new BigDecimal("245");	
	
	/**
	 * Inicijalizira podatak o snazi te nasljedjenim varijablama od klase Artikl.
	 * 
	 * @param naslov podatak o naslovu Automobila.
	 * @param opis podatak o opisu Automobila.
	 * @param cijena podatak o cijeni Automobila.
	 * @param snagaKs podatak o snagi Automobila.
	 */
	public Automobil(String naslov, String opis, BigDecimal cijena, Stanje stanje, BigDecimal snagaKs, Long id) {
		super(naslov, opis, cijena, stanje, id);
		this.snagaKs = snagaKs;
	}

	/**
	 *
	 * 
	 * @return Vraca podatke koji nam pomazu u odredjivanju cijene osiguranja. 
	 * 
	 * @throws NemoguceOdreditiGrupuOsiguranjaException provjerava da li je moguce odraditi grupu osiguranja.
	 */
	@Override
	public BigDecimal izracunajGrupuOsiguranja() throws NemoguceOdreditiGrupuOsiguranjaException {
			if( snagaKs.compareTo(new BigDecimal("80")) < 0) {
				return new BigDecimal("1");
			}
			else if( snagaKs.compareTo(new BigDecimal("140")) < 0) {
				return new BigDecimal("2");
			}
			else if( snagaKs.compareTo(new BigDecimal("180")) < 0) {
				return new BigDecimal("3");
			}
			else if( snagaKs.compareTo(new BigDecimal("200")) < 0) {
				return new BigDecimal("4");
			}
			else {
				throw new NemoguceOdreditiGrupuOsiguranjaException();
			}
	}
 
	/**
	 *
	 * 
	 * @return Vraca podatke o Automobilu. 
	 * 
	 * @throws NemoguceOdreditiGrupuOsiguranjaException provjerava da li je moguce odraditi grupu osiguranja.
	 */
	@Override
	public String tekstOglasa(){
		
		BigDecimal cijenaOsiguranja = new BigDecimal("0");
		String cijenaOsiguranjaString = new String();
		
		try {
			cijenaOsiguranja = izracunajCijenuOsiguranja();
			cijenaOsiguranjaString = cijenaOsiguranja.toString();
		}catch(NemoguceOdreditiGrupuOsiguranjaException ex) {
			logger.info("Pogreska prilikom odredjivanja cijene osiguranja.");
			cijenaOsiguranjaString = ex.getMessage();
		}
		
		return "Naslov automobila: " + super.getNaslov()
			+ "\nOpis automobila: " + super.getOpis()
			+ "\nSnaga automobila: " + snagaKs 
		    + "\nStanje automobila: " + super.getStanje()
			+ "\nIzracun osiguranja automobila: " + cijenaOsiguranjaString 
			+ "\nCijena automobila: " + super.getCijena();
		
	}
	

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + ((snagaKs == null) ? 0 : snagaKs.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (!super.equals(obj))
			return false;
		if (getClass() != obj.getClass())
			return false;
		Automobil other = (Automobil) obj;
		if (snagaKs == null) {
			if (other.snagaKs != null)
				return false;
		} else if (!snagaKs.equals(other.snagaKs))
			return false;
		return true;
	}

	public BigDecimal getSnagaKs() {
		return snagaKs;
	}

	public void setSnagaKs(BigDecimal snagaKs) {
		this.snagaKs = snagaKs;
	}
	
	
	@Override
	public String toString() {
		return super.getNaslov()
		+ ", " + super.getOpis()
		+ ", " + snagaKs 
	    + ", " + super.getStanje()
		+ ", " + super.getCijena();
	}

	
}
