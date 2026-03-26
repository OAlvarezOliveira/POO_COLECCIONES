package excepciones02;


import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;


public class App {


	private static ArrayList<Arbol> bosque;


	public static void main(String[] args) throws FileNotFoundException {


		String[] linea;
		bosque = new ArrayList<Arbol>();
		
		File fichero = new File("C:/Users/damdu101/Desktop/arboles.txt");
		Scanner sc = new Scanner(fichero);
		while(sc.hasNextLine()) {
			linea = sc.nextLine().split("#");
			try {
				bosque.add(new Arbol(Integer.parseInt(linea[1]), linea[0]));


			} catch (ArbolException | NumberFormatException e) {
				System.out.println("Formato de número no válido: " + e.getMessage());				
			} catch (Exception e) {
				System.out.println("Error general: " + e.getMessage());				
			} 
		}


		// Listar
		for (Arbol a : bosque) {
			System.out.println(a);
		}


	}


}




