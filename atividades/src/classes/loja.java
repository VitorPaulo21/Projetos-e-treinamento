package classes;

import java.util.ArrayList;
import java.util.Scanner;

public class loja {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		mapList map = new mapList();
		String value;
		String pos;
		
		System.out.println("Bem vindo a loja 25% de desconto\n"
				+"escolha uma op��o\n");
	    do {	
			System.out.println("1) Adicionar um produto.");
			System.out.println("2) Visualizar lista de produtos");
			System.out.println("3) Alterar o desconto atual dos produtos ");
			System.out.println("5) Sair ");
			
			pos = scan.nextLine();
			
			suite: switch (pos) {
			case "1": {
				
				System.out.println("Tudo bem! \nVamos adicionar um produto entao!\nDigite a classe do produto");
				map.add("class", scan.nextLine());
				System.out.println("ok agora digite o nome do produto");
				map.put("name", scan.nextLine(),(map.size())-1);
				System.out.println("ok agora o pre�o do produto");
				map.put("price", scan.nextLine(),(map.size())-1);
				System.out.println("deseja inserir um desconto?");
				String choice ="";
				do {
					System.out.println("responda com sim ou nao.");
					
					choice = scan.nextLine();
					if (choice.equals("sim")) {
						
						System.out.println("por favor insira o desconto");
						value = scan.nextLine();
						value = value.replaceAll(",", ".");
						map.replaceAll("discount", value);
						break;
					} else if(choice.equals("nao")){
						System.out.println("Inserir o desconto padr�o?\n1)sim\n2)nao");
                        int cho2 = 0;
					doll:	do {
							
								cho2 = scan.nextInt();
							
							if ( cho2==1 ){
								
								map.replaceAll("discount", "0.25");
								
							} else if ( cho2==2 ){
								
								if (map.size()>0) {
									
									if (map.contains("discount", map.size()-1)) {
										
										map.replaceAll("discount", map.get("discount", map.size()-1));
										
									} else {

										map.put("discount", "0.25", map.size()-1);
										
									}
									
								} else {

									map.add("discount", "0.25");
									
								}
								
							}else {
								
								System.out.println("Op��io invalida");
								
							}
						} while (cho2<1||cho2>2);
						
						break suite;
						
					}else {
						
						System.out.println("Op��o Inv�lida");
						
					}
				} while (!(choice.equals("sim"))||!(choice.equals("nao")));
				
				System.out.println("ok tudo certo");
				break suite;
			}
			case "2":{
				
				if (map.size()>0) {
					int choice = 0;
					do {
					System.out.println("Deseja separar por classe?\n1)Sim\n2)N�o");
					choice = scan.nextInt();
					
						if (choice==1) {
							ArrayList<String> listClass = new ArrayList<String>();
							listClass = map.getAllKeyValue("class",true);
							int choice2;
							do {
							System.out.println("Essas sao as op�oes de classes\n"
									+ "Por favor escolha um numero");
							 for (int i=0; i<listClass.size(); i++) {
								
								System.out.println((i+1)+listClass.get(i));
								
							}
							 
								
							     
								  choice2 = scan.nextInt();

								 String classe = listClass.get(choice2-1);
								 if (choice2>0&&choice2<=listClass.size()) {
									
									 ArrayList<Integer> list = new ArrayList<Integer>();
									 list=map.getAllKeyPos("class", classe);
									 System.out.println("\nA lista de produtos diacordo com a classe\n");
									 for (int i=0; i<list.size(); i++) {
										
										System.out.printf("Classe: %s\nNome: %s\nPre�o: R$%s\nDisconto: %%%s\n\n",
												map.get("class", list.get(i)),map.get("name", list.get(i)),map.get("price",
														list.get(i)),map.get("discount", list.get(i)));
										
									}
									 break suite;
								} else {
									
									System.out.println("Op��o Invalida");

								}
								 
							} while (choice2<1||choice2>(listClass.size()+1));
							
							break;
							
						} else if(choice == 2){
							
							System.out.println("\nEssa � A lista de Produtos Atual:\n");
							for (int i=0; i<map.size(); i++) {
								String cla = map.get("class", i);
								String nam = map.get("name", i);
								String pri = map.get("price", i);
								String dis = map.get("discount", i);
								System.out.printf("Classe: %s\nNome: %s\nPre�o: R$%s\nDisconto: %%%s\n\n",cla,
										nam, pri, dis);
								
							}
							break suite;
						} else {
							
							System.out.println("Op��o invalida");
				
						}
					} while (choice>2||choice<1);
					
					
				} else {

					System.out.println("No momento\nnao h� produtos adicionados\n2");
					
				}
				break suite;
			}
			
			case "3":{
				
				System.out.println("Insira o desconto");
				map.replaceAll("discount", scan.nextLine());
				System.out.println("Feito");
				break suite;
			}
			
			case "5":{
				
				System.out.println("Saindo...");
				break suite;
				
			}
			
			default:
				System.out.println("op��o inv�lida!\nselecione outra op��o\n");
			}
		} while (!pos.equals("5"));
		scan.close();
 	}
}
