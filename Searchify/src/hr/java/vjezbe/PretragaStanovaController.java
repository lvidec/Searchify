package hr.java.vjezbe;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.math.BigDecimal;
import java.util.List;

import hr.java.vjezbe.baza.BazaPodataka;
import hr.java.vjezbe.entitet.Stan;
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

public class PretragaStanovaController {

	private List<Stan> listItems;
	
    @FXML private TextField naslovTextField;
    @FXML private TextField opisTextField;
    @FXML private TextField kvadraturaTextField;
    @FXML private TextField cijenaTextField;

    @FXML private TableView<Stan> tablicaRezultataPretrage;
   
    @FXML private TableColumn<Stan, String> stupacNaslova;
    @FXML private TableColumn<Stan, String> stupacOpisa;
    @FXML private TableColumn<Stan, Integer> stupacKvadrature;
    @FXML private TableColumn<Stan, BigDecimal> stupacCijene;
    @FXML private TableColumn<Stan, Stanje> stupacStanja;

    public void initialize() throws FileNotFoundException, BazaPodatakaException {
    	stupacNaslova.setCellValueFactory(new PropertyValueFactory<Stan, String>("naslov"));

    	stupacOpisa.setCellValueFactory(new PropertyValueFactory<Stan, String>("opis"));

    	stupacKvadrature.setCellValueFactory(new PropertyValueFactory<Stan, Integer>("kvadratura"));
		
    	stupacCijene.setCellValueFactory(new PropertyValueFactory<Stan, BigDecimal>("kvadratura"));

    	stupacStanja.setCellValueFactory(new PropertyValueFactory<Stan, Stanje>("stanje"));
	
    	listItems = BazaPodataka.dohvatiStanovePremaKriterijima(new Stan(null, null, null, null, null, null));
    	
    	ObservableList<Stan> listaStana = FXCollections.observableArrayList(listItems);
    	
    	tablicaRezultataPretrage.setItems(listaStana);
    }
    
    
    public void pretraziButton() throws FileNotFoundException, NumberFormatException, BazaPodatakaException {
    	
    	System.out.println("PRETRAZI");
    	String naslov = naslovTextField.getText();
    	String opis = opisTextField.getText();
    	
    	Integer kvadratura;
    	BigDecimal cijena = new BigDecimal("0");
		
		if(kvadraturaTextField.getText().isEmpty())
			kvadratura = null;
		else
			kvadratura = Integer.valueOf(Integer.parseInt(kvadraturaTextField.getText()));
		
			
		if(cijenaTextField.getText().isEmpty())
			cijena = null;
		else
			cijena = BigDecimal.valueOf(Double.parseDouble(cijenaTextField.getText()));
		
    	  	
    	List<Stan> listaTrazenih = BazaPodataka.dohvatiStanovePremaKriterijima(new Stan(naslov, opis, cijena, kvadratura, null, null));    	
    	
    	ObservableList<Stan> listaTrazenihStanova = FXCollections.observableArrayList(listaTrazenih);
    	
    	tablicaRezultataPretrage.setItems(listaTrazenihStanova);
   
//    	List<Stan> listaTrazenih = BazaPodataka.dohvatiStanovePremaKriterijima(new Stan(naslov.toString(), opis.toString(), (kvadratura.length() == 0) ? null : new BigDecimal(Double.parseDouble(kvadratura)), (kvadratura.length() == 0) ? null : Integer.parseInt(kvadratura.toString()), Stanje.IZVRSNO, 1L));

    	
    	ObservableList<Stan> listaTrazenihStana = FXCollections.observableArrayList(listaTrazenih);
    	
    	tablicaRezultataPretrage.setItems(listaTrazenihStana);
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
