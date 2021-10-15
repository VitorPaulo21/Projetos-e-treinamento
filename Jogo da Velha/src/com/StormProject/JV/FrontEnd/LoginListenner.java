package com.StormProject.JV.FrontEnd;

import java.util.ArrayList;

import com.StormProject.JV.BackEnd.Events;
import com.StormProject.JV.BackEnd.Usuario;

public interface LoginListenner {

	public void loginListenner(Events event, ArrayList<Usuario> list);
	
}
