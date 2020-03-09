package hr.java.vjezbe;

import java.io.IOException;

import javafx.fxml.FXMLLoader;
import javafx.scene.layout.BorderPane;

public class VidecController {
	
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
