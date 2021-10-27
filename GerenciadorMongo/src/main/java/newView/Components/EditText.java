package newView.Components;

import java.awt.Color;

import CssConverter.CSS;
import javafx.scene.control.TextField;

public class EditText extends TextField{

	private CSS css;
	
	
	public EditText() {
		
		css = new CSS();
		
		setStyle(css.
				setTextColor(new Color(193, 119, 50))
				.setFontFamily("Oswald")
				.setFontSize(14)
				.setBackgroundColor(new Color(33,33,33))
				.setBorderRadius(5)
				.setPadding(3,20,3,3)
				.get() +
				"-fx-border-color:" + CSS.colorToHex(new Color(193, 119, 50)) +";");
		css.clean();
		
		textProperty().addListener(l -> {
			
			setNormal();
			
		});
		
	}
	
	public void setRed() {
		
		setStyle(css.
				setTextColor(new Color(183, 28, 28))
				.setFontFamily("Oswald")
				.setFontSize(14)
				.setBackgroundColor(new Color(33,33,33))
				.setBorderRadius(5)
				.setPadding(3,20,3,3)
				.get() +
				"-fx-border-color:" + CSS.colorToHex(new Color(193, 119, 50)) +";");
		css.clean();
	}
	
	
	public void setNormal() {
		
		setStyle(css.
				setTextColor(new Color(193, 119, 50))
				.setFontFamily("Oswald")
				.setFontSize(14)
				.setBackgroundColor(new Color(33,33,33))
				.setBorderRadius(5)
				.setPadding(3,20,3,3)
				.get() +
				"-fx-border-color:" + CSS.colorToHex(new Color(193, 119, 50)) +";");
		css.clean();
	}
	
}
