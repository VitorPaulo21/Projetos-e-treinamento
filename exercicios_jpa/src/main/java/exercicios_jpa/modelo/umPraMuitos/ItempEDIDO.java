package exercicios_jpa.modelo.umPraMuitos;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

import exercicios_jpa.modelo.basico.Produto;


@Entity
public class ItempEDIDO {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	
	@ManyToOne
	private pedido pedido;
	
	@ManyToOne
	private Produto produto;
	
	private int qtd;
	
	private Double preço;

	public ItempEDIDO() {
		// TODO Auto-generated constructor stub
	}
	
	
	
	public ItempEDIDO(exercicios_jpa.modelo.umPraMuitos.pedido pedido, Produto produto, int qtd) {
		super();
		this.pedido = pedido;
		this.setProduto(produto);
		this.qtd = qtd;
	}



	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public pedido getPedido() {
		return pedido;
	}

	public void setPedido(pedido pedido) {
		this.pedido = pedido;
	}

	public Produto getProduto() {
		return produto;
	}

	public void setProduto(Produto produto) {
		this.produto = produto;
		
		if (produto != null && this.preço == null) {
			
			setPreço(produto.getPreco());
			
		}
	}

	public int getQtd() {
		return qtd;
	}

	public void setQtd(int qtd) {
		this.qtd = qtd;
	}

	public Double getPreço() {
		return preço;
	}

	public void setPreço(Double preço) {
		this.preço = preço;
	}
	
	
	
	
}
