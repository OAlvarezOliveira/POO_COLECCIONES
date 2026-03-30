
package boletin;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Scanner;

/**
 * Ranking con HashMap y ArrayList. Crea un programa que gestione las
 * puntuaciones de jugadores:
 * 
 * a. Usa un HashMap<String, Integer> donde la clave sea el nombre del jugador y
 * el valor su puntuaci n.
 * 
 * b. Permite agregar jugadores y actualizar su puntuaci n.
 * 
 * c. Genera un ranking de jugadores ordenado de mayor a menor puntuaci n.
 * 
 * Utiliza HashMap y convi rtelo a List<Map.Entry<K,V>>. Aplica Collections.sort
 * utilizando Comparator
 */

public class Ejercicio04 {

	private static HashMap<String, Integer> rankings;
	private static Scanner sc;

	public static void main(String[] args) {

		menu();
	}

	private static void datosPrueba() {
		rankings.put("Pepe", 2040);
		rankings.put("Manuel", 1200);
		rankings.put("Luis", 1044);
		rankings.put("Rodrigo", 2044);
		rankings.put("Rosa", 1233);
		rankings.put("Lucia", 1345);
		rankings.put("Maria", 1023);
		rankings.put("Jorge", 1043);
		rankings.put("Paco", 1020);

	}

	private static void menu() {
		rankings = new HashMap<String, Integer>();
		datosPrueba();
		sc = new Scanner(System.in);
		boolean jugadores = !(rankings.isEmpty());
		int num;

		do {
			System.out.printf("\n----------Menu---------\n" + "1-A adir Jugador\n" + "2-Actualizar Puntuacion\n"
					+ "3-Ver Ranking\n" + "4-Salir\n-----------------------\n");
			System.out.printf("Introduce una opcion:");
			num = sc.nextInt();
			sc.nextLine();
			System.out.println();

			switch (num) {
			case 1:
				addJugador();
				jugadores = true;
				break;
			case 2:
				// verificar que haya jugadores antes de actualizar
				if (jugadores) {
					actualizarPuntuacion();
				} else {
					System.out.printf("No hay jugadores para actualizar");
				}
				break;
			case 3:
				if (jugadores) {
					imprimirRanking();
				} else {
					System.out.printf("No hay jugadores en el Ranking");
				}
				break;

			default:
				System.out.println("Saliendo---");

				break;
			}// switch

		} while (num != 4); // do while

	}

	private static List<Entry<String, Integer>> ordenar() {
		/**
		 * Utiliza HashMap y convi rtelo a List<Map.Entry<K,V>>. Aplica Collections.sort
		 * utilizando Comparator
		 */

		List<Map.Entry<String, Integer>>  puntuacion = new ArrayList<>(rankings.entrySet());
		Collections.sort(puntuacion, Comparator.comparing(Map.Entry::getValue, Comparator.reverseOrder()));
		
		return puntuacion;
	}

	private static void imprimirRanking() {
	    List<Map.Entry<String, Integer>> rankingOrdenado = ordenar();
	    System.out.printf("%-5s %-15s %s%n", "Pos", "Jugador", "Puntuación");
	    System.out.println("-------------------------------");
	    int pos = 1;

	    for (Map.Entry<String, Integer> entry : rankingOrdenado) {
	        System.out.printf("%d %s %d%n", pos++, entry.getKey(), entry.getValue());
	    }
	}

	private static void actualizarPuntuacion() {
		String nombre;
		int puntos;
		System.out.printf("Introduce el Nombre del Jugador para actualizar su Puntuacion:\n");
		nombre = sc.nextLine().trim();

		if (existeJugador(nombre)) {
			System.out.printf("Introduce la puntuacion de %s: ", nombre);
			puntos = sc.nextInt();

			rankings.put(nombre, (Integer) puntos);
		} else {
			System.out.printf("Jugador %s No Encontrado\n", nombre);
		}
	}

	private static boolean existeJugador(String nombre) {
		return rankings.containsKey(nombre);
	}

	private static void addJugador() {
		String nombre;
		int puntos;
		System.out.printf("Introduce el Nombre del Jugador:\n");
		nombre = sc.nextLine().trim();

		if (existeJugador(nombre)) {
			System.out.println("Nombre en uso, prueba otro o usa la opcion Actualizar Puntuacion");
		} else {
			System.out.printf("Introduce la puntuacion de %s:\n", nombre);
			puntos = sc.nextInt();
			rankings.put(nombre, (Integer) puntos);
		}
	}

}
