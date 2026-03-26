package Boletin;

/*Ejercicio de examen pero con numeros - repetir hasta el infinito*/
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.Scanner;


public class Ejercicio01 {


	private static ArrayList<String> nombres;
	
	public static void main(String[] args) {
		
		leerNombres();		
		if(!nombres.isEmpty()) {
			
			imprimirNombres();
			quitarDuplicados();
			ordenarNombres();
			imprimirNombres();
			
		}



	}


	private static void quitarDuplicados() {
		
		HashSet<String> conjunto = new HashSet<>(nombres);
		//Set<String> conjunto = new HashSet<>(nombres);
		nombres = new ArrayList(conjunto);
	}


	private static void ordenarNombres() {
		
		Collections.sort(nombres);
		
	}


	private static void imprimirNombres() {
		
		System.out.printf("\nImprimiendo lista de nombres\n");
		for (String n : nombres) {
			System.out.printf("%s\n", n);
		}
		
	}


	private static void leerNombres() {
				
		Scanner teclado = new Scanner(System.in);
		nombres = new ArrayList<String>();
		String nombre;
		
		while(true) {
			System.out.printf("Introduce un nombre: ");
			nombre = teclado.nextLine();
			if(nombre.equalsIgnoreCase("fin")) {
				break;
			}
			if(nombre.isBlank()) {
				System.out.println("no se permiten nombres en blanco");
				continue;
			}
			nombres.add(nombre);
		}
		
	}


}

