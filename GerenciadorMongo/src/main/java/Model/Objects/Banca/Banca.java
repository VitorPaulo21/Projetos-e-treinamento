package Model.Objects.Banca;

public class Banca{

private String id;
	
	private int ident;
	
	private double inicial;
	
	private double finall;
	
	public Banca() {
		ident = 1;
	}

	public Banca(double inicial, double finall) {
		super();
		this.inicial = inicial;
		this.finall = finall;
		ident = 1;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public double getInicial() {
		return inicial;
	}

	public void setInicial(double inicial) {
		this.inicial = inicial;
	}

	public double getFinall() {
		return finall;
	}

	public void setFinall(double finall) {
		this.finall = finall;
	}

	public int getIdent() {
		return ident;
	}

	public void setIdent(int ident) {
		this.ident = ident;
	}

	
}
