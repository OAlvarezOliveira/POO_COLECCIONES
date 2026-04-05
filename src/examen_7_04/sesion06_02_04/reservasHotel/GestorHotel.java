package examen_7_04.sesion06_02_04.reservasHotel;

import java.util.HashMap;
import java.util.InputMismatchException;
import java.util.Iterator;
import java.util.Map.Entry;
import java.util.Scanner;

public class GestorHotel {
	private static HashMap<String, Reserva> reservas = new HashMap<>();
	private static Scanner sc = new Scanner(System.in);

	public static void main(String[] args) {
		cargarDatos(); // Crear 2-3 reservas de prueba
		mostrarMenu();

	}

	private static void cargarDatos() {
		Reserva r1 = new Reserva("209S040426", "Marta Lopez", 209, 5, true);
		Reserva r2 = new Reserva("318D050326", "Marta Lopez", 318, 5, false);
		Reserva r3 = new Reserva("102D050326", "Marta Lopez", 209, 5, true);

		reservas.put(r1.getCodigoReserva(), r1);
		reservas.put(r2.getCodigoReserva(), r2);
		reservas.put(r3.getCodigoReserva(), r3);

	}

	private static void mostrarMenu() {
		int opcion = 0;

		do {
			System.out.println("\n=== SISTEMA RESERVAS HOTEL ===");
			System.out.println("1. Crear reserva");
			System.out.println("2. Cancelar reserva");
			System.out.println("3. Marcar reserva como pagada");
			System.out.println("4. Consultar reserva");
			System.out.println("5. Listar todas las reservas");
			System.out.println("6- Salir");
			System.out.println("Elige opción (1-6):");

			try {
				opcion = sc.nextInt();
				sc.nextLine();
			} catch (InputMismatchException e) {
				System.out.println("La opcion debe ser un valor numerico del 1-7");
				sc.nextLine();
				opcion = 0;
			}

			switch (opcion) {
			case 1:
				try {
					crearReserva();
				} catch (ReservaYaExisteException | FechaInvalidaException e) {
					System.out.println(e.getMessage());
				}
				break;
			case 2:
				try {
					cancelarReserva();
				} catch (ReservaNoEncontradaException e) {
					System.out.println(e.getMessage());
				}
				break;
			case 3:
				try {
					marcarPagada();
				} catch (ReservaNoEncontradaException e) {
					System.out.println(e.getMessage());
				}
				break;
			case 4:
				try {
					consultarReserva();
				} catch (ReservaNoEncontradaException e) {
					System.out.println(e.getMessage());
				}
				break;
			case 5:
				listarTodasReservas();
				break;
			case 6:
				System.out.println("¡Adiós!");
				break;
			default:
				System.out.println("Opción inválida");
			}

		} while (opcion != 6);

	}

	private static void listarTodasReservas() {

		if (reservas.isEmpty()) {
			System.out.println("No hay reservas guardadas en el sistema");
		} else {
			for (Entry<String, Reserva> elemento : reservas.entrySet()) {
				System.out.println(elemento.getValue());
			}
		}
	}

	private static void consultarReserva() throws ReservaNoEncontradaException {
		System.out.print("Código reserva: ");
		String codigo = sc.nextLine();

		if (!reservas.containsKey(codigo)) {
			throw new ReservaNoEncontradaException("La reserva " + codigo + " no existe");
		}

		Reserva r = reservas.get(codigo);
		System.out.println(r);

	}

	private static void marcarPagada() throws ReservaNoEncontradaException {
		System.out.print("Código reserva: ");
		String codigo = sc.nextLine();

		if (!reservas.containsKey(codigo)) {
			throw new ReservaNoEncontradaException("La reserva " + codigo + " no existe");
		}

		Reserva r = reservas.get(codigo); 

		if (r.isPagado()) {
			System.out.println("Ya estaba pagada");
		} else {
			r.setPagado(true);
			System.out.println("✅ Marcada como pagada");
		}
	}

	private static void cancelarReserva() throws ReservaNoEncontradaException {

		System.out.print("Código reserva: ");
		String codigo = sc.nextLine();

		if (!reservas.containsKey(codigo)) {
			throw new ReservaNoEncontradaException("La reserva " + codigo + " no existe");
		}

		reservas.remove(codigo); // Directo, ya validaste
		System.out.println("Reserva " + codigo + " eliminada");

	}

	private static void crearReserva() throws ReservaYaExisteException, FechaInvalidaException {

		// PASO 1: Pedir datos
		System.out.print("Código reserva: ");
		String codigo = sc.nextLine();

		System.out.print("Nombre cliente: ");
		String nombre = sc.nextLine();

		System.out.print("Número habitación: ");
		int habitacion = sc.nextInt();
		sc.nextLine();

		System.out.print("Número de noches: ");
		int noches = sc.nextInt();
		sc.nextLine();

		// PASO 2: Validar datos simples
		if (noches <= 0) {
			throw new FechaInvalidaException("Las noches deben ser positivas");
		}

		// PASO 3: Validar que NO exista (clave duplicada)
		if (reservas.containsKey(codigo)) {
			throw new ReservaYaExisteException("La reserva " + codigo + " ya existe");
		}

		// PASO 4: Crear objeto
		Reserva nueva = new Reserva(codigo, nombre, habitacion, noches, false);

		// PASO 5: Añadir a HashMap
		reservas.put(codigo, nueva);

		// PASO 6: Mensaje éxito
		System.out.println("✅ Reserva creada");
	}

}
