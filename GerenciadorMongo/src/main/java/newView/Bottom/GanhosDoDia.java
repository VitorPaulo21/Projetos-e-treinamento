package newView.Bottom;

import java.awt.Color;
import java.util.Optional;

import CssConverter.CSS;
import Model.Controler.Controler;
import Model.Objects.List.Ganho;
import Observers.Refreshers.Refresh;
import javafx.geometry.HPos;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Label;
import javafx.scene.control.TextInputDialog;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.ColumnConstraints;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Priority;

public class GanhosDoDia extends GridPane implements Refresh{

	private Label label;
	private Label txt;
	private CSS css;
	private String data;
	private TextInputDialog input;
	
	public GanhosDoDia() {
		
		input = new TextInputDialog();
		input.setTitle("Entrada Externa");
		input.setHeaderText("Insira um valor positivo para adicionar\nOu um valor negativo para subtrair");

		this.data = Controler.FormatedDate;
		
		css = new CSS();
		Image image = new Image("/addButtonr.png");
		ImageView addbutton = new ImageView(image);
		addbutton.setFitWidth(37);
		addbutton.setFitHeight(37);
		addbutton.setSmooth(true);
		addbutton.setStyle(css
				.setBackgroundColor(new Color(33,33,33))
				.setPadding(0)
				.setBackgroundInsets(0)
				.get());
		
		HBox box = new HBox();
		box.setPadding(new Insets(0));
		box.getChildren().add(addbutton);

		
		box.setOnMouseClicked(e -> inputClicked());
		
		label = new Label("Ganhos do dia:");
		txt = new Label();
		
		txt.setAlignment(Pos.CENTER_LEFT);
		


		label.setStyle(css
				.setFontFamily("Oswald")
				.setFontSize(15)
				.setTextColor(new Color(193, 119, 50))
				.setPadding(0)
				.get());
		
		txt.setStyle(css
				.setFontFamily("Oswald")
				.setFontSize(15)
				.setTextColor(new Color(76, 175, 80))
				.setPadding(3,5,3,5)
				.setBackgroundInsets(5)
				.get());
		
		Controler.addToList(this);
		
		ColumnConstraints cc1 = new ColumnConstraints();
		ColumnConstraints cc2 = new ColumnConstraints();
		ColumnConstraints cc3 = new ColumnConstraints();
		cc1.setPercentWidth(43.5);
		cc1.setHalignment(HPos.RIGHT);
		cc1.setFillWidth(false);
//		cc1.setHgrow(Priority.ALWAYS);
		
		cc2.setHalignment(HPos.LEFT);
		cc2.setFillWidth(true);
		cc2.setHgrow(Priority.ALWAYS);
		
		cc3.setFillWidth(false);
		cc3.setHgrow(Priority.ALWAYS);
		cc3.setHalignment(HPos.RIGHT);
		
		getColumnConstraints().add(cc1);
		getColumnConstraints().add(cc2);
		getColumnConstraints().add(cc3);
		
		setGridLinesVisible(true);
		
		setAlignment(Pos.CENTER);
		
	
		
		add(label, 0, 0);
		add(txt, 1, 0);
		add(box, 2, 0);
		
	}


	private void save() {
		
		Controler.Banca.setFinall(Controler.Banca.getInicial() + Controler.total);
		Controler.addBanca();
		
	}
	

	@Override
	public void refreshN() {
		
		if (Controler.isStopped()) {
			
			Controler.showOptionStop();
			
		}
		
		Double t = Controler.total;
		
		if (t < 0) {
			
			txt.setText(String.format("R$ %.2f", t));
			txt.setStyle(css
					.setFontFamily("Oswald")
					.setFontSize(15)
					.setTextColor(new Color(183, 28, 28))
					.setPadding(3,5,3,5)
					.setBackgroundInsets(5)
					.get());
			
		} else {
			txt.setText(String.format("R$ +%.2f", t));
			txt.setStyle(css
					.setFontFamily("Oswald")
					.setFontSize(15)
					.setTextColor(new Color(76, 175, 80))
					.setPadding(3,5,3,5)
					.setBackgroundInsets(5)
					.get());
		}
		
		save();
		
	}
	

	private void inputClicked() {
		
		Optional<String> escolha = input.showAndWait();
		double value = 0;
		input.close();
		
		if (escolha.isPresent()) {
			
			if (!(escolha == null)) {
				
				System.out.println("1");
				
				if (!escolha.isEmpty()) {
					
					try {
						
						value = Double.parseDouble(escolha.get().replace(",", ".").replace("+", ""));
						
	
							Ganho ganho = new Ganho(data, value);
							
							Controler.saveGanho(ganho.getValor());
							System.out.println("3");
							
	
						
					} catch (NumberFormatException e2) {
						Controler.showNumberException();
					}	
				}
				
			}
			
		}
		
	}
	
}
