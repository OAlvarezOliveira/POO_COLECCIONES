package examen_7_04.sesion05_01_04;

import java.util.HashMap;
import java.util.Map.Entry;
import java.util.Scanner;

public class Ejercicio10 {
	
	public static void main(String[] args) {
		
		String frase;
		String[] palabras;
		Scanner teclado = new Scanner(System.in);
		HashMap<String, Integer> contador = new HashMap<>();
		      /*palabra,cantidad*/ 
		
		System.out.println("introduce una frase a procesar:");
		frase = teclado.nextLine();
		palabras = frase.split(" ");
		
		for (String palabra : palabras) {
			
			if (contador.containsKey(palabra)) {
			    int actual = contador.get(palabra);
			    contador.put(palabra, actual + 1);
			} else {
			    contador.put(palabra, 1);
			}
			
		}
		
		for (Entry<String, Integer> entry : contador.entrySet()) {
		    System.out.println(entry.getKey() + ": " + entry.getValue());
		}
		
		teclado.close();
	}

}
