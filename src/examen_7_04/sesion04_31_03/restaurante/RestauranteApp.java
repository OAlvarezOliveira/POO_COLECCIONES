package examen_7_04.sesion04_31_03.restaurante;

import java.util.HashMap;
import java.util.HashSet;

public class RestauranteApp {

	private static HashMap<String, Plato> menu = new HashMap<>();
	// Clave: código plato (ej: "P001")
	// Valor: objeto Plato (codigo, nombre, precio, disponible)

	// Pedidos por mesa
	private static HashMap<Integer, HashSet<String>> pedidos = new HashMap<>();
	// Clave: número mesa
	// Valor: HashSet con códigos de platos pedidos

	// Mesas ocupadas (solo números de mesa)
	private static HashSet<Integer> mesasOcupadas = new HashSet<>();

	// contador de agotados
	private static int platoAgotado = 0;

	public static void main(String[] args) {

		// Añadir al menú
		añadirPlato("P001", "Paella", 12.50);
		añadirPlato("P002", "Ensalada", 6.00);
		añadirPlato("P003", "Pizza", 9.50);
		añadirPlato("P004", "Hamburguesa", 8.00);
		añadirPlato("P005", "Pasta", 10.00);

		// Ocupar mesas
		ocuparMesa(1); // ✅
		ocuparMesa(2); // ✅
		ocuparMesa(1); // ❌ Ya ocupada

		// Hacer pedidos
		hacerPedido(1, "P001"); // Mesa 1: Paella
		hacerPedido(1, "P002"); // Mesa 1: Ensalada
		hacerPedido(2, "P003"); // Mesa 2: Pizza
		hacerPedido(1, "P001"); // ❌ Duplicado en misma mesa
		hacerPedido(3, "P004"); // ❌ Mesa no ocupada

		// Marcar agotado
		marcarNoDisponible("P001"); // Paella agotada

		// Intentar pedir agotado
		hacerPedido(2, "P001"); // ❌ No disponible

		// Mostrar pedidos
		mostrarPedidosMesa(1);

		// Liberar mesa (calcular total)
		liberarMesa(1); // 12.50 + 6.00 = 18.50€

		// Estadísticas
		estadisticas();

	}

	private static void estadisticas() {
		System.out.printf("- Mesas ocupadas:  %d \n", mesasOcupadas.size());
		System.out.printf("- Platos en menú:  %d \n", menu.size());
		System.out.printf("- Platos agotados: %d \n", platoAgotado);

	}

	private static void liberarMesa(int numMesa) {
		if (!mesasOcupadas.contains(numMesa)) {
			System.out.println("Mesa no ocupada");
			return;
		}

		// Calcular total
		double total = 0;
		HashSet<String> pedidosMesa = pedidos.get(numMesa);

		for (String codigo : pedidosMesa) {
			Plato plato = menu.get(codigo);
			total += plato.getPrecio();
		}

		System.out.printf("Cuenta Mesa %d: %.2f€\n", numMesa, total);

		// Liberar
		mesasOcupadas.remove(numMesa);
		pedidos.remove(numMesa);
		System.out.println("Mesa liberada");

	}

	private static void mostrarPedidosMesa(int numMesa) {
	    System.out.printf("Pedidos Mesa %d:\n", numMesa);
		HashSet<String> pedidosMesa = pedidos.get(numMesa);

	    for (String codigo : pedidosMesa) {
	        Plato plato = menu.get(codigo);
	        System.out.printf("- %s - %.2f€\n", 
	            plato.getNombre(), plato.getPrecio());
	    }

	}

	private static void marcarNoDisponible(String codigoPlato) {
		Plato plato = menu.get(codigoPlato);

		if (plato.isDisponible()) {
			plato.setDisponible(false);
			System.out.printf("%s - %s marcado como NO DISPONIBLE", plato.getCodigo(), plato.getNombre());
			platoAgotado++;
			return;
		}

	}

	private static void hacerPedido(int numMesa, String codigoPlato) {
		// 1. Validar mesa ocupada
		if (!mesasOcupadas.contains(numMesa)) {
			System.out.println("Mesa no ocupada");
			return;
		}

		// 2. Validar plato existe
		if (!menu.containsKey(codigoPlato)) {
			System.out.println("Plato no existe");
			return;
		}

		// 3. Validar plato disponible
		Plato plato = menu.get(codigoPlato);

		if (!plato.isDisponible()) {
			System.out.printf("Plato no disponible: %s \n", plato.getNombre());
			return;
		}

		// 4. Añadir a pedidos
		HashSet<String> pedidosMesa = pedidos.get(numMesa);

		if (pedidosMesa.add(codigoPlato)) {
			System.out.println("Pedido: " + plato.getNombre());
		} else {
			System.out.println("Ya pedido en esta mesa");
		}

	}

	private static void ocuparMesa(int numMesa) {

		if (mesasOcupadas.contains(numMesa)) {

			System.out.printf("Mesa %d ya está ocupada \n", numMesa);

		} else {

			mesasOcupadas.add(numMesa);
	        pedidos.put(numMesa, new HashSet<>());  
			System.out.printf("Mesa %d ocupada \n", numMesa);

		}

	}

	private static void añadirPlato(String codigo, String nombre, double precio) {

		if (menu.containsKey(codigo)) {

			System.out.println("Plato ya existente no se puede añadir");

		} else {

			Plato pl1 = new Plato(codigo, nombre, precio);
			menu.put(codigo, pl1);

			System.out.printf("Plato añadido: %s - %s \n", pl1.getCodigo(), pl1.getNombre());

		}

	}

}
