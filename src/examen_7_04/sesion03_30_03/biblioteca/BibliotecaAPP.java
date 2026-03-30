package examen_7_04.sesion03_30_03.biblioteca;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map.Entry;

public class BibliotecaAPP {

	// Catálogo completo de libros
	private static HashMap<String, Libro> catalogo = new HashMap<>();
	// Clave: ISBN
	// Valor: objeto Libro

	// Libros actualmente prestados (solo ISBN)
	private static HashSet<String> prestados = new HashSet<>();

	public static void main(String[] args) {

		// Añadir libros
		añadirLibro("978-1", "El Quijote", "Cervantes");
		añadirLibro("978-2", "Cien años de soledad", "García Márquez");
		añadirLibro("978-3", "1984", "Orwell");
		añadirLibro("978-4", "El principito", "Saint-Exupéry");
		añadirLibro("978-5", "Harry Potter", "Rowling");

		// Prestar
		prestarLibro("978-1"); // ✅ El Quijote prestado
		prestarLibro("978-3"); // ✅ 1984 prestado
		prestarLibro("978-3"); // ❌ Ya está prestado
		prestarLibro("978-9"); // ❌ No existe

		// Devolver
		devolverLibro("978-1"); // ✅ El Quijote devuelto
		devolverLibro("978-2"); // ❌ No estaba prestado

		// Buscar
		buscarLibro("978-3"); // Encontrado - PRESTADO
		buscarLibro("978-4"); // Encontrado - DISPONIBLE

		// Listar
		listarDisponibles();
		listarPrestados();
		estadisticas();

	}

	private static void estadisticas() {
		
		System.out.println("Total catálogo: " + catalogo.size());
		System.out.println("Prestados:  " + prestados.size());
		System.out.println("Disponibles: " + (catalogo.size() - prestados.size()));


	}

	private static void listarPrestados() {
		 System.out.println("Libros Prestados:");
		    for (Entry<String, Libro> entry : catalogo.entrySet()) {
		        if (prestados.contains(entry.getKey())) { 
		            Libro libro = entry.getValue();
		            System.out.println("- " + libro);
		        }
		    }

	}

	public static void listarDisponibles() {
	    System.out.println("Libros disponibles:");
	    for (Entry<String, Libro> entry : catalogo.entrySet()) {
	        if (!prestados.contains(entry.getKey())) {  // NO está en prestados
	            Libro libro = entry.getValue();
	            System.out.println("- " + libro);
	        }
	    }
	}

	private static void buscarLibro(String isbn) {

		if (!catalogo.containsKey(isbn)) {
	        System.out.println("Libro no encontrado");
	        return;
	    }
	    
	    Libro libro = catalogo.get(isbn);
	    if (prestados.contains(isbn)) {
	        System.out.println(libro.getTitulo() + " [PRESTADO]");
	    } else {
	        System.out.println(libro.getTitulo() + " [DISPONIBLE]");
	    }

	}

	private static void devolverLibro(String isbn) {

		Libro libro = catalogo.get(isbn);

		if (prestados.contains(isbn)) {
			prestados.remove(isbn);
			System.out.println("Devolucion Realizada: " + libro.getTitulo());
		} else {
			System.out.println("El libro no estaba prestado: " + libro.getIsbn());

		}

	}

	private static void prestarLibro(String isbn) {
		// 1. Validar que existe
	    if (!catalogo.containsKey(isbn)) {
	        System.out.println(" Libro no encontrado");
	        return;
	    }
	    
	    // 2. Validar que no está prestado
	    if (prestados.contains(isbn)) {
	        System.out.println("El libro ya está prestado");
	        return;
	    }
	    
	    // 3. Prestar
	    prestados.add(isbn);
	    Libro libro = catalogo.get(isbn);
	    System.out.println("Préstamo: " + libro.getTitulo() + " ✅");
	}

	private static void añadirLibro(String isbn, String titulo, String autor) {

		if (catalogo.containsKey(isbn)) {
			System.out.println("El libro ya existe no es posible añadirlo: ");
		} else {

			Libro l1 = new Libro(isbn, titulo, autor);
			catalogo.put(isbn, l1);
			System.out.println("Libro Añadido: " + l1.getIsbn() + " " + l1.getTitulo());

		}

	}

}
