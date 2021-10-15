package View.Objects;

import java.awt.Color;
import java.util.ArrayList;
import java.util.Random;

import CssConverter.CSS;

public abstract class Block implements Cloneable{

	private int x;
	private int y;
	private ArrayList<Color> color;
	private String tipo;

	public Block() {
		color = new ArrayList<Color>();
		color.add(CSS.hexToColor("#ff0099"));
		color.add(CSS.hexToColor("#f3f315"));
		color.add(CSS.hexToColor("#83f52c"));
		color.add(CSS.hexToColor("#ff6600"));
		color.add(CSS.hexToColor("#6e0dd0"));
		
	}


	public int getX() {
		return x;
	}


	public void setX(int x) {
		this.x = x;
	}


	public int getY() {
		return y;
	}


	public void setY(int y) {
		this.y = y;
	}


	public Color getColor() {
		Random rnd = new Random();
		
		return color.get(rnd.nextInt(5));

	}

	
	
	public String getTipo() {
		return tipo;
	}


	public <U extends String> void setTipo(U tipo) {
		this.tipo = tipo;
	}

	public Block cloneS() throws CloneNotSupportedException {
		
		return (Block) this.clone();
		
	}

	public abstract void rotate();
	
	public abstract void chanceColor();
	
	public abstract double getType();
	
	public abstract ArrayList<Integer> getObjeto();
	
	public abstract Color getCor();
}
