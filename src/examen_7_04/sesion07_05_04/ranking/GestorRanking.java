package examen_7_04.sesion07_05_04.ranking;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Scanner;

public class GestorRanking {

	private static HashMap<String, Integer> puntuaciones = new HashMap<>();
	private static Scanner sc = new Scanner(System.in);

	public static void main(String[] args) {
		int opcion = 0;

		// Carga inicial
		cargarDatos();

		do {

			System.out.printf("=== RANKING JUGADORES ===\n");
			System.out.printf("1. Agregar jugador\n");
			System.out.printf("2. Actualizar puntuación\n");
			System.out.printf("3. Consultar puntuación\n");
			System.out.printf("4. Mostrar ranking ordenado\n");
			System.out.printf("5. Listar todos los jugadores , orden no garantizado\n");
			System.out.printf("6. Salir\n");
			try {
				System.out.printf("Elige una opcion (1-6)");
				opcion = Integer.parseInt(sc.nextLine());

				switch (opcion) {
				case 1:
					agregarJugador();
					break;

				case 2:
					actualizarPuntuacion();
					break;
				case 3:
					consultarPuntuacion();
					break;
				case 4:
					mostrarRanking();
					break;
				case 5:
					listarJugadores();
					break;
				case 6:
					System.out.printf("Saliendo de la APP.Hasta pronto!!");
					break;
				}

			} catch (NumberFormatException e) {

				System.out.println("Error: numero invalido");
			}

		} while (opcion != 6);

	}

	private static void listarJugadores() {

		System.out.printf("Imprimiento ranking de jugadores , orden no garantizado");
		for (Map.Entry<String, Integer> entry : puntuaciones.entrySet()) {

			System.out.printf("Jugador : %s || %d home run \n", entry.getKey(), entry.getValue());

		}

	}

	private static void mostrarRanking() {
		ArrayList<Map.Entry<String, Integer>> ranking = new ArrayList<>(puntuaciones.entrySet());

		Collections.sort(ranking, (e1, e2) -> e2.getValue().compareTo(e1.getValue()));

		// imprimir ordenado
		int i = 1;
		for (Map.Entry<String, Integer> entry : ranking) {

			System.out.printf("Posicion %d : %s || %d home run \n", i, entry.getKey(), entry.getValue());
			i++;
		}

	}

	private static void consultarPuntuacion() {
		String nombreTemporal;
		int puntuacionTemporal;
		boolean valido = false;

		System.out.println("Introduce el nombre del Jugador del que deseas consultar la puntuacion");
		nombreTemporal = sc.nextLine();

		if (!puntuaciones.containsKey(nombreTemporal)) {

			System.out.printf("\nError: El Jugador %s no existe en el ranking de jugadores", nombreTemporal);

		} else {
			System.out.printf("\nLa puntuación del jugador %s es de %d", nombreTemporal,
					puntuaciones.get(nombreTemporal));

		}

	}

	private static void actualizarPuntuacion() {
		String nombreTemporal;
		int puntuacionTemporal;
		boolean valido = false;

		System.out.println("Introduce el nombre del Jugador del que deseas consultar la puntuacion");
		nombreTemporal = sc.nextLine();

		if (!puntuaciones.containsKey(nombreTemporal)) {

			System.out.printf("\nError: El Jugador %s no existe en el ranking de jugadores", nombreTemporal);

		} else {

			while (!valido) {
				try {

					System.out.printf("\nIntroduce la nueva  puntuacion del %s:", nombreTemporal);
					puntuacionTemporal = Integer.parseInt(sc.nextLine());

					if (puntuacionTemporal >= 0) {

						puntuaciones.put(nombreTemporal, puntuacionTemporal);
						valido = true;

					} else {

						System.out.println("EL valor de la puntuacion debe ser mayor o igual a 0");

					}

				} catch (NumberFormatException e) {

					System.out.println("Error: numero invalido");

				}

			} // fin while

		}

	}

	private static void agregarJugador() {

		String nombreTemporal;
		int puntuacionTemporal = 0;
		boolean valido = false;

		System.out.println("Introduce el nombre del Jugador a añadir");
		nombreTemporal = sc.nextLine();

		while (!valido) {
			try {

				System.out.println("Introduce la puntuacion del Jugador a añadir");
				puntuacionTemporal = Integer.parseInt(sc.nextLine());

				if (puntuacionTemporal >= 0) {

					valido = true;

				} else {

					System.out.println("EL valor de la puntuacion debe ser mayor o igual a 0");

				}

			} catch (NumberFormatException e) {

				System.out.println("Error: numero invalido");

			}

		} // fin while

		if (puntuaciones.containsKey(nombreTemporal)) {

			System.out.printf("\nError: El Jugador %s ya existe , imposible añadir", nombreTemporal);

		} else {

			puntuaciones.put(nombreTemporal, puntuacionTemporal);
			System.out.printf("\nÉxito: El Jugador %s ha sido añadido al ranking", nombreTemporal);

		}

	}

	private static void cargarDatos() {

		puntuaciones.put("Shohei Ohtani", 54);
		puntuaciones.put("Aaron Judge", 58);
		puntuaciones.put("Giancarlo Stanton", 27);
		puntuaciones.put("Kyle Schwarber", 38);
		puntuaciones.put("Pete Alonso", 34);
		puntuaciones.put("Salvador Pérez", 27);

	}

}
