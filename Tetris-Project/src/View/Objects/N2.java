package View.Objects;

import java.awt.Color;
import java.util.ArrayList;

public class N2 extends Block{

	private Color cor;
	private ArrayList<Integer> Objeto;
	private double type = 3;
	private int[] shape= {1,1,0,
			              0,2,1,
			              0,0,0};
	
	private int[] shape2 = {0,0,1,
			                0,2,1,
			                0,1,0};
	
	private int actualForm;
	
	public N2() {
		actualForm = 0;
		cor = getColor();
		Objeto = new ArrayList<Integer>();
		for (int i = 0; i < shape.length; i++) {
			Objeto.add(shape[i]);
		}
		
		setTipo("N2");
	}
	
	public void rotate() {
		
		if (actualForm == 0) {
			
			for (int i = 0; i < shape.length; i++) {
				
				Objeto.set(i, shape2[i]);
				
			}
			actualForm = 1;
		} else {

			for (int i = 0; i < shape.length; i++) {
				
				Objeto.set(i, shape[i]);
				
			}
			actualForm = 0;
		}
		
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