package exercicios_jpa.modelo.herança;

import javax.persistence.Entity;

@Entity
public class ferrary extends Carro{

	private String nome;
	
	private String marca;
	
	private String modelo;
	
	private String cor;
	
	private boolean turbo;


	public ferrary() {
	}

	public ferrary(String combustivel, String placa, int qtdAcentos, int numPortas, int potencia,
			double aceleracao,
			String nome, String marca, String modelo, String cor, boolean turbo) {
		super(combustivel, placa, qtdAcentos, numPortas, potencia, aceleracao);
		this.nome = nome;
		this.marca = marca;
		this.modelo = modelo;
		this.cor = cor;
		this.turbo = turbo;
	}

	public boolean isTurbo() {
		return turbo;
	}

	public void setTurbo(boolean turbo) {
		this.turbo = turbo;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getMarca() {
		return marca;
	}

	public void setMarca(String marca) {
		this.marca = marca;
	}

	public String getModelo() {
		return modelo;
	}

	public void setModelo(String modelo) {
		this.modelo = modelo;
	}

	public String getCor() {
		return cor;
	}

	public void setCor(String cor) {
		this.cor = cor;
	}
	
}
