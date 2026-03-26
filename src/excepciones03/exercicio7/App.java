package excepciones03.exercicio7;

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

public class App {
	public static void recursionInfinita() {
        recursionInfinita();
    }

    public static void main(String[] args) {
        try {
            // 🔹 Descomenta una de las dos líneas para probar cada error:

            // 1. Provocar StackOverflowError
            // recursionInfinita();

            // 2. Provocar OutOfMemoryError
            int[] arrayGigante = new int[Integer.MAX_VALUE]; 

        } catch (StackOverflowError e) {
            System.out.println("❌ Error: Se produjo un StackOverflowError.");
        } catch (OutOfMemoryError e) {
            System.out.println("❌ Error: Se produjo un OutOfMemoryError.");
        }
    }
}

