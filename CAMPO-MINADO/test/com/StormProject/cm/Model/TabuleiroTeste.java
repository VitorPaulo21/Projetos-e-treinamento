package com.StormProject.cm.Model;

import static org.junit.jupiter.api.Assertions.*;

import java.util.Random;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class TabuleiroTeste {

	Tabuleiro tab;
	
	@BeforeEach
	void gerarTabuleiro() {
		
		tab = new Tabuleiro(100, 100, 100);
		
	}
	
	@Test
	void test() {
		
		int minados = (int) tab.getCampos().stream().filter(c -> c.isMinado()).count();
		
		tab.getCampos().stream().filter(c -> c.isMinado()).map(c -> c.getLinha() 
				+ "," + c.getColuna() + ": " + tab.getCampos().indexOf(c)).forEach(System.out::println);
		
		assertTrue(minados == 100);
		
	}

}
