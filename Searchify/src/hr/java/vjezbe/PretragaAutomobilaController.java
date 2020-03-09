package hr.java.vjezbe;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.math.BigDecimal;
import java.util.List;

import hr.java.vjezbe.baza.BazaPodataka;
import hr.java.vjezbe.entitet.Automobil;
import hr.java.vjezbe.entitet.Stanje;
import hr.java.vjezbe.iznimke.BazaPodatakaException;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.BorderPane;

public class PretragaAutomobilaController {
	
	private List<Automobil> listItems;

	@FXML private TextField naslovTextField;
    @FXML private TextField opisTextField;
    @FXML private TextField snagaTextField;
    @FXML private TextField cijenaTextField;

    @FXML private TableView<Automobil> tablicaRezultataPretrage;
   
    @FXML private TableColumn<Automobil, String> stupacNaslova;
    @FXML private TableColumn<Automobil, String> stupacOpisa;
    @FXML private TableColumn<Automobil, BigDecimal> stupacSnage;
    @FXML private TableColumn<Automobil, BigDecimal> stupacCijene;
    @FXML private TableColumn<Automobil, Stanje> stupacStanja;

    
    public void initialize() throws FileNotFoundException, BazaPodatakaException {
    	stupacNaslova.setCellValueFactory(new PropertyValueFactory<Automobil, String>("naslov"));

    	stupacOpisa.setCellValueFactory(new PropertyValueFactory<Automobil, String>("opis"));

    	stupacSnage.setCellValueFactory(new PropertyValueFactory<Automobil, BigDecimal>("snagaKs"));
		
    	stupacCijene.setCellValueFactory(new PropertyValueFactory<Automobil, BigDecimal>("cijena"));

    	stupacStanja.setCellValueFactory(new PropertyValueFactory<Automobil, Stanje>("stanje"));
	
    	listItems = BazaPodataka.dohvatiAutomobilePremaKriterijima(new Automobil(null, null, null, null, null, null));
    	
    	ObservableList<Automobil> listaAutomobila = FXCollections.observableArrayList(listItems);
    	
//    	System.out.println(BazaPodataka.dohvatiAutomobilePremaKriterijima(new Automobil(naslov, opis, cijena, stanje, snagaKs, id)));
    	
    	
    	tablicaRezultataPretrage.setItems(listaAutomobila);
    }
    
    
    public void pretraziButton() throws FileNotFoundException, NumberFormatException, BazaPodatakaException {
    	
    	System.out.println("PRETRAZI");
    	String naslov = naslovTextField.getText();
    	String opis = opisTextField.getText();
    	
    	BigDecimal cijena = new BigDecimal("0");
    	BigDecimal snaga = new BigDecimal("0");
		
		if(cijenaTextField.getText().isEmpty())
			cijena = null;
		else
			cijena = BigDecimal.valueOf(Double.parseDouble(cijenaTextField.getText()));
		
			
		if(snagaTextField.getText().isEmpty())
			snaga = null;
		else
			snaga = BigDecimal.valueOf(Double.parseDouble(snagaTextField.getText()));
		
    	  	
    	List<Automobil> listaTrazenih = BazaPodataka.dohvatiAutomobilePremaKriterijima(new Automobil(naslov.toString(), opis.toString(), cijena, null, snaga, null));
    	
    	
    	ObservableList<Automobil> listaTrazenihAutomobila = FXCollections.observableArrayList(listaTrazenih);
    	
    	tablicaRezultataPretrage.setItems(listaTrazenihAutomobila);
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
