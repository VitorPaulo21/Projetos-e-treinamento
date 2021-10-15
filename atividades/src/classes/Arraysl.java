package classes;

import java.util.Scanner;

public class Arraysl {

	public static void main(String[] args) {

		Scanner scanl = new Scanner(System.in);
		int num = 0;

		System.out.println("Olá quantas notas voce gostaria de inserir?");
		num = scanl.nextInt();
        scanl.close();
		double[] notas = new double[num];
		scanl = new Scanner(System.in);

		for (int i = 0; i < notas.length; i++) {

			System.out.println("Insira a nota " + (i + 1));

			String n = scanl.nextLine().replaceAll(",", ".");
			double c = Double.parseDouble(n);

			notas[i] = c;

			if (i == notas.length - 1) {

				System.out.println("Tudo certo.");

			}

		}

		double media = 0;

		for (double d : notas) {

			media += d;

		}

		System.out.printf("A sua média de notas é %.2f", media / notas.length);
		scanl.close();
	}

}
