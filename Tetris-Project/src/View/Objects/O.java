package View.Objects;

import java.awt.Color;
import java.util.ArrayList;

public class O extends Block{

	private Color cor;
	private ArrayList<Integer> Objeto;
	private double type = 2;
	private int[] shape= {1,1,
			              2,1};
	
	private int actualForm;
	
	public O() {
		actualForm = 0;
		cor = getColor();
		Objeto = new ArrayList<Integer>();
		for (int i = 0; i < shape.length; i++) {
			Objeto.add(shape[i]);
		}
		
		setTipo("O");
	}
	
	public void rotate() {

	}

	public ArrayList<Integer> getObjeto() {
		return Objeto;
	}

	public double getType() {
		return type;
	}
	public void chanceColor() {
		
		cor = getColor();
		
	}

	@Override
	public Color getCor() {
		// TODO Auto-generated method stub
		return cor;
	}
}