package hr.java.vjezbe.entitet;

import java.util.ArrayList;
import java.util.List;

/**
 * Prestavlja entitet koji je definiran nazivom te poljem artikala.
 * 
 * @author Leonardo
 *
 */
public class Kategorija<T extends Artikl> extends Entitet {
	
	private String naziv;
	private List<T> artikli = new ArrayList<>();

	/**
	 * Inicijalizira podatak o nazivu te polju artikla.
	 * 
	 * @param naziv podatak o nazivu kategorije.	 
	 * @param artikli podatak o polju artikla.	 
	*/
	public Kategorija(String naziv, List<T> artikli, Long id) {
		super(id);
		this.naziv = naziv;
		this.artikli = artikli;
	}
	

//	@Override
//	public int hashCode() {
//		final int prime = 31;
//		int result = 1;
//		result = prime * result + ((naziv == null) ? 0 : naziv.hashCode());
//		return result;
//	}
//
//	@Override
//	public boolean equals(Object obj) {
//		if (this == obj)
//			return true;
//		if (obj == null)
//			return false;
//		if (getClass() != obj.getClass())
//			return false;
//		Kategorija other = (Kategorija) obj;
//		if (naziv == null) {
//			if (other.naziv != null)
//				return false;
//		} else if (!naziv.equals(other.naziv))
//			return false;
//		return true;
//	}
	
	
	public void dodajArtikl(T artikl){
		this.artikli.add(artikl);
	}
	
	public T dohvatiArtikl(int index) {
		return this.artikli.get(index);
	}
	
	public List<T> getArtikli() {
		return this.artikli;
	}
	
	
	public String getNaziv() {
		return naziv;
	}
	public void setNaziv(String naziv) {
		this.naziv = naziv;
	}
//	public List<T> getartikli() {
//		return artikli;
//	}
//	public void setartikli(List<T> artikli) {
//		this.artikli = artikli;
//	}
}



