package com.StormProject.exerciciossb.model.Entities;

import org.springframework.web.bind.annotation.RestController;

public class Cliente {

	private int ID;

	private String nome;

	private String cpf;

	public Cliente(int iD, String nome, String cpf) {
		super();
		ID = iD;
		this.nome = nome;
		this.cpf = cpf;
	}

	public int getID() {
		return ID;
	}

	public void setID(int iD) {
		ID = iD;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

}
