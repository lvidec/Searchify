package hr.java.vjezbe;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.List;

import hr.java.vjezbe.baza.BazaPodataka;
import hr.java.vjezbe.entitet.PoslovniKorisnik;
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

public class PretragaPoslovnihController {

	private List<PoslovniKorisnik> listItems;
	
    @FXML private TextField nazivTextField;
    @FXML private TextField webTextField;
    @FXML private TextField emailTextField;
    @FXML private TextField telefonTextFIeld;

    @FXML private TableView<PoslovniKorisnik> tablicaRezultataPretrage;

    @FXML private TableColumn<PoslovniKorisnik, String> stupacNaziva;
    @FXML private TableColumn<PoslovniKorisnik, String> stupacWeba;
    @FXML private TableColumn<PoslovniKorisnik, String> stupacEmaila;
    @FXML private TableColumn<PoslovniKorisnik, String> stupacTelefona;

    public void initialize() throws FileNotFoundException, BazaPodatakaException {
    	stupacNaziva.setCellValueFactory(new PropertyValueFactory<PoslovniKorisnik, String>("naziv"));

    	stupacWeba.setCellValueFactory(new PropertyValueFactory<PoslovniKorisnik, String>("web"));
		
    	stupacEmaila.setCellValueFactory(new PropertyValueFactory<PoslovniKorisnik, String>("email"));

    	stupacTelefona.setCellValueFactory(new PropertyValueFactory<PoslovniKorisnik, String>("telefon"));
	
    	listItems = BazaPodataka.dohvatiPoslovnePremaKriterijima(new PoslovniKorisnik(null, null, null, null, null));
    	
    	ObservableList<PoslovniKorisnik> listaPoslovnih = FXCollections.observableArrayList(listItems);
    	
    	tablicaRezultataPretrage.setItems(listaPoslovnih);
    }
    
    
    public void pretraziButton() throws FileNotFoundException, BazaPodatakaException {
    	
    	System.out.println("PRETRAZI");
    	String naziv = nazivTextField.getText();
    	String web = webTextField.getText();
    	String email = emailTextField.getText();
    	String telefon = telefonTextFIeld.getText();
    	    
    	
    	List<PoslovniKorisnik> listaTrazenih = BazaPodataka.dohvatiPoslovnePremaKriterijima(new PoslovniKorisnik(naziv, web, email, telefon, null));
    	
    	ObservableList<PoslovniKorisnik> listaTrazenihPoslovnih = FXCollections.observableArrayList(listaTrazenih);
    	
    	tablicaRezultataPretrage.setItems(listaTrazenihPoslovnih);
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
