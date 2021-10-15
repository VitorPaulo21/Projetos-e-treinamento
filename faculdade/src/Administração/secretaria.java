package Administração;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;



public class secretaria {
	
	public static void main(String[] args) {
		
		Scanner scan = new Scanner(System.in);
		ArrayList <Integer> add = new ArrayList<Integer>();
		int in = 0;
		
		do {
			
			System.out.println("Digite um numero");
			
			try {
				
				in = Integer.parseInt(scan.nextLine());
				
			} catch (NumberFormatException ex) {
				
				System.out.println("Numero invalido");
				continue;
			}
			
			add.add(in);
		} while (add.size()<10);
		int big = 0;
		for (int i = 0 ; i<=add.size()-1 ; i++) {
			
			if (add.get(i)>big) {
				
				big = add.get(i);
				
			} 
			
		}
		
		System.out.printf("O maior numero é %d",big);
		scan.close();
	}
	

}
