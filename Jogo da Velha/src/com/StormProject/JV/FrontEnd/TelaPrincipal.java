package com.StormProject.JV.FrontEnd;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.util.ArrayList;

import javax.swing.JFrame;

import com.StormProject.JV.BackEnd.Events;
import com.StormProject.JV.BackEnd.Usuario;

@SuppressWarnings("serial")
public class TelaPrincipal extends JFrame implements LoginListenner, PainelTabuleiroListenner{

	PainelTabuleiro tabuleiro;
	Login login;
	PainelTabuleiro painel;
	Users usere;
	ArrayList<Usuario> list;
	public TelaPrincipal() {
		
		login = new Login();
		
		login.notifyMe(this);
		
		setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		setSize(new Dimension(600,320));
		setLayout(new FlowLayout());
		setLocationRelativeTo(null);
		
//		loginListenner(Events.LOGGED, null);
		add(login);
		
		setVisible(true);
	}
	
	public TelaPrincipal(Users usere) {
		
		this.usere = usere;
		login = new Login();
		
		login.notifyMe(this);
		
		setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		setSize(new Dimension(600,320));
		setLayout(new FlowLayout());
		setLocationRelativeTo(null);
		
//		loginListenner(Events.LOGGED, null);
		if (usere.isNull()) {
			add(login);
			
		}else {
			
			loginListenner(Events.LOGGED, usere.list);
			
		}
		
		setVisible(true);
	}
	
	
	
	public static void main(String[] args) {
		
		new TelaPrincipal();
		
	}

	PainelTabuleiroListenner tabul = this;
	
	@Override
	public void loginListenner(Events event, ArrayList<Usuario> list) {
		if (event == Events.LOGGED) {
			this.list = list;
			usere = new Users(this.list);
			remove(login);
			setVisible(false);
			
			tabuleiro = new PainelTabuleiro(list);
			tabuleiro.notifyMe(tabul);
			setSize(new Dimension(200,200));
			setMaximumSize(new Dimension(200,200));
			setResizable(false);
//			setBounds(1, 1, 200, 200);
			setLayout(new BorderLayout());
			setLocationRelativeTo(null);
			add(tabuleiro);
			setVisible(true);
			
		}
		
	}

	@Override
	public void closeListenner(Events event) {

		if (event == Events.CLOSE) {
			dispose();
		} else if (event == Events.RESET) {
			
			
			new TelaPrincipal(usere);
			dispose();
		}
		
	}

	
	
}
