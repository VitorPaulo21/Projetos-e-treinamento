package com.StormProject.JV.BackEnd;

public class Usuario {

	private String nome;
	private Campo camp;
	public Usuario(String nome, Campo camp) {
		
		this.nome = nome;
		this.camp = camp;
		camp.setUser(this);
	}
	public Usuario() {
		
	}
	
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public Campo getCamp() {
		return camp;
	}
	
	public boolean isLogged() {
		
		return nome != null && camp != null;
		
	}
	@Override
	public String toString() {
		return  nome;
	}
	
}
