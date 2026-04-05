package examen_7_04.sistemaBiblioteca;

import java.util.HashMap;
import java.util.Scanner;

import java.util.InputMismatchException;
import java.util.Map.Entry;

import examen_7_04.sistemaBiblioteca.excepcionesPersonalizadas.FechaInvalidaException;
import examen_7_04.sistemaBiblioteca.excepcionesPersonalizadas.PrestamoNoEncontradoException;
import examen_7_04.sistemaBiblioteca.excepcionesPersonalizadas.LibroNoDisponibleException;

public class GestorBiblioteca {

	private static HashMap<String, Libro> catalogoLibros = new HashMap<>();
	// (clave: ISBN)
	private static HashMap<String, Prestamo> prestamosActivos = new HashMap<>();
	// (clave: codigoPrestamo)
	private static Scanner sc = new Scanner(System.in);

	private static String ultimoCodigo = "P004";

	public static void main(String[] args) {

		// datos prueba
		cargarDatos();

		//
		mostrarMenu();
	}

	private static void mostrarMenu() {
		int opcion = 0;

		do {
			System.out.println("\n=== SISTEMA BIBLIOTECA ===");
			System.out.println("1. Realizar préstamo");
			System.out.println("2. Devolver libro");
			System.out.println("3. Consultar disponibilidad");
			System.out.println("4. Listar libros disponibles");
			System.out.println("5. Listar préstamos activos");
			System.out.println("6. Salir");
			System.out.println("Elige opción (1-6):");

			try {
				opcion = sc.nextInt();
				sc.nextLine();
			} catch (InputMismatchException e) {
				System.out.println("La opcion debe ser un valor numerico del 1-7");
				sc.nextLine();
				opcion = 0;
			}

			switch (opcion) {
			case 1:
				try {
					realizarPrestamo();
				} catch (LibroNoDisponibleException | FechaInvalidaException e) {
					System.out.println(e.getMessage());
				}
				break;
			case 2:
				try {
					devolverLibro();
				} catch (PrestamoNoEncontradoException e) {
					System.out.println(e.getMessage());
				}
				break;
			case 3:
				try {
					consultarDisponibilidad();
				} catch (LibroNoDisponibleException e) {
					System.out.println(e.getMessage());
				}
				break;
			case 4:
				listarLibrosDisponibles();
				break;
			case 5:
				listarPrestamosActivos();
				break;
			case 6:
				System.out.println("¡Adiós!");
				break;
			default:
				System.out.println("Opción inválida");
			}

		} while (opcion != 6);

	}

	private static void listarPrestamosActivos() {

		if (prestamosActivos.isEmpty()) {
			System.out.println("No hay prestamos activos");
		} else {
			for (Entry<String, Prestamo> elemento : prestamosActivos.entrySet()) {
				System.out.println(elemento.getValue());
			}
		}
	}

	private static void listarLibrosDisponibles() {
		boolean hayDisponibles = false;

		for (Entry<String, Libro> elemento : catalogoLibros.entrySet()) {
			if (!elemento.getValue().isPrestado()) {
				System.out.println(elemento.getValue());
			}
		}
		if (!hayDisponibles) {
			System.out.println("No hay libros disponibles");
		}
	}

	private static void consultarDisponibilidad() throws LibroNoDisponibleException {

		System.out.println("Introduce el ISBN para ver su disponibilidad");
		String isbn = sc.nextLine();

		if (!catalogoLibros.containsKey(isbn)) {
			throw new LibroNoDisponibleException("Libro no existe");
		}
		Libro l = catalogoLibros.get(isbn);

		if (l == null) {
			System.out.println("Error: El libro con ISBN " + isbn + " no existe en el catálogo.");
			return;
		}

		if (l.isPrestado()) {
			System.out.println("El libro '" + l.getTitulo() + "' está actualmente prestado.");
		} else {
			System.out.println("El libro '" + l.getTitulo() + "' está disponible.");
		}
	}

	private static void devolverLibro() throws PrestamoNoEncontradoException {

		System.out.println("Introduce el  código préstamo para devolver el libro");
		String codigoPrestamo = sc.nextLine();

		if (!prestamosActivos.containsKey(codigoPrestamo)) {
			throw new PrestamoNoEncontradoException(codigoPrestamo + "no existe");
		} else {

			Prestamo p = prestamosActivos.get(codigoPrestamo);
			Libro l = p.getLibro();
			l.setPrestado(false);
			prestamosActivos.remove(codigoPrestamo);
			System.out.println("El préstamo" + codigoPrestamo + "se ha realizado de forma satisfactoria");

		}

	}

	private static void realizarPrestamo() throws LibroNoDisponibleException, FechaInvalidaException {

		System.out.print("Introduce el ISBN del libro: ");
		String isbn = sc.nextLine();

		System.out.print("Introduce el nombre del Socio receptor: ");
		String nombreUsuario = sc.nextLine();

		int diasPrestamo = -1;
		boolean entradaValida = false;

		while (!entradaValida) {
			try {
				System.out.print("Introduce los días de préstamo (0-15): ");
				String entrada = sc.nextLine();
				diasPrestamo = Integer.parseInt(entrada);

				if (diasPrestamo >= 0 && diasPrestamo <= 15) {
					entradaValida = true;
				} else {
					System.out.println("Error: El número debe estar entre 0 y 15.");
				}
			} catch (NumberFormatException e) {
				System.out.println("Error: Debes introducir un valor numérico entero.");
			}
		}

		if (!catalogoLibros.containsKey(isbn)) {
			throw new LibroNoDisponibleException("Libro no existe en catálogo");
		}
		Libro l = catalogoLibros.get(isbn);

		if (l.isPrestado()) {
			throw new LibroNoDisponibleException("El libro con ISBN " + isbn + " no se puede prestar.");
		} else if (diasPrestamo == 0) {
			throw new FechaInvalidaException("La duración del préstamo no puede ser de 0 días.");
		} else {

			l.setPrestado(true);
			String nuevoCodigo = creaCodigoPrestamoUnico();
			Prestamo p1 = new Prestamo(nuevoCodigo, l, nombreUsuario, diasPrestamo);
			prestamosActivos.put(nuevoCodigo, p1);

		}
		System.out.println("\n¡Éxito! Préstamo registrado para " + nombreUsuario + " por " + diasPrestamo + " días.");
	}

	public static String creaCodigoPrestamoUnico() {
		int numero = Integer.parseInt(ultimoCodigo.substring(1));
		numero++;
		String nuevoCodigo = String.format("P%03d", numero);
		ultimoCodigo = nuevoCodigo;
		return nuevoCodigo;
	}

	private static void cargarDatos() {

		Libro l1 = new Libro("9788422616", "La sombra del viento", "Carlos Ruiz Zafón", false);
		Libro l2 = new Libro("9780307474", "Crónica de una muerte anunciada", "Gabriel García Márquez", true);
		Libro l3 = new Libro("9788466659", "El nombre de la rosa", "Umberto Eco", false);
		Libro l4 = new Libro("9788466332", "Cien años de soledad", "Gabriel García Márquez", false);
		Libro l5 = new Libro("9788408224", "El código Da Vinci", "Dan Brown", true);
		Libro l6 = new Libro("9788420471", "Dime quién soy", "Julia Navarro", false);
		Libro l7 = new Libro("9788497592", "1984", "George Orwell", true);
		Libro l8 = new Libro("9780451524", "Rebelión en la granja", "George Orwell", false);
		Libro l9 = new Libro("9788433920", "Los pilares de la Tierra", "Ken Follett", true);

		// Cargar Libros
		catalogoLibros.put(l1.getIsbn(), l1);
		catalogoLibros.put(l2.getIsbn(), l2);
		catalogoLibros.put(l3.getIsbn(), l3);
		catalogoLibros.put(l4.getIsbn(), l4);
		catalogoLibros.put(l5.getIsbn(), l5);
		catalogoLibros.put(l6.getIsbn(), l6);
		catalogoLibros.put(l7.getIsbn(), l7);
		catalogoLibros.put(l8.getIsbn(), l8);
		catalogoLibros.put(l9.getIsbn(), l9);

		Prestamo p1 = new Prestamo("P001", l2, "Juan Pérez", 15);
		Prestamo p2 = new Prestamo("P002", l5, "Ana García", 7);
		Prestamo p3 = new Prestamo("P003", l7, "Carlos Ruiz", 30);
		Prestamo p4 = new Prestamo("P004", l9, "Elena Sanz", 10);

		// Cargar prestamos
		prestamosActivos.put("P001", p1);
		prestamosActivos.put("P002", p2);
		prestamosActivos.put("P003", p3);
		prestamosActivos.put("P004", p4);
		
		
		

	}

}
