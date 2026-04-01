package examen_7_04.sesion05_01_04;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Ejercicio08 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		char[] nombre = new char[10];
		double estatura = 0;
		double peso = 0;
		boolean datosValidos = false;

		// Pedir datos con control de excepciones
		while (!datosValidos) {
			try {
				// Pedir nombre
				System.out.print("Nombre (máx 10 caracteres): ");
				String nombreTemp = sc.next();

				// Convertir String a char[] controlando desborde
				if (nombreTemp.length() > 10) {
					throw new ArrayIndexOutOfBoundsException("Nombre demasiado largo (máx 10 caracteres)");
				}

				for (int i = 0; i < nombreTemp.length(); i++) {
					nombre[i] = nombreTemp.charAt(i);
				}

				// Pedir estatura
				System.out.print("Estatura (m): ");
				estatura = sc.nextDouble();

				// Pedir peso
				System.out.print("Peso (kg): ");
				peso = sc.nextDouble();

				// Si llegamos aquí, datos válidos
				datosValidos = true;

			} catch (InputMismatchException e) {
				System.out.println("❌ Error: Debes introducir el tipo de dato correcto");
				sc.nextLine(); // Limpiar buffer

			} catch (ArrayIndexOutOfBoundsException e) {
				System.out.println("❌ Error: " + e.getMessage());
			}
		}

		// Calcular IMC controlando división por cero
		try {
			if (estatura == 0) {
				throw new ArithmeticException("La estatura no puede ser 0");
			}

			double imc = peso / (estatura * estatura);

			System.out.println("\n✅ Datos registrados:");
			System.out.println("Nombre: " + new String(nombre).trim());
			System.out.println("Estatura: " + estatura + " m");
			System.out.println("Peso: " + peso + " kg");
			System.out.printf("IMC: %.2f\n", imc);

		} catch (ArithmeticException e) {
			System.out.println("❌ Error: " + e.getMessage());
		}

		sc.close();
	}
}
