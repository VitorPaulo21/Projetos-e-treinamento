package View.Grid;

import java.awt.Color;
import java.util.Objects;

import CssConverter.CSS;
import javafx.scene.layout.HBox;

public class Slots extends HBox{

	private int x;
	private int y;
	private boolean filled;
	private boolean actual;
	private boolean stopped;
	private Color color;
	
	public Slots(int x, int y) {
		
		this.x = x;
		this.y = y;
		
		setPrefSize(30,30);
		setMaxSize (30,30);
		setMinSize (30,30);
		setColor(new Color(33,33,33));
		
		
	}
	
	public void setColor(Color color) {
		
		CSS css = new CSS();
		
		if (color == null) {
			setStyle(css
//					.setBackgroundColor(color)
					.fx().border().color().set().get()
					+ CSS.colorToHex(new Color(99,33,99)) + ";"
					+ "-fx-background-color: #00000000;");
			this.color = null;
			filled = false;
			css.clean();
		} else {
			
			setStyle(css
					.setBackgroundColor(color)
					.fx().border().color().set().get()
					+ CSS.colorToHex(new Color(99,33,99)) + ";");
			filled = true;
			this.color = color;
			css.clean();
			
		}
		

	}
	
	public void noBorder() {
		
		CSS css = new CSS();
		setStyle(css.setBackgroundColor(new Color(52, 60, 57)).get());
		
	}
	
	public boolean isFilled() {
		
		return filled;
		
	}
	

	public void setFilled(boolean filled) {
		this.filled = filled;
	}

	public int getX() {
		return x;
	}

	public int getY() {
		return y;
	}
	
	

	public void setX(int x) {
		this.x = x;
	}

	public void setY(int y) {
		this.y = y;
	}

	public boolean isActual() {
		return actual;
	}

	public void setActual(boolean actual) {
		this.actual = actual;
	}

	
	
	public boolean isStopped() {
		return stopped;
	}

	public void setStopped(boolean stopped) {
		this.stopped = stopped;
	}

	@Override
	public int hashCode() {
		return Objects.hash(actual);
	}

	public Color getColor() {
		return color;
	}

	public boolean equalTo(Object obj) {

		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Slots other = (Slots) obj;
		return actual == other.actual;
	}
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return getX() + " ," + getY();
	}
}
