package exercicios_jpa.modelo.umPraMuitos;

import java.util.Date;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
@Entity
public class pedido {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	private Date data;
	
	@OneToMany(mappedBy = "pedido")
	private List<ItempEDIDO> itens;
	
	public pedido() {
		
		this.setData(new Date());
		
	}

	
	
	public pedido(Date data) {
		super();
		this.data = data;
	}



	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Date getData() {
		return data;
	}

	public void setData(Date data) {
		this.data = data;
	}



	public List<ItempEDIDO> getItens() {
		return itens;
	}



	public void setItens(List<ItempEDIDO> itens) {
		this.itens = itens;
	}
	
	
	
}
