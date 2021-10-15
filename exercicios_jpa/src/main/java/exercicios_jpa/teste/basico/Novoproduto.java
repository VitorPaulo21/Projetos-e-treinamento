package exercicios_jpa.teste.basico;

import Infra.DAO;
import exercicios_jpa.modelo.basico.Produto;

public class Novoproduto {

	public static void main(String[] args) {
		
		Produto prod = new Produto("BomBom", 2.45);
		
		DAO<Produto> dao = new DAO<Produto>(Produto.class);
		
		dao.open().insert(prod).close().fechar();
		
	}
	
}
