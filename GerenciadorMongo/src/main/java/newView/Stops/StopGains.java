package newView.Stops;

import java.awt.Color;

import CssConverter.CSS;
import Model.Controler.Controler;
import Model.Objects.Banca.Banca;
import Model.Objects.Stops.Stops;
import Observers.Refreshers.Enter;
import Observers.Refreshers.Refresh;
import javafx.geometry.HPos;
import javafx.geometry.Insets;
import javafx.scene.control.Label;
import javafx.scene.layout.ColumnConstraints;
import javafx.scene.layout.GridPane;
import newView.Components.TextWithEdit;
import newView.Components.TitledBorderPane;

public class StopGains extends TitledBorderPane implements Refresh, Enter{

	private TextWithEdit stopGainField;
	private TextWithEdit stopLossField;
	private Label stopGain;
	private Label stopLoss;
	private Stops stops;
	private Banca banca;
	private boolean edit1 = false;
	private boolean edit2 = false;
	
	public StopGains() {
		super();
		this.banca = Controler.Banca;
		
		Controler.addToList(this);
		
		Label title = new Label("Stop's");
		
		
		this.stops = Controler.Stops;
		
		stopGainField = new TextWithEdit(this);
		stopGainField.getText().setText("Gain:");
		setGainField(stopGainField, stops);
		
		stopLossField = new TextWithEdit(this);
		stopLossField.getText().setText("Loss:");
		setLossField(stopLossField, stops);
		
		stopGain = new Label();
		CSS css = new CSS();
		
		stopLoss = new Label();
		
		stopGain.setStyle(css.setTextColor(new Color(76, 175, 80))
				.setFontFamily("Oswald")
				.setFontSize(15)
				.get());
		stopLoss.setStyle(css.setTextColor(new Color(183, 28, 28))
				.setFontFamily("Oswald")
				.setFontSize(15)
				.get());
		
		setStopGain();
		setStopLoss();
		
		GridPane grid = new GridPane();
		
		ColumnConstraints CC = new ColumnConstraints();
		CC.setPercentWidth(50);
		CC.setHalignment(HPos.CENTER);
		CC.setFillWidth(true);
		
		grid.setPadding(new Insets(7,7,7,0));
		
		grid.getColumnConstraints().add(CC);
		grid.getColumnConstraints().add(CC);
		
		grid.add(stopGainField, 0, 0);
		grid.add(stopLossField, 1, 0);
		grid.add(stopGain, 0, 2);
		grid.add(stopLoss, 1, 2);
		
		title.setStyle(super.getTopTitleStile());
		
		addTitle(title);
		
		getChildren().addAll(title, grid);
		
	}
	
	private void setGainField(TextWithEdit e, Stops p) {
		
		e.getEdit().setText(String.format("%.2f", p.getStopGain()));
		
	}
	private void setLossField(TextWithEdit e, Stops p) {
		
		e.getEdit().setText(String.format("%.2f", p.getStopLoss()));
		
	}
	
	private void setStopGain() {
		
		stopGain.setText(String.format("R$%.2f", stops.getStopGain() * banca.getInicial()));
		
	}
	private void setStopLoss() {
		
		stopLoss.setText(String.format("R$%.2f", stops.getStopLoss() * banca.getInicial()));
		
	}
	
	private void save() throws NumberFormatException{
		edit1 = false;
		edit2 = true;
		stops.setStopGain(Double.parseDouble(stopGainField.getEdit().getText().replace(",", ".")));
		edit1 = true;
		edit2 = false;
		stops.setStopLoss(Double.parseDouble(stopLossField.getEdit().getText().replace(",", ".")));
		edit2 = true;
		
		Controler.savePercents(stops);
		
	}

	@Override
	public void refreshN() {
		
		this.banca = Controler.Banca;
		this.stops = Controler.Stops;
		
		setGainField(stopGainField, stops);
		setLossField(stopLossField, stops);
		setStopGain();
		setStopLoss();
		
		stopGainField.setCursor();
		stopLossField.setCursor();
	}

	@Override
	public void enterPressed() {

		try {

			save();
			
		} catch (NumberFormatException e) {
			
			Controler.showNumberException();
			
			if (edit1 == false) {
				
				stopGainField.setEditRed();
				edit1 = false;
				edit2 = false;
				
			} else if (edit2 == false) {
				
				stopLossField.setEditRed();
				edit1 = false;
				edit2 = false;
				
			}
			
		}
		
	}



	
	
}
