package classes;

import java.util.Scanner;

public class datatest {
public static void main(String[] args) {
	

	data dat = new data(21,03,2000);
	data dat2 = new data();
	
	Scanner scan = new Scanner(System.in);
	
	/*System.out.println("insira um dia");
	dat.dia = scan.nextInt();
	System.out.println("insira um mes");
	dat.mes = scan.nextInt();
	System.out.println("insira um ano");
	dat.ano = scan.nextInt();
	System.out.println("insira um dia");
	dat2.dia = scan.nextInt();
	System.out.println("insira um mes");
	dat2.mes = scan.nextInt();
	System.out.println("insira um ano");
	dat2.ano = scan.nextInt();*/
	
	System.out.println(dat.getData());
	System.out.println(dat2.getData());
	
	scan.close();
}
}
