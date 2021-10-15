package View.Objects;

import java.awt.Color;
import java.util.ArrayList;

public class L extends Block{

	private Color cor;
	private ArrayList<Integer> Objeto;
	private double type = 3;
	private int[] shape= {0,1,0,
			              0,2,0,
			              0,1,1};
	
	private int[] shape2 = {0,0,0,
			                1,2,1,
			                1,0,0};
	private int[] shape3= {1,1,0,
			               0,2,0,
			               0,1,0};
	
	private int[] shape4 = {0,0,1,
			                1,2,1,
			                0,0,0};
	
	private int actualForm;
	
	
	public L() {
		
		
		actualForm = 0;
		cor = getColor();
		Objeto = new ArrayList<Integer>();
		for (int i = 0; i < shape.length; i++) {
			Objeto.add(shape[i]);
		}
		setTipo("L");
		
	}
	
	public void rotate() {
		
		if (actualForm == 0) {
			
			for (int i = 0; i < shape.length; i++) {
				
				Objeto.set(i, shape2[i]);
			}
			actualForm = 1;
		} else if (actualForm == 1){

			for (int i = 0; i < shape.length; i++) {
				
				Objeto.set(i, shape3[i]);
			}
			actualForm = 2;
		}else if (actualForm == 2){
		
		for (int i = 0; i < shape.length; i++) {
			
			Objeto.set(i, shape4[i]);
		}
		actualForm = 3;
	}else if (actualForm == 3){
		
		for (int i = 0; i < shape.length; i++) {
			
			Objeto.set(i, shape[i]);
		}
		actualForm = 0;
	}
		
	}
	public void chanceColor() {
		
		cor = getColor();
		
	}

	@Override
	public double getType() {
		// TODO Auto-generated method stub
		return type;
	}

	@Override
	public ArrayList<Integer> getObjeto() {
		// TODO Auto-generated method stub
		return Objeto;
	}

	@Override
	public Color getCor() {
		// TODO Auto-generated method stub
		return cor;
	}

}