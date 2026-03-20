package coleccions;

import java.util.HashSet;
import java.util.Scanner;

/**
 * Resolucion de la tarea 
 * 
 * Curso 2025-26
 * 
 * @author O.Alvarez
 * @version 1.0
 *
 */

public class App {
	
	private static HashSet numeros; 

	public static void main(String[] args) {


		leerNumeros();
		mostrarNumeros();

	}

	private static void mostrarNumeros() {
		// TODO Auto-generated method stub
		
	}

	private static void leerNumeros() {
		
		Scanner teclado = new Scanner (System.in);
		numeros = new HashSet();
		
		for (int i = 0; i < 10; i++) {
			
			System.out.printf("Introduce números: ");
			numeros.add(teclado.nextInt());
			
		}
		
	}

}
