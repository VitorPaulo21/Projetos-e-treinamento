package exercicios_jpa.modelo.basico;

import javax.persistence.*;

@Entity
@Table(name = "Produtos")
public class Produto implements Infra.Entity{

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(name = "prod_name", length = 300, nullable = false)
	private String nome;
	
	@Column(name = "prod_price", nullable = false, precision = 11, scale = 2)
	private Double preco;
	
	public Produto() {
		
		
	}

	public Produto(String nome, Double preco) {
		super();
		this.nome = nome;
		this.preco = preco;
	}

	public Produto(Long id, String nome, Double preco) {
		super();
		this.id = id;
		this.nome = nome;
		this.preco = preco;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public Double getPreco() {
		return preco;
	}

	public void setPreco(Double preco) {
		this.preco = preco;
	}
	
	
	
}
