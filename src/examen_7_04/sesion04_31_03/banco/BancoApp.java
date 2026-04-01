package examen_7_04.sesion04_31_03.banco;

import java.util.HashMap;
import java.util.Map;

public class BancoApp {

	private static HashMap<String, Cuenta> cuentas = new HashMap<>();

	public static void main(String[] args) {

		// Crear cuentas
		try {
			crearCuenta("001", "Ana García", 1000);
			crearCuenta("002", "Luis Pérez", 500);
			crearCuenta("003", "María Ruiz", 200);
			crearCuenta("001", "Pedro Sanz", 300); // ❌ Duplicado
		} catch (CantidadInvalidaException e) {
			System.out.println("Error: " + e.getMessage());
		} catch (IllegalArgumentException e) {
			System.out.println("Error: " + e.getMessage());
		}

		// Depositar
		try {
			depositar("001", 200); // ✅ 1000 → 1200
			depositar("001", -50); // ❌ Cantidad negativa
		} catch (CuentaNoEncontradaException | CantidadInvalidaException e) {
			System.out.println("Error: " + e.getMessage());
		}

		// Retirar
		try {
			retirar("002", 300); // ✅ 500 → 200
			retirar("002", 500); // ❌ Saldo insuficiente
		} catch (CuentaNoEncontradaException | CantidadInvalidaException | SaldoInsuficienteException e) {
			System.out.println("Error: " + e.getMessage());
		}

		// Transferir
		try {
			transferir("001", "003", 400); // ✅ 001: 1200→800, 003: 200→600
			transferir("003", "999", 100); // ❌ Cuenta destino no existe
		} catch (CuentaNoEncontradaException | CantidadInvalidaException | SaldoInsuficienteException e) {
			System.out.println("Error: " + e.getMessage());
		}

		// Consultar
		try {
			consultarSaldo("001");
			consultarSaldo("999"); // ❌ No existe
		} catch (CuentaNoEncontradaException e) {
			System.out.println("Error: " + e.getMessage());
		}

		// Listar todas
		listarCuentas();
	}

	private static void listarCuentas() {

		cuentas.forEach((key, val) -> System.out.println(val));
	}

	private static void consultarSaldo(String numeroCuenta) throws CuentaNoEncontradaException {

		if (!cuentas.containsKey(numeroCuenta)) {
			throw new CuentaNoEncontradaException("Cuenta no encontrada: " + numeroCuenta);
		}

		Cuenta c = cuentas.get(numeroCuenta);
		System.out.printf("💰 Saldo cuenta %s: %.2f€\n", numeroCuenta, c.getSaldo());

	}

	private static void transferir(String cuentaOrigen, String cuentaDestino, double cantidad)
			throws CuentaNoEncontradaException, CantidadInvalidaException, SaldoInsuficienteException {

		// PASO 1: Validar cantidad > 0
		if (cantidad <= 0) {
			throw new CantidadInvalidaException("La cantidad debe ser positiva: " + cantidad);
		}

		// PASO 2 : Validar origen existe (sin else)
		if (!cuentas.containsKey(cuentaOrigen)) {
			throw new CuentaNoEncontradaException("Cuenta origen no encontrada: " + cuentaOrigen);
		}

		// PASO 3: Validar destino existe (sin else)
		if (!cuentas.containsKey(cuentaDestino)) {
			throw new CuentaNoEncontradaException("Cuenta destino no encontrada: " + cuentaDestino);
		}

		// PASO 4: Obtener DESPUÉS de validar (seguro que existen)
		Cuenta cO = cuentas.get(cuentaOrigen);
		Cuenta cD = cuentas.get(cuentaDestino);

		// PASO 5: Validar saldo suficiente
		if (cO.getSaldo() < cantidad) {
			throw new SaldoInsuficienteException(String
					.format("Saldo insuficiente. Saldo: %.2f€, intentó transferir: %.2f€", cO.getSaldo(), cantidad));
		}

		// PASO 6: Realizar transferencia REAL
		cO.retirar(cantidad); // RESTA del origen
		cD.depositar(cantidad); // SUMA al destino

		// Mostrar confirmación
		System.out.printf("✅ Transferencia: %.2f€ de %s a %s\n", cantidad, cuentaOrigen, cuentaDestino);
		System.out.printf("   - Cuenta %s: %.2f€\n", cuentaOrigen, cO.getSaldo());
		System.out.printf("   - Cuenta %s: %.2f€\n", cuentaDestino, cD.getSaldo());
	}

	private static void retirar(String numeroCuenta, double cantidad)
			throws CuentaNoEncontradaException, CantidadInvalidaException, SaldoInsuficienteException {

		if (cantidad <= 0) {
			throw new CantidadInvalidaException("La cantidad debe ser positiva: " + cantidad);
		}

		if (!cuentas.containsKey(numeroCuenta)) {
			throw new CuentaNoEncontradaException("Cuenta no encontrada: " + numeroCuenta);
		}

		Cuenta c2 = cuentas.get(numeroCuenta);

		if (c2.getSaldo() < cantidad) {
			throw new SaldoInsuficienteException(String
					.format("Saldo insuficiente. Saldo: %.2f€, intentó transferir: %.2f€", c2.getSaldo(), cantidad));
		}

		c2.retirar(cantidad);
		System.out.printf("Retiro: %.2f  de cuenta  %s. \n", cantidad, numeroCuenta);
		System.out.printf("Nuevo saldo: %.2f  \n", c2.getSaldo());

	}

	private static void depositar(String numeroCuenta, double cantidad)
			throws CuentaNoEncontradaException, CantidadInvalidaException {

		if (cantidad <= 0) {
			throw new CantidadInvalidaException("La cantidad debe ser positiva: " + cantidad);
		}

		if (!cuentas.containsKey(numeroCuenta)) {
			throw new CuentaNoEncontradaException("Cuenta no encontrada: " + numeroCuenta);
		}

		Cuenta c = cuentas.get(numeroCuenta);
		c.depositar(cantidad);
		System.out.printf("✅ Depósito: %.2f€ en cuenta %s. Nuevo saldo: %.2f€\n", cantidad, numeroCuenta, c.getSaldo());
	}

	private static void crearCuenta(String numeroCuenta, String titular, double saldo)
		    throws CantidadInvalidaException {
		    
		    if (saldo < 0) {
		        throw new CantidadInvalidaException("Saldo inicial no puede ser negativo: " + saldo);
		    }
		    
		    if (cuentas.containsKey(numeroCuenta)) {
		        throw new IllegalArgumentException("La cuenta " + numeroCuenta + " ya existe");
		    }
		    
		    Cuenta c1 = new Cuenta(numeroCuenta, titular, saldo);
		    cuentas.put(numeroCuenta, c1);
		    System.out.printf("✅ Cuenta creada: %s - %s (%.2f€)\n", 
		        numeroCuenta, titular, saldo);
		}
}
