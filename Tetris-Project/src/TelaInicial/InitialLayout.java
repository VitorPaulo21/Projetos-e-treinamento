package TelaInicial;

import java.awt.Color;
import java.util.function.Consumer;

import CssConverter.CSS;
import View.Header.Header;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.input.KeyCode;
import javafx.scene.input.MouseButton;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.VBox;
import javafx.scene.text.TextAlignment;
import javafx.stage.Stage;

public class InitialLayout extends BorderPane{

	private Header head;
	
	public InitialLayout(Consumer<Boolean> start, Stage stage) {
		CSS css = new CSS();
		
		head = new Header(stage);
		
		Button button = new Button("Start");
		Label title = new Label("Bem vindo ao Tetris");
		title.setStyle(css
				.setFontFamily("Roboto Mono")
				.setFontSize(28)
				.setTextColor(new Color(99,33,99))
				.setPadding(5, 0, 10, 0)
				.get());
		css.clean();
		Label text = new Label("Para iniciar o jogo clique no botão abaixo");
		text.setTextAlignment(TextAlignment.CENTER);
		text.setWrapText(true);
		text.setStyle(css
				.setFontFamily("Roboto Mono")
				.setFontSize(16)
				.setTextColor(new Color(99,33,99))
				.setPadding(0,0,10,0)
				.get());
		css.clean();
		
		button.setStyle(css.setBackgroundColor(new Color(99,33,99))
				.setTextColor(Color.white)
				.setFontFamily("Roboto Mono")
				.setFontSize(13)
				.setBackgroundRadius(8)
				.get());
		css.clean();
		button.setOnMouseClicked(e -> {
			
			if (e.getButton() == MouseButton.PRIMARY) {

				start.accept(true);
				
				
			}
			
		});
		

		
		VBox box = new VBox();
		
		box.setAlignment(Pos.CENTER);
		box.setStyle(css.setBackgroundColor(new Color(255,235,235))
				.setBackgroundRadius(0,0,9,9).get());
		css.clean();
		
		setStyle(css.setBackgroundRadius(9)
				.get());
		
		box.getChildren().add(title);
		box.getChildren().add(text);
		box.getChildren().add(button);
		setTop(head);
		setCenter(box);
		
		
	}

	public Header getHead() {
		return head;
	}
	
	
	
}
