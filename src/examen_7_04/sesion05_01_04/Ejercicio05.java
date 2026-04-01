package examen_7_04.sesion05_01_04;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Ejercicio05 {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);

		try {

			System.out.print("Introduce el dividendo: ");
			int dividendo = sc.nextInt();

			System.out.print("Introduce el divisor: ");
			int divisor = sc.nextInt();

			int resultado = dividendo / divisor;

			System.out.println("Resultado: " + dividendo + " / " + divisor + " = " + resultado);

		} catch (ArithmeticException e) {
			System.out.println("Error: No se puede dividir por cero");

		} catch (InputMismatchException e) {
			System.out.println("Error: Debes introducir un número entero");

		} finally {
			sc.close();
		}

	}

}
