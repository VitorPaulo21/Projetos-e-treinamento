package classes;

import java.util.Scanner;

public class jantar {

	public static void main(String[] args) {
		
		
		
		
		Scanner scan = new Scanner(System.in);
		pessoa pes = new pessoa();
		alimento arroz = new alimento("Arroz", 0.500);
		alimento feijao = new alimento("Feijao", 0.300);
		alimento carne = new alimento("Carne", 0.700);
		int choice = 0;
		
		
		System.out.println("Insira seu nome");
		pes.nome = scan.nextLine();
		System.out.println("Insira seu peso");
		pes.peso = scan.nextDouble();
		
		do {
			
			System.out.println("\nDeseja comer algo?\n1) Arroz\n2) Feijao\n3) Carne\n-1)Sair");
			choice = scan.nextInt();
			
			if ( choice == 1 ){
				
				System.out.println(pes.nome+" Seu peso antes é:" + pes.peso);
				pes.comer(arroz);
				System.out.println(pes.nome+" Seu peso agora é:" + pes.peso);
				
			} else if ( choice == 2 ){
				
				System.out.println(pes.nome+" Seu peso antes é:" + pes.peso);
				pes.comer(feijao);
				System.out.println(pes.nome+" Seu peso agora é:" + pes.peso);
				
			} else if (choice == 3) {
				
				System.out.println(pes.nome+" Seu peso antes é:" + pes.peso);
				pes.comer(carne);
				System.out.println(pes.nome+" Seu peso agora é:" + pes.peso);
				
			} else if (choice == -1) {
				
				System.out.println("Obrigado");
				break;
				
			} else {
				
				System.out.println("Opção inválida");
				continue;
				
			}
			
		} while (choice>0);
		
		scan.close();
		
	}
	
}
