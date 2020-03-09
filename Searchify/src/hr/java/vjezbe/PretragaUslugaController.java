package hr.java.vjezbe;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.math.BigDecimal;
import java.util.List;

import hr.java.vjezbe.baza.BazaPodataka;
import hr.java.vjezbe.entitet.Usluga;
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

public class PretragaUslugaController {
	
	List<Usluga> listItems;
	
	@FXML private TextField naslovTextField;
	@FXML private TextField opisTextField;
	@FXML private TextField cijenaTextField;

	@FXML private TableView<Usluga> tablicaRezultataPretrage;
	
	@FXML private TableColumn<Usluga, String> stupacNaslova;
	@FXML private TableColumn<Usluga, String> stupacOpisa;
	@FXML private TableColumn<Usluga, BigDecimal> stupacCijene;
	@FXML private TableColumn<Usluga, Stanje> stupacStanja;
	
	public void initialize() throws FileNotFoundException, BazaPodatakaException {
    	stupacNaslova.setCellValueFactory(new PropertyValueFactory<Usluga, String>("naslov"));

    	stupacOpisa.setCellValueFactory(new PropertyValueFactory<Usluga, String>("opis"));
		
    	stupacCijene.setCellValueFactory(new PropertyValueFactory<Usluga, BigDecimal>("cijena"));

    	stupacStanja.setCellValueFactory(new PropertyValueFactory<Usluga, Stanje>("stanje"));
	
    	listItems = BazaPodataka.dohvatiUslugePremaKriterijima(new Usluga(null, null, null, null, null));
    	
    	ObservableList<Usluga> listaUslugaa = FXCollections.observableArrayList(listItems);
    	
    	tablicaRezultataPretrage.setItems(listaUslugaa);
    }
    
    
    public void pretraziButton() throws FileNotFoundException, BazaPodatakaException {
    	
    	System.out.println("PRETRAZI");
    	String naslov = naslovTextField.getText();
    	String opis = opisTextField.getText();
    	
    	BigDecimal cijena = new BigDecimal("0");
		
		if(cijenaTextField.getText().isEmpty())
			cijena = null;
		else
			cijena = BigDecimal.valueOf(Double.parseDouble(cijenaTextField.getText()));
		
		
    	List<Usluga> listaTrazenih = BazaPodataka.dohvatiUslugePremaKriterijima(new Usluga(naslov.toString(), opis.toString(), cijena, null, null));
    	
    	
    	ObservableList<Usluga> listaTrazenihUslugaa = FXCollections.observableArrayList(listaTrazenih);
    	
    	tablicaRezultataPretrage.setItems(listaTrazenihUslugaa);
   
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
