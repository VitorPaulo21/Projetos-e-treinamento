package newView.Top;

import java.awt.Color;

import CssConverter.CSS;
import Model.Controler.Controler;
import javafx.geometry.Pos;
import javafx.scene.control.Label;
import newView.Components.TitledBorderPane;

public class Data extends TitledBorderPane{

	
	private String FormatedDate;
	
	public Data() {
		super();
		CSS css = new CSS();
		
		FormatedDate = Controler.FormatedDate;
		
		Label label = new Label(FormatedDate);
		Label title = new Label("Data");
		
		setAlignment(Pos.CENTER);
		
		
		
		title.setStyle(super.getTopTitleStile());
		css.clean();
		
		addTitle(title);
		
		label.setStyle(css
				.setFontFamily("Oswald")
				.setTextColor(new Color(193, 119, 50))
				.setFontSize(16)
				.setBackgroundInsets(10)
				.setPadding(10, 10, 10, 10)
				.get());
		css.clean();
		
		getChildren().addAll(title, label);

	}


	
}
