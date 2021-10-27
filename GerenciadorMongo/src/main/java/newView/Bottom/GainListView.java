package newView.Bottom;

import java.awt.Color;
import java.util.ArrayList;
import java.util.List;

import CssConverter.CSS;
import Model.Controler.Controler;
import Model.Objects.List.Ganho;
import Observers.Refreshers.RefreshList;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.geometry.Pos;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.layout.HBox;

public class GainListView extends ListView<HBox> implements RefreshList{
	ArrayList<Double> values = new ArrayList<Double>();
	ArrayList<Label> labels = new ArrayList<Label>();
	ArrayList<HBox> boxes = new ArrayList<>();
	@SuppressWarnings("unused")
	private String data;
	private String stileRed;
	private String stileGreen;
	private CSS css;
	private ObservableList<HBox> items;
	private double total = 0;
	
	public GainListView() {
		
		
		Controler.refreshList = this;
		
		css = new CSS();
		
		stileRed = css
				.setFontFamily("Oswald")
				.setTextColor(new Color(183, 28, 28))
				.setFontSize(14)
				.setPadding(8)
				.get();
		css.clean();
		stileGreen = css
				.setFontFamily("Oswald")
				.setTextColor(new Color(56, 142, 60))
				.setFontSize(14)
				.setPadding(8)
				.get();
		css.clean();
		this.data = Controler.FormatedDate;
		
		this.setFixedCellSize(30);

		getSelectionModel().select(-1);
		
		this.setStyle(css.setBackgroundColor(new Color(33,33,33))
				.setBackgroundInsets(0)
				.setPadding(10,0,0,0)
				.setMinWidth(600)
				.get()
				+"-fx-border-color:" + CSS.colorToHex(new Color(33,33,33)) + ";"
				+"-fx-control-inner-background:" + CSS.colorToHex(new Color(33,33,33)) + ";"
				+ "-fx-control-inner-background-alt:" + CSS.colorToHex(new Color(33,33,33)) + ";"
				+"-fx-cell-border-color:" + CSS.colorToHex(new Color(33,33,33)) + ";"
				);
		
		generateList();
		
		
	}
	
	private void getValues() {
		
		List<Ganho> ganhosList = Controler.Ganhos.getGanhos();
		
		ganhosList.forEach(g -> {
			
			values.add(g.getValor());
			
		});
		
	}
	
	private Label labelSetStyle(Double value) {
		
		Label label = new Label();
		
		if (value < 0) {
		
			label.setText(String.format("%.2f", value));
			label.setStyle(stileRed);
			
		} else {
			
			
			label.setText(String.format("+%.2f", value));
			label.setStyle(stileGreen);
			
		}
		label.setAlignment(Pos.CENTER);
		return label;
		
	}
	
	private void populateLabels() {
		
		values.forEach(v -> {
			labels.add(labelSetStyle(v));
			total += v;
		});
		
	}
	
	private HBox setHbox(Label label) {
		
		HBox box = new HBox();
		
		box.getChildren().add(label);
		
		box.setAlignment(Pos.CENTER);
		css.clean();
		box.setStyle(css.setBackgroundColor(new Color(33,33,33)).get());
		
		return box;
	}

	private void populateList() {
		items = FXCollections.observableArrayList(boxes);
		
		labels.forEach(l -> {
			
			items.add(0,setHbox(l));
		});
		
		
		this.setItems(items);
		
	}
	
	private void generateList() {
		
		getValues();
		populateLabels();
		populateList();
		calculateTotal();
	}

	private void calculateTotal() {
		
		Controler.total = this.total;
		Controler.refreshGanhosDoDia();
		
	}
	
	@Override
	public void refreshL(Double value) {

		items.add(0, setHbox(labelSetStyle(value)));
		total += value;
		this.setItems(items);
		this.refresh();
		calculateTotal();
		
	}
	


	
}
