package boletin;

import java.util.HashMap;
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

public class Ejercicio02 {
	
	private static HashMap<String , Integer> contador;
	
public static void main(String[] args) {
		
		String frase;
		
		frase = leerFrase();
		try {
			contarApariciones(frase);
			imprimir();
		} catch(IllegalArgumentException e) {
			System.out.println(e.getMessage());
		} catch(Exception e) {
			System.out.println("Error general: " + e.getMessage());
		} 
		


	}

	private static void imprimir() {
		System.out.printf("\nImprimiendo estadisticas\n");

		for(String clave :contador.keySet()) {
			
			System.out.printf("%s:%d \n", clave, contador.get(clave));

			
		}
		
		
	}

	private static void contarApariciones(String oracion)  throws IllegalArgumentException{
		
		contador = new HashMap<>();
		int num;
		
		if(oracion.isBlank()) { throw new  IllegalArgumentException("no se permiten frases vacias"); }
		
		
		String [] palabras= oracion.split("\\s+");
		for (String palabra : palabras) {
////intento recuperar la palabra del mapa . po si ya existe
//			if(contador.get(palabra) == null) {contador.put(palabra, 1);}else {
//				
//				num= contador.get(palabra);
//				contador.put(palabra, ++num);
//				
//			}
			
			contador.put(palabra, contador.getOrDefault(palabra, 0)+1);
		}
		
		
	}

	private static String leerFrase() {
		
		Scanner teclado = new Scanner(System.in);
		
		System.out.println("Introduzca una frase");
		return teclado.nextLine();
	
	}
	
}

