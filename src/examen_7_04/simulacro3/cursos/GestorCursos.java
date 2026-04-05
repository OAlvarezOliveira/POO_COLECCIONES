package examen_7_04.simulacro3.cursos;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map.Entry;
import java.util.Scanner;

import examen_7_04.simulacro3.cursos.excepciones.AlumnoYaInscritoException;
import examen_7_04.simulacro3.cursos.excepciones.CursoNoEncontradoException;

public class GestorCursos {
	private static HashMap<String, Curso> cursos = new HashMap<>();
	private static Scanner sc = new Scanner(System.in);

	public static void main(String[] args) {

		cargarDatos();
		menu();

	}

	private static void menu() {
		int opcion = 0;

		do {
			System.out.printf("\n=== GESTIÓN CURSOS ===");
			System.out.printf("\n1. Inscribir alumno");
			System.out.printf("\n2. Dar de baja alumno");
			System.out.printf("\n3. Listar alumnos de curso");
			System.out.printf("\n4. Mostrar estadísticas");
			System.out.printf("\n5. Curso con más alumnos");
			System.out.printf("\n6. Salir");

			try {
				System.out.printf("\nElige una opcion");
				opcion = Integer.parseInt(sc.nextLine());
			} catch (NumberFormatException e) {
				System.out.printf("\nError: Formato de opción no valido");
			}

			switch (opcion) {
			case 1:
				inscribirAlumno();
				break;
			case 2:
				darBajaAlumno();
				break;
			case 3:
				listarAlumnosCurso();
				break;
			case 4:
				mostrarEstadisticas();
				break;
			case 5:
				cursoConMasAlumnos();
				break;
			case 6:
				System.out.printf("\nSaliendo de la APP");
				break;

			default:
				System.out.printf("\nError: Opcion incorrecta");
				break;
			}

		} while (opcion != 6);
	}

	private static void cursoConMasAlumnos() {
	    // Si no hay cursos, avisamos y salimos
	    if (cursos.isEmpty()) {
	        System.out.println("\nNo hay cursos registrados en la academia.");
	        return;
	    }

	    int alumnosMaximos = -1; // Con -1 nos aseguramos de que cualquier curso con 0 o más lo supere
	    String cursoMasAlumnos = "";

	    for (Entry<String, Curso> entry : cursos.entrySet()) {
	        Curso curso = entry.getValue();
	        int numAlumnosCurso = curso.getInscritos().size();
	        
	        if (numAlumnosCurso > alumnosMaximos) {
	            alumnosMaximos = numAlumnosCurso;
	            cursoMasAlumnos = curso.getNombre();
	        }
	    }

	    System.out.println("\n--- CURSO ESTRELLA ---");
	    System.out.printf("El curso con más alumnos es '%s' con un total de %d inscritos.\n", 
	                      cursoMasAlumnos, alumnosMaximos);
	}


	private static void mostrarEstadisticas() {
	    int totalAlumnosAcademia = 0;

	    System.out.println("\n--- ESTADÍSTICAS DE LA ACADEMIA ---");
	    
	    for (Entry<String, Curso> entry : cursos.entrySet()) {
	        String codigo = entry.getKey();
	        Curso curso = entry.getValue();
	        
	        int numAlumnosCurso = curso.getInscritos().size();
	        
	        System.out.printf("Curso: [%s] %s - Alumnos inscritos: %d\n", 
	                          codigo, curso.getNombre(), numAlumnosCurso);
	        
	        totalAlumnosAcademia += numAlumnosCurso;
	    }

	    System.out.println("-----------------------------------");
	    System.out.printf("Total de inscripciones gestionadas: %d\n", totalAlumnosAcademia);
	}


	private static void listarAlumnosCurso() {
		try {
			System.out.printf("\nIntroduce el codigo del curso: ");
			String codigo = sc.nextLine();

			if (!cursos.containsKey(codigo)) {
				throw new CursoNoEncontradoException("El codigo del curso no existe.");
			}

			Curso c1 = cursos.get(codigo);
			ArrayList<Alumno> inscritos1 = c1.getInscritos();

			if (inscritos1.isEmpty()) {
			    System.out.println("\nSin alumnos inscritos");
			} else {
			    for (Alumno alumno : inscritos1) {
			        System.out.println(alumno);
			    }
			}

		} catch (CursoNoEncontradoException e) {
			System.out.println("\nError: " + e.getMessage());
		}

	}

	private static void darBajaAlumno() {

		Alumno alumnoEliminar = null;

		try {
			System.out.printf("Introduce el codigo del curso: \n");
			String codigo = sc.nextLine();

			if (!cursos.containsKey(codigo)) {
				throw new CursoNoEncontradoException("El codigo del curso no existe.");
			}

			Curso c1 = cursos.get(codigo);
			ArrayList<Alumno> inscritos1 = c1.getInscritos();

			System.out.printf("Introduce el DNI del Alumno: \n");
			String dni = sc.nextLine();

			for (Alumno a : inscritos1) {
				if (a.getDni().equalsIgnoreCase(dni)) {
					alumnoEliminar = a;
				}
			}

			if (alumnoEliminar != null) {
				inscritos1.remove(alumnoEliminar);
			} else {
				System.out.printf("El Alumno no existe en el curso indicado\n");
			}


		} catch (CursoNoEncontradoException e) {
			System.out.printf("\nError: " + e.getMessage());
		}

	}

	private static void inscribirAlumno() {
		boolean valido = false;

		while (!valido) {
			try {
				System.out.print("\nIntroduce el codigo del curso: ");
				String codigo = sc.nextLine();

				if (!cursos.containsKey(codigo)) {
					throw new CursoNoEncontradoException("El codigo del curso no existe.");
				}

				Curso c1 = cursos.get(codigo);
				ArrayList<Alumno> inscritos1 = c1.getInscritos();

				System.out.print("Introduce el DNI del Alumno: ");
				String dni = sc.nextLine();

				for (Alumno a : inscritos1) {
					if (a.getDni().equalsIgnoreCase(dni)) {
						throw new AlumnoYaInscritoException("El alumno ya está inscrito en este curso.");
					}
				}

				System.out.print("Introduce el nombre del Alumno: ");
				String nombre = sc.nextLine();
				System.out.print("Introduce el email del Alumno: ");
				String email = sc.nextLine();

				inscritos1.add(new Alumno(dni, nombre, email));
				valido = true;
				System.out.println("\nAlumno inscrito con éxito.");

			} catch (CursoNoEncontradoException | AlumnoYaInscritoException e) {
				System.out.println("\nError: " + e.getMessage());
			}
		}
	}

	public static void cargarDatos() {
	    // Cursos
	    Curso c1 = new Curso("INF01", "Programación Java");
	    Curso c2 = new Curso("INF02", "Bases de Datos");
	    Curso c3 = new Curso("INF03", "Desarrollo Web");
	    Curso c4 = new Curso("INF04", "Ciberseguridad");
	    Curso c5 = new Curso("INF05", "Diseño UI/UX");
	    
	    cursos.put("INF01", c1);
	    cursos.put("INF02", c2);
	    cursos.put("INF03", c3);
	    cursos.put("INF04", c4);
	    cursos.put("INF05", c5);

	    // Alumnos
	    Alumno a1 = new Alumno("12345678A", "Ana García", "ana@email.com");
	    Alumno a2 = new Alumno("23456789B", "Luis Rodríguez", "luis@email.com");
	    Alumno a3 = new Alumno("34567890C", "María López", "maria@email.com");
	    Alumno a4 = new Alumno("45678901D", "Pedro Ruiz", "pedro@email.com");
	    Alumno a5 = new Alumno("56789012E", "Elena Sanz", "elena@email.com");
	    Alumno a6 = new Alumno("67890123F", "Javier Gómez", "javier@email.com");
	    Alumno a7 = new Alumno("78901234G", "Lucía Martín", "lucia@email.com");
	    Alumno a8 = new Alumno("89012345H", "Carlos Vega", "carlos@email.com");
	    Alumno a9 = new Alumno("90123456I", "Isabel Cano", "isabel@email.com");
	    Alumno a10 = new Alumno("01234567J", "Marcos Soler", "marcos@email.com");

	    // Inscripciones repartidas
	    c1.getInscritos().add(a1);
	    c1.getInscritos().add(a2);
	    c1.getInscritos().add(a3);
	    
	    c2.getInscritos().add(a4);
	    c2.getInscritos().add(a5);
	    c2.getInscritos().add(a10); // Marcos también hace Bases de Datos
	    
	    c3.getInscritos().add(a6);
	    c3.getInscritos().add(a7);
	    
	    c4.getInscritos().add(a8);
	    c4.getInscritos().add(a9);
	    
	    c5.getInscritos().add(a10);

	    System.out.println("Datos cargados correctamente: 5 cursos y 10 alumnos disponibles.");
	}

}