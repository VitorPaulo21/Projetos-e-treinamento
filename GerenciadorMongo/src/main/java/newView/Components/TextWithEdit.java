package newView.Components;

import java.awt.Color;

import CssConverter.CSS;
import Observers.Refreshers.Enter;
import javafx.geometry.Pos;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyCode;
import javafx.scene.layout.HBox;

public class TextWithEdit extends HBox{

	private Label text;
	private EditText edit;
	
	public TextWithEdit(Enter enter) {
		
		CSS css = new CSS();
		
		String textStyle = css
				.setFontFamily("Oswald")
				.setTextColor(new Color(193, 119, 50))
				.setFontSize(15)
				.setBackgroundInsets(10)
				.setPadding(10, 5, 10, 3)
				.get();
		css.clean();
		
		setAlignment(Pos.CENTER);
		
		text = new Label();
		edit = new EditText();
		
		edit.setOnKeyPressed(event -> {
			
			if (event.getCode() == KeyCode.ENTER) {
				
				
				
				enter.enterPressed();
				
			}
			
		});
		
		text.setStyle(textStyle);
		
		getChildren().addAll(text, edit);
		
	}

	public Label getText() {
		return text;
	}

	public void setText(Label text) {
		this.text = text;
	}

	public TextField getEdit() {
		return edit;
	}
	
	public void setEditRed() {
		
		edit.setRed();
		
	}
	
	
	public void setCursor() {
		
		edit.selectPositionCaret(edit.getText().length());
		
	}
	
}
