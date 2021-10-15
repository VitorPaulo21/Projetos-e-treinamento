package com.StormProject.JV.BackEnd;

import java.util.ArrayList;
import java.util.function.BiFunction;


public class Tabuleiro {

	int numLinhas = 3;
	int numColunas = 3;
	Usuario winner;
	ArrayList<Area> Campos = new ArrayList<Area>();
	ArrayList<TabuleiroListenner> Observers = new ArrayList<>();

	public Tabuleiro() {

		gerarCampos();

	}

	public void notifyMe(TabuleiroListenner listenner) {
		
		Observers.add(listenner);
		
	}
	
	public void notifyEvent(Events event) {
		
		Observers.forEach(o -> o.eventListenner(event));
		
	}
	
	private void gerarCampos() {

		for (int i = 0; i < numLinhas; i++) {

			for (int j = 0; j < numColunas; j++) {

				Campos.add(new Area(i, j, this));

			}

		}

	}
	// Methods

	public boolean addCamp(int x, int y, Usuario user) {

		Area toAdd = Campos.stream()
				.filter(a -> a.getLinha() == x && a.getColuna() == y)
				.findFirst()
				.get();

		if (toAdd != null) {

			if (toAdd.isNull()) {

				toAdd.setCamp(user.getCamp());
				if (objCompleeted()) {
					
					notifyEvent(Events.WIN);
				} else if (isVelha()) {
					
					notifyEvent(Events.VELHA);
				}
				return true;
				
			} else {
				 
				return false;
			}

		} else {

			return false;

		}
	}

	public ArrayList<ArrayList<Area>> allInArray() {

		ArrayList<ArrayList<Area>> read = new ArrayList(3);
		ArrayList<Area> second = new ArrayList(3);

//		while (second.size()<3) {
//			
//			second.add(new Area(0,0));
//			
//		}

		while (read.size() < 3) {

			read.add(new ArrayList<Area>());

		}

		int count = 0;
		for (int i = 0; i < 3; i++) {

			for (int j = 0; j < 3; j++) {

				read.get(i).add(j, Campos.get(count));

				count++;
			}

//			read.set(i, second);
//			second.clear();
		}

		return read;
	}

	private boolean readLines() {

		boolean end = false;

		one: for (ArrayList<Area> buff : allInArray()) {

			ArrayList<Area> eql = new ArrayList();

			for (Area area : buff) {

				if (area.isNull()) {
					break;
				} else {

					if (eql.size() > 0) {

						if (area.getCamp().getClass() == eql.get(0).getCamp().getClass()) {

							eql.add(area);

						}

					} else {

						eql.add(area);

					}

				}

			}

			if (eql.size() == 3) {

				setWinner(eql.get(0).getCamp().getUser());
				end = true;
				break one;
			}
			eql.clear();
		}

		return end;

	}

	private boolean readColums() {
		boolean end = false;
		ArrayList<ArrayList<Area>> read = allInArray();

		for (int i = 0; i < 3; i++) {

			if (read.get(0).get(i).isNull() || read.get(1).get(i).isNull() || read.get(2).get(i).isNull()) {

				continue;

			} else {

				end = read.get(0).get(i).getCamp().getClass() == read.get(1).get(i).getCamp().getClass()
						&& read.get(1).get(i).getCamp().getClass() == read.get(2).get(i).getCamp().getClass();

				if (end) {

					setWinner(read.get(0).get(i).getCamp().getUser());
					break;

				}

			}

		}

		return end;
	}

	private boolean readDiagonal() {
		boolean end1 = false;
		boolean end2 = false;
		ArrayList<ArrayList<Area>> read = allInArray();

		if (read.get(0).get(0).isNull() || read.get(1).get(1).isNull() || read.get(2).get(2).isNull()) {

		} else {

			end1 = read.get(0).get(0).getCamp().getClass() == read.get(1).get(1).getCamp().getClass()
					&& read.get(1).get(1).getCamp().getClass() == read.get(2).get(2).getCamp().getClass();
		}

		if (read.get(0).get(2).isNull() || read.get(1).get(1).isNull() || read.get(2).get(0).isNull()) {

		} else {

			end2 = read.get(0).get(2).getCamp().getClass() == read.get(1).get(1).getCamp().getClass()
					&& read.get(1).get(1).getCamp().getClass() == read.get(2).get(0).getCamp().getClass();
		}

		if (end1) {

			setWinner(read.get(1).get(1).getCamp().getUser());

		} else if (end2) {

			setWinner(read.get(1).get(1).getCamp().getUser());

		}

		return end1 || end2;
	}

	public boolean objCompleeted() {

		return readColums() || readDiagonal() || readLines();

	}

	public boolean isVelha() {
		boolean end = Campos.stream().allMatch(a -> !a.isNull()) && !objCompleeted();

		return end;
	}

	// GETTERS AND SETTERS
	public ArrayList<Area> getCampos() {
		return Campos;
	}

	public void setWinner(Usuario userW) {

		winner = userW;

	}

	public Usuario getWinner() {

		return winner;
	}

	

	public void reset() {

		winner = null;
		Campos.clear();
		gerarCampos();
		
		notifyEvent(Events.RESET);

	}
}
