package Model.Objects.List;

import java.util.ArrayList;


public class Ganhos{


	private String id;
	
	
	private String data;
	
	
	ArrayList<Ganho> ganhos;
	
	public Ganhos() {
		ganhos = new ArrayList<Ganho>();
	}
	
	

	public Ganhos(String data) {
		super();
		this.data = data;
		ganhos = new ArrayList<Ganho>();
	}



	public Ganhos(ArrayList<Ganho> ganhos) {
		super();
		this.ganhos = ganhos;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public ArrayList<Ganho> getGanhos() {
		return ganhos;
	}

	public String getData() {
		return data;
	}

	public void setData(String data) {
		this.data = data;
	}

	public void setGanhos(ArrayList<Ganho> ganhos) {
		this.ganhos = ganhos;
	}
	
	
	
}
