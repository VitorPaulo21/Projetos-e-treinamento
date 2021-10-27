package com.SpringMongo.SpringMongo.Model;

import org.springframework.data.annotation.Id;

import lombok.Data;

@Data
public class Ganho {

	@Id
	private String id;
	
	private String data;
	
	private double valor;
	
	public Ganho() {
	}

	public Ganho(String data, double valor) {
		super();
		this.data = data;
		this.valor = valor;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getData() {
		return data;
	}

	public void setData(String data) {
		this.data = data;
	}

	public double getValor() {
		return valor;
	}

	public void setValor(double valor) {
		this.valor = valor;
	}
	
	
	
}
