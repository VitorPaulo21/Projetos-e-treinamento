package newView.Bottom;

import javafx.geometry.Pos;
import javafx.scene.layout.VBox;

public class BottomView extends VBox{

	private GainListView gainList;
	
	public BottomView() {
		
		
		gainList = new GainListView();
		setAlignment(Pos.BOTTOM_CENTER);
		
		getChildren().add(gainList);
		
		
	}
	
	
}
