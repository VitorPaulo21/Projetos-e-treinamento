package newView.Bottom;


import java.awt.Color;

import CssConverter.CSS;
import Model.Controler.Controler;
import Model.Objects.List.Ganho;
import Observers.Refreshers.Refresh;
import javafx.geometry.HPos;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Tooltip;
import javafx.scene.input.MouseButton;
import javafx.scene.layout.ColumnConstraints;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.RowConstraints;

public class Buttons extends GridPane implements Refresh{


	private String data;
	private Button winButton;
	private Button lossButton;
	
	public Buttons() {
		
		Controler.addToList(this);
		
		this.data = Controler.FormatedDate;
		
		winButton = new Button("Win");
		lossButton = new Button("Loss");
		
		CSS css = new CSS();
		
		winButton.setStyle( css
				.setFontFamily("Oswald")
				.setBackgroundColor(new Color(56, 142, 60))
				.setTextColor(new Color(33,33,33))
				.setFontSize(27)
				.setPadding(0)
				.setBackgroundRadius(0, 0, 0, 10)
				.get()
				);
		css.clean();
		
		
		
		lossButton.setStyle( css
				.setFontFamily("Oswald")
				.setBackgroundColor(new Color(183, 28, 28))
				.setTextColor(new Color(33,33,33))
				.setFontSize(27)
				.setBackgroundRadius(0, 0, 10, 0)
				.setPadding(0)
				.get());
		css.clean();
		
		setInfo();
		
		
		winButton.setOnMouseClicked(e -> {
			
			if(e.getButton() == MouseButton.PRIMARY) {
				
				if (Controler.allowClicks) {
					
					win();
					
				} else {
					
//					Notifications.create()
//					.title("Alerta")
//					.text("Voce optou por nao operar mais hoje\nReinicie a aplicação para continuar a operar")
//					.showInformation();
				}
			}
			
			
		});
		
		lossButton.setOnMouseClicked(e -> {
			
			if (e.getButton() == MouseButton.PRIMARY) {
				
				if (Controler.allowClicks) {
					
					loss();
					
				}  else {
					
//					Notifications.create()
//					.title("Alerta")
//					.text("Voce optou por nao operar mais hoje\nReinicie a aplicação para continuar a operar")
//					.showInformation();
				}	
			}
				
			
			
		});
		
		
		RowConstraints rc = new RowConstraints();
		rc.setMinHeight(50);
		getRowConstraints().add(rc);
		setAlignment(Pos.CENTER);
		ColumnConstraints cc = new ColumnConstraints();
		cc.setFillWidth(true);
		cc.setPercentWidth(50);
		cc.setHalignment(HPos.CENTER);
		winButton.setPrefWidth(220);
		lossButton.setPrefWidth(220);
		winButton.setPrefHeight(50);
		lossButton.setPrefHeight(50);
		getColumnConstraints().add(cc);
		getColumnConstraints().add(cc);

		add(winButton, 0, 0);
		add(lossButton, 1, 0);
		
		
	}
	
	private Ganho operation(boolean bool) {
		Ganho ganh;
		if (bool) {
			
//			return (Banca.getBanca() * Stops.getToInvest()) / Stops.getPayout();
			 ganh = new Ganho(data, ((Controler.Banca.getInicial() * Controler.Percents.getToInvest())
					 /Controler.Percents.getPayout())
					 * Controler.Percents.getPayout());
			
		}else {
			
			ganh = new Ganho(data, ((Controler.Banca.getInicial() * Controler.Percents.getToInvest())
					 /Controler.Percents.getPayout()));
		}
		
		Tooltip winInfo = new Tooltip("+" + ganh.getValor());
		Tooltip lossInfo = new Tooltip("-"+ ganh.getValor());
		
		winButton.setTooltip(winInfo);
		lossButton.setTooltip(lossInfo);
			return ganh;
			
	}
	
	private void win() {
		Ganho ganh = operation(true);
		Controler.saveGanho(ganh.getValor());
		
	}
	private void loss() {
		
		Ganho ganho = operation(false);
		
		ganho.setValor(ganho.getValor() * (-1));
		
		Controler.saveGanho(ganho.getValor());
		
	}
	

	
	private void setInfo() {
		
		Tooltip winInfo = new Tooltip("+" + operation(true).getValor());
		Tooltip lossInfo = new Tooltip("-"+operation(false).getValor());
		
		winButton.setTooltip(winInfo);
		lossButton.setTooltip(lossInfo);
		
	}

	@Override
	public void refreshN() {
		
		setInfo();
		
	}
	
}
