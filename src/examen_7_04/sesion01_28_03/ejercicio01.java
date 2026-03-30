package examen_7_04.sesion01_28_03;

import java.util.HashSet;
import java.util.Scanner;

public class ejercicio01 {

	public static HashSet<String> set = new HashSet<>();

	public static void main(String[] args) {

		Scanner teclado = new Scanner(System.in);
		int duplicado = 0;

		duplicado = añadeElementos(teclado, duplicado);

		System.out.printf("EL numero de duplicados ha sido de %d\n", duplicado);

		imprimirHashSet();

	}

	private static void imprimirHashSet() {

		for (String elemento : set) {

			System.out.println(elemento);

		}
	}

	public static int añadeElementos(Scanner teclado, int duplicado) {

		String nombre;
		for (int i = 0; i < 5; i++) {

			System.out.println("Introduce un nombre para guardar");
			nombre = teclado.nextLine();

			if (set.add(nombre)) {
				System.out.println("Añadido");
			} else {
				System.out.println("Ya existe");
				duplicado++;
			}

		}
		return duplicado;
	}

}
