package exercicios_jpa.modelo.herança;

import Infra.DAO;

public class testeCarro {

	public static void main(String[] args) {
		
		
		DAO<Buggaty> dao = new DAO<>(Buggaty.class);
		DAO<ferrary> dao2 = new DAO<>(ferrary.class);

		ferrary f800 = dao2.getFromId(1);
		
		Buggaty Veyron = dao.getFromId(2);
		
		System.out.println(f800.getNome());
		System.out.println(f800.getCombustivel());
		System.out.println(Veyron.getNome());
		System.out.println(Veyron.getCombustivel());
	}
	
}
