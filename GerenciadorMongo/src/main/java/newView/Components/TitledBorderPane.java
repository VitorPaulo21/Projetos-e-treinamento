package newView.Components;

import java.awt.Color;

import CssConverter.CSS;
import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.layout.StackPane;

public class TitledBorderPane extends StackPane{

	private CSS css = new CSS();
	
	private String topTitleStile;
	
	public TitledBorderPane() {
		super();
		topTitleStile = css
				.setFontFamily("Oswald")
				.setTextColor(new Color(193, 119, 50))
				.setFontSize(15)
				.setBackgroundColor(new Color(33,33,33))
				.get()
				+ "-fx-translate-y: -13;";
		css.clean();
		

		setStyle("-fx-content-display: top;" + css.fx().border().insets().setInsetsValue(15, 3, 0, 3)
				.setBorderRadius(5)
				.fx().border().color().set().get() + CSS.colorToHex(new Color(193, 119, 50)) +";");
	}
	
	public void addTitle(Node e) {
		
		setAlignment(e, Pos.TOP_CENTER);
		
	}

	public String getTopTitleStile() {
		return topTitleStile;
	}

	
	
}
