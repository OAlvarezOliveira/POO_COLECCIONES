package coleccions.HashMap;


import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;


public class AppHashMap {


	private static HashMap<String, Vehiculo> coches;
	
	public static void main(String[] args) {
		
		insertarVehiculos();
		// listarVehiculos2();
		existeVehiculo();		
		
	}


	private static void existeVehiculo() {
		
		String matricula;
		Scanner teclado = new Scanner(System.in);
		
		System.out.printf("Introduce la matrícula para comprobar si existe: ");
		matricula = teclado.nextLine();
		
		if(coches.containsKey(matricula)) {			
			System.out.println("Si existe");
		} else {
			System.out.println("No existe");
		}
		
	}


	private static void listarVehiculos() {
		
		//Devuelve un conjunto/set de String
		Set<String> matriculas = coches.keySet();
		
		for(String matricula : matriculas) {
			System.out.printf("%s ---- %s\n", matricula, coches.get(matricula));
		}
		
	}


	private static void insertarVehiculos() {
		
		inicializarCoches();
		coches.put("4567BDW", new Vehiculo("Toyota", "Julio Mosquera"));
		coches.put("OR4568L", new Vehiculo("Seat", "Susana Pérez"));
		coches.put("1313LZX", new Vehiculo("Citroen", "Luis María"));
		coches.put("0000CCC", new Vehiculo("Renault", "Reinaldo López"));
		
	}


	private static void inicializarCoches() {
		coches = new HashMap();
		
	}


}
