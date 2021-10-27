package com.SpringMongo.SpringMongo.Model;

import java.util.ArrayList;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;

import lombok.Data;

@Data
public class Ganhos {

	@Id
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
	
	
	
}
