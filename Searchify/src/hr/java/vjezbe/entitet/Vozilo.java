 package hr.java.vjezbe.entitet;

import java.math.BigDecimal;

import hr.java.vjezbe.iznimke.NemoguceOdreditiGrupuOsiguranjaException;

/**
 * Predstavlja entitet vozila.
 * 
 * @author Leonardo
 *
 */
public interface Vozilo {

	/**
	 * @param konjskaSnaga podatak o konjskim snagama.
	 * 
	 * @return vraca jacinu kilowata iz konjskih snaga.
	 */
	default public BigDecimal izracunajKw(BigDecimal konjskaSnaga) {
		BigDecimal koeficijent = new BigDecimal("0.73549875");
		BigDecimal kw = konjskaSnaga.multiply(koeficijent);
		return kw;
	}
	
	/**
	 * @return vraca cijenu osiguranja.
	 * 
	 * @throws NemoguceOdreditiGrupuOsiguranjaException provjerava da li je moguce odraditi grupu osiguranja.
	 */
	default public BigDecimal izracunajCijenuOsiguranja() throws NemoguceOdreditiGrupuOsiguranjaException {
			switch(izracunajGrupuOsiguranja().intValue()) {
			case 1:
				return new BigDecimal("1000");
			case 2:
				return new BigDecimal("3000");
			case 3:
				return new BigDecimal("5000");
			case 4: 
				return new BigDecimal("7000");
			case 5: 
				throw new NemoguceOdreditiGrupuOsiguranjaException();
			}

			return new BigDecimal("0");

	}
	
	/**
	 * @return vraca grupu osiguranja.
	 * 
	 * @throws NemoguceOdreditiGrupuOsiguranjaException provjerava da li je moguce odraditi grupu osiguranja.
	 */
	public BigDecimal izracunajGrupuOsiguranja() throws NemoguceOdreditiGrupuOsiguranjaException;
	
}
