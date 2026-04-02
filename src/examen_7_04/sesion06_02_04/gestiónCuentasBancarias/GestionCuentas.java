package examen_7_04.sesion06_02_04.gestiónCuentasBancarias;

import java.util.HashMap;
import java.util.InputMismatchException;
import java.util.Scanner;

import examen_7_04.sesion04_31_03.banco.CuentaNoEncontradaException;

public class GestionCuentas {

	private static HashMap<String, Cuenta> cuentas = new HashMap<>();
	// Clave: número de cuenta (String)
	// Valor: objeto Cuenta
	private static Scanner sc = new Scanner(System.in);

	public static void main(String[] args) {

		int opcion = 0;

		do {

			try {
				System.out.println("======= MENU =======");
				System.out.println("1. Crear cuenta");
				System.out.println("2. Depositar");
				System.out.println("3.Retirar Dinero");
				System.out.println("4. Consultar saldo ");
				System.out.println("5.Listar todas las cuentas");
				System.out.println("6.Eliminar cuenta ");
				System.out.println("7.Salir ");

				System.out.println("Elige una opcion ");
				opcion = sc.nextInt();
				sc.nextLine();

			} catch (InputMismatchException e) {
				System.out.println("La opcion debe ser un valor numerico");
				opcion = 0;
			}

			switch (opcion) {
			case 1:
				creaCuenta();
				break;
			case 2:
				depositar();
				break;
			case 3:
				retirar();
				break;
			case 4:
				consultarSaldo();
				break;
			case 5:
				listarCuentas();
				break;
			case 6:
				eliminarCuenta();
				break;
			case 7:
				System.out.println("Saliendo de la App");
				break;
			}

		} while (opcion != 7);

	}

	private static void eliminarCuenta() {
		try {
			System.out.print("Número de cuenta: ");
			String num = sc.nextLine();

			if (!cuentas.containsKey(num)) {
				throw new CuentaNoEncontradaException("La cuenta " + num + " no existe");
			}

			System.out.printf("La cuenta %s ha sido eliminada \n", num);
			cuentas.remove(num);

		} catch (CuentaNoEncontradaException e) {
			System.out.println(e.getMessage());
			System.out.println("Operación Cancelada");
		} catch (InputMismatchException e) {
			System.out.println("Entrada inválida. Operación Cancelada");
			sc.nextLine(); // Limpiar buffer en caso de error
		}

	}

	private static void listarCuentas() {
		if (cuentas.isEmpty()) {
			System.out.println("No hay cuentas registradas en el sistema.");
			return;
		}

		System.out.println("--- Listado de Cuentas ---");
		for (Cuenta cuenta : cuentas.values()) {
			System.out.println(cuenta);
		}
	}

	private static void consultarSaldo() {

		try {
			System.out.print("Número de cuenta: ");
			String num = sc.nextLine();

			if (!cuentas.containsKey(num)) {
				throw new CuentaNoEncontradaException("La cuenta " + num + " no existe");
			}

			Cuenta c1 = cuentas.get(num);

			System.out.printf("El saldo disponible para la cuenta %s es de %.2f \n", num, c1.getSaldo());

		} catch (CuentaNoEncontradaException e) {
			System.out.println(e.getMessage());
			System.out.println("Operación Cancelada");
		} catch (InputMismatchException e) {
			System.out.println("Entrada inválida. Operación Cancelada");
			sc.nextLine(); // Limpiar buffer en caso de error
		}
	}

	private static void retirar() {
		try {
			System.out.print("Número de cuenta: ");
			String num = sc.nextLine();

			if (!cuentas.containsKey(num)) {
				throw new CuentaNoEncontradaException("La cuenta " + num + " no existe");
			}

			System.out.print("Cantidad a retirar: ");
			double cant = sc.nextDouble();
			sc.nextLine(); // Limpiar buffer

			if (cant < 0) {
				throw new CantidadInvalidaException("La cantidad debe ser positiva");
			}

			Cuenta c1 = cuentas.get(num);
			c1.retirar(cant);
			System.out.println("Retirada realizada con éxito.");

		} catch (CuentaNoEncontradaException | CantidadInvalidaException e) {
			System.out.println(e.getMessage());
			System.out.println("Operación Cancelada");
		} catch (InputMismatchException e) {
			System.out.println("Entrada inválida. Operación Cancelada");
			sc.nextLine(); // Limpiar buffer en caso de error
		}

	}

	private static void depositar() {
		try {
			System.out.print("Número de cuenta: ");
			String num = sc.nextLine();

			if (!cuentas.containsKey(num)) {
				throw new CuentaNoEncontradaException("La cuenta " + num + " no existe");
			}

			System.out.print("Cantidad a depositar: ");
			double cant = sc.nextDouble();
			sc.nextLine(); // Limpiar buffer

			if (cant < 0) {
				throw new CantidadInvalidaException("La cantidad debe ser positiva");
			}

			Cuenta c1 = cuentas.get(num);
			c1.depositar(cant);
			System.out.println("Depósito realizado con éxito.");

		} catch (CuentaNoEncontradaException | CantidadInvalidaException e) {
			System.out.println(e.getMessage());
			System.out.println("Operación Cancelada");
		} catch (InputMismatchException e) {
			System.out.println("Entrada inválida. Operación Cancelada");
			sc.nextLine(); // Limpiar buffer en caso de error
		}
	}

	private static void creaCuenta() {
		try {
			System.out.print("Número de cuenta: ");
			String num = sc.nextLine();

			if (cuentas.containsKey(num)) {
				System.out.println("❌ La cuenta " + num + " ya existe");
				return;
			}

			System.out.print("Titular: ");
			String titular = sc.nextLine();

			System.out.print("Saldo inicial: ");
			double saldo = sc.nextDouble();
			sc.nextLine(); // Limpiar buffer

			if (saldo < 0) {
				throw new CantidadInvalidaException("El saldo inicial debe ser positivo");
			}

			Cuenta nuevaCuenta = new Cuenta(num, titular, saldo);
			cuentas.put(num, nuevaCuenta);
			System.out.println("✅ Cuenta creada con éxito");

		} catch (CantidadInvalidaException e) {
			System.out.println(e.getMessage());
			System.out.println("Operación Cancelada");
		} catch (InputMismatchException e) {
			System.out.println("Entrada inválida. Operación Cancelada");
			sc.nextLine(); // Limpiar buffer
		}
	}
}