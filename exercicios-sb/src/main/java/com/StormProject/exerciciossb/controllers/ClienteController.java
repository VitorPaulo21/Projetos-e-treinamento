package com.StormProject.exerciciossb.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.StormProject.exerciciossb.model.Entities.Cliente;

@RestController
public class ClienteController {

	@GetMapping("/clientes/all")
	private Cliente cliente() {
		
		return new Cliente(32, "paulo", "14233434686");
		
	}
	
}
