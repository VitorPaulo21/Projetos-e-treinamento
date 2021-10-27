package newView.Header;

import CssConverter.CSS;
import Model.Controler.Controler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Label;
import javafx.scene.input.MouseButton;
import javafx.scene.layout.HBox;

public class Header extends HBox{

	public Header(Runnable min) {
		
		CSS css = new CSS();
		
		Label exit = new Label();
		Label minimize = new Label();
		
		exit.setMinSize(15, 15);
		minimize.setMinSize(15, 15);
		
		exit.setAlignment(Pos.CENTER);
		minimize.setAlignment(Pos.CENTER);
		
		exit.setStyle(css.setBackgroundColor(CSS.hexToColor("#F9544D"))
				.setBackgroundRadius(90)
				.setBackgroundInsets(0)
				.setPadding(0)
				.setFontSize(11)
				.get());
		
		minimize.setStyle(css.setBackgroundColor(CSS.hexToColor("#E4BD47"))
				.setBackgroundRadius(90)
				.setBackgroundInsets(0)
				.setPadding(0)
				.setFontSize(10)
				.get());
		
		minimize.setRotate(90);
		
		exit.setOnMouseClicked(e -> {
			if (e.getButton() == MouseButton.PRIMARY) {
				Controler.destroy();
			System.exit(0);
			
			}
		});
		
		
		minimize.setOnMouseClicked(e -> {
			
			if (e.getButton() == MouseButton.PRIMARY) {
				
				min.run();
				
			}
			
		});
		
		setOnMouseEntered(e -> {
			
			exit.setText("X");
			minimize.setText("|");
			
		});
		
		setOnMouseExited(e -> {
			
			exit.setText("");
			minimize.setText("");
			
		});
		
		setAlignment(Pos.CENTER_LEFT);
		setPadding(new Insets(8,8,0,8));
		setSpacing(4);
		getChildren().addAll(exit, minimize);
	}
	
	
	
}
