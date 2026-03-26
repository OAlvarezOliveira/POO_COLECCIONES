package excepciones03.exercicio5;

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
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

        try {
            System.out.print("Introduce el numerador: ");
            int a = sc.nextInt();

            System.out.print("Introduce el denominador: ");
            int b = sc.nextInt();

            int resultado = a / b;
            System.out.println("Resultado = " + resultado);

        } catch (ArithmeticException e) {
            System.out.println("❌ No se puede dividir entre 0.");
        } catch (InputMismatchException e) {
            System.out.println("❌ Debes introducir un número entero.");
        } finally {
            sc.close();
        }
    }
}

