package com.SpringMongo.SpringMongo.Service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.SpringMongo.SpringMongo.Model.Ganho;
import com.SpringMongo.SpringMongo.Model.Ganhos;
import com.SpringMongo.SpringMongo.Model.Percents;
import com.SpringMongo.SpringMongo.Model.Stops;
import com.SpringMongo.SpringMongo.Model.Banca;
import com.SpringMongo.SpringMongo.Repository.BancaRepository;
import com.SpringMongo.SpringMongo.Repository.GanhosRepository;
import com.SpringMongo.SpringMongo.Repository.PercentsRepository;
import com.SpringMongo.SpringMongo.Repository.StopsRepository;
import com.SpringMongo.SpringMongo.Service.BancaService;

@Service
public class BancaServiceImpl implements BancaService{

	@Autowired
	BancaRepository bancaRepository;
	@Autowired
	PercentsRepository percentsRepository;
	@Autowired
    StopsRepository stopsRepository;
	@Autowired
	GanhosRepository ganhosRepository;
	
	
	@Override
	public Banca obterBanca() {
		return bancaRepository
				.findByIdent(1)
				.orElseThrow(() -> new IllegalArgumentException("Banca nao existe."));
	}

	@Override
	public Percents obterPercents() {
		return percentsRepository
				.findByIdent(1)
				.orElseThrow(() -> new IllegalArgumentException("Percent nao existe."));
	}

	@Override
	public Stops obterStops() {
		return stopsRepository
				.findByIdent(1)
				.orElseThrow(() -> new IllegalArgumentException("Stops nao existe."));
	}

	@Override
	public Ganhos obterGanhos(String data) {
		if (ganhosRepository
				.findByData(data).isPresent()) {
			
			return ganhosRepository
					.findByData(data).get();	
		} else {
			return null;
		}
	}

	@Override
	public void saveBanca(double inicial, double finall) {
		Banca banc = new Banca(inicial, finall);
		bancaRepository.findByIdent(1).ifPresent(b -> {
			
			banc.setId(b.getId());
			
		});
		bancaRepository.save(banc);
	}

	@Override
	public void savePercent(double toInv, double payout) {
		
		Percents percents = new Percents(payout, toInv);
		percentsRepository.findByIdent(1).ifPresent(b -> {
			
			percents.setId(b.getId());
			
		});
		percentsRepository.save(percents);
		
	}

	@Override
	public void saveStops(double stopgain, double stopLoss) {
		
		Stops stops = new Stops(stopgain, stopLoss);
        stopsRepository.findByIdent(1).ifPresent(b -> {
			
			stops.setId(b.getId());
			
		});
		stopsRepository.save(stops);
		
	}

	@Override
	public void saveGanhos(String data, double valor) {
		
		Ganho ganho = new Ganho(data, valor);
		if (ganhosRepository.findByData(data).isPresent()) {
			Ganhos ganhos = ganhosRepository.findByData(data).get();
			ganhos.getGanhos().add(ganho);
			ganhosRepository.save(ganhos);
			
		} else {
			
			Ganhos ganhos = new Ganhos(data);
			ganhos.getGanhos().add(ganho);
			ganhosRepository.save(ganhos);
			
		}
		
	}

}
