package exercicios_jpa.modelo.herança;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;

@Entity
@Inheritance(strategy = InheritanceType.JOINED)
public class Carro {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int ID;
	
	private String combustivel;
	
	private String Placa;
	
	private int qtdAcentos;
	
	private int numPortas;
	
	private int potencia;
	
	private double aceleracao;
	
	protected Carro() {
	}

	public Carro(String combustivel, String placa, int qtdAcentos, int numPortas, int potencia, double aceleracao
			) {
		super();
		this.combustivel = combustivel;
		Placa = placa;
		this.qtdAcentos = qtdAcentos;
		this.numPortas = numPortas;
		this.potencia = potencia;
		this.aceleracao = aceleracao;
		
	}

	public int getID() {
		return ID;
	}

	public void setID(int iD) {
		ID = iD;
	}

	public String getCombustivel() {
		return combustivel;
	}

	public void setCombustivel(String combustivel) {
		this.combustivel = combustivel;
	}

	public String getPlaca() {
		return Placa;
	}

	public void setPlaca(String placa) {
		Placa = placa;
	}

	public int getQtdAcentos() {
		return qtdAcentos;
	}

	public void setQtdAcentos(int qtdAcentos) {
		this.qtdAcentos = qtdAcentos;
	}

	public int getNumPortas() {
		return numPortas;
	}

	public void setNumPortas(int numPortas) {
		this.numPortas = numPortas;
	}

	public int getPotencia() {
		return potencia;
	}

	public void setPotencia(int potencia) {
		this.potencia = potencia;
	}

	public double getAceleracao() {
		return aceleracao;
	}

	public void setAceleracao(double aceleracao) {
		this.aceleracao = aceleracao;
	}


	
	
}
