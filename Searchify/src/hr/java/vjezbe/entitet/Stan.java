package hr.java.vjezbe.entitet;

import java.math.BigDecimal;

import hr.java.vjezbe.iznimke.CijenaJePreniskaException;

/**
 * Predstavlja entitet stana koji je definiran kvadraturom.
 * 
 * @author Leonardo
 *
 */
public class Stan extends Artikl implements Nekretnina{
	Integer kvadratura = 0;

	/**
	 * Inicijalizira podatak o naslovu, opisu, cijeni i kvadraturi.
	 * 
	 * @param naslov podatak o naslovu stana.
	 * @param opis podatak o opisu stana.
	 * @param cijena podatak o cijeni stana.
	 * @param kvadratura podatak o kvadraturi stana.
	 */
	public Stan(String naslov, String opis, BigDecimal cijena, Integer kvadratura, Stanje stanje, Long id) {
		super(naslov, opis, cijena, stanje, id);
		this.kvadratura = kvadratura;
	}

	public Integer getKvadratura() {
		return kvadratura;
	}

	public void setKvadratura(Integer kvadratura) {
		this.kvadratura = kvadratura;
	}

	/**
	 * @return vraca podatke o stanu.
	 * 
	 * @throws CijenaJePreniskaException provjerava da li je cijena bez poraza veca od 5000kn.
	 */
	@Override 
	public String tekstOglasa(){
		
		BigDecimal izracunatPorez = new BigDecimal("0");
		String izracunatPorezString = new String();
		
		try {
			izracunatPorez = izracunajPorez(super.getCijena());
			izracunatPorezString = izracunatPorez.toString();
		}catch(CijenaJePreniskaException ex) {
			logger.info("Pogreska prilikom odredivanja iznosa poreza!");
			izracunatPorezString = ex.getMessage();
		}
		
		return "Naslov nekretnine: " + super.getNaslov()
		   + "\nOpis nekretnine: " + super.getOpis() 
		   + "\nKvadratura nekretnine: " + kvadratura 
		   + "\nStanje nekretnine: " + super.getStanje()
		   + "\nPorez na nekretnine: " + izracunatPorezString
		   + "\nCijena nekretnine: " + super.getCijena();
	
		
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + kvadratura;
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
		Stan other = (Stan) obj;
		if (kvadratura != other.kvadratura)
			return false;
		return true;
	}

	@Override
	public String toString() {
		return super.getNaslov()
		   + ", " + super.getOpis() 
		   + ", " + kvadratura 
		   + ", " + super.getStanje()
		   + ", " + super.getCijena();
	}
	
	

}
