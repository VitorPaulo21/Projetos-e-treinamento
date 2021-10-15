package View.Objects;

import java.util.ArrayList;

public class Randomizer {

	private ArrayList<Block> objetos = new ArrayList<Block>();
	
	public Randomizer() {
		
		objetos.add(new I());
		objetos.add(new N());
		objetos.add(new N2());
		objetos.add(new L());
		objetos.add(new L2());
		objetos.add(new O());
		objetos.add(new T());
		
	}

	public ArrayList<Block> getObjetos() {
		return objetos;
	}
	public void reset() {
		objetos.clear();
		objetos.add(new I());
		objetos.add(new N());
		objetos.add(new N2());
		objetos.add(new L());
		objetos.add(new L2());
		objetos.add(new O());
		objetos.add(new T());
	}
}
