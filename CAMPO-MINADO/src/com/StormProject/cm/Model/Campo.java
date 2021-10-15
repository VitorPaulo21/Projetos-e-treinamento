package com.StormProject.cm.Model;

import java.util.ArrayList;


public class Campo implements CampoListener{

	private final int linha;
	private final int coluna;
	
	private boolean aberto = false;
	private boolean minado = false;
	private boolean marcado = false;
	private boolean suspeita = false;
	
	private ArrayList<Campo> vizinhos = new ArrayList<Campo>();
	private ArrayList<CampoListener> listenners = new ArrayList<>();

	 Campo(int linha, int coluna) {
		this.linha = linha;
		this.coluna = coluna;
	}
	 
	 //METHODS
	 
		 //PUBLIC
	 public void alterarSuspeita() {
		 
		 suspeita = !suspeita;
		 eventListenner(this, Evento.SUSPEITA);
		 
	 }

	 public void notifyMe(CampoListener toAdd) {
		 
		 if (toAdd == null) {
			 return;
		}
		 
		listenners.add(toAdd); 
	 }
	 
	 

		 //PACKAGE
		 
			    void open() {
				 
				 aberto = true;
				 
				 if (aberto ) {
					
					 eventListenner(this, Evento.ABRIR);
					 
				} 
				
				 
			 }

				boolean adicionarVizinho (Campo vizinho) {
					
					boolean difLinha = linha != vizinho.linha;
					boolean difColuna = coluna != vizinho.coluna;
					boolean diagonal = difLinha && difColuna;
					
					int deltaLinha = Math.abs(linha - vizinho.linha);
					int deltaColuna = Math.abs(coluna - vizinho.coluna);
					int deltaGeral = deltaLinha + deltaColuna;
					
					if ( deltaGeral == 1 && !diagonal ){
						
						vizinhos.add(vizinho);
						return true;
						
					} else if ( deltaGeral == 2 && diagonal ){
						
						vizinhos.add(vizinho);
						return true;
						
					} else {
						
						return false;
						
					}
					
					
				}

				public void alternarMarcacao () {
					
					if (!aberto) {
						
						marcado = !marcado;
						
					}
					
					if (marcado) {
						
						eventListenner(this, Evento.MARCAR);
						
					} else if (!marcado && !aberto) {
						
						eventListenner(this, Evento.DESMARCAR);
					}
				}

				public boolean abrir () {
					
					if (!aberto && !marcado) {
						
						
						if (minado ) {
							
							open();
							eventListenner(this, Evento.EXPLODIR);
							return false;
						}
						
						open();
						if (vizinhancaSegura()) {
							
							vizinhos.forEach(v -> v.abrir());
							
						}
						
						return true;
						
					} else {
						
						return false;
						
					}
					
				}
				
				boolean vizinhancaSegura() {
					
					return vizinhos.stream().noneMatch(v -> v.minado);
					
				}

				void minar () {
					
					minado = true;
					
				}
				

				boolean objetivoAlcancado2 () {
					
					boolean desvendado = !minado && aberto;
					boolean protegido = minado && marcado;
					
					return desvendado || protegido;
					
				}
				
				void reset () {
					
					aberto =false;
					marcado = false;
					minado = false;
					eventListenner(this, Evento.FECHADO);
					eventListenner(this, Evento.DESMARCAR);
				}

		 //PRIVATE
		 
				public  long minasNaVizinhanca() {
					
					return vizinhos.stream().filter(v -> v.minado).count();
					
				}

				private void eventListenner(Campo camp, Evento event) {
					 
					 listenners.forEach(c -> c.callEvent(camp, event));
					 
				 }
	 
	 
	 
	 
	 

	 //LISTENNERS
				@Override
				public void callEvent(Campo camp, Evento event) {
					
				}

	 //GETTERS & SETTERS
				public ArrayList<Campo> getVizinhos() {
					return vizinhos;
				}

				public boolean isMarcado() {
					
					return marcado;
					
				}

				public boolean isaberto() {
					
					return aberto;
					
				}

				public int getLinha() {
					return linha;
				}

				public int getColuna() {
					return coluna;
				}
				
				public boolean isMinado() {
					return minado;
				}
				
				public void setAberto(boolean aberto) {
					this.aberto = aberto;
				}

				
	 //TOSTRING
	 
	 //EQUALS & HASHCODE
	 
				public boolean isSuspeita() {
					return suspeita;
				}

				@Override
				public int hashCode() {
					final int prime = 31;
					int result = 1;
					result = prime * result + coluna;
					result = prime * result + linha;
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
					Campo other = (Campo) obj;
					if (coluna != other.coluna)
						return false;
					if (linha != other.linha)
						return false;
					return true;
				}

	
	
		
	
	


	

	
	
}
