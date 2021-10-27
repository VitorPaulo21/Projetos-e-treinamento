package Model;

import java.awt.Color;
import java.io.*;
import java.net.*;

import org.json.JSONObject;

import CssConverter.CSS;
import Model.Controler.Controler;
import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import newView.Balanca.Balanca;
import newView.Bottom.BottomView;
import newView.Bottom.Buttons;
import newView.Bottom.GanhosDoDia;
import newView.Header.Header;
import newView.Porcentagens.Percents;
import newView.Stops.StopGains;
import newView.Top.Data;

public class Initiation extends Application implements Runnable{

	private Header header;
	private Data data;
	private Balanca banca;
	private StopGains stopGains;
	private GanhosDoDia ganhosDoDIa;
	private Percents percents;
	private BottomView bottomView;
	private Buttons buttons;

	private CSS css = new CSS();
	
	private Stage primaryStage;

	private double x = 0;
	private double y = 0;
	
	@Override
	public void start(Stage primaryStage) throws Exception {

		this.primaryStage = primaryStage;
		

		header = new Header(this);
		data = new Data();
		banca = new Balanca();
		stopGains = new StopGains();
		percents = new Percents();
		ganhosDoDIa = new GanhosDoDia();
		bottomView = new BottomView();
		buttons = new Buttons();

		VBox box = new VBox();

		box.setStyle(css.setBackgroundColor(new Color(33, 33, 33)).setBackgroundRadius(10).get());
		box.setAlignment(Pos.TOP_CENTER);

		box.getChildren().addAll(header, data, banca, stopGains, percents, bottomView, ganhosDoDIa, buttons);

		Scene cena = new Scene(box, 440, 600);

		cena.setFill(javafx.scene.paint.Color.TRANSPARENT);
		cena.getStylesheets().add("https://fonts.googleapis.com/css2?family=Oswald");

	header.setOnMousePressed(event -> {
			
		x = 
				event.getScreenX()
				- 
				primaryStage.getX()
				;
		y = 
				event.getScreenY()
				- 
				primaryStage.getY()
				;
		
			
		});
	
	header.setOnMouseDragged(e -> {
		
		primaryStage.setX(e.getScreenX() - x);
		
		primaryStage.setY(e.getScreenY() - y);
		
	});
		
		primaryStage.setScene(cena);
		primaryStage.initStyle(StageStyle.TRANSPARENT);
		Controler.isInitializated = true;
		primaryStage.show();
	}

	public static void main(String[] args) {
		
		launch(args);
	}

	@Override
	public void run() {
		
		primaryStage.setIconified(true);
		
	}

	@Override
	public void stop() throws Exception {
		Controler.destroy();
		super.stop();
	}
	
	
}
