package Model;

import java.applet.AudioClip;
import java.io.File;
import java.io.FileInputStream;
import java.util.function.Consumer;

import Controler.Layout;
import TelaInicial.InitialLayout;
import View.Header.Header;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.input.KeyCode;
import javafx.scene.input.MouseButton;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

public class App extends Application implements Runnable{

	private double x;
	private double y;
	private Scene cena;
	private Scene cena1;
	private Stage stage;
	private Runnable reset;
	private Layout layout;
	private VBox box;
	
	@Override
	public void start(Stage primaryStage) throws Exception {
		Font.loadFont(new FileInputStream(new File("./src/Roboto.ttf")), 16);
		
		
		
		stage = new Stage();
		Header head = new Header(stage);
		box = new VBox();
		box.getChildren().add(head);
		layout = new Layout(this);
		box.getChildren().add(layout);
		box.setStyle("-fx-background-color: #00000000;");
		Consumer<Boolean> changeScreen = s -> {
			layout.started = true;
			cena = new Scene(box, 551, 630);
			cena.setOnKeyPressed(e -> {
				
				if (e.getCode() == KeyCode.DOWN) {
					layout.down();
//					AudioClip buzzer = new AudioClip(getClass().getResource("/Pop.wav").toExternalForm());
//					buzzer.play();
				} else if (e.getCode() == KeyCode.RIGHT) {
					layout.right();
//					AudioClip buzzer = new AudioClip(getClass().getResource("/Pop.wav").toExternalForm());
//					buzzer.play();
				} else if (e.getCode() == KeyCode.LEFT) {
					layout.left();
//					AudioClip buzzer = new AudioClip(getClass().getResource("/Pop.wav").toExternalForm());
//					buzzer.play();
				} else if (e.getCode() == KeyCode.SPACE) {
					layout.rotate();
//					AudioClip buzzer = new AudioClip(getClass().getResource("/Pop.wav").toExternalForm());
//					buzzer.play();
				}
				
			});
			cena.setFill(Color.TRANSPARENT);
			stage.initStyle(StageStyle.TRANSPARENT);
			stage.setResizable(false);
			stage.setScene(cena);
			primaryStage.close();
			stage.show();
		};
		InitialLayout initialLayout = new InitialLayout(changeScreen, primaryStage);
		
		cena1 = new Scene(initialLayout, 400, 200);
//		cena.getStylesheets().add();
		head.setOnMousePressed(e -> {
			
			if (e.getButton() == MouseButton.PRIMARY) {
				
				x = e.getScreenX() - stage.getX();
				y = e.getScreenY() - stage.getY();
						
			}
			
		});
		
		head.setOnMouseDragged(e -> {
			
			if (e.getButton() == MouseButton.PRIMARY) {
				
				stage.setX(e.getScreenX() - x);
				stage.setY(e.getScreenY() - y);
				
			}
			
		});
		
		initialLayout.getHead().setOnMousePressed(e -> {
			
			if (e.getButton() == MouseButton.PRIMARY) {
				
				x = e.getScreenX() - primaryStage.getX();
				y = e.getScreenY() - primaryStage.getY();
						
			}
			
		});
		
		initialLayout.getHead().setOnMouseDragged(e -> {
			
			if (e.getButton() == MouseButton.PRIMARY) {
				
				primaryStage.setX(e.getScreenX() - x);
				primaryStage.setY(e.getScreenY() - y);
				
			}
			
		});
		
		reset = () -> {
			box = new VBox();
			box.getChildren().add(head);
			layout = new Layout(this);
			box.getChildren().add(layout);
			box.setStyle("-fx-background-color: #00000000;");
			cena.setRoot(box);
			stage.setScene(cena);
			layout.started = true;
		};
		
		cena1.setFill(Color.TRANSPARENT);
		primaryStage.initStyle(StageStyle.TRANSPARENT);
		primaryStage.setResizable(false);
		primaryStage.setScene(cena1);
		primaryStage.show();
		
	}

	public static void main(String[] args) {
		
		launch(args);
		
	}

	@Override
	public void run() {
		reset.run();
	}
	
}
