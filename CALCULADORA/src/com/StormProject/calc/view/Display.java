package com.StormProject.calc.view;

import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.Label;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

import com.StormProject.calc.model.Memoria;
import com.StormProject.calc.model.MemoriaObserver;

@SuppressWarnings("serial")
public class Display extends JPanel implements MemoriaObserver{                 

	private final JLabel label;
	
	public Display() {
		setBackground(new Color(47,49,50));
		Memoria.getInstancia().notifyMe(this);
		label = new JLabel(Memoria.getInstancia().getTextoAtual());
		label.setForeground(Color.WHITE);
		label.setFont(new Font("courier", Font.PLAIN, 30));
		//TODO make the font bee smaller as you add more numbers
		setLayout(new FlowLayout(FlowLayout.RIGHT, 1, 25));
		
		add(label);
		
		
	}

@Override
public void valueChanged(String newvalue) {
	
	label.setText(newvalue);
	
}
	
}
