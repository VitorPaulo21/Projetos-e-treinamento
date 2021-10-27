package com.SpringMongo.SpringMongo.Service;

import com.SpringMongo.SpringMongo.Model.Ganhos;
import com.SpringMongo.SpringMongo.Model.Percents;
import com.SpringMongo.SpringMongo.Model.Stops;
import com.SpringMongo.SpringMongo.Model.Banca;

public interface BancaService {

	public Banca obterBanca();
	
	public Percents obterPercents();
	
	public Stops obterStops();
	
	public Ganhos obterGanhos(String data);
	
	public void saveBanca(double inicial, double finall);
	
	public void savePercent(double toInv, double payout);
	
	public void saveStops(double stopgain, double stopLoss);
	
	public void saveGanhos(String data, double valor);
}
