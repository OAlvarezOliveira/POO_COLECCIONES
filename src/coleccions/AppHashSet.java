package coleccions;


import java.util.HashSet;
import java.util.Iterator;
import java.util.Scanner;
import java.util.Set;


public class AppHashSet {


	private static HashSet<Integer> numeros;
	
	public static void main(String[] args) {
		
		leerNumeros();
		mostrarNumeros();
		System.out.printf("Número de valores únicos: %d\n", cantidadValoresUnicos());
		
		if(existe(5)) {
			System.out.println("Existe en el conjunto");
		} else {
			System.out.println("No existe en el conjunto");
		}


	}


	private static boolean existe(int num) {
		
		return numeros.contains(num);
	}


	private static Object cantidadValoresUnicos() {
		return numeros.size();
	}


	private static void mostrarNumeros() {
		
		/*for (Integer numero : numeros) {
			System.out.println(numero);
		}*/
		
		Iterator<Integer> it = numeros.iterator();
		while(it.hasNext()) {
			System.out.println(it.next());
		}
		
	}


	private static void leerNumeros() {		
		
		Scanner teclado = new Scanner(System.in);
		
		numeros = new HashSet<Integer>();
		
		for (int i = 0; i < 10; i++) {
			System.out.printf("Introduce número: ");
			numeros.add(teclado.nextInt());
		}
		
	}


}

