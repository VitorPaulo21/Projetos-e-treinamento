package com.StormProject.cm.View;

import java.util.function.Consumer;

import javax.swing.JFrame;

import com.StormProject.cm.Model.Tabuleiro;

@SuppressWarnings("serial")
public class TelaPrincipal extends JFrame{

	PainelTabuleiro paine;
	
	public TelaPrincipal() {
		Tabuleiro tabuleiro = new Tabuleiro(27, 40, 100);
		paine = new PainelTabuleiro(tabuleiro);
		
		add(paine);
		
		setTitle("Campo Minado");
		
		setSize(getMaximumSize());
		setExtendedState(MAXIMIZED_BOTH);
		setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		setVisible(true);
		
		Consumer<Boolean> eventListenner = e -> {
			
			if (e) {
				
			} else {

				dispose();
				
			}
			
		};
		
		paine.notifyMe(eventListenner);
		
		
	}
	
	
	
	public static void main(String[] args) {
		
		new TelaPrincipal();
		
		
	}
	
}
