package View.Next;

import java.awt.Color;
import java.util.ArrayList;

import CssConverter.CSS;
import View.Grid.Slots;
import View.Objects.Block;
import javafx.geometry.Pos;
import javafx.scene.control.Label;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.text.TextAlignment;

public class Proximos extends VBox{

	private ArrayList<Slots> slots;
	private ArrayList<Slots> actualSlots;
	private int x;
	private int y;
	private int count;
	private Block actual;
	private GridPane grid = new GridPane();
	public Proximos() {
		CSS css = new CSS();
		slots = new ArrayList<Slots>();
		actualSlots = new ArrayList<Slots>();
		setAlignment(Pos.TOP_CENTER);
		setStyle("-fx-background-color: #00000000;");
		Label title = new Label("Próximo");
		title.setStyle(css.setTextColor(CSS.hexToColor("#f3f315"))
				.setFontFamily("Roboto Mono")
				.setFontSize(20)
				.get());
		css.clean();
		HBox box = new HBox();
		box.setAlignment(Pos.CENTER);
		box.setStyle(css.setBackgroundColor(new Color(80, 10, 80)).get());
		box.getChildren().add(title);
		for (int i = 0; i < 5; i++) {
			
			for (int j = 0; j < 5; j++) {
				
				Slots slot = new Slots(i, j);
				slot.setColor(new Color(52, 60, 57));
				
				slot.noBorder();
				grid.add(slot, i, j);
				slots.add(slot);
			}
			
		}
		getChildren().add(box);
		getChildren().add(grid);
	}
	
	public void newBlock(Block block) {
		x = 0;
		y = 0;
		count = 0;
		actualSlots.clear();
		block.getObjeto().forEach(o -> {
			
			if (o == 2 || o == 1) {
				
				
				
				x = count % (int) block.getType() + 1;
				y = (count / (int) block.getType()) + 1;
				
				
				Slots slot = new Slots(x, y); 
				slot.setColor(block.getCor());
				actualSlots.add(slot);
			}
			count++;
		});
		actual = block;
		renderize();
	}
	private void renderize() {
		slots.forEach(s -> {
			s.setColor(new Color(52, 60, 57));
			s.noBorder();
		});
		actualSlots.forEach(s -> {
			
			slots.stream().filter(gl -> gl.getX() == s.getX())
			.filter(gl -> gl.getY() == s.getY())
			.forEach(gl -> {
				
				gl.setColor(s.getColor());
			});
			
		});
		
	}
	
	public Block getBlock() {
		
		return actual;
	}
}
