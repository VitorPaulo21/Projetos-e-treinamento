package com.SpringMongo.SpringMongo.Model;

import org.springframework.data.annotation.Id;

import lombok.Data;

@Data
public class Stops {

	@Id
	private String id;
	
	private double stopGain;
	
	private int ident;
	
	private double stopLoss;
	
	public Stops() {
		ident = 1;
	}

	public Stops(double stopGain, double stopLoss) {
		super();
		this.stopGain = stopGain;
		this.stopLoss = stopLoss;
		ident = 1;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public double getStopGain() {
		return stopGain;
	}

	public void setStopGain(double stopGain) {
		this.stopGain = stopGain;
	}

	public double getStopLoss() {
		return stopLoss;
	}

	public void setStopLoss(double stopLoss) {
		this.stopLoss = stopLoss;
	}

	public int getIdent() {
		return ident;
	}

	public void setIdent(int ident) {
		this.ident = ident;
	}
	
	
	
}
