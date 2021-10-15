package exercicios_jpa.teste.basico;

import Infra.DAO;
import exercicios_jpa.modelo.basico.Produto;
import exercicios_jpa.modelo.umPraMuitos.ItempEDIDO;
import exercicios_jpa.modelo.umPraMuitos.pedido;

public class testeUmPramuitos {

	public static void main(String[] args) {
		
		DAO<Object> dao = new DAO<Object>();
		
		pedido ped = new pedido();
		Produto prod = new Produto("Porta", 232.00);
		ItempEDIDO item = new ItempEDIDO(ped, prod, 10);
		
		dao.open()
		.insert(ped)
		.insert(prod)
		.insert(item)
		.close()
		.fechar();
		
	}
	
}
