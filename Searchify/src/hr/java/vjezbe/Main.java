package hr.java.vjezbe;

import javafx.application.Application;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.fxml.FXMLLoader;
import hr.java.vjezbe.niti.DatumObjaveNit;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.util.Duration;



public class Main extends Application {
	
//	private static Stage stage = new Stage();
	private static BorderPane borderPane = new BorderPane();
	
	public static void main(String[] args) {
		launch(args);
	}
	
	
	@Override
	public void start(Stage primaryStage) {
		try {
//			stage = primaryStage;
			
			borderPane = (BorderPane)FXMLLoader.load(getClass().getResource("Videc.fxml"));
			
			Scene scene = new Scene(borderPane, 600, 500);
			scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
			
			primaryStage.setScene(scene);
			
			Timeline prikazSlavljenika = new Timeline(new KeyFrame(Duration.seconds(10),
					new EventHandler<ActionEvent>() {
						@Override
						public void handle(ActionEvent event) {
							Platform.runLater(new DatumObjaveNit());
						}
					} ));
			
			prikazSlavljenika.setCycleCount(Timeline.INDEFINITE);
			prikazSlavljenika.play();
			
			
			primaryStage.show();
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	
	public static void setCenterPane(BorderPane center) {
//		Scene scene = new Scene(center, 600, 500);
//		
//		stage.setScene(scene);
//		stage.show();	
		
		borderPane.setCenter(center);
	}
	
}
