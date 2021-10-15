package exercicios_jpa.teste.basico;

import Infra.DAO;
import exercicios_jpa.modelo.umPraMuitos.ItempEDIDO;
import exercicios_jpa.modelo.umPraMuitos.pedido;

public class ObterPedido {

	public static void main(String[] args) {
		
		DAO<pedido> dao = new DAO<pedido>(pedido.class);
		
		pedido pedido = dao.getFromId(1L);
		
		for (ItempEDIDO item : pedido.getItens()) {
			System.out.println(item.getQtd());
		}
		
		
		dao.fechar();
	}
	
}
