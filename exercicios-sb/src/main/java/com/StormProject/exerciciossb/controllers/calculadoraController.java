package com.StormProject.exerciciossb.controllers;

import javax.websocket.server.PathParam;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class calculadoraController {

	@GetMapping("/soma/{a}/{b}")
	public Integer soma(@PathVariable int a, @PathVariable int b) {
		return a+b;
		
	}
	
	@GetMapping("/subtrair")
	private Integer subtracao(@RequestParam(name = "a", defaultValue = "0", required = true) int a
			,@RequestParam(name = "b", defaultValue = "0", required = true) int b) {
		
		
		return a-b;
	}
	
}
