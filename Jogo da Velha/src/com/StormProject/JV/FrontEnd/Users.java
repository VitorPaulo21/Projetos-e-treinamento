package com.StormProject.JV.FrontEnd;

import java.util.ArrayList;

import com.StormProject.JV.BackEnd.Usuario;

public class Users {

	Usuario user1;
	Usuario user2;
	ArrayList<Usuario> list;
	public Users(ArrayList<Usuario> list) {
		this.list = list;
		user1 = list.get(0);
		user2 = list.get(1);
		
	}
	
	public boolean isNull() {
		boolean u1 = user1 == null;
		boolean u2 = user2 == null;
		
		return u1 && u2;
	}
	
}
