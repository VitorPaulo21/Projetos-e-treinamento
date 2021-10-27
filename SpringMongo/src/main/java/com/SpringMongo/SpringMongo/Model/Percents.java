package com.SpringMongo.SpringMongo.Model;

import org.springframework.data.annotation.Id;

import lombok.Data;

@Data
public class Percents {
	
	@Id
	private String id;
	
	private double payout;
	
	private int ident;
	
	private double toInvest;
	
	public Percents() {
		ident = 1;
	}

	public Percents(double payout, double toInvest) {
		super();
		this.payout = payout;
		this.toInvest = toInvest;
		ident = 1;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public double getPayout() {
		return payout;
	}

	public void setPayout(double payout) {
		this.payout = payout;
	}

	public double getToInvest() {
		return toInvest;
	}

	public void setToInvest(double toInvest) {
		this.toInvest = toInvest;
	}

	public int getIdent() {
		return ident;
	}

	public void setIdent(int ident) {
		this.ident = ident;
	}
	
	
	
}
