package excepciones03.exercicio8;

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

        String nombre = "";
        double estatura = 0;
        double peso = 0;

        // a) Pedir nombre con control de desbordamiento en el array de chars
        boolean nombreValido = false;
        while (!nombreValido) {
            try {
                System.out.print("Introduce el nombre: ");
                nombre = sc.nextLine();

                char[] buffer = new char[10];
                buffer = nombre.toCharArray();
                if (nombre.length() > buffer.length) {
                    throw new ArrayIndexOutOfBoundsException("El nombre excede las 10 posiciones.");
                }
                // Copiamos el nombre al array
                for (int i = 0; i < nombre.length(); i++) {
                    buffer[i] = nombre.charAt(i);
                }
                nombreValido = true;

            } catch (ArrayIndexOutOfBoundsException e) {
                System.out.println("❌ Error: " + e.getMessage());
                System.out.println("Vuelve a introducir un nombre más corto.");
            }
        }

        // b) Pedir estatura (en metros)
        boolean estaturaValida = false;
        while (!estaturaValida) {
            try {
                System.out.print("Introduce la estatura (m): ");
                estatura = sc.nextDouble();
                estaturaValida = true;
            } catch (InputMismatchException e) {
                System.out.println("❌ Error: Debes introducir un número (usa . como separador decimal).");
                sc.nextLine(); // limpiar buffer
            }
        }

        // c) Pedir peso (en kg)
        boolean pesoValido = false;
        while (!pesoValido) {
            try {
                System.out.print("Introduce el peso (kg): ");
                peso = sc.nextDouble();
                pesoValido = true;
            } catch (InputMismatchException e) {
                System.out.println("❌ Error: Debes introducir un número (usa . como separador decimal).");
                sc.nextLine(); // limpiar buffer
            }
        }

        // Calcular IMC con control de división por cero
        try {
            if (estatura == 0) {
                throw new ArithmeticException("La estatura no puede ser cero.");
            }
            double imc = peso / (estatura * estatura);
            System.out.printf("✅ El IMC de %s es: %.2f\n", nombre, imc);

        } catch (ArithmeticException e) {
            System.out.println("❌ Error: " + e.getMessage());
        }

        sc.close();
    }
}

