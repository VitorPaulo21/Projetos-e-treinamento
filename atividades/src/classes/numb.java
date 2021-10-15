package classes;

import java.util.ArrayList;


public class numb {

	String[] v = { "a", "b", "c", "d", "e", "f", "g", "h", "i", "j", "k", "l", "m", "n", "o", "p", "q", "r", "s", "t",
			"u", "v", "w", "x", "y", "z", "A", "B", "C", "D", "E", "F", "G", "H", "I", "J", "K", "L", "M", "N", "O",
			"P", "Q", "R", "S", "T", "U", "V", "W", "X", "Y", "Z", "1", "2", "3", "5", "6", "7", "8", "9", "0", ",",
			".", ";", ":", "<", ">", "\"", "'", "\\", "|", "/", "?", "!", "@", "#", "$", "%", "¨", "£", "¢", "¬", "&",
			"*", "(", ")", "-", "_", "+", "=", "§", " ", " " };

	ArrayList<Integer> tox93(int val) {
		ArrayList<Integer> val93 = new ArrayList<Integer>();

		if ( val>92 ){
			
			val93.add(0,92);
			val -= 92;
			for (; val >= 0; val--) {
				
				for (int i = 0; i < val93.size(); i++) {
					
					if (val93.get(i)==93) {
						
						if (i==0) {
							
							val93.add(0,1);
							val93.set(1, 0);
							
						} else {

							val93.set(i-1, val93.get(i-1)+1);
							val93.set(i, 0);
							
						}
						
					} else {
						//nada
					}
					
				}

					
				if (val>0) {
					
					val93.set(val93.size()-1, val93.get(val93.size()-1)+1);
					
				} else {
					//nada
				}	
					
				if (val == 0 && val93.contains(93)) {
					
					val++;
					
				} else {

				}	
//fim desse loop FOR
				
				
			}
			
		} else if ( val==92 ){
			
			val93.add(0,92);
			val-=92;
			
		} else {
			
			val93.add(0,val);
			val -= val;
			
		}
		
	return val93;	

	}

	
	
	String toStr(ArrayList<Integer> val) {

		String[] a = new String[val.size()];
		String r = "";
		
		for (int i = 0; i < val.size(); i++) {
			
			a[i] = v[Integer.parseInt(val.get(i).toString())];
			r = r + a[i];
		}
		
		return r;
		
	}	
}
