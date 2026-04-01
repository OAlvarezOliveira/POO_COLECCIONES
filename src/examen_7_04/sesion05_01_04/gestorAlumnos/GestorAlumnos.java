package examen_7_04.sesion05_01_04.gestorAlumnos;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

public class GestorAlumnos {

	private static ArrayList<Alumno> alumnos = new ArrayList<>();

	public static void main(String[] args) {
		int numAlumnos = 0;

		Scanner sc = new Scanner(System.in);

		try {
			System.out.println("Cuantos alumnos deseas introducir?");
			numAlumnos = sc.nextInt();
			sc.nextLine(); // Limpiar buffer

		} catch (InputMismatchException e) {

			System.out.println("Error: Debes introducir un número entero");
		}

		for (int i = 0; i < numAlumnos; i++) {
			String nombreCompleto = "";
			String dni = "";
			String ciclo = "";
			int anhoNacimiento = 0;
			boolean pendientes = false;
			// Pedir datos

			while (nombreCompleto.isEmpty()) {
				System.out.print("Introduce el Nombre del Alumno: ");
				nombreCompleto = sc.nextLine();

				if (nombreCompleto.isEmpty()) {
					System.out.println("❌ Error: Nombre no puede estar vacío");
				}
			}

			while (dni.isEmpty()) {
				System.out.println("Introduce el DNI del Alumno");
				dni = sc.nextLine();

				if (dni.isEmpty()) {
					System.out.println("Error: DNI no puede estar vacío");
				}
			}

			while (ciclo.isEmpty()) {
				System.out.println("Introduce el ciclo que cursa el Alumno");
				ciclo = sc.nextLine();

				if (ciclo.isEmpty()) {
					System.out.println("Error: Debes introducir un ciclo válido");
				}
			}

			try {
				System.out.println("Introduce el año de nacimiento del Alumno");
				anhoNacimiento = sc.nextInt();
				sc.nextLine(); // Limpiar buffer

			} catch (InputMismatchException e) {

				System.out.println("Error: Debes introducir un número entero");
			}

			try {
				System.out.println("¿Tiene asignaturas pendientes? (true/false)");
				pendientes = sc.nextBoolean();
				sc.nextLine();
			} catch (InputMismatchException e) {
				System.out.println("Error: Debes introducir true o false");
				sc.nextLine();
				pendientes = false; // Valor por defecto
			}

			// Crear alumno

			Alumno a1 = new Alumno(nombreCompleto, dni, ciclo, anhoNacimiento, pendientes);

			// añadir a lista

			alumnos.add(a1);

		} // FinFOR

		// Recorrer ArrayList y mostrar todos

		for (Alumno a : alumnos) {

			System.out.println(a);

		}

		System.out.println("Introduce el DNI del Alumno que quieres buscar");
		String dniBuscar = sc.nextLine();
		Alumno encontrado = null;

		for (Alumno a : alumnos) {
			if (a.getDni().equals(dniBuscar)) {
				encontrado = a;
				break; // Salir del for
			}
		}

		if (encontrado != null) {
			System.out.println("Alumno encontrado: " + encontrado);
		} else {
			System.out.println("Alumno no encontrado");
		}

		if (encontrado != null) {
			System.out.print("¿Eliminar? (S/N): ");
			String respuesta = sc.nextLine();

			if (respuesta.equalsIgnoreCase("S")) {
				alumnos.remove(encontrado); // Eliminar del ArrayList
				System.out.println("Alumno eliminado");

				// Mostrar lista actualizada
				System.out.println("\n=== Lista actualizada ===");
				for (Alumno a : alumnos) {
					System.out.println(a);
				}
			}
		}

	}

}
