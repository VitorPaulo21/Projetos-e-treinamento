package com.SpringMongo.SpringMongo.Controller;

import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.net.URLEncoder;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.SpringMongo.SpringMongo.Model.Ganhos;
import com.SpringMongo.SpringMongo.Model.Percents;
import com.SpringMongo.SpringMongo.Model.Stops;
import com.SpringMongo.SpringMongo.Model.Banca;
import com.SpringMongo.SpringMongo.Service.BancaService;

@RestController
@RequestMapping("inv")
public class BancaController {

	@Autowired
	BancaService bancaService;
	
	@GetMapping("getBanca")
	public Banca getBacna() {
		
		return bancaService.obterBanca();
		
	}
	@GetMapping("getPercent")
	public Percents getPercent() {
		
		return bancaService.obterPercents();
		
	}
	@GetMapping("getStops")
	public Stops getStops() {
		
		return bancaService.obterStops();
		
	}
	@GetMapping("getGanhos/{data}")
	public Ganhos getBacna(@PathVariable String data) {
		data = data.replace("-", "/");
		return bancaService.obterGanhos(data);
		
	}
	
	@PostMapping("saveBanca")
	public void saveBanca(@RequestParam("inicial") double inicial,
			@RequestParam("finall") double finall) {
		
		bancaService.saveBanca(inicial, finall);
		
	}
	
	@PostMapping("savePercent")
	public void savePercent(@RequestParam("toInv") double toInv,
			@RequestParam("payout") double payout) {
		
		bancaService.savePercent(toInv, payout);
		
	}
	
	@PostMapping("saveStops")
	public void saveStops(@RequestParam("stopLoss") double stopLoss,
			@RequestParam("stopGain") double stopGain) {
		
		bancaService.saveStops(stopGain, stopLoss);
		
	}
	
	@PostMapping("saveGanho")
	public void saveGanho(@RequestParam("data") String data,
			@RequestParam("valor") double valor) {
		
		try {
			bancaService.saveGanhos(URLDecoder.decode(data, "UTF-8"), valor);
		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
}
