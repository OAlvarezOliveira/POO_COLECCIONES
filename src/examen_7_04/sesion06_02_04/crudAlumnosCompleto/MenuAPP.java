package examen_7_04.sesion06_02_04.crudAlumnosCompleto;

import java.time.LocalDate;
import java.time.Year;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

public class MenuAPP {

	private static ArrayList<Alumno> alumnos = new ArrayList<>();

	public static void main(String[] args) {

		mostrarMenu();

	}

	public static void mostrarMenu() {
		int opcion;

		Scanner teclado = new Scanner(System.in);

		do {

			System.out.println("--- MENÚ GESTIÓN DE ALUMNOS ------");
			System.out.println("--- 1. Alta alumno ---------------");
			System.out.println("--- 2. Baja alumno ---------------");
			System.out.println("--- 3. Modificación alumno -------");
			System.out.println("--- 4. Listado de alumnos --------");
			System.out.println("--- 5. Buscar alumno por DNI -----");
			System.out.println("--- 6. Salir ---------------------");
			System.out.println("--- Elige la opcion a ejecutar ---");

			try {
				opcion = teclado.nextInt();
			} catch (InputMismatchException e) {
				System.out.println("La opcion debe ser un valor numerico del 1-6");
				System.out.println("--- Elige la opcion a ejecutar ---");
				opcion = teclado.nextInt();
			    teclado.nextLine(); // Limpiar buffer
			    opcion = 0; // Valor inválido → vuelve a mostrar menú
			}

			switch (opcion) {
			case 1:
				altaAlumno();
				break;

			case 2:
				bajaAlumno();
				break;
			case 3:
				modificacionAlumno();
				break;
			case 4:
				listarAlumno();
				break;
			case 5:
				buscarAlumnoPorDni();
				break;
			case 6:
				System.out.println("--- Saliendo del programa ---");
				break;

			}

		} while (opcion != 6);
	}

	private static void altaAlumno() {

		boolean datosCorrectos = false;
		boolean duplicado = false;
		Scanner teclado2 = new Scanner(System.in);

		while (!datosCorrectos) {

			String nombreCompleto = "";
			String dni = "";
			String ciclo = "";
			int anhoNacimiento = 0;
			boolean pendientes = false;

			while (nombreCompleto.isEmpty()) {
				System.out.println("Introduce el nombre completo del Alumno");
				nombreCompleto = teclado2.nextLine();
			}

			while (dni.isEmpty() || duplicado) {
				System.out.println("Introduce el dni del Alumno");
				dni = teclado2.nextLine();
				duplicado = false;
				for (Alumno alumno : alumnos) {

					if (alumno.getDni().equals(dni)) {
						duplicado = true;
						break;
					}
				}

			}

			while (ciclo.isEmpty()) {
				System.out.println("Introduce el ciclo del Alumno");
				ciclo = teclado2.nextLine();
			}

			int year = LocalDate.now().getYear();

			while (anhoNacimiento < 0 || anhoNacimiento > year) {

				try {

					System.out.println("Introduce el año de naciemiento del Alumno");
					anhoNacimiento = teclado2.nextInt();

				} catch (InputMismatchException e) {
					System.out.println("La fecha de naciemiento debe ser un valor numérico entero ");
					teclado2.nextLine();
				}
			}

			boolean leido = false;
			while (!leido) {
				try {
					System.out.println("¿Tiene asignaturas pendientes (True/False)?");
					pendientes = teclado2.nextBoolean();
					leido = true;
				} catch (InputMismatchException e) {
					System.out.println("Error: Debes introducir 'true' o 'false'.");
					teclado2.nextLine();
				}
			}

			// Crear alumno
			Alumno nuevo = new Alumno(nombreCompleto, dni, ciclo, anhoNacimiento, pendientes);
			alumnos.add(nuevo);
			System.out.println("Alumno añadido");
			datosCorrectos = true;

		}

	}

	private static void bajaAlumno() {
		Scanner teclado4 = new Scanner(System.in);
		Alumno eliminado = buscarAlumnoPorDni();

		if (eliminado != null) {

			System.out.println("Alumno encontrado , ¿ deseas eliminar el regristro S/N?");
			String respuesta = teclado4.nextLine();
			if (respuesta.equalsIgnoreCase("S")) {
				alumnos.remove(eliminado);
				System.out.println("Alumno eliminado");

			} else {

			    System.out.println("Operación cancelada");

			}

		}
	}

	private static void modificacionAlumno() {
		Scanner teclado4 = new Scanner(System.in);
		Alumno modificado = buscarAlumnoPorDni();

		if (modificado != null) {
			System.out.println("Introduce el nuevo nombreCompleto del Alumno");
			modificado.setNombreCompleto(teclado4.nextLine());
			System.out.println("Introduce el nuevo dni del Alumno");
			modificado.setDni(teclado4.nextLine());
			System.out.println("Introduce el nuevo ciclo del Alumno");
			modificado.setCiclo(teclado4.nextLine());
			System.out.println("Introduce el nuevo anhoNacimiento del Alumno");
			modificado.setAnhoNacimiento(teclado4.nextInt());
			teclado4.nextLine();
			System.out.println("Tiene materias pendientes el alumno");
			modificado.setPendientes(teclado4.nextBoolean());

		} else {

			System.out.println("Alumno no encontrado no se puede eliminar");

		}

	}

	private static void listarAlumno() {

		System.out.println("==LISTA DE ALUMNOS==");

		for (Alumno alumno : alumnos) {

			System.out.println(alumno);

		}

	}

	private static Alumno buscarAlumnoPorDni() {
		Scanner teclado3 = new Scanner(System.in);
		System.out.println("Introduce el dni del Alumno a buscar");
		String dniBuscar = teclado3.nextLine();
		Alumno buscado = null;

		for (Alumno alumno : alumnos) {

			if (alumno.getDni().equals(dniBuscar)) {
				buscado = alumno;
				break;
			}
		}

		return buscado;

	}

}
