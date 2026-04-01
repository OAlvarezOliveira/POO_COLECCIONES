package examen_7_04.sesion05_01_04;

import java.util.Scanner;

public class Ejercicio06 {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);

		try {

			System.out.print("Introduce tu edad: ");
			int edad = sc.nextInt();

			if (edad < 0 || edad > 120) {
				throw new EdadInvalidaException("Edad inválida: " + edad + ". Debe estar entre 0 y 120");

			}

			System.out.println("Edad válida: " + edad + " años");

		} catch (EdadInvalidaException e) {
            System.out.println("Error: " + e.getMessage());

		} catch (Exception e) {
			System.out.println("Error inesperado: " + e.getMessage());

		} finally {
			sc.close();
		}

	}

}
