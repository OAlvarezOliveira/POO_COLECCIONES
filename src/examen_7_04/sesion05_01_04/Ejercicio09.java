package examen_7_04.sesion05_01_04;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.Scanner;

public class Ejercicio09 {

	public static void main(String[] args) {

		ArrayList<String> nombres = new ArrayList<>();
		String nombre = "";
		Scanner teclado = new Scanner(System.in);

		// PASO 1: Leer nombres por teclado
		while (!nombre.equalsIgnoreCase("FIN")) {

			System.out.println("Introduce un nombre");
			nombre = teclado.nextLine();

			if (nombre.equalsIgnoreCase("FIN")) {
				continue;
			}
			nombres.add(nombre);

		}

		// PASO 2: Mostrar todos los nombres en el orden que se insertaron

		System.out.println("\n--- Orden de inserción ---");

		for (String name : nombres) {

			System.out.println(name);

		}
		// PASO 3: Eliminar duplicados

		HashSet<String> nombresCopia = new HashSet<>();

		for (String name : nombres) {

			nombresCopia.add(name);
		}

		System.out.println("\n--- Sin duplicados (orden no garantizado) ---");

		for (String name : nombresCopia) {

			System.out.println(name);

		}
		// PASO 4: Ordenar alfabéticamente
		ArrayList<String> nombresOrdenados = new ArrayList<>();

		for (String name : nombresCopia) {

			nombresOrdenados.add(name);
		}

		Collections.sort(nombresOrdenados);

		System.out.println("\n--- Ordenados alfabéticamente ---");

		for (String name : nombresOrdenados) {

			System.out.println(name);
		}
	}

}
