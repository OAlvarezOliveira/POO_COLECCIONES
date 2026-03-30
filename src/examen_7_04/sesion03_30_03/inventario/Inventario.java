package examen_7_04.sesion03_30_03.inventario;

import java.util.HashMap;
import java.util.Scanner;

public class Inventario {

	private static HashMap<String, Integer> inventario = new HashMap<>();

	public static void main(String[] args) {

		// variables
		Scanner teclado = new Scanner(System.in);
		int opcion;
		String producto;
		int cantidad;

		// menu
		do {

			System.out.printf("Introduce una opcion a ejecutar \n");
			System.out.printf("1. Añadir productos con stock inicial \n");
			System.out.printf("2. Vender producto \n");
			System.out.printf("3. Reponer stock \n");
			System.out.printf("4. Mostrar productos con stock bajo \n");
			System.out.printf("5. Listar todo el inventario \n");
			System.out.printf("6. Salir");
			opcion = teclado.nextInt();
			teclado.nextLine();

			switch (opcion) {
			case 1:
				añadirStockInicial();
				break;
			case 2:
				System.out.printf("2. VENTAS DE PRODUCTOS \n");
				System.out.printf("/-/ Nombre del Producto \n");
				producto = teclado.nextLine();
				System.out.printf("/-/ Cantidad de producto a añadir \n");
				cantidad = teclado.nextInt();
				teclado.nextLine();
				venderProducto(producto, cantidad);
				break;
			case 3:
				System.out.printf("3. REPOSICION DE STOCKS \n");
				System.out.printf("/-/ Nombre del Producto \n");
				producto = teclado.nextLine();
				System.out.printf("/-/ Cantidad de producto a añadir \n");
				cantidad = teclado.nextInt();
				teclado.nextLine();
				reponerStock(producto, cantidad);
				break;
			case 4:
				mostrarStockBajo();
				break;
			case 5:
				listarInventario();
				break;
			case 6:
				System.out.printf("Saliendo de la App");
				break;

			}

		} while (opcion != 6);

	}

	private static void añadirStockInicial() {
		inventario.put("Ratón", 15);
		inventario.put("Teclado", 8);
		inventario.put("Monitor", 3);
		inventario.put("Webcam", 12);
		inventario.put("Auriculares", 2);

	}

	private static void venderProducto(String producto, int cantidad) {
		// 1. Verificar que existe (containsKey)
		if (!inventario.containsKey(producto)) {
			System.out.println("❌ Producto no existe");
			return;
		}

		// 2. Verificar stock suficiente
		int stockActual = inventario.get(producto);
		if (stockActual < cantidad) {
			System.out.println("❌ Stock insuficiente");
			return;
		}

		// 3. Actualizar stock
		inventario.put(producto, stockActual - cantidad);
		System.out.println("✅ Vendido: " + cantidad + " " + producto);

	}

	private static void reponerStock(String producto, int cantidad) {
		// Si existe → sumar
		// Si no existe → crear nuevo
		int stockActual = inventario.getOrDefault(producto, 0);
		inventario.put(producto, stockActual + cantidad);
		System.out.println("✅ Repuesto: " + cantidad + " " + producto);

	}

	private static void mostrarStockBajo() {
		System.out.println("\n Productos con stock bajo (<5):");
		for (String producto : inventario.keySet()) {
			int stock = inventario.get(producto);
			if (stock < 5) {
				System.out.println("- " + producto + ": " + stock);
			}
		}

	}

	private static void listarInventario() {
		System.out.println("\n Inventario completo:");
		for (String producto : inventario.keySet()) {
			System.out.println("- " + producto + ": " + inventario.get(producto));
		}

	}

}
