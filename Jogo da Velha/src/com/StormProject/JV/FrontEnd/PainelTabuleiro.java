package com.StormProject.JV.FrontEnd;

import java.awt.Dimension;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.util.ArrayList;

import javax.swing.BorderFactory;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

import com.StormProject.JV.BackEnd.Area;
import com.StormProject.JV.BackEnd.Events;
import com.StormProject.JV.BackEnd.Tabuleiro;
import com.StormProject.JV.BackEnd.TabuleiroListenner;
import com.StormProject.JV.BackEnd.Usuario;

@SuppressWarnings("serial")
public class PainelTabuleiro extends JPanel implements CaixinhaListenner, TabuleiroListenner{

	ArrayList<PainelTabuleiroListenner> Observers = new ArrayList<>();
	boolean p1 = false;
	Tabuleiro tabuleiro;
	ArrayList<Usuario> list;
	public PainelTabuleiro(ArrayList<Usuario> list) {
		this.list = list;
		GridLayout lay = new GridLayout(3, 3);
		lay.minimumLayoutSize(this);
		setLayout(lay);
		setBounds(0, 0, 200, 200);
		setSize(200, 200);
		setBorder(BorderFactory.createTitledBorder("hey"));
		tabuleiro = new Tabuleiro();
		tabuleiro.notifyMe(this);
		tabuleiro.getCampos().forEach(o -> {
			
			this.add(o.getCaixaVIew());
			o.getCaixaVIew().notifyMe(this);
		});
		
		
		
	}

	@Override
	public void eventListenner(Events event, Area area) {
		if (event == Events.CLICKED) {
			
			if (p1) {
				tabuleiro.getCampos().stream()
				.filter(a -> a.getLinha() == area.getLinha() &&
				a.getColuna() == area.getColuna())
				.filter(c -> c.isNull())
				.findFirst()
				.ifPresent(a -> {
					
					tabuleiro.addCamp(area.getLinha(), area.getColuna(),
							list.get(1).getCamp().getUser());
					p1 = false;
					
				});
			} else {
				tabuleiro.getCampos().stream()
				.filter(a -> a.getLinha() == area.getLinha() &&
						a.getColuna() == area.getColuna())
				.filter(c -> c.isNull())
				.findFirst()
				.ifPresent(a -> {
					
					tabuleiro.addCamp(area.getLinha(), area.getColuna(),
							list.get(0).getCamp().getUser());
					p1 = true;
					
				});
			}
			
		}
		
	}

	public void notifyMe(PainelTabuleiroListenner listenner) {
		
		Observers.add(listenner);
		
	}
	
	public void throwEvent(Events event) {
		
		Observers.forEach(o -> o.closeListenner(event));
		
	}
	
	public Integer showDialog (String txt) {
		Object[] choices = {"Sim", "Não"};
		Object defaultChoice = choices[0];
//		JOptionPane pane = new JOptionPane();
		
		return JOptionPane.showOptionDialog(null,
				txt,
				"Alerta",
				JOptionPane.YES_NO_OPTION,
				JOptionPane.DEFAULT_OPTION,
				null,
				choices,
				defaultChoice);
		
	}
	
	@Override
	public void eventListenner(Events event) {
		
		
		if (event == Events.WIN) {
			
			int ch = showDialog(tabuleiro.getWinner().getNome() +
					" Venceu o Jogo\nDeseja Iniciar um novo jogo?");
			
			if (ch == 0) {
				
				tabuleiro.reset();
				
			}else {
				
				throwEvent(Events.CLOSE);
				
			}
			
		} else if (event == Events.VELHA) {
			int ch = showDialog("o jogo deu velha\nDeseja Iniciar um novo jogo?");
			
			if (ch == 0) {
				
				tabuleiro.reset();
				
			}else {
				
				throwEvent(Events.CLOSE);
				
			}
		} else if (event == Events.RESET) {
            throwEvent(Events.RESET);
		}
		
	}
}
