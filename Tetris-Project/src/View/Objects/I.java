package View.Objects;

import java.awt.Color;
import java.util.ArrayList;

public class I extends Block{

	private Color cor;
	private ArrayList<Integer> Objeto;
	private double type = 4;
	private int[] shape= {0,1,0,0,
			              0,1,0,0,
			              0,1,0,0,
			              0,1,0,0};
	
	private int[] shape2 = {0,0,0,0,
		                	1,1,2,1,
                            0,0,0,0,
                            0,0,0,0};
	
	private int actualForm;
	
	
	public I() {
		
		
		actualForm = 0;
		cor = getColor();
		Objeto = new ArrayList<Integer>();
		for (int i = 0; i < shape.length; i++) {
			Objeto.add(shape[i]);
		}
		setTipo("I");
		
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