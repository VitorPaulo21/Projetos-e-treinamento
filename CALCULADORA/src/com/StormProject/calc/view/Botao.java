package com.StormProject.calc.view;

import java.awt.Color;
import java.awt.Font;

import javax.swing.BorderFactory;
import javax.swing.JButton;

@SuppressWarnings("serial")
public class Botao extends JButton{

	
	public Botao(String txt, Color color) {
		
		setText(txt);
		setOpaque(true);
		setBackground(color);
		setForeground(Color.WHITE);
		setBorder(BorderFactory.createLineBorder(Color.black));
		
			
			setFont(new Font("courier", Font.PLAIN, 25));
			
		
		
		
	}
	
}
