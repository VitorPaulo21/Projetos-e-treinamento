package newView.Balanca;

import java.awt.Color;

import CssConverter.CSS;
import Model.Controler.Controler;
import Model.Objects.Banca.Banca;
import Observers.Refreshers.Enter;
import Observers.Refreshers.Refresh;
import javafx.geometry.HPos;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Label;
import javafx.scene.layout.ColumnConstraints;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import newView.Components.TextWithEdit;
import newView.Components.TitledBorderPane;

public class Balanca extends TitledBorderPane implements Refresh, Enter {

	private TextWithEdit initial;
	private Label finall;
	private Banca banca;

	public Balanca() {
		super();
		Controler.addToList(this);
		this.banca = Controler.Banca;
		CSS css = new CSS();

		String textStyle2 = css.setFontFamily("Oswald").setTextColor(new Color(193, 119, 50))
				.setBackgroundColor(new Color(33, 33, 33)).setFontSize(16).setBackgroundInsets(10)
				.setPadding(10, 5, 10, 3).get();
		css.clean();

		Label titulo = new Label("Banca");
		titulo.setStyle(super.getTopTitleStile());

		initial = new TextWithEdit(this);
		finall = new Label("Atual: R$ " + Double.toString(banca.getFinall()));

		initial.getText().setText("Inicial:");
		initial.getEdit().setText(Double.toString(banca.getInicial()));
		finall.setStyle(textStyle2);

		GridPane grid = new GridPane();

		HBox box = new HBox();
		box.setAlignment(Pos.CENTER_LEFT);
		box.getChildren().add(initial);

		css.clean();

		grid.add(box, 0, 0);
		grid.add(finall, 1, 0);
//		grid.setGridLinesVisible(true);
		ColumnConstraints CC1 = new ColumnConstraints();
		CC1.setPercentWidth(50);
		CC1.setHalignment(HPos.CENTER);
		grid.getColumnConstraints().add(CC1);
		grid.getColumnConstraints().add(CC1);
		grid.setPadding(new Insets(7, 0, 7, 0));

		super.addTitle(titulo);

		getChildren().addAll(titulo, grid);

	}

	
	
	private void save() throws NumberFormatException {

		//TODO aqui pode haver falhas, verificar
		
		banca.setInicial(Double.parseDouble(initial.getEdit().getText().replace(",", ".")));
		
		double ganhos = Controler.Ganhos.getGanhos().stream()
		.map(e -> e.getValor())
		.reduce(0.0, (i,e) -> i + e)
		.doubleValue();
		
		banca.setFinall(Double.parseDouble(initial.getEdit().getText().replace(",", ".")) + ganhos);

		Controler.saveBanca(banca);

	}

	@Override
	public void refreshN() {

		this.banca = Controler.Banca;
		
		initial.getEdit().setText(Double.toString(banca.getInicial()));
		finall.setText(String.format("Atual: R$%.2f", banca.getFinall()));
		
		initial.setCursor();
		
	}



	@Override
	public void enterPressed() {

		try {
			save();
		} catch (NumberFormatException e) {

			Controler.showNumberException();
			initial.setEditRed();
			
		}
		
	}

}
