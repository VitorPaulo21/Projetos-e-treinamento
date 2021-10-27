package newView.Porcentagens;

import java.awt.Color;

import CssConverter.CSS;
import Model.Controler.Controler;
import Model.Objects.Banca.Banca;
import Model.Objects.Percents.Porcents;
import Observers.Refreshers.Enter;
import Observers.Refreshers.Refresh;
import javafx.geometry.HPos;
import javafx.geometry.Pos;
import javafx.scene.control.Label;
import javafx.scene.layout.ColumnConstraints;
import javafx.scene.layout.GridPane;
import newView.Components.TextWithEdit;
import newView.Components.TitledBorderPane;

public class Percents extends TitledBorderPane implements Refresh, Enter{

	
	private Banca banca;
	private TextWithEdit toInvest;
	private TextWithEdit Payout;
	private Label bancPersent;
	private Label initialHand;
	private Porcents percents;
	private boolean edit1 = false;
	private boolean edit2 = false;
	
	public Percents() {
		super();
		this.banca = Controler.Banca;
		
		Controler.addToList(this);
		
		GridPane grid = new GridPane();
		toInvest = new TextWithEdit(this);
		Payout = new TextWithEdit(this);
		
		this.percents = Controler.Percents;
		
		GridPane gridTop = new GridPane();
		
		toInvest.getText().setText("A inv.");
		Payout.getText().setText("Payout");
		updatePayout();
		updateToInv();
		
		Label p = new Label("%");
		Label p2 = new Label("%");
		
		CSS css = new CSS();
		
		String txtStyle = css
				.setFontFamily("Oswald")
				.setTextColor(new Color(193, 119, 50))
				.setFontSize(15)
				.setBackgroundInsets(10)
				.setPadding(10, 5, 10, 3)
				.get();
		
		p.setStyle(txtStyle);
		css.clean();
		p2.setStyle(txtStyle);
		css.clean();
		
		updateToInv();
		updatePayout();
		
		toInvest.getText().setStyle(css
				.setFontFamily("Oswald")
				.setTextColor(new Color(193, 119, 50))
				.setFontSize(15)
				.setBackgroundInsets(0)
				.setPadding(10,5, 10, 3)
				.get());
		css.clean();
		
		Payout.getChildren().add(p2);
		
		toInvest.getChildren().add(p);
		
		ColumnConstraints cc = new ColumnConstraints();
		cc.setPercentWidth(50);
		cc.setFillWidth(true);
		cc.setHalignment(HPos.CENTER);
		
		ColumnConstraints ccAll = new ColumnConstraints();
		ccAll.setPercentWidth(100);
		ccAll.setHalignment(HPos.CENTER);
		
		ColumnConstraints cc1 = new ColumnConstraints();
//		cc1.setPercentWidth(100/3);
		cc1.setFillWidth(false);
		cc1.setHalignment(HPos.CENTER);
		ColumnConstraints cc2 = new ColumnConstraints();
		cc2.setPercentWidth(100/3);
		cc2.setHalignment(HPos.CENTER);
		ColumnConstraints ccR = new ColumnConstraints();
		ccR.setPercentWidth(100/3);
		ccR.setHalignment(HPos.RIGHT);
		
		gridTop.getColumnConstraints().add(cc);
		gridTop.getColumnConstraints().add(cc);

		Label titulo = new Label("Porcentagens");
		
		addTitle(titulo);
		titulo.setStyle(getTopTitleStile());
		gridTop.setAlignment(Pos.CENTER);
//		gridTop.setGridLinesVisible(true);
		
		gridTop.add(toInvest, 0, 0);
		gridTop.add(Payout, 1, 0);
		
		bancPersent = new Label();
		initialHand = new Label();
		
		bancPersent.setStyle(txtStyle);
		initialHand.setStyle(txtStyle);
		
		updateBancPercent();
		updateHand();
		
		
		
		GridPane gridDown = new GridPane();
	
		gridDown.getColumnConstraints().add(ccR);
		gridDown.getColumnConstraints().add(cc1);
		gridDown.getColumnConstraints().add(cc2);
//		gridDown.setGridLinesVisible(true);
		gridDown.setAlignment(Pos.CENTER);
		
		gridDown.add(bancPersent, 0, 0);
		gridDown.add(initialHand, 1, 0);
		
		
		grid.getColumnConstraints().add(ccAll);
		
		grid.add(gridTop, 0, 0);
		grid.add(gridDown, 0, 1);
		
		getChildren().addAll(titulo, grid);
		
	}
	
	
	private void updateToInv() {
		
		toInvest.getEdit().setText(String.format("%.2f", percents.getToInvest()));
		
	}
	private void updatePayout() {
		
		Payout.getEdit().setText(String.format("%.2f", percents.getPayout()));
		
	}
	
	private Double hand() {
		
		return (banca.getInicial() * percents.getToInvest()) / percents.getPayout();
		
	}
	
	private void updateBancPercent() {
		
		bancPersent.setText(String.format("%.2f%%", (hand() / banca.getInicial()) * 100));
		
	}
	
	private void updateHand() {
		
		initialHand.setText(String.format("Inicial: R$%.2f", hand()));
		
	}
	
//	public Double getRefreshedValue() {
//		
//		refreshN();
//		return hand();
//		
//	}
//	
//	public double getPayout() {
//		
//		this.percents = Controler.Invpercs;
//		
//		return Stops.getPayout();
//		
//	}
	
	@Override
	public void refreshN() {
		
		
		this.percents = Controler.Percents;
		this.banca = Controler.Banca;
		
		updateToInv();
		updatePayout();
		updateHand();
		updateBancPercent();
		
		toInvest.setCursor();
		Payout.setCursor();
		
	}


	private void save() throws NumberFormatException{
		edit1 = false;
		edit2 = true;
		percents.setToInvest(Double.parseDouble(toInvest.getEdit().getText().replace(",", ".")));
		edit1 = true;
		edit2 = false;
		System.out.println("Stop1");
		percents.setPayout(Double.parseDouble(Payout.getEdit().getText().replace(",", ".")));
		edit2 = true;
		System.out.println("Stop2");
		
		Controler.saveInvPercs(percents);
	}
	
	@Override
	public void enterPressed() {
		
		try {
			
			save();
			
			
		} catch (NumberFormatException e) {
			
			Controler.showNumberException();
			
			if (!edit1) {

				toInvest.setEditRed();
				edit1 = false;
				edit2 = false;
			} else if (!edit2) {
				
				Payout.setEditRed();
				edit1 = false;
				edit2 = false;
				
			}
			
		}
		
	}

}
