package com.StormProject.cm.View;

import java.awt.Color;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.BorderFactory;
import javax.swing.Icon;
import javax.swing.JButton;
import javax.swing.plaf.basic.BasicIconFactory;

import com.StormProject.cm.Model.Campo;
import com.StormProject.cm.Model.CampoListener;
import com.StormProject.cm.Model.Evento;

@SuppressWarnings("serial")
public class BotaoCampo extends JButton implements CampoListener, MouseListener {

	private final Color BG_PADRAO = new Color(184, 184, 184);
	private final Color BG_MARCAR = new Color(8, 179, 247);
	private final Color BG_EXPLODIR = new Color(189, 66, 68);
	private final Color BG_TEXTOVERDE = new Color(0, 100, 0);
	private Campo campo;
	
	public BotaoCampo(Campo campo) {

		setBackground(BG_PADRAO);
		setBorder(BorderFactory.createBevelBorder(0));
		this.campo = campo;
		campo.notifyMe(this);
		addMouseListener(this);
	}

	@Override
	public void callEvent(Campo camp, Evento event) {

		switch (event) {
		case ABRIR:
			putOpenStyle();
			break;
		case MARCAR:
			putMarkStyle();
			break;
		case DESMARCAR:
			putDefaultStyle();
			break;
		case EXPLODIR:
			putExplosionStyle();
			break;
		case SUSPEITA:
			putSuspeitaStyle();
			break;
		default:
			putDefaultStyle();
		}

	}

	private void putSuspeitaStyle() {
		
		setBackground(Color.YELLOW);
		setBorder(BorderFactory.createBevelBorder(0));
		setForeground(Color.RED);
		setText("?");
		
	}

	private void putDefaultStyle() {
		
		setBackground(BG_PADRAO);
		setBorder(BorderFactory.createBevelBorder(0));
		setText("");
	}

	private void putExplosionStyle() {

		setBackground(BG_EXPLODIR);
		setForeground(Color.WHITE);
		setText("X");
		
	}


	private void putMarkStyle() {
		
		setBackground(BG_MARCAR);
		setForeground(Color.BLACK);
		setText("O");

	}

	private void putOpenStyle() {
		// TODO Auto-generated method stub

		if (campo.isMinado()) {
			
			setBackground(BG_EXPLODIR);
			setText("*");
			setForeground(Color.WHITE);
			return;
			
		}
		
		setBackground(BG_PADRAO);
		setBorder(BorderFactory.createLineBorder(Color.GRAY));
		
		switch ((int) campo.minasNaVizinhanca()) {
		case 0:
//			setText("");
			break;
		case 1: {
			setForeground(BG_TEXTOVERDE);
			setText(Long.toString(campo.minasNaVizinhanca()));
			break;
		}
		case 2: {
			setForeground(Color.BLUE);
			setText(Long.toString(campo.minasNaVizinhanca()));
			break;
		}
		case 3: {
			setForeground(Color.RED);
			setText(Long.toString(campo.minasNaVizinhanca()));
			break;
		}
		case 4: {
			setForeground(new Color(150, 0 ,205));
			setText(Long.toString(campo.minasNaVizinhanca()));
			break;
		}
		case 5: {
			setForeground(new Color(255,131,0));
			setText(Long.toString(campo.minasNaVizinhanca()));
			break;
		}
		default:
			setForeground(Color.PINK);
			setText(Long.toString(campo.minasNaVizinhanca()));
			
		}
		
		
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mousePressed(MouseEvent e) {
		
		if (e.getButton() == 1) {
			
			campo.abrir();
			
		} else {
			if (!campo.isMarcado()) {
				
				campo.alternarMarcacao();
				
				
			} else if (campo.isMarcado() && !campo.isSuspeita()) {
				campo.alterarSuspeita();
				
			} else {
				
				campo.alterarSuspeita();
				campo.alternarMarcacao();
			}
			
		}
		
		
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

}
