package hr.java.vjezbe.util;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import hr.java.vjezbe.entitet.Artikl;
import hr.java.vjezbe.entitet.Automobil;
import hr.java.vjezbe.entitet.Datoteka;
import hr.java.vjezbe.entitet.Kategorija;
import hr.java.vjezbe.entitet.Korisnik;
import hr.java.vjezbe.entitet.PoslovniKorisnik;
import hr.java.vjezbe.entitet.PrivatniKorisnik;
import hr.java.vjezbe.entitet.Stan;
import hr.java.vjezbe.entitet.Stanje;
import hr.java.vjezbe.entitet.Usluga;
import hr.java.vjezbe.iznimke.CijenaJePreniskaException;
import hr.java.vjezbe.iznimke.NemoguceOdreditiGrupuOsiguranjaException;


public class Datoteke {
	
	private static final Logger logger = LoggerFactory.getLogger(Datoteke.class);

	public static final String SERIALIZATION_FILE_NAME = "serijalizacija.dat";
	
	
	
	public static void main(String[] args) throws NemoguceOdreditiGrupuOsiguranjaException, CijenaJePreniskaException, FileNotFoundException, IOException, ClassNotFoundException {
				
		Scanner sc = new Scanner(System.in);
				
		List<String> listaLinijaDatotekeKorisnici = new ArrayList<>();
		int brDatKorisnici = 0;
		
		Datoteka datotekaKorisnici = ucitajDatoteku("Korisnici.txt", brDatKorisnici, listaLinijaDatotekeKorisnici);
		
//		System.out.print("Unesite broj korisnika koji želite unijeti: ");
//		int brojKorisnika = Integer.parseInt(listaLinijaDatotekeKorisnici.get(brDatKorisnici++));
		
		int brojKorisnika = Integer.parseInt(datotekaKorisnici.getListaLinijaDatoteke().get(brDatKorisnici++));
		
		brojKorisnika = ispravanUnosInt(brojKorisnika);
		
		List<Korisnik> korisnici = new ArrayList<>();
		List<Korisnik> listaSvihUnesenihKorisnika = new ArrayList<>();
		int redniBrojKorisnici = 0;
		
		
		korisnici = unosKorisnika(sc, redniBrojKorisnici, datotekaKorisnici.getListaLinijaDatoteke(), brDatKorisnici, listaSvihUnesenihKorisnika);
		
		
		List<String> listaLinijaDatotekeKategorije = new ArrayList<>();
		int brDatKategorije = 0;
		
		Datoteka datotekaKategorije = ucitajDatoteku("Kategorije.txt", brDatKategorije, listaLinijaDatotekeKategorije);
		
		
//		System.out.print("Unesite broj kategorija koji želite unijeti: ");
		int brojKategorija = Integer.parseInt(datotekaKategorije.getListaLinijaDatoteke().get(brDatKategorije++));
		brojKategorija = ispravanUnosInt(brojKategorija);

		List<Kategorija<Artikl>> kategorije = new ArrayList<>();
		
		Map<Kategorija<Artikl>, List<Artikl>> mapaArtikala = new HashMap<>();
		List<Kategorija<Artikl>> listaSvihUnesenihKategorija = new ArrayList<>();
		int redniBrojKategorije = 0;
		int brDatArtikli = 0;
	
		
		kategorije = unosKategorije(sc, redniBrojKategorije, mapaArtikala, datotekaKategorije.getListaLinijaDatoteke(), brDatKategorije, listaSvihUnesenihKategorija, brDatArtikli);	
		
		List<String> listaLinijaDatotekeProdaje = new ArrayList<>();
		int brDatProdaje = 0;
		
		Datoteka datotekaProdaje = ucitajDatoteku("Prodaje.txt", brDatProdaje, listaLinijaDatotekeProdaje);
		
//		System.out.print("Unesite broj artikala koji su aktivno na prodaju: ");
		int brojArtikalaProdaja = Integer.parseInt(datotekaProdaje.getListaLinijaDatoteke().get(brDatProdaje));
		brojArtikalaProdaja = ispravanUnosInt(brojArtikalaProdaja);
		
		
		List<Integer> odabraniKorisnik = new ArrayList<>();
		List<Integer> odabranaKategorija = new ArrayList<>();
		List<Integer> odabraniArtikl = new ArrayList<>();
		List<Integer> brDatProdajeZaDatume = new ArrayList<>();
		
		for(int i = 0; i < brojArtikalaProdaja; i++) {
			odabirKorisnika(sc, i, brojKorisnika, korisnici, odabraniKorisnik, ++brDatProdaje, datotekaProdaje.getListaLinijaDatoteke());
			
			odabirKategorije(sc, i, brojKategorija, kategorije, odabranaKategorija, ++brDatProdaje, datotekaProdaje.getListaLinijaDatoteke());
						
			odabirArtikla(sc, i, kategorije, odabraniArtikl, odabranaKategorija, ++brDatProdaje, datotekaProdaje.getListaLinijaDatoteke());
			
			brDatProdajeZaDatume.add(++brDatProdaje);
		}
		
		System.out.println("Trenutno su oglasi na prodaju: ");
		String LINIJA_CRTICA = "------------------------------------------------------------------------------------------------------------";
		System.out.println(LINIJA_CRTICA);
		
		
		for(int i = 0; i < brojArtikalaProdaja; i++) {
			
			List<Artikl> prodajaLista = kategorije.get(odabranaKategorija.get(i)-1).getArtikli();
						
			//System.out.println((kategorije.get(odabranaKategorija.get(i)-1).getAtrikli()[odabraniArtikl.get(i)-1]).tekstOglasa());
			System.out.println((prodajaLista.get(odabraniArtikl.get(i)-1)).tekstOglasa());
			
//			LocalDate today = LocalDate.now();
//			String formattedDate = today.format(DateTimeFormatter.ofPattern("dd.MM.yyyy")); 
//			System.out.println("Datum objave: " + formattedDate);
			
			System.out.println("Datum Objave: " + datotekaProdaje.getListaLinijaDatoteke().get(brDatProdajeZaDatume.get(i)));
		
			System.out.println(korisnici.get(odabraniKorisnik.get(i)-1).dohvatiKontakt());
			System.out.println(LINIJA_CRTICA);
		}
		
		
		System.out.println("Ispis po kategorijama: ");
		System.out.println(LINIJA_CRTICA);

		for(int i = 0; i < kategorije.size(); i++ ) {
			
			List<Artikl> ListaArtikala = kategorije.get(i).getArtikli();
			
			System.out.println("Kategorija: " + kategorije.get(i).getNaziv());
			System.out.println(LINIJA_CRTICA);

			ListaArtikala.stream().sorted(Comparator.comparing(Artikl::getNaslov).thenComparing(Artikl::getOpis)).forEach(x -> System.out.println(x.tekstOglasa() + "\n" + LINIJA_CRTICA)); 
		}
	}
	
	
	
	
	


//MMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMM
	
	
	
	

/////////											FUNCTIONS !!!
	
	
	public static List<Artikl> dohvatiArtikle() throws FileNotFoundException {
		String pathArtikli = "C:\\Java\\Pripreme za Labose\\Videc-8\\dat\\Artikli.txt";
		
		Scanner artikliScanner = new Scanner(new File(pathArtikli));
        List<Artikl> listaArtikala = new ArrayList<>();
        
        while(artikliScanner.hasNextLine()) {
            int vrstaArtikla = artikliScanner.nextInt();
            artikliScanner.nextLine();
           
            if (vrstaArtikla == 1) {
                Long id = artikliScanner.nextLong();
                artikliScanner.nextLine();
               
                String naslov = artikliScanner.nextLine();
 
                String opis = artikliScanner.nextLine();
 
                BigDecimal cijena = artikliScanner.nextBigDecimal();
 
                int odabirStanja = artikliScanner.nextInt();
//                artikliScanner.nextLine();
                Stanje stanje = Stanje.values()[odabirStanja - 1];
 
                listaArtikala.add(new Usluga(naslov, opis, cijena, stanje, id));
            } else if (vrstaArtikla == 2) {
                Long id = artikliScanner.nextLong();
                artikliScanner.nextLine();
               
                String naslov = artikliScanner.nextLine();
 
                String opis = artikliScanner.nextLine();
 
                BigDecimal snagaKs = artikliScanner.nextBigDecimal();
                artikliScanner.nextLine();
 
                BigDecimal cijena = artikliScanner.nextBigDecimal();
                artikliScanner.nextLine();
 
                int odabirStanja = artikliScanner.nextInt();
//                artikliScanner.nextLine();
                Stanje stanje = Stanje.values()[odabirStanja - 1];
 
                listaArtikala.add(new Automobil(naslov, opis, cijena, stanje, snagaKs, id));
            } else {
                Long id = artikliScanner.nextLong();
                artikliScanner.nextLine();
               
                String naslov = artikliScanner.nextLine();
 
                String opis = artikliScanner.nextLine();
 
                int kvadratura = artikliScanner.nextInt();
//                artikliScanner.nextLine();
 
                BigDecimal cijena = artikliScanner.nextBigDecimal();
                artikliScanner.nextLine();
 
                int odabirStanja = artikliScanner.nextInt();
                artikliScanner.nextLine();
                Stanje stanje = Stanje.values()[odabirStanja - 1];
               
                listaArtikala.add(new Stan(naslov, opis, cijena, kvadratura, stanje, id));
            }
        }
        artikliScanner.close();
        return listaArtikala;
    }
	
	
	public static List<Korisnik> dohvatiKorisnike() throws FileNotFoundException {
		String korisniciPath = "C:\\Java\\Pripreme za Labose\\Videc-8\\dat\\Korisnici.txt";
		Scanner scKorisnici = new Scanner(new File(korisniciPath));
		
		List<Korisnik> listaKorisnika = new ArrayList<>();
		
		int brojac = 0;
		@SuppressWarnings("unused")
		int brojKorisnika = 0;
		
		while(scKorisnici.hasNextLine()) {
			
			if( brojac == 0)
				brojKorisnika = scKorisnici.nextInt();
			int tipKorisnika = scKorisnici.nextInt();	
			scKorisnici.nextLine();
			String idString = scKorisnici.nextLine();
			
			brojac++;
			
			if( tipKorisnika == 1) {
				String ime = scKorisnici.nextLine();
				String prezime = scKorisnici.nextLine();
				String email = scKorisnici.nextLine();
				String telefon = scKorisnici.nextLine();
				
				Long id = Long.parseLong(idString);
				
				listaKorisnika.add(new PrivatniKorisnik(ime, prezime, email, telefon, id));
			}
			else if( tipKorisnika == 2) {
				String naziv = scKorisnici.nextLine();
				String web = scKorisnici.nextLine();
				String email = scKorisnici.nextLine();
				String telefon = scKorisnici.nextLine();
				
				Long id = Long.parseLong(idString);
				
				listaKorisnika.add(new PoslovniKorisnik(naziv, web, email, telefon, id));
			}
		}
		scKorisnici.close();
		return listaKorisnika;
	}
	




private static Datoteka ucitajDatoteku(String datoteka, int brDat, List<String> listaLinijaDatoteke) throws FileNotFoundException, IOException {

		String pathDatoteka = "C:\\Java\\Pripreme za Labose\\Videc-8\\dat\\".concat(datoteka);
		
		listaLinijaDatoteke = new ArrayList<>();
		
		try(BufferedReader bufferedReader = new BufferedReader(new FileReader(pathDatoteka))){
			String line;
			while((line = bufferedReader.readLine()) != null) {
				listaLinijaDatoteke.add(line);
			}
		}catch(IOException ex) {
			ex.printStackTrace();
		}
		
		System.out.println("Ucitavanje " + datoteka + "...");
		
		return new Datoteka(pathDatoteka, brDat, listaLinijaDatoteke);
}
	
	
	/**
	 * Provjerava je li unos ispravan za int vrijednosti.
	 * 
	 * @param scanner podatak o scanner objektu.
	 * @param broj podatak o broju koji je testiran.
	 * 
	 * @return vraca broj ako je prosao "test".
	 */
	private static int ispravanUnosInt(int broj) {
		boolean nastavi = true;
		do {	
			try {
				if(broj < 0) {
					throw new ArithmeticException();
				}
				else {
					nastavi = false;
				}
			}
			catch(ArithmeticException ex1) {
				System.out.println("Morate unijeti pozitivan broj...");
				logger.info("Pogreška prilikom unosa int tipa podatka");
			}
			catch(InputMismatchException ex2) {
				System.out.println("Morate unijeti brojacane vrijednosti...");
				logger.info("Pogreška prilikom unosa BigDecimal tipa podatka");
			}
		}while(nastavi);
		
		return broj; 
	}
	
	
	/**
	 * Provjerava je li unos ispravan za BigDecimal vrijednosti.
	 * 
	 * @param scanner podatak o scanner objektu.
	 * @param broj podatak o broju koji je testiran.
	 * 
	 * @return vraca broj ako je prosao "test".
	 */
	private static BigDecimal ispravanUnosBigDecimal(BigDecimal broj) {
		boolean nastavi = true;
		do {	
			try {
				if(broj.compareTo(new BigDecimal("0")) < 0) {
					throw new ArithmeticException();
				}
				else {
					nastavi = false;
				}
			}
			catch(ArithmeticException ex1) {
				System.out.println("Morate unijeti pozitivan broj...");
				logger.info("Nije unijet pozitivan broj.");
			}
			catch(InputMismatchException ex2) {
				System.out.println("Morate unijeti brojacane vrijednosti...");
				logger.info("Nisu unijete brojcane vrijednosti.");
			}
		}while(nastavi);
		
		return broj;
	}
	
	
	/**
	 * Unosimo korisnika.
	 * 
	 * @param scanner podataka o scanner objektu.
	 * @param redniBroj podatak o broju koji odradjuje kojem polju porstupamo. 
	 * 
	 * @return vraca objekt Korisnika sa svim parametrima.
	 */
	private static List<Korisnik> unosKorisnika(Scanner scanner, int redniBroj, List<String> listaLinijaDatotekeKorisnici, int brDatKorisnici, List<Korisnik> listaSvihUnesenihKorisnika) {

	    if( listaLinijaDatotekeKorisnici.size() == brDatKorisnici) {
			return listaSvihUnesenihKorisnika;
		}
		else {
//			System.out.println("Unesite tip " + (redniBroj+1) + ". korisnika");
//			System.out.println("1. Privatni");
//			System.out.println("2. Poslovni");
//			System.out.println("Odabir >>");
			
			int tipKorisnika = Integer.parseInt(listaLinijaDatotekeKorisnici.get(brDatKorisnici++));
			tipKorisnika = ispravanUnosInt(tipKorisnika);
	
			
			Long id = Long.parseLong(listaLinijaDatotekeKorisnici.get(brDatKorisnici++));
			
			if(tipKorisnika == 1) {
//				System.out.printf("Unesite ime " + (redniBroj+1) + ". osobe: ");
				String ime = listaLinijaDatotekeKorisnici.get(brDatKorisnici++);
				
//				System.out.printf("Unesite prezime " + (redniBroj+1) + ". osobe: ");
				String prezime = listaLinijaDatotekeKorisnici.get(brDatKorisnici++);
				
//				System.out.printf("Unesite e-mail " + (redniBroj+1) + ". osobe: ");
				String email = listaLinijaDatotekeKorisnici.get(brDatKorisnici++);
				
//				System.out.printf("Unesite telefon " + (redniBroj+1) + ". osobe: ");
				String telefon = listaLinijaDatotekeKorisnici.get(brDatKorisnici++);
				
				listaSvihUnesenihKorisnika.add(new PrivatniKorisnik(ime, prezime, email, telefon, id));
			
				return unosKorisnika(scanner, ++redniBroj, listaLinijaDatotekeKorisnici, brDatKorisnici, listaSvihUnesenihKorisnika);
			}
			else { 
//				System.out.printf("Unesite naziv " + (redniBroj+1) + ". tvrtke: ");
				String naziv = listaLinijaDatotekeKorisnici.get(brDatKorisnici++);
	
//				System.out.printf("Unesite e-mail " + (redniBroj+1) + ". tvrtke: ");
				String email = listaLinijaDatotekeKorisnici.get(brDatKorisnici++);
	
//				System.out.printf("Unesite web " + (redniBroj+1) + ". tvrtke: ");
				String web = listaLinijaDatotekeKorisnici.get(brDatKorisnici++);
	
//				System.out.printf("Unesite telefon " + (redniBroj+1) + ". tvrtke: ");
				String telefon = listaLinijaDatotekeKorisnici.get(brDatKorisnici++);
	
				listaSvihUnesenihKorisnika.add(new PoslovniKorisnik(naziv, email, web, telefon, id));
				
				return unosKorisnika(scanner, ++redniBroj, listaLinijaDatotekeKorisnici, brDatKorisnici, listaSvihUnesenihKorisnika);
			}
		}
	}
	 
	
	/**
	 * Unosimo kategoriju.
	 * 
	 * @param scanner podataka o scanner objektu.
	 * @param redniBroj podatak o broju koji odradjuje kojem polju pristupamo. 
	 * @param listaLinijaDatotekeKategorije 
	 * 
	 * @return vraca objekt Kategorije sa svim parametrima.
	 * @throws IOException 
	 * @throws FileNotFoundException 
	 * @throws ClassNotFoundException 
	 */
	private static List<Kategorija<Artikl>> unosKategorije(Scanner scanner, int redniBroj, Map<Kategorija<Artikl>, List<Artikl>> mapaArtikala, List<String> listaLinijaDatotekeKategorije, int brDatKategorije, List<Kategorija<Artikl>> listaSvihUnesenihKategorija, int brDatArtikli) throws FileNotFoundException, IOException, ClassNotFoundException {
		
		if( listaLinijaDatotekeKategorije.size() == brDatKategorije) {
			return listaSvihUnesenihKategorija;
		}
		else {
//			System.out.print("Unesite naziv " + (redniBroj+1) + " kategorije: ");
			
			Long id = Long.parseLong(listaLinijaDatotekeKategorije.get(brDatKategorije++)); 
					
			String nazivKategorije = listaLinijaDatotekeKategorije.get(brDatKategorije++);
			
//			System.out.print("Unesite broj artikala koji želite unijeti za unesenu kategoriju: ");
			String listaId;
			listaId = listaLinijaDatotekeKategorije.get(brDatKategorije++).replace(" ", "");
			
			List<Artikl> artikli = new ArrayList<Artikl>();
			
			List<Artikl> listaArtikala = new ArrayList<>();
			List<Artikl> listaSvihUnesenihArtikala = new ArrayList<>();
			
			
			String datotekaArtikli = "C:\\Java\\Pripreme za Labose\\Videc-8\\dat\\Artikli.txt";
			brDatArtikli = 0;
			
			List<String> listaLinijaDatotekeArtikli = new ArrayList<>();
			
			
			try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(SERIALIZATION_FILE_NAME))) {
				
				try(BufferedReader bufferedReader = new BufferedReader(new FileReader(datotekaArtikli))){
					String line;
					while((line = bufferedReader.readLine()) != null) {
						listaLinijaDatotekeArtikli.add(line);
					}
				}catch(IOException ex) {
					ex.printStackTrace();
				}
				
				System.out.println("Ucitavanje Artikli.txt");
				
				oos.writeObject(listaLinijaDatotekeArtikli);
			}catch(IOException ex) {
				System.out.println(ex);
			}
			
			
			int pronadjeniId = 0;
			artikli = unosArtikala(scanner, redniBroj, listaArtikala, listaSvihUnesenihArtikala, brDatArtikli, listaLinijaDatotekeArtikli, listaId, pronadjeniId);
			
			mapaArtikala.put(new Kategorija<Artikl>(nazivKategorije, artikli, id), listaArtikala);
	
			listaSvihUnesenihKategorija.add(new Kategorija<Artikl>(nazivKategorije, artikli, id));
			
			return unosKategorije(scanner, ++redniBroj, mapaArtikala, listaLinijaDatotekeKategorije, brDatKategorije, listaSvihUnesenihKategorija, brDatArtikli);
		}
	}
		
	/**
	 * Unosimo artikle.
	 * 
	 * @param scanner podataka o scanner objektu.
	 * @param redniBroj podatak o broju koji odradjuje kojem polju pristupamo. 
	 * @param listaLinijaDatotekeArtikli 
	 * @param listaId 
	 * @param pronadjeniId 
	 * 
	 * @return vraca objekt artikla sa svim parametrima.
	 * @throws IOException 
	 * @throws FileNotFoundException 
	 * @throws ClassNotFoundException 
	 */
	private static List<Artikl> unosArtikala(Scanner scanner, int redniBroj, List<Artikl> listaArtikala, List<Artikl> listaSvihUnesenihArtikala, int brDatArtikli, List<String> listaLinijaDatotekeArtikli, String listaId, int pronadjeniId) throws FileNotFoundException, ClassNotFoundException {
		
		try(ObjectInputStream ois = new ObjectInputStream(new FileInputStream(SERIALIZATION_FILE_NAME))) {
			
			@SuppressWarnings("unchecked")
			List<String> procitanaListaLinijaDatotekeArtikli = (List<String>) ois.readObject();
			
			
			int brojPodatakaPoArtiklu = 7;
			
			if( (brDatArtikli == (brojPodatakaPoArtiklu * listaId.length()) && brDatArtikli == (brojPodatakaPoArtiklu * pronadjeniId)) || brDatArtikli >= procitanaListaLinijaDatotekeArtikli.size() ) {
				return listaSvihUnesenihArtikala;
			}
					
			else {
	//			System.out.println("Unesite tip " + (redniBroj+1) + ". artikla");
	//			System.out.println("1. Usluga");
	//			System.out.println("2. Automobil");
	//			System.out.println("3. Stan");
	//			System.out.println("Odabir >>");
				
				
				int tipArtikla = ispravanUnosInt(Integer.parseInt(procitanaListaLinijaDatotekeArtikli.get(brDatArtikli++)));
		
				Long id = Long.parseLong(procitanaListaLinijaDatotekeArtikli.get(brDatArtikli++));
				
				if( listaId.contains(id.toString())) {
					pronadjeniId++;
					
					if(tipArtikla == 1) {
	//					System.out.printf("Unesite naslov " + (redniBroj+1) + ". oglasa usluge: ");
						String naslov = procitanaListaLinijaDatotekeArtikli.get(brDatArtikli++);
						
	//					System.out.printf("Unesite opis " + (redniBroj+1) + ". oglasa usluge: ");
						String opis = procitanaListaLinijaDatotekeArtikli.get(brDatArtikli++);
						
	//					System.out.printf("Unesite cijenu " + (redniBroj+1) + ". oglasa usluge: ");
						BigDecimal cijena = ispravanUnosBigDecimal(new BigDecimal(procitanaListaLinijaDatotekeArtikli.get(brDatArtikli++)));
						
						Stanje stanje = unosStanja(Integer.parseInt(procitanaListaLinijaDatotekeArtikli.get(brDatArtikli++)));
						
						listaArtikala.add(new Usluga(naslov, opis, cijena, stanje, id));
						
						listaSvihUnesenihArtikala.add(new Usluga(naslov, opis, cijena, stanje, id));
						
						return unosArtikala(scanner, redniBroj, listaArtikala, listaSvihUnesenihArtikala, brDatArtikli, procitanaListaLinijaDatotekeArtikli, listaId, pronadjeniId);
					}
					else if(tipArtikla == 2) { 
	//					System.out.printf("Unesite naslov " + (redniBroj+1) + ". oglasa automobila: ");
						String naslov = procitanaListaLinijaDatotekeArtikli.get(brDatArtikli++);
						
	//					System.out.printf("Unesite opis " + (redniBroj+1) + ". oglasa automobila: ");
						String opis = procitanaListaLinijaDatotekeArtikli.get(brDatArtikli++);
			
	//					System.out.printf("Unesite snagu " + (redniBroj+1) + ". (u ks) oglasa automobila: ");
						BigDecimal snaga = ispravanUnosBigDecimal(new BigDecimal(procitanaListaLinijaDatotekeArtikli.get(brDatArtikli++)));
						
	//					System.out.printf("Unesite cijenu " + (redniBroj+1) + ". oglasa automobila: ");
						BigDecimal cijena = ispravanUnosBigDecimal(new BigDecimal(procitanaListaLinijaDatotekeArtikli.get(brDatArtikli++)));
						
						Stanje stanje = unosStanja(Integer.parseInt(procitanaListaLinijaDatotekeArtikli.get(brDatArtikli++)));
						
						listaArtikala.add(new Automobil(naslov, opis, cijena, stanje, snaga, id));
			
						listaSvihUnesenihArtikala.add(new Automobil(naslov, opis, cijena, stanje, snaga, id));
						
						return unosArtikala(scanner, redniBroj, listaArtikala, listaSvihUnesenihArtikala, brDatArtikli, procitanaListaLinijaDatotekeArtikli, listaId, pronadjeniId);
					}
					else {
	//					System.out.printf("Unesite naslov " + (redniBroj+1) + ". oglasa stana: ");
						String naslov = procitanaListaLinijaDatotekeArtikli.get(brDatArtikli++);
			
	//					System.out.printf("Unesite opis " + (redniBroj+1) + ". oglasa stana: ");
						String opis = procitanaListaLinijaDatotekeArtikli.get(brDatArtikli++);
			
	//					System.out.printf("Unesite kvadraturu " + (redniBroj+1) + ". oglasa stana: ");
						int kvadratura = ispravanUnosInt(Integer.parseInt(procitanaListaLinijaDatotekeArtikli.get(brDatArtikli++)));
						
	//					System.out.printf("Unesite cijenu " + (redniBroj+1) + ". oglasa stana: ");
						BigDecimal cijena = ispravanUnosBigDecimal(new BigDecimal(procitanaListaLinijaDatotekeArtikli.get(brDatArtikli++)));
					
						Stanje stanje = unosStanja(Integer.parseInt(procitanaListaLinijaDatotekeArtikli.get(brDatArtikli++)));
						
						listaArtikala.add(new Stan(naslov, opis, cijena, kvadratura, stanje, id));
			
						listaSvihUnesenihArtikala.add(new Stan(naslov, opis, cijena, kvadratura, stanje, id));
						
						return unosArtikala(scanner, redniBroj, listaArtikala, listaSvihUnesenihArtikala, brDatArtikli, procitanaListaLinijaDatotekeArtikli, listaId, pronadjeniId);
					}
				}
				return unosArtikala(scanner, redniBroj, listaArtikala, listaSvihUnesenihArtikala, brDatArtikli + 5, procitanaListaLinijaDatotekeArtikli, listaId, pronadjeniId);
			}
			
		}catch(IOException | ClassCastException ex) {
			System.out.println(ex);
		}
		return unosArtikala(scanner, redniBroj, listaArtikala, listaSvihUnesenihArtikala, brDatArtikli, listaLinijaDatotekeArtikli, listaId, pronadjeniId);
	}
	
	/**
	 * Odabiremo stanje artikla.
	 * 
	 * @param scanner podatak o scanner objektu.
	 */
	private static Stanje unosStanja(int stanjeRedniBroj) {
		for (int i = 0; i < Stanje.values().length; i++) {
//			System.out.println((i + 1) + ". " + Stanje.values()[i]);
		}
		 		
		while (true) {
//			System.out.print("Odabir stanja artikla >> ");
			
			if (stanjeRedniBroj >= 1 && stanjeRedniBroj <= Stanje.values().length){
				return Stanje.values()[stanjeRedniBroj - 1];
			} 
			else {
				System.out.println("Neispravan unos!");
			}
		}
	}
		
	/**
	 * Odabiremo korisnika.
	 * 
	 * @param scanner podatak o scanner objektu.
	 * @param i podatak o broju koji odradjuje kojem polju pristupamo. 
	 * @param brojKorisnika podatak koji odredjuje koliko korisnika ima.
	 * @param korisnici polje korisnika.
	 * @param odabraniKorisnik podatak koji odredjuje kojem korisniku pristupamo.
	 */
	private static void odabirKorisnika(Scanner scanner, int i, int brojKorisnika, List<Korisnik> korisnici, List<Integer> odabraniKorisnik, int brDatProdaje, List<String> listaLinijaDatotekeProdaje) {
//		System.out.println("Odaberite korisnika:");
		
		for(int j = 0; j < brojKorisnika; j++) {
//			System.out.println((j+1) + ". " + korisnici.get(j).dohvatiKontakt()); 
		}
//		System.out.println("Odabir >>");

		int broj = Integer.parseInt(listaLinijaDatotekeProdaje.get(brDatProdaje));
		odabraniKorisnik.add(ispravanUnosInt(broj));
	}

	
	/**
	 * Odabiremo kategoriju.
	 * 
	 * @param scanner podatak o scanner objektu.
	 * @param i podatak o broju koji odradjuje kojem polju pristupamo. 
	 * @param brojKorisnika podatak koji odredjuje koliko kategorija ima.
	 * @param kategorije polje kategorije.
	 * @param odabranaKategorija podatak koji odredjuje kojoj kategoriji pristupamo.
	 */
	private static void odabirKategorije(Scanner scanner, int i, int brojKategorija, List<Kategorija<Artikl>> kategorije, List<Integer> odabranaKategorija, int brDatProdaje, List<String> listaLinijaDatotekeProdaje) {
//		System.out.println("Odaberite kategoriju:");
		
		for(int j = 0; j < brojKategorija; j++) {
//			System.out.println((j+1) + ". " + kategorije.get(j).getNaziv());
		}
//		System.out.println("Odabir >>");
		
		int broj = Integer.parseInt(listaLinijaDatotekeProdaje.get(brDatProdaje));
		odabranaKategorija.add(ispravanUnosInt(broj));
	}
	
	
	/**
	 * Odabiremo artikl.
	 * 
	 * @param scanner podatak o scanner objektu.
	 * @param i podatak o broju koji odradjuje kojem polju pristupamo. 
	 * @param kategorije polje kategorije.
	 * @param odabraniArtikl podatak koji odredjuje kojem artiklu pristupamo.
	 * @param odabranaKategorija podatak koji odredjuje kojoj kategoriji pristupamo.
	 */
	private static void odabirArtikla(Scanner scanner, int i, List<Kategorija<Artikl>> kategorije, List<Integer> odabraniArtikl, List<Integer> odabranaKategorija, int brDatProdaje, List<String> listaLinijaDatotekeProdaje) {
//		System.out.println("Odaberite artikal:");
								
		List<Artikl> artiklOdabirLista = (kategorije.get(odabranaKategorija.get(i) - 1).getArtikli());
				
		for(int j = 0; j < artiklOdabirLista.size(); j++) {
			
			//System.out.println((j+1) + ". "  kategorije.get(odabranaKategorija.get(i)-1).getAtrikli()+[j].getNaslov()); 
//			System.out.println((j+1) + ". " + artiklOdabirLista.get(j).getNaslov()); 			
		}							
//		System.out.println("Odabir >>");
		
		int broj = Integer.parseInt(listaLinijaDatotekeProdaje.get(brDatProdaje));
		odabraniArtikl.add(ispravanUnosInt(broj));
	}
	
	
	
/*	
	
	
1
1
Tin
Kramberger
tin@tvz.hr
12345654321
2
Rabljeni automobili
4
2
BMW
BMW M5
625
1100000
2
2
BMW
BMW M5
625
1100000
2
2
BMW
BMW 320d
190
350000
1
2
Alfa Romeo 
Alfa Romeo 147 skoro ispravna, savrseno stanje
150
20000
4
Stanovi Zagreb
2
3
Ravnice
Prekrasan stan
75
1000000
3
3
Kvatric
Drzavni stan, derutan
30
200000
4
1
1
2
1


	
	
*/
	
	
	
}
