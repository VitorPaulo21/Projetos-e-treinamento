package com.StormProject.JV.BackEnd;

import java.util.ArrayList;

public class Campo {

	  int Linha;
	  int Coluna;
	  Usuario user;
	  
	  
	  ArrayList<Campo> Vizinhos = new ArrayList<Campo>();

	public Campo() {
		
		
	}

	public int getLinha() {
		return Linha;
	}

	public void setLinha(int linha) {
		Linha = linha;
	}

	public int getColuna() {
		return Coluna;
	}

	public void setColuna(int coluna) {
		Coluna = coluna;
	}

	public ArrayList<Campo> getVizinhos() {
		return Vizinhos;
	}

	public Usuario getUser() {
		return user;
	}

	public void setUser(Usuario user) {
		this.user = user;
	}
	  
	  
	
}
