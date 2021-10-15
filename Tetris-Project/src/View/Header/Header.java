package View.Header;

import java.awt.Color;

import CssConverter.CSS;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.input.MouseButton;
import javafx.scene.layout.HBox;
import javafx.scene.text.TextAlignment;
import javafx.stage.Stage;

public class Header extends HBox{

	public Header(Stage stage) {
		CSS css = new CSS();
		Label exit = new Label("");
		Label min = new Label("");
		
		setAlignment(Pos.CENTER_LEFT);
		exit.setOnMouseClicked(e -> {
			
			if (e.getButton() == MouseButton.PRIMARY) {
				
				System.exit(0);
				
			}
			
		});
		min.setOnMouseClicked(e -> {
			
			if (e.getButton() == MouseButton.PRIMARY) {
				
				stage.setIconified(true);
				
			}
			
		});
		
		
		exit.setPrefSize(22, 22);
		exit.setMinSize(22, 22);
		exit.setMaxSize(22, 22);
		exit.setPadding(new Insets(0));
		exit.setGraphicTextGap(0);
		exit.setTranslateX(5);
		exit.setWrapText(true);
		exit.setAlignment(Pos.CENTER);
		exit.setScaleX(0.7);
		exit.setScaleY(0.7);
		exit.setStyle(css.setBackgroundColor(CSS.hexToColor("#FF605C"))
				.setBackgroundRadius(90)
				.setFontFamily("Roboto Mono")
				.setFontSize(15)
				.setPadding(0)
				.setBackgroundInsets(0)
				.get());
		
		exit.setTextAlignment(TextAlignment.CENTER);
		
		min.setPrefSize(22, 22);
		min.setMinSize(22, 22);
		min.setMaxSize(22, 22);
		min.setPadding(new Insets(0));
		min.setGraphicTextGap(0);
		min.setTranslateX(5);
		min.setWrapText(true);
		min.setAlignment(Pos.CENTER);
		min.setScaleX(0.7);
		min.setScaleY(0.7);
		min.setRotate(90);
		min.setStyle(css.setBackgroundColor(CSS.hexToColor("#FFBD44"))
				.setBackgroundRadius(90)
				.setFontFamily("Roboto Mono")
				.setFontSize(8)
				.setPadding(0)
				.setBackgroundInsets(0)
				.get());
		
		min.setTextAlignment(TextAlignment.CENTER);
		
		setPrefHeight(30);
		setMinHeight(30);
		setMaxHeight(30);
		setStyle(css.setBackgroundColor(new Color(99,33,99))
				.setBackgroundRadius(8, 8, 0, 0).get());
		
		setOnMouseEntered(e -> {
			
			exit.setText("x");
			min.setText("|");
			
		});
		
		setOnMouseExited(e -> {
			
			exit.setText("");
			min.setText("");
			
		});
		
		getChildren().add(exit);
		getChildren().add(min);
		
	}
	
}
