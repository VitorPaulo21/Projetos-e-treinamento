package com.StormProject.cm.Model;

import java.util.ArrayList;
import java.util.Random;
import java.util.function.Consumer;
import java.util.function.Predicate;

public class Tabuleiro implements CampoListener{

	private int colunas;
	private int linhas;
	private int qtdMinas;

	private final ArrayList<Campo> campos = new ArrayList<Campo>();
	private ArrayList<Consumer<Boolean>> listenners = new ArrayList<>();

	public Tabuleiro(int linhas, int colunas, int qtdMinas) {
		this.colunas = colunas;
		this.linhas = linhas;
		this.qtdMinas = qtdMinas;

		gerarCampos();
		associarVizinhos();
		gerarMinas();
	}
	
	public void notifyMe(Consumer<Boolean> listenner) {
		
		if (listenner == null) {
			return;
		}
		listenners.add(listenner);
	};			
	public void abrir (int linha, int coluna) {
		campos.parallelStream()
		.filter(c -> c.getLinha() == linha && c.getColuna() == coluna)
		.findFirst()
		.ifPresent(c -> c.abrir());
		
	}
	public void closeAll (int linha, int coluna) {
		campos.parallelStream()
		.filter(c -> c.getLinha() == linha && c.getColuna() == coluna)
		.findFirst()
		.ifPresent(c -> {
			
			c.setAberto(false);
			c.alternarMarcacao();
		});
		
		campos.parallelStream()
		.filter(c -> c.isaberto() && c.isMinado())
		.forEach(c -> c.setAberto(false));;
	}
	
	public void rest1() {
		
		campos.parallelStream()
		.filter(c -> !c.isMinado() && !(c.getLinha() == 0 && c.getColuna() ==0))
		.forEach(c -> c.setAberto(true));
		
		campos.parallelStream()
		.filter(c -> c.isMinado())
		.forEach(c -> c.alternarMarcacao());
		
	}
	
	public void alternarMarcacao (int linha, int coluna) {
		campos.parallelStream()
		.filter(c -> c.getLinha() == linha && c.getColuna() == coluna)
		.findFirst()
		.ifPresent(c -> c.alternarMarcacao());
		
	}

	public void alternarSuspeita (int linha, int coluna) {
		campos.parallelStream()
		.filter(c -> c.getLinha() == linha && c.getColuna() == coluna)
		.findFirst()
		.ifPresent(c -> c.alterarSuspeita());
		
	}
	
	public void openAllBombs () {
		campos.parallelStream()
		.filter(c -> c.isMinado())
		.filter(c -> !c.isMarcado())
		.forEach(c -> c.open());
		
	}
	
	private void gerarCampos() {

		for (int i = 0; i < linhas; i++) {

			for (int j = 0; j < colunas; j++) {

				Campo campo = new Campo(i, j);
				campo.notifyMe(this);
				campos.add(campo);

			}
			
		}

	}

	private void associarVizinhos() {

		campos.forEach(c -> campos.forEach(v -> c.adicionarVizinho(v)));

	}

	private void gerarMinas() {

		int minasArmadas = 0;
		Random random = new Random();

		do {
			int aleatorio = 0;

			Predicate<Campo> mined = c -> c.isMinado();

			minasArmadas = (int) (campos.stream().filter(mined).count());

			aleatorio = random.nextInt(campos.size());

			campos.get(aleatorio).minar();

		} while (minasArmadas < qtdMinas - 1);

	}

	public ArrayList<Campo> getCampos() {
		return campos;
	}

	public boolean objetivoAlcancado() {

		return campos.stream().allMatch(c -> c.objetivoAlcancado2());

	}

	public void reset() {

		campos.stream().forEach(c -> c.reset());
		gerarMinas();
	}


	public void eventListenner(Boolean bool) {
		
		listenners.forEach(c -> c.accept(bool));
		
	}
	
	
	
	public int getColunas() {
		return colunas;
	}

	public int getLinhas() {
		return linhas;
	}

	@Override
	public void callEvent(Campo camp, Evento event) {
		// TODO Auto-generated method stub
		if (event == Evento.ABRIR || event == Evento.MARCAR || event == Evento.DESMARCAR) {
			
			 
			if (objetivoAlcancado()) {
				
				eventListenner(true);
				
			}
			
		}
		if (event == Evento.EXPLODIR) {
			openAllBombs();
			eventListenner(false);
		}
	}

	

	
	
}
