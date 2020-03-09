package hr.java.vjezbe.entitet;

import java.util.ArrayList;
import java.util.List;

public class Datoteka {
	
	private String datoteka;
	private int brDat = 0;
	private List<String> listaLinijaDatoteke = new ArrayList<>();


	public Datoteka(String datoteka, int brDat, List<String> listaLinijaDatoteke) {
		super();
		this.datoteka = datoteka;
		this.brDat = brDat;
		this.listaLinijaDatoteke = listaLinijaDatoteke;
	}
	
	
	public String getDatoteka() {
		return datoteka;
	}
	public void setDatoteka(String datoteka) {
		this.datoteka = datoteka;
	}
	public int getBrDat() {
		return brDat;
	}
	public void setBrDat(int brDat) {
		this.brDat = brDat;
	}
	public List<String> getListaLinijaDatoteke() {
		return listaLinijaDatoteke;
	}
	public void setListaLinijaDatoteke(List<String> listaLinijaDatoteke) {
		this.listaLinijaDatoteke = listaLinijaDatoteke;
	}


}