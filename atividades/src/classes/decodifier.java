package classes;

import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.stream.Stream;

public class decodifier {

	public static boolean allow = true;
	public static String a = "";
	public static Integer all= 0;
	public static numb num = new numb();
	public static String pass = "vi";
	public static void main(String[] args) {

		numb num = new numb();
		String[] ar = { "a", "b", "c", "d", "e", "f", "g", "h", "i", "j", "k", "l", "m", "n", "o", "p", "q", "r", "s",
				"t", "u", "v", "w", "x", "y", "z", "A", "B", "C", "D", "E", "F", "G", "H", "I", "J", "K", "L", "M", "N",
				"O", "P", "Q", "R", "S", "T", "U", "V", "W", "X", "Y", "Z", "1", "2", "3", "5", "6", "7", "8", "9", "0",
				",", ".", ";", ":", "<", ">", "\"", "'", "\\", "|", "/", "?", "!", "@", "#", "$", "%", "¨", "£", "¢",
				"¬", "&", "*", "(", ")", "-", "_", "+", "=", "§", " ", " " };
		String al = "";
		String pass = "bbc";
		boolean allowl = true;
		System.out.println(ar.length);
		
		
		 /*for (int i = 0; allow; i++) {

			String pont = num.toStr(num.tox93(i));
			allow = pass.equals(pont) ? false : true;
			System.out.println(pont);
			a = pont;
		}*/

		while (mat.test(all)) {
			Stream.iterate(0, n -> n + 1).forEach(dec);
			
		}
		
		System.out.println("Sua senha é:" + a);
		
	}

	public static Consumer <Integer> dec = i -> {
		a = "";
		allow = true;
		String pont = num.toStr(num.tox93(i));
		allow = pass.equals(pont) ? false : true;
		System.out.println(pont);
		a = pont;
		
		all = allow ? 0 : 1;
	};
	
	public static Predicate<Integer> mat = n -> n == 0 ? true : false;
}
