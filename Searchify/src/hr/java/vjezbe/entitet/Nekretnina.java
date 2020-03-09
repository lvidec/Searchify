package hr.java.vjezbe.entitet;

import java.math.BigDecimal;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import hr.java.vjezbe.iznimke.CijenaJePreniskaException;

/**
 * Predtavlja entitet Nekretnine koja je definirana cijenom poreza.
 * 
 * @author Leonardo
 *
 */
public interface Nekretnina {
	
	static final Logger logger = LoggerFactory.getLogger(Nekretnina.class);

	/**
	 * 
	 * @param cijenaNekretnine podatak o cijeni nekretnine prije poreza.
	 * 
	 * @return vraca podatak o cijeni poreza.
	 */
	default public BigDecimal izracunajPorez(BigDecimal cijenaNekretnine) throws CijenaJePreniskaException{
		
		BigDecimal porez = new BigDecimal("0");
		
		porez = cijenaNekretnine.multiply(new BigDecimal("0.03"));
		if(cijenaNekretnine.compareTo(new BigDecimal("10000")) < 0) {
			throw new CijenaJePreniskaException();
		}
	
		

		return porez;
		
	}
}
