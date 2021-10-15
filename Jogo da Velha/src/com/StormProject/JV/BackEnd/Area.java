package com.StormProject.JV.BackEnd;

import java.util.ArrayList;

import com.StormProject.JV.FrontEnd.Caixinha;

public class Area {

	private Campo camp;
	private final Caixinha CaixaVIew = new Caixinha(this);

	private int Linha;
	private int Coluna;
	private final Tabuleiro tabuleiro;

	
	ArrayList<AreaListenner> Observers2 = new ArrayList<>();
	
	
	public Area(int linha, int coluna, Tabuleiro tabul) {
		Linha = linha;
		Coluna = coluna;
		tabuleiro = tabul;
		
	}

	public void notifyMe(AreaListenner listenner) {
		if (listenner == null) {
			return;
		}
		Observers2.add(listenner);
		
	}
	
	public void notifyEvent(Events event) {
		
//		Observers2.forEach(o -> o.eventListenner(event));
		CaixaVIew.eventListenner(event);
		
	}
	
	public boolean isNull() {

		if (camp == null) {

			return true;

		} else {

			return false;

		}

	}

	public Campo getCamp() {
		return camp;
	}

	public Area setCamp(Campo camp) {
		if (camp == null) {
			return null;
		}
		this.camp = camp;

		if (!isNull()) {

			notifyEvent(Events.CAMP_ADDED);
			
		}

		return this;
	}

	public int getLinha() {
		return Linha;
	}

	public int getColuna() {
		return Coluna;
	}

	public Caixinha getCaixaVIew() {
		return CaixaVIew;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + Coluna;
		result = prime * result + Linha;
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Area other = (Area) obj;
		if (Coluna != other.Coluna)
			return false;
		if (Linha != other.Linha)
			return false;
		return true;
	}

	

	

}
