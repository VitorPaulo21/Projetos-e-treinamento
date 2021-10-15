package View.PontuationScreen;

import java.awt.Color;
import java.util.function.Consumer;

import CssConverter.CSS;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseButton;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;

public class Pontuation extends VBox{

	private Label lines;
	private Label points;
	private int linesNum;
	public Pontuation(Consumer<Integer> reset) {
		
		
		Image image = new Image("/reset-WHITE-ICON.png");
		ImageView resImg = new ImageView(image);
		resImg.setFitHeight(80);
		resImg.setFitWidth(80);
		
		HBox box2 = new HBox();
		box2.getChildren().add(resImg);
		box2.setAlignment(Pos.CENTER);
		box2.setOnMouseClicked(e -> {
			
			if (e.getButton() == MouseButton.PRIMARY) {
				
				reset.accept(1);
				
			}
			
		});
		CSS css = new CSS();
		box2.setStyle("-fx-background-color: #00000000;");
		
		linesNum = 0;
		
		VBox box1 = new VBox();
		box1.setStyle(css.setBackgroundColor(new Color(80, 10, 80)).get());
		css.clean();
		box1.setPrefWidth(100);
		box1.setAlignment(Pos.CENTER);
		box1.setPadding(new Insets(7));
		
		Label pts = new Label("Pontos");
		pts.setStyle(css
				.setTextColor(CSS.hexToColor("#f3f315"))
				.setFontFamily("Roboto Mono")
				.setFontSize(20)
				.get());
		css.clean();
		
		lines = new Label(linesNum + "");
		lines.setPrefWidth(90);
		lines.setAlignment(Pos.CENTER);
		lines.setStyle(css.setBackgroundColor(new Color(33,33,33))
				.setFontFamily("Roboto Mono")
				.setFontSize(18)
				.setTextColor(Color.white)
				.get());
		css.clean();
		
		Label lns = new Label("Linhas");
		lns.setStyle(css
				.setTextColor(CSS.hexToColor("#f3f315"))
				.setFontFamily("Roboto Mono")
				.setFontSize(20)
				.get());
		css.clean();
		
		points = new Label(linesNum * 100 + "");
		points.setPrefWidth(90);
		points.setAlignment(Pos.CENTER);
		points.setStyle(css.setBackgroundColor(new Color(33,33,33))
				.setFontFamily("Roboto Mono")
				.setFontSize(18)
				.setTextColor(Color.white)
				.get());
		css.clean();
		
		box1.getChildren().add(pts);
		box1.getChildren().add(points);
		box1.getChildren().add(lns);
		box1.getChildren().add(lines);
		
		
		setPrefWidth(100);
		setAlignment(Pos.TOP_CENTER);
		
		getChildren().add(box1);
		getChildren().add(box2);

	}
	
	public void addPoints() {
		
		linesNum++;
		lines.setText(linesNum + "");
		points.setText(linesNum * 100 + "");
	}
	
}
