package classes;

import java.util.Scanner;

public class desafioDoLuiz {

	public static void main(String[] args) {
		
		mapList map = new mapList();
		Scanner scan = new Scanner(System.in);
		Scanner scan1 = new Scanner(System.in);
		Scanner scan2 = new Scanner(System.in);
		int pos;
		
		
	cas:	do {
			for (int i=0;i<map.size(); i++) {
				if (map.size()>0) {
					System.out.println(i+")"+map.get("item", i));
					
				} else {

					break;
					
				}
				
			}
			System.out.println("1");
			System.out.println("2");
			System.out.println("3");
			System.out.println("4");
			System.out.println("5");
			
			
			pos = scan.nextInt();
			
			switch (pos) {
			case 1: {
				System.out.println("insira o valor");
				
				map.add("item", scan1.nextLine());
				break;
			}
			case 2:{
				boolean cont = false;
				System.out.println("digite o item a ser pesquisado");
				String value = scan1.nextLine();
				for (int i=0 ; i<map.size(); i++) {
					
					if (map.get("item", i).contains(value)) {
						
						System.out.println("o seu valor foi encontrado\n");
						System.out.println(map.get("item", i));
						break;
					} else {
						
						if (i==(map.size()-1)) {
							
							cont=true;
						}

					}
					
				}
				if (cont) {
					
					System.out.println("esse produto nao existe");
					
				}
				
			}
			break;
			case 3:{
				
				int key;
				String value;
				
				System.out.println("Insira a posição");
				key = scan1.nextInt();
				System.out.println("Insira o valor a ser alterado");
				value = scan2.nextLine();
				
				if (key<map.size() && key>=0) {
					map.put("item", value, key);
					
				} else {

					System.out.println("valor ou posição nao existe");
					
				}
				
			}
			break;
			case 4:{
				
				int key;
				
				System.out.println("Insira a posição a ser deletada");
				key = scan1.nextInt();
				
				if (key<map.size() && key>=0) {
					map.remove(key);
					
				} else {

					System.out.println("posição nao existe");
					
				}
				
			}
			break;
			case 5 :{
				
				System.out.println("saindo...");
				break cas;
				
			}
			default:
				
			}
			
			
			
			
		} while (pos>0||pos<=5);
		scan.close();
		scan1.close();
		scan2.close();
	}
	
	
}
