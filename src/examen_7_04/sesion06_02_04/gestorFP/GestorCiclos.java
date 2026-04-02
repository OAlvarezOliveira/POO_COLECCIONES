package examen_7_04.sesion06_02_04.gestorFP;

import java.util.HashSet;
import java.util.InputMismatchException;
import java.util.Scanner;

public class GestorCiclos {
	// 8 HashSet
	private static HashSet<Alumno> smr1 = new HashSet<>();
	private static HashSet<Alumno> smr2 = new HashSet<>();
	private static HashSet<Alumno> daw1 = new HashSet<>();
	private static HashSet<Alumno> daw2 = new HashSet<>();
	private static HashSet<Alumno> dam1 = new HashSet<>();
	private static HashSet<Alumno> dam2 = new HashSet<>();
	private static HashSet<Alumno> asir1 = new HashSet<>();
	private static HashSet<Alumno> asir2 = new HashSet<>();
	private static Scanner teclado = new Scanner(System.in);

	private static String cicloActual = "SMR"; // Ciclo seleccionado

	public static void main(String[] args) {
		cargarDatos();
		mostrarMenu();
	}

	private static void mostrarMenu() {
		int opcion = 0;

		do {

			System.out.println("--- MENÚ (Ciclo actual: " + cicloActual + ") ---");
			System.out.println("1- Escoger ciclo");
			System.out.println("2- Mostrar todos los alumnos del ciclo");
			System.out.println("3- Mostrar alumnos de 1º");
			System.out.println("4- Mostrar alumnos de 2º");
			System.out.println("5- Mostrar alumnos que han pasado de curso con pendientes");
			System.out.println("6- Mostrar alumnos de 2º sin pendientes");
			System.out.println("7- Salir");

			try {
				opcion = teclado.nextInt();
				teclado.nextLine();
			} catch (InputMismatchException e) {
				System.out.println("La opcion debe ser un valor numerico del 1-7");
				teclado.nextLine();
				opcion = 0;
			}

			switch (opcion) {
			case 1:
				escogerCiclo();
				break;
			case 2:
				mostrarTodosAlumnos();
				break;
			case 3:
				mostrarAlumnosPrimero();
				break;
			case 4:
				mostrarAlumnosSegundo();
				break;
			case 5:
				mostrarAlumnosPendientes();
				break;
			case 6:
				mostrarAlumnosSegundoSinPendientes();
				break;
			case 7:
				System.out.println("¡Adiós!");
				break;
			default:
				System.out.println("❌ Opción inválida");
			}

		} while (opcion != 7);

	}

	private static void mostrarAlumnosSegundoSinPendientes() {
		if (cicloActual.equals("SMR")) {
			System.out.println("=== Alumnos de 2º SMR sin Asg. pendientes ===\n");
			for (Alumno alumno : smr2) {
				if (!alumno.isPendientes()) {
					System.out.println(alumno);
				}
			}

		} else if (cicloActual.equals("DAW")) {
			System.out.println("=== Alumnos de 2º DAW sin Asg. pendientes ===\n");
			for (Alumno alumno : daw2) {
				if (!alumno.isPendientes()) {
					System.out.println(alumno);
				}
			}

		} else if (cicloActual.equals("DAM")) {
			System.out.println("=== Alumnos de 2º DAM sin Asg. pendientes ===\n");
			for (Alumno alumno : dam2) {
				if (!alumno.isPendientes()) {
					System.out.println(alumno);
				}
			}

		} else if (cicloActual.equals("ASIR")) {
			System.out.println("=== Alumnos de 2º ASIR sin Asg. pendientes ===\n");
			for (Alumno alumno : asir2) {
				if (!alumno.isPendientes()) {
					System.out.println(alumno);
				}
			}

		}

	}

	private static void mostrarAlumnosPendientes() {
		if (cicloActual.equals("SMR")) {
			System.out.println("=== Alumnos de 2º SMR con Asg. pendientes ===\n");
			for (Alumno alumno : smr2) {
				if (alumno.isPendientes()) {
					System.out.println(alumno);
				}
			}

		} else if (cicloActual.equals("DAW")) {
			System.out.println("=== Alumnos de 2º DAW con Asg. pendientes ===\n");
			for (Alumno alumno : daw2) {
				if (alumno.isPendientes()) {
					System.out.println(alumno);
				}
			}

		} else if (cicloActual.equals("DAM")) {
			System.out.println("=== Alumnos de 2º DAM con Asg. pendientes  ===\n");
			for (Alumno alumno : dam2) {
				if (alumno.isPendientes()) {
					System.out.println(alumno);
				}
			}

		} else if (cicloActual.equals("ASIR")) {
			System.out.println("=== Alumnos de 2º ASIR con Asg. pendientes  ===\n");
			for (Alumno alumno : asir2) {
				if (alumno.isPendientes()) {
					System.out.println(alumno);
				}
			}

		}

	}

	private static void mostrarAlumnosSegundo() {
		if (cicloActual.equals("SMR")) {
			System.out.println("=== Alumnos de 2º SMR ===\n");
			for (Alumno alumno : smr2) {
				System.out.println(alumno);
			}

		} else if (cicloActual.equals("DAW")) {
			System.out.println("=== Alumnos de 2º DAW ===\n");
			for (Alumno alumno : daw2) {
				System.out.println(alumno);
			}

		} else if (cicloActual.equals("DAM")) {
			System.out.println("=== Alumnos de 2º DAM ===\n");
			for (Alumno alumno : dam2) {
				System.out.println(alumno);
			}

		} else if (cicloActual.equals("ASIR")) {
			System.out.println("=== Alumnos de 2º ASIR ===\n");
			for (Alumno alumno : asir2) {
				System.out.println(alumno);
			}

		}

	}

	private static void mostrarAlumnosPrimero() {
		if (cicloActual.equals("SMR")) {
			System.out.println("=== Alumnos de 1º SMR ===\n");
			for (Alumno alumno : smr1) {
				System.out.println(alumno);
			}

		} else if (cicloActual.equals("DAW")) {
			System.out.println("=== Alumnos de 1º DAW ===\n");
			for (Alumno alumno : daw1) {
				System.out.println(alumno);
			}

		} else if (cicloActual.equals("DAM")) {
			System.out.println("=== Alumnos de 1º DAM ===\n");
			for (Alumno alumno : dam1) {
				System.out.println(alumno);
			}

		} else if (cicloActual.equals("ASIR")) {

			System.out.println("=== Alumnos de 1º ASIR ===\n");
			for (Alumno alumno : asir1) {
				System.out.println(alumno);
			}

		}

	}

	private static void mostrarTodosAlumnos() {

		if (cicloActual.equals("SMR")) {
			// mostrar smr1 + smr2
			System.out.println("=== Alumnos de SMR ===\n");
			for (Alumno alumno : smr1) {
				System.out.println(alumno);
			}

			for (Alumno alumno : smr2) {
				System.out.println(alumno);
			}

		} else if (cicloActual.equals("DAW")) {
			// mostrar daw1 + daw2
			System.out.println("=== Alumnos de DAW ===\n");
			for (Alumno alumno : daw1) {
				System.out.println(alumno);
			}

			for (Alumno alumno : daw2) {
				System.out.println(alumno);
			}

		} else if (cicloActual.equals("DAM")) {
			// mostrar dam1 + dam2
			System.out.println("=== Alumnos de DAM ===\n");
			for (Alumno alumno : dam1) {
				System.out.println(alumno);
			}

			for (Alumno alumno : dam2) {
				System.out.println(alumno);
			}

		} else if (cicloActual.equals("ASIR")) {
			// mostrar asir1 + asir2
			System.out.println("=== Alumnos de ASIR ===\n");
			for (Alumno alumno : asir1) {
				System.out.println(alumno);
			}

			for (Alumno alumno : asir2) {
				System.out.println(alumno);
			}

		}

	}

	private static void escogerCiclo() {
	    Scanner sc = new Scanner(System.in);
	    
	    System.out.println("\n=== CICLOS DISPONIBLES ===");
	    System.out.println("1. SMR");
	    System.out.println("2. DAW");
	    System.out.println("3. DAM");
	    System.out.println("4. ASIR");
	    System.out.print("Elige ciclo (1-4): ");
	    
	    try {
	        int opcion = sc.nextInt();
	        sc.nextLine();
	        
	        switch (opcion) {
	            case 1: cicloActual = "SMR"; break;
	            case 2: cicloActual = "DAW"; break;
	            case 3: cicloActual = "DAM"; break;
	            case 4: cicloActual = "ASIR"; break;
	            default: 
	                System.out.println("Opción inválida");
	                return;
	        }
	        
	        System.out.println("Ciclo cambiado a " + cicloActual);
	        
	    } catch (InputMismatchException e) {
	        System.out.println("Debe ser un número");
	        sc.nextLine();
	    }
	}

	private static void cargarDatos() {
		// SMR 1º
		smr1.add(new Alumno("Juan Pérez", "11111111A", "SMR", 2006, false));
		smr1.add(new Alumno("Ana García", "22222222B", "SMR", 2007, true));
		smr1.add(new Alumno("Luis López", "33333333C", "SMR", 2006, false));

		// SMR 2º
		smr2.add(new Alumno("María Ruiz", "44444444D", "SMR", 2005, false));
		smr2.add(new Alumno("Pedro Sanz", "55555555E", "SMR", 2005, true));

		// DAW 1º
		daw1.add(new Alumno("Laura Martín", "66666666F", "DAW", 2006, false));
		daw1.add(new Alumno("Carlos Díaz", "77777777G", "DAW", 2007, false));

		// DAW 2º
		daw2.add(new Alumno("Sara Fernández", "88888888H", "DAW", 2005, true));
		daw2.add(new Alumno("Javier Moreno", "99999999I", "DAW", 2005, false));

		// DAM 1º
		dam1.add(new Alumno("Elena Navarro", "10101010J", "DAM", 2006, false));
		dam1.add(new Alumno("Diego Torres", "11111110K", "DAM", 2007, true));

		// DAM 2º
		dam2.add(new Alumno("Lucía Romero", "12121212L", "DAM", 2005, false));
		dam2.add(new Alumno("Miguel Jiménez", "13131313M", "DAM", 2005, false));

		// ASIR 1º
		asir1.add(new Alumno("Carmen Vega", "14141414N", "ASIR", 2006, true));
		asir1.add(new Alumno("Raúl Castro", "15151515O", "ASIR", 2007, false));

		// ASIR 2º
		asir2.add(new Alumno("Marta Gil", "16161616P", "ASIR", 2005, false));
		asir2.add(new Alumno("Alberto Ramos", "17171717Q", "ASIR", 2005, true));
	}

}
