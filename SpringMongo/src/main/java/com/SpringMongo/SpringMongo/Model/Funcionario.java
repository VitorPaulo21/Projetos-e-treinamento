package com.SpringMongo.SpringMongo.Model;

import java.math.BigDecimal;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.Data;

@Data
@Document("Funcionarios")
public class Funcionario {

	@Id
	private String codico;
	
	private String nome;
	
	private Integer idade;
	
	private BigDecimal salario;
	
	@DBRef
	private Funcionario chefe;
	
	public Funcionario() {
	}

	public Funcionario(String nome, Integer idade, BigDecimal salario, Funcionario chefe) {
		super();
		this.nome = nome;
		this.idade = idade;
		this.salario = salario;
		this.chefe = chefe;
	}

	public String getCodico() {
		return codico;
	}

	public void setCodico(String codico) {
		this.codico = codico;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public Integer getIdade() {
		return idade;
	}

	public void setIdade(Integer idade) {
		this.idade = idade;
	}

	public BigDecimal getSalario() {
		return salario;
	}

	public void setSalario(BigDecimal salario) {
		this.salario = salario;
	}

	public Funcionario getChefe() {
		return chefe;
	}

	public void setChefe(Funcionario chefe) {
		this.chefe = chefe;
	}
	
	
	
	
	
}
