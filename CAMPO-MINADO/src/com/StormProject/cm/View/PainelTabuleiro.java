package com.StormProject.cm.View;

import java.awt.GridLayout;
import java.util.ArrayList;
import java.util.function.Consumer;

import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;

import com.StormProject.cm.Model.Tabuleiro;

@SuppressWarnings("serial")
public class PainelTabuleiro extends JPanel{
	
	ArrayList<Consumer<Boolean>> listenners = new ArrayList<Consumer<Boolean>>();
	
	public void notifyMe(Consumer<Boolean> bool) {
		
		if (bool == null) {
			return;
		}
		
		listenners.add(bool);
		
	}
	
	public void addEventListenner(Boolean bool) {
		
		listenners.forEach(e -> e.accept(bool));
		
	}

	public PainelTabuleiro(Tabuleiro tabuleiro) {
		
		setLayout(new GridLayout(tabuleiro.getLinhas(), tabuleiro.getColunas()));
		
		tabuleiro.getCampos().forEach(c -> add(new BotaoCampo(c)));
		
		tabuleiro.notifyMe(e -> {
			
			Object[] choices = {"Sim", "Nao"};
			Object defaultChoice = choices[0];
			SwingUtilities.invokeLater(() -> {
				
				if (e.booleanValue()) {
					JOptionPane pane = new JOptionPane();
					int opt = pane.showOptionDialog(this,
							"Voce venceu!!!\nDeseja Iniciar um novo Jogo?",
							"Venceu", JOptionPane.YES_NO_OPTION,
							JOptionPane.QUESTION_MESSAGE, null, choices, defaultChoice);
					
					if (opt == JOptionPane.OK_OPTION) {
						tabuleiro.reset();
					} else {
						addEventListenner(false);
					}
					
				} else {
					
					JOptionPane pane = new JOptionPane();
					int opt = pane.showOptionDialog(this,
							"Voce Perdeu!!!\nDeseja Iniciar um novo Jogo?",
							"Perdeu", JOptionPane.YES_NO_OPTION,
							JOptionPane.QUESTION_MESSAGE, null, choices, defaultChoice);
					
					if (opt == JOptionPane.OK_OPTION) {
						tabuleiro.reset();
					} else {
						addEventListenner(false);
					}
					
					
				}
				
			});
			
		});
	}
	
}
