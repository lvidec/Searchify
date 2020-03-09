package hr.java.vjezbe;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import hr.java.vjezbe.baza.BazaPodataka;
import hr.java.vjezbe.entitet.Artikl;
import hr.java.vjezbe.entitet.Automobil;
import hr.java.vjezbe.entitet.Korisnik;
import hr.java.vjezbe.entitet.PoslovniKorisnik;
import hr.java.vjezbe.entitet.PrivatniKorisnik;
import hr.java.vjezbe.entitet.Prodaja;
import hr.java.vjezbe.entitet.Stan;
import hr.java.vjezbe.entitet.Usluga;
import hr.java.vjezbe.iznimke.BazaPodatakaException;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.layout.BorderPane;

public class UnosProdajeController {


	@FXML private ComboBox<Artikl> artiklComboBox;
    @FXML private ComboBox<Korisnik> korisnikComboBox;
    @FXML private DatePicker datumDatePicker;
	
	
    public void initialize() throws BazaPodatakaException {
    	
    	List<Artikl> listaArtikla = new ArrayList<>();
    	
    	listaArtikla.addAll((Collection<? extends Artikl>) BazaPodataka.dohvatiAutomobilePremaKriterijima(new Automobil(null, null, null, null, null, null)));
    	listaArtikla.addAll((Collection<? extends Artikl>) BazaPodataka.dohvatiStanovePremaKriterijima(new Stan(null, null, null, null, null, null)));
    	listaArtikla.addAll((Collection<? extends Artikl>) BazaPodataka.dohvatiUslugePremaKriterijima(new Usluga(null, null, null, null, null)));

    	ObservableList<Artikl> listaArtiklaProdaja = FXCollections.observableArrayList(listaArtikla);
    	
    	artiklComboBox.setItems(listaArtiklaProdaja);
    
    	
    	List<Korisnik> listaKorisnika = new ArrayList<>();
    	
    	listaKorisnika.addAll((Collection<? extends Korisnik>) BazaPodataka.dohvatiPrivatnePremaKriterijima(new PrivatniKorisnik(null, null, null, null, null)));
    	listaKorisnika.addAll((Collection<? extends Korisnik>) BazaPodataka.dohvatiPoslovnePremaKriterijima(new PoslovniKorisnik(null, null, null, null, null)));
    	
    	ObservableList<Korisnik> listaKorisnikaProdaja = FXCollections.observableArrayList(listaKorisnika);
    	
    	korisnikComboBox.setItems(listaKorisnikaProdaja);
    	
    
    }
    
    
    public void unesiButton() throws BazaPodatakaException {
    	
		BazaPodataka.pohraniNovuProdaju(new Prodaja(artiklComboBox.getValue(), korisnikComboBox.getValue(), datumDatePicker.getValue(), null));
    
		Alert alert = new Alert(AlertType.INFORMATION);
		alert.setTitle("Information");
		alert.setContentText("Uspjesno unesena prodaja!");
		alert.showAndWait();
    }
    
    
	public void prikaziPretraguAutomobila() {
		try {
			BorderPane center = FXMLLoader.load(getClass().getResource("PretragaAutomobila.fxml"));
			Main.setCenterPane(center);
			System.out.println("USPJESNO OTVORENJE PRETRAGE Automobila");
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	
	public void prikaziPretraguStanova() {
		try {
			BorderPane center = FXMLLoader.load(getClass().getResource("PretragaStanova.fxml"));
			Main.setCenterPane(center);
			System.out.println("USPJESNO OTVORENJE PRETRAGE Stanova");
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	
	public void prikaziPretraguUsluga() {
		try {
			BorderPane center = FXMLLoader.load(getClass().getResource("PretragaUsluga.fxml"));
			Main.setCenterPane(center);
			System.out.println("USPJESNO OTVORENJE PRETRAGE Usluga");
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	
	public void prikaziPretraguPrivatnih() {
		try {
			BorderPane center = FXMLLoader.load(getClass().getResource("PretragaPrivatnih.fxml"));
			Main.setCenterPane(center);
			System.out.println("USPJESNO OTVORENJE PRETRAGE Privatnih");
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	
	public void prikaziPretraguPoslovnih() {
		try {
			BorderPane center = FXMLLoader.load(getClass().getResource("PretragaPoslovnih.fxml"));
			Main.setCenterPane(center);
			System.out.println("USPJESNO OTVORENJE PRETRAGE Poslovnih");
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public void prikaziPretraguProdaje() {
		try {
			BorderPane center = FXMLLoader.load(getClass().getResource("PretragaProdaje.fxml"));
			Main.setCenterPane(center);
			System.out.println("USPJESNO OTVORENJE PRETRAGE Prodaje");
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public void prikaziUnosAutomobila() {
		try {
			BorderPane center = FXMLLoader.load(getClass().getResource("UnosAutomobila.fxml"));
			Main.setCenterPane(center);
			System.out.println("USPJESNO OTVORENJE UNOSA Automobila");
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	
	public void prikaziUnosStanova() {
		try {
			BorderPane center = FXMLLoader.load(getClass().getResource("UnosStanova.fxml"));
			Main.setCenterPane(center);
			System.out.println("USPJESNO OTVORENJE UNOSA Stanova");
		} catch (IOException e) {
			e.printStackTrace();	
		}
	}
	
	
	public void prikaziUnosUsluga() {
		try {
			BorderPane center = FXMLLoader.load(getClass().getResource("UnosUsluga.fxml"));
			Main.setCenterPane(center);
			System.out.println("USPJESNO OTVORENJE UNOSA Usluga");
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	
	public void prikaziUnosPrivatnih() {
		try {
			BorderPane center = FXMLLoader.load(getClass().getResource("UnosPrivatnih.fxml"));
			Main.setCenterPane(center);
			System.out.println("USPJESNO OTVORENJE UNOSA Privatnih");
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	
	public void prikaziUnosPoslovnih() {
		try {
			BorderPane center = FXMLLoader.load(getClass().getResource("UnosPoslovnih.fxml"));
			Main.setCenterPane(center);
			System.out.println("USPJESNO OTVORENJE UNOSA Poslovnih");
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public void prikaziUnosProdaje() {
		try {
			BorderPane center = FXMLLoader.load(getClass().getResource("UnosProdaje.fxml"));
			Main.setCenterPane(center);
			System.out.println("USPJESNO OTVORENJE UNOSA Prodaje");
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	

}
