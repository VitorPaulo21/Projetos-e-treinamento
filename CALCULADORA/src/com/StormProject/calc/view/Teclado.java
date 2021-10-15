package com.StormProject.calc.view;

import java.awt.Color;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.LayoutManager;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.function.BiFunction;
import java.util.function.Function;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JPanel;

import com.StormProject.calc.model.Memoria;

@SuppressWarnings("serial")
public class Teclado extends JPanel implements ActionListener{

	public Teclado() {
		final Color CinzaEsc =  new Color(67, 69, 71);
		final Color CinzaCl =  new Color(98, 100, 102);
		final Color Lrnj =  new Color(241, 161, 61);
		setBorder(BorderFactory.createLineBorder(Color.BLACK));
		GridBagLayout layout = new GridBagLayout();
		GridBagConstraints c = new GridBagConstraints();
		
		c.weightx = 1;
		c.weighty = 1;
		c.fill = GridBagConstraints.BOTH;
		setLayout(layout);
		
		//LINHA 1
		addButton("C", CinzaEsc, c, 0, 0);
		addButton("\u00B1", CinzaEsc, c, 1, 0);
		addButton("%", CinzaEsc, c, 2, 0);
		addButton("*", Lrnj, c, 3, 0);
		
		//LINHA 2
		addButton("7", CinzaCl, c, 0, 1);
		addButton("8", CinzaCl, c, 1, 1);
		addButton("9", CinzaCl, c, 2, 1);
		addButton("/", Lrnj, c, 3, 1);
		
		//LINHA 3
		addButton("4", CinzaCl, c, 0, 2);
		addButton("5", CinzaCl, c, 1, 2);
		addButton("6", CinzaCl, c, 2, 2);
		addButton("-", Lrnj, c, 3, 2);
		
		//LINHA 4
		addButton("1", CinzaCl, c, 0, 3);
		addButton("2", CinzaCl, c, 1, 3);
		addButton("3", CinzaCl, c, 2, 3);
		addButton("+", Lrnj, c, 3, 3);
		
		//LINHA 5
		c.gridwidth = 2;
		addButton("0", CinzaCl, c, 0, 4);
		c.gridwidth = 1;
		addButton(",", CinzaCl, c, 2, 4);
		addButton("=", Lrnj, c, 3, 4);
		
	}
	
	private void addButton(String txt, Color cor, GridBagConstraints cs, int x, int y) {
		
		Botao but = new Botao(txt, cor);
		cs.gridx = x;
		cs.gridy = y;
		but.addActionListener(this);
		add(but,cs);
		
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		
		if (e.getSource() instanceof JButton) {
			
			JButton botao = (JButton) e.getSource();
			Memoria.getInstancia().processCommand(botao.getText());;
			
		}
		
	}
	
}
