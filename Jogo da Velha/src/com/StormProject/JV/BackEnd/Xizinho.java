package com.StormProject.JV.BackEnd;

public class Xizinho extends Campo{

	private String tipe = "X";

	public Xizinho() {
		super();
	}

	@Override
	public String toString() {
		return "X";
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
