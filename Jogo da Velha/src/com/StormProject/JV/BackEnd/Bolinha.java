package com.StormProject.JV.BackEnd;

public class Bolinha extends Campo{

	private String tipe = "O";
	
	public Bolinha() {
		
		super();
		
	}

	@Override
	public String toString() {
		return tipe;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((tipe == null) ? 0 : tipe.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (obj.getClass() == this.getClass()) {
			return true;
		} else {
			return false;
		}
	}
	
	
	
}
