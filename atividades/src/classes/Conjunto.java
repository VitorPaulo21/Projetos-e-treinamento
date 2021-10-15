package classes;

import java.util.Scanner;
import java.util.TreeSet;

public class Conjunto {

	public static void main(String[] args) {

		TreeSet<Integer> c1 = new TreeSet<Integer>();
		TreeSet<Integer> c2 = new TreeSet<Integer>();
		TreeSet<Integer> c3 = new TreeSet<Integer>();
		TreeSet<Integer> c1e2 = new TreeSet<Integer>();
		TreeSet<Integer> c2e3 = new TreeSet<Integer>();
		TreeSet<Integer> c3e1 = new TreeSet<Integer>();
		TreeSet<Integer> pre = new TreeSet<Integer>();
		TreeSet<Integer> call = new TreeSet<Integer>();
		Scanner scan = new Scanner(System.in);
		int option = 0;

		doing: do {

			System.out.println("selecione o conjubnto em que quer inserir dados");

			try {

				option = scan.nextInt();

			} catch (Exception e) {

				option = 0;
				System.out.println("Opção Inválida");
				break doing;

			}
			if (option > 0 && option <= 3) {

				if (option == 1) {

					System.out.println("Insira o dado do conjunto " + option);
					try {

						c1.add(scan.nextInt());

					} catch (Exception e) {

						System.out.println("Opção Invalida");
						continue doing;
					}
					System.out.println("ok");

				} else if (option == 2) {

					System.out.println("Insira o dado do conjunto " + option);
					try {

						c2.add(scan.nextInt());

					} catch (Exception e) {

						System.out.println("Opção Invalida");
						continue doing;
					}
					System.out.println("ok");

				} else if (option == 3) {

					System.out.println("Insira o dado do conjunto " + option);
					try {

						c3.add(scan.nextInt());

					} catch (Exception e) {

						System.out.println("Opção Invalida");
						continue doing;
					}
					System.out.println("ok");

				}

			} else {

				System.out.println("Opção invalida");

			}

			copy(c1, c1e2);
			copy(c2, c2e3);
			copy(c3, c3e1);
			c1e2.retainAll(c2);
			c2e3.retainAll(c3);
			c3e1.retainAll(c1);

			copy(c1e2, pre);
			pre.retainAll(c2e3);

			copy(c3e1, call);
			call.retainAll(pre);

			System.out.println("Conjuno 1" + c1);
			System.out.println("Conjuno 2" + c2);
			System.out.println("Conjuno 3" + c3);
			System.out.println("Conjuno 1 e 2" + c1e2);
			System.out.println("Conjuno 2 e 3" + c2e3);
			System.out.println("Conjuno 3 e 1" + c3e1);
			System.out.println("Todos os Conjuntos" + call);

		} while (option != -1);

	}

	public static void copy(TreeSet<Integer> obj, TreeSet<Integer> to) {

		for (Integer integer : obj) {

			to.add(integer);

		}

	}
}
