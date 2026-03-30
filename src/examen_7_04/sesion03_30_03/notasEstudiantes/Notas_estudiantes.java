package examen_7_04.sesion03_30_03.notasEstudiantes;

import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

public class Notas_estudiantes {

	private static HashMap<String, Double> notas = new HashMap<>();

	public static void main(String[] args) {

		// Añadir Datos
		cargaDatosPrueba();
		// Mostrar estudiantes con nota >= 5
		mostrarAprobados();
		// Mostrar estudiantes con nota >= 9
		mostrarSobresalientes();
		// Calcular nota media de todos
		calcularMedia();
		// Encontrar estudiante con mejor nota
		mejorEstudiante();

	}

	private static void mejorEstudiante() {

		String mejorEstudiante = "";
		double mayor = -1.0;

		for (Entry<String, Double> entry : notas.entrySet()) {
			String nombre = entry.getKey();
			double nota = entry.getValue();

			if (nota > mayor) {

				mayor = entry.getValue();

				mejorEstudiante = entry.getKey();
			}
		}

		System.out.printf("Mejor estudiante: %s (%.2f) \n\n", mejorEstudiante, mayor);

	}

	private static void calcularMedia() {
		double resultado = 0.0;
		double suma = 0.0;

		for (Entry<String, Double> entry : notas.entrySet()) {
			String nombre = entry.getKey();
			double nota = entry.getValue();
			suma += nota;
		}

		if (notas.size() > 0) {

			resultado = (double) (suma / notas.size());
			System.out.printf("Nota media: %.2f \n\n", resultado);

		} else {

			System.out.println("No hay elementos suficientes para calcular media \n");

		}

	}

	private static void mostrarSobresalientes() {
		System.out.println("\n\nSobresalientes (nota >= 9)");
		for (Entry<String, Double> entry : notas.entrySet()) {
			String nombre = entry.getKey();
			double nota = entry.getValue();

			if (nota >= 9.0) {
				System.out.println(nombre + ": " + notas);
			}

		}

		System.out.println();

	}

	private static void mostrarAprobados() {
		System.out.println("\n\nAprobados (nota >= 5)");
		for (Entry<String, Double> entry : notas.entrySet()) {
			String nombre = entry.getKey();
			double nota = entry.getValue();

			if (nota >= 5.0) {
				System.out.println(nombre + ": " + notas);
			}
		}

	}

	public static void cargaDatosPrueba() {
		// Añadir
		notas.put("Ana García", 8.5);
		notas.put("Luis Pérez", 7.2);
		notas.put("María Ruiz", 9.1);
		notas.put("Pedro Sanz", 5.8);
		notas.put("Laura Díaz", 6.5);
	}

}
