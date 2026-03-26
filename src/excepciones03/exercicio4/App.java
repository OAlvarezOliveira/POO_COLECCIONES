package excepciones03.exercicio4;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Scanner;

/**
 * Resolución de la tarea xx
 * 
 * Curso 2025-26
 * @author Julio Mosquera
 * @version 1.0
 */

public class App {
	public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Introduce el nombre del archivo: ");
        String rutaArchivo = sc.nextLine();

        File file = new File(rutaArchivo);

        try (Scanner lector = new Scanner(file)) {
            while (lector.hasNextLine()) {
                System.out.println(lector.nextLine());
            }
        } catch (FileNotFoundException e) {
            System.out.println("❌ Archivo no encontrado: " + rutaArchivo);
        } catch (IOException e) {
            System.out.println("❌ Error de lectura en el archivo");
        } finally {
            sc.close();
        }
    }
}

