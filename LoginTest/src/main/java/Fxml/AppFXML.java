package Fxml;
import java.net.URL;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;



public class AppFXML extends Application{

	@Override
	public void start(Stage primaryStage) throws Exception {
		
		String css = getClass().getResource("/Fxml/Estilo.css").toExternalForm();
		URL aquivoFXML = getClass().getResource("/Fxml/Login.fxml");
		GridPane raiz = FXMLLoader.load(aquivoFXML);
		
		Scene cena = new Scene(raiz, 350, 400);
		
		cena.getStylesheets().add(css);
		
		primaryStage.setResizable(false);
		primaryStage.setScene(cena);
		primaryStage.setTitle("Tela de Login");
		primaryStage.show();
		
	}

	public static void main(String[] args) {
		
		launch(args);
		
	}
	
	
}
