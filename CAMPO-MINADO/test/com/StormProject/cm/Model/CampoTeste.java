package com.StormProject.cm.Model;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class CampoTeste {

	private Campo campo;
	@BeforeEach
	void iniciarcampo () {
		
		campo = new Campo(3,3);
		
	}
	
	@Test
	void test() {
		
		Campo vizinho = new Campo(3,3);
		 
		boolean test = campo.adicionarVizinho(vizinho);
		
		assertFalse(test);
				}

	@Test
	void openTest () {
		
		Campo vizinho31 = new Campo(3,1);
		Campo vizinho41 = new Campo(4,1);
		Campo vizinho22 = new Campo(2,2);
		
		vizinho41.minar();
		vizinho31.adicionarVizinho(vizinho41);
		vizinho22.adicionarVizinho(vizinho31);
		
		campo.adicionarVizinho(vizinho22);
		
		campo.abrir();
		
		assertTrue((vizinho31.isaberto()) && !vizinho41.isaberto() );
		
	}
	
	@Test
	void counter () {
		
		Campo v1 = new Campo(3,2);
		Campo v2 = new Campo(3,4);
		Campo v3 = new Campo(4,3);
		Campo v4 = new Campo(2,3);
		Campo v5 = new Campo(2,2);
		
		List<Campo> camps = Arrays.asList(v1, v2, v3, v4, v5);
		
		camps.stream().forEach(v -> campo.adicionarVizinho(v));
		
		//campo.getVizinhos().stream().forEach(v -> System.out.println(v.getLinha() + ", " + v.getColuna()));
		
		assertTrue(campo.getVizinhos().size() == 5);
		
	}
	
	@Test
	void StringCollor () {
		
		Campo v1 = new Campo(2,2);
		Campo v2 = new Campo(2,3);
		Campo v3 = new Campo(2,4);
		Campo v4 = new Campo(3,2);
		Campo v5 = new Campo(3,4);
		Campo v6 = new Campo(4,2);
		Campo v7 = new Campo(4,3);
		Campo v8 = new Campo(4,4);
		
		v1.minar();
		v2.minar();
		v3.minar();
		v4.minar();
		v5.minar();
		v6.minar();
		v7.minar();
		v8.minar();
		
		List<Campo> camps = Arrays.asList(v1, v2, v3, v4, v5, v6, v7, v8);
		
		boolean result = camps.stream().allMatch(v -> campo.adicionarVizinho(v));
		
//		campo.abrir();
		campo.alternarMarcacao();
		
//		System.out.println(campo.getVizinhos().size() + ": vizinhos " 
//		+ Long.toString(campo.minasNaVizinhanca()) + ": Minas Vizinhas");
//		System.out.println(campo);
		
		assertTrue(result);
		
		
		
	}
	
}
