package exercicios_jpa.modelo.herança;

import javax.persistence.Entity;

@Entity
public class Buggaty extends Carro {

	private String nome;

	private String marca;

	private String modelo;

	private String cor;

	private boolean aerofolio;

	public Buggaty() {
	}

	public Buggaty(String combustivel, String placa, int qtdAcentos, int numPortas, int potencia, double aceleracao,
			String nome, String marca, String modelo, String cor, boolean aerofolio) {
		super(combustivel, placa, qtdAcentos, numPortas, potencia, aceleracao);
		this.nome = nome;
		this.marca = marca;
		this.modelo = modelo;
		this.cor = cor;
		this.aerofolio = aerofolio;
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

	public boolean isAerofolio() {
		return aerofolio;
	}

	public void setAerofolio(boolean aerofolio) {
		this.aerofolio = aerofolio;
	}

}
