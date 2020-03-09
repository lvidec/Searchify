package hr.java.vjezbe.niti;

import hr.java.vjezbe.baza.BazaPodataka;
import hr.java.vjezbe.entitet.Prodaja;
import hr.java.vjezbe.iznimke.BazaPodatakaException;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;

public class DatumObjaveNit implements Runnable{
		
	@SuppressWarnings("unused")
	public static Thread nit;

	
	@Override
	public void run() {

		Alert alert = new Alert(AlertType.INFORMATION);
		alert.setTitle("Information");
		try {
			alert.setContentText(BazaPodataka.zadnjeUnesenaProdaja(new Prodaja(null, null, null, null)).toString());
		} catch (BazaPodatakaException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		alert.showAndWait();
		
		
	}
	
}
