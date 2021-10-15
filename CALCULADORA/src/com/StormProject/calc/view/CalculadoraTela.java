package com.StormProject.calc.view;

import java.awt.BorderLayout;
import java.awt.Dimension;

import javax.swing.JFrame;

@SuppressWarnings("serial")
public class CalculadoraTela extends JFrame{

	public CalculadoraTela() {
		
		organizarLayout();
		
		setSize(232,322);
		setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		setResizable(false);
		
		setLocationRelativeTo(null);
		setTitle("Calculadora");
		setVisible(true);
	}
	
	
	private void organizarLayout() {
		
		setLayout(new BorderLayout());
		
		Display display = new Display();
		display.setPreferredSize(new Dimension(233,60));
		Teclado teclado = new Teclado();
		add(display, BorderLayout.NORTH);
		add(teclado, BorderLayout.CENTER);
		
	}


	public static void main(String[] args) {
		
		new CalculadoraTela();
		
	}
}
