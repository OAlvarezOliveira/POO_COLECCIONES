package excepciones03.exercicio6;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.InputMismatchException;
import java.util.Scanner;

/**
 * Resolución de la tarea xx
 * 
 * Curso 2025-26
 * @author Julio Mosquera
 * @version 1.0
 */

class EdadInvalidaException extends Exception {
    public EdadInvalidaException(String mensaje) {
        super(mensaje);
    }
}

public class App {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        try {
            System.out.print("Introduce tu edad: ");
            int edad = sc.nextInt();

            if (edad < 0 || edad > 120) {
                throw new EdadInvalidaException("La edad " + edad + " no es válida.");
            }

            System.out.println("✅ Edad aceptada: " + edad);

        } catch (EdadInvalidaException e) {
            System.out.println("❌ Error: " + e.getMessage());
        } finally {
            sc.close();
        }
    }
}

