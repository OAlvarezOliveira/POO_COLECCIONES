package excepciones01;

import java.io.File;
import java.io.FileNotFoundException;
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

public class App2 {

	public static void main(String[] args) throws FileNotFoundException  {
		
		leerArchivo();
			

	}
	
	/**
	 * 
	 * @throws FileNotFoundException
	 */
	private static void leerArchivo() throws FileNotFoundException {
		File f = new File("datos.txt");
		

			
			Scanner lector = new Scanner(f);
	}

}
