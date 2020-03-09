package hr.java.vjezbe;

import java.io.IOException;

import hr.java.vjezbe.baza.BazaPodataka;
import hr.java.vjezbe.entitet.PoslovniKorisnik;
import hr.java.vjezbe.iznimke.BazaPodatakaException;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Alert;
import javafx.scene.control.TextField;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.layout.BorderPane;

public class UnosPoslovnihController {

    @FXML private TextField nazivTextField;

    @FXML private TextField webTextField;

    @FXML private TextField emailTextField;

    @FXML private TextField telefonTextField;

    public void initialize() {
    	
    }
    
    
    public void unesiButton() throws BazaPodatakaException {
    			
    	if( nazivTextField.getText().toString().length() == 0 && webTextField.getText().toString().length() != 0 && emailTextField.getText().toString().length() != 0 && telefonTextField.getText().toString().length() != 0) {
    		Alert alert = new Alert(AlertType.ERROR);
    		alert.setTitle("ERROR");
    		alert.setContentText("Naslov je obavezan podatak!");
    		alert.showAndWait();
    	}
    	else if( nazivTextField.getText().toString().length() == 0 && webTextField.getText().toString().length() == 0 && emailTextField.getText().toString().length() != 0 && telefonTextField.getText().toString().length() != 0) {
    		Alert alert = new Alert(AlertType.ERROR);
    		alert.setTitle("ERROR");
    		alert.setContentText("Naslov je obavezan podatak! \nOpis je obavezan podatak!");
    		alert.showAndWait();
    	}
    	else if( nazivTextField.getText().toString().length() == 0 && webTextField.getText().toString().length() == 0 && emailTextField.getText().toString().length() == 0 && telefonTextField.getText().toString().length() != 0) {
    		Alert alert = new Alert(AlertType.ERROR);
    		alert.setTitle("ERROR");
    		alert.setContentText("Naslov je obavezan podatak! \nOpis je obavezan podatak! \nCijena je obavezan podatak!");
    		alert.showAndWait();
    	}
    	else if( nazivTextField.getText().toString().length() == 0 && webTextField.getText().toString().length() == 0 && emailTextField.getText().toString().length() == 0 && telefonTextField.getText().toString().length() == 0) {
    		Alert alert = new Alert(AlertType.ERROR);
    		alert.setTitle("ERROR");
    		alert.setContentText("Naslov je obavezan podatak! \nOpis je obavezan podatak! \nCijena je obavezan podatak! \nStanje je obavezan podatak!");
    		alert.showAndWait();
    	}
    	else if( webTextField.getText().toString().length() == 0 && nazivTextField.getText().toString().length() != 0 && emailTextField.getText().toString().length() != 0 && telefonTextField.getText().toString().length() != 0) {
    		Alert alert = new Alert(AlertType.ERROR);
    		alert.setTitle("ERROR");
    		alert.setContentText("Opis je obavezan podatak!");
    		alert.showAndWait();
    	}
    	else if( webTextField.getText().toString().length() == 0 && emailTextField.getText().toString().length() == 0 && nazivTextField.getText().toString().length() != 0 && telefonTextField.getText().toString().length() != 0) {
    		Alert alert = new Alert(AlertType.ERROR);
    		alert.setTitle("ERROR");
    		alert.setContentText("Opis je obavezan podatak! \nCijena je obavezan podatak!");
    		alert.showAndWait();
    	}
    	else if( webTextField.getText().toString().length() == 0 && emailTextField.getText().toString().length() == 0 && telefonTextField.getText().toString().length() == 0  && nazivTextField.getText().toString().length() != 0) {
    		Alert alert = new Alert(AlertType.ERROR);
    		alert.setTitle("ERROR");
    		alert.setContentText("Opis je obavezan podatak! \nCijena je obavezan podatak! \nStanje je obavezan podatak!");
    		alert.showAndWait();
    	}
    	else if( emailTextField.getText().toString().length() == 0 && nazivTextField.getText().toString().length() != 0 && webTextField.getText().toString().length() != 0 && telefonTextField.getText().toString().length() != 0) {
    		Alert alert = new Alert(AlertType.ERROR);
    		alert.setTitle("ERROR");
    		alert.setContentText("Cijena je obavezan podatak");
    		alert.showAndWait();
    	}
    	else if( emailTextField.getText().toString().length() == 0 && telefonTextField.getText().toString().length() == 0 && nazivTextField.getText().toString().length() != 0 && webTextField.getText().toString().length() != 0) {
    		Alert alert = new Alert(AlertType.ERROR);
    		alert.setTitle("ERROR");
    		alert.setContentText("Cijena je obavezan podatak \nStanje je obavezan podatak!");
    		alert.showAndWait();
    	}
    	else if( telefonTextField.getText().toString().length() == 0 && nazivTextField.getText().toString().length() != 0 && webTextField.getText().toString().length() != 0 && emailTextField.getText().toString().length() != 0 ) {
    		Alert alert = new Alert(AlertType.ERROR);
    		alert.setTitle("ERROR");
    		alert.setContentText("\nStanje je obavezan podatak!");
    		alert.showAndWait();
    	}
    	else {

    		BazaPodataka.pohraniNoviPoslovniKorisnik(new PoslovniKorisnik(nazivTextField.getText(), webTextField.getText(), emailTextField.getText(), telefonTextField.getText(), 5L));
    		
    		Alert alert = new Alert(AlertType.INFORMATION);
    		alert.setTitle("Information");
    		alert.setContentText("Podaci uspjesno uneseni!");
    		alert.showAndWait();
        	
    	}
    	
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
