package Administração;

import java.util.Random;
import java.util.Scanner;

public class agenda {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		Random ram = new Random();
		int num = ram.nextInt(101);
		boolean conseguiu=false;
		String perto = "";
		
		System.out.println("vamos iniciar aqui \no jogo da adivinhação");
		System.out.println("O systema ira gerar \num numero aleatorio\nSeu trabalho \né tentar adivinhar");
		
		for (int i=1 ; i<=10 ; i++) {
			System.out.println("\n\nesta é sua tentativa n°" + i);
			System.out.println("digite um numero \no systema ira dizer \nse esta perto ou nao.");
			int entr = scan.nextInt();
			
			if (entr==num) {
				conseguiu = true;
				break;
			} else {
				conseguiu = false;
				perto = entr < num ? "menor que" : entr > num ? "maior que" : "erro";
				if (i==10) {
					
					System.out.printf("\n\nOps o numero nao é esse mas \no numero %d \né "
							+ "%s que o numero secreto",entr,perto);
					
				} else {
					
					System.out.printf("\n\nOps o numero nao é esse mas \no numero %d \né "
							+ "%s que o numero secreto\ntente novamente",entr,perto);

				}
				

			}
			
			
		}
		
		if (conseguiu) {
			
			System.out.println("\n\nParabens você conseguiu!! \no numero a ser adivinhado era "+num);
			
		} else {

			System.out.println("\n\nMas que pena suas tentativas acabaram \ntente outra vez ^-^");
			
		}
		
	}
	
}
