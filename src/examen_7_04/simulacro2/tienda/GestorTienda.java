package examen_7_04.simulacro2.tienda;

import java.util.HashMap;
import java.util.Map.Entry;
import java.util.Scanner;

import examen_7_04.simulacro2.tienda.excepciones.DatoInvalidoException;
import examen_7_04.simulacro2.tienda.excepciones.ProductoNoEncontradoException;

public class GestorTienda {

	private static HashMap<String, Producto> productos = new HashMap<>();
	private static Scanner sc = new Scanner(System.in);

	public static void main(String[] args) {

		cargarDatos();
		menu();

	}

	private static void menu()  {
		int opcion = 0;

		do {

			System.out.printf("\n=== GESTIÓN TIENDA ===");
			System.out.printf("\n1. Agregar producto");
			System.out.printf("\n2. Vender producto");
			System.out.printf("\n3. Consultar stock");
			System.out.printf("\n4. Actualizar precio");
			System.out.printf("\n5. Listar productos");
			System.out.printf("\n6. Salir");

			try {
				opcion = Integer.parseInt(sc.nextLine());

			} catch (NumberFormatException  e) {
				System.out.printf("\nError: La opcion debe ser un número valido entre 1-6");
			}

			switch (opcion) {
			case 1:
				agregarProducto();
				break;
			case 2:
				venderProducto();
				break;
			case 3:
				consultarStock();
				break;
			case 4:
				actualizarPrecio();
				break;
			case 5:
				listarProductos();
				break;
			case 6:
				System.out.printf("\nSaliendo de la APP");
				break;
			default:
				System.out.printf("\nOpcion incorrecta ,la opcion debe ser un número valido entre 1-6 ");
				break;
			}

		} while (opcion != 6);

	}

	private static void listarProductos() {

		if (productos.isEmpty()) {

			System.out.print("\nBBDD Vacía , no hay productos a mostrar ");

		} else {

			for (Entry<String, Producto> entry : productos.entrySet()) {
				String key = entry.getKey();
				Producto val = entry.getValue();

				System.out.println(val);

			}

		}
	}

	private static void actualizarPrecio() {
		String codigo = "";
		double precioNuevo = 0;
		boolean valido = false;

		while (!valido) {
			try {
				System.out.print("\nIntroduce el codigo: ");
				codigo = sc.nextLine();
				if (!productos.containsKey(codigo)) {
					{
						throw new ProductoNoEncontradoException("EL producto no existe en la BBDD");
					}
				} else {
					Producto p = productos.get(codigo);

					try {
						System.out.print("\nIntroduce el nuevo precio del producto: ");
						precioNuevo = Double.parseDouble(sc.nextLine());
						if (precioNuevo <= 0) {
							throw new DatoInvalidoException("El nuevo precio debe ser una cantidad superior a cero");
						}

						p.setPrecio(precioNuevo);
						valido = true;
						System.out.printf("\nSe ha actualizado a producto %.2f el precio del producto %s", precioNuevo,
								p.getNombre());

					} catch (NumberFormatException e) {
						System.out.printf("\nError: El precio debe ser un valor positivo");
					}
				}

			} catch (ProductoNoEncontradoException e) {
				System.out.println("Error: " + e.getMessage());
			} catch (DatoInvalidoException e) {
				System.out.println("Error: " + e.getMessage());
			}

		} // FIN WHILE

	}

	private static void consultarStock() {

		String codigo = "";
		boolean valido = false;

		try {
			System.out.print("\nIntroduce el codigo: ");
			codigo = sc.nextLine();
			if (!productos.containsKey(codigo)) {
				{
					throw new ProductoNoEncontradoException("EL producto no existe en la BBDD");
				}
			} else {
				Producto p = productos.get(codigo);

				System.out.printf("\nDisponemos de %d unidades del producto %s ", p.getStock(), p.getNombre());
			}

		} catch (ProductoNoEncontradoException e) {
			System.out.println("Error: " + e.getMessage());
		}

	}

	private static void venderProducto() {
		String codigo = "";
		int cantidad = 0;
		int stock = 0;
		int nuevoStock;
		boolean valido = false;

		while (!valido) {
			try {
				System.out.print("\nIntroduce el codigo: ");
				codigo = sc.nextLine();
				if (!productos.containsKey(codigo)) {
					{
						throw new ProductoNoEncontradoException("EL producto no existe en la BBDD");
					}
				} else {
					Producto p = productos.get(codigo);

					try {
						System.out.print("\nIntroduce la cantidad a vender: ");
						cantidad = Integer.parseInt(sc.nextLine());
						if (cantidad < 0) {
							throw new DatoInvalidoException("La cantidad a vender no puede ser negativa");
						}
						if (p.getStock() < cantidad) {
							throw new DatoInvalidoException(
									"La cantidad a vender no puede ser superiror al stock disponible");
						}

						nuevoStock = p.getStock() - cantidad;
						p.setStock(nuevoStock);
						valido = true;
						System.out.printf("\nSe han vendido %d unidades del producto %s, quedan %d", cantidad,
								p.getNombre(), p.getStock());

					} catch (NumberFormatException e) {
						System.out.printf("\nError: La cantidad debe ser un valor entero positivo");
					}
				}

			} catch (ProductoNoEncontradoException e) {
				System.out.println("Error: " + e.getMessage());
			} catch (DatoInvalidoException e) {
				System.out.println("Error: " + e.getMessage());
			}

		} // FIN WHILE

	}

	private static void agregarProducto() { // Quitamos el throws porque lo capturamos dentro
		String codigo = "";
		String nombre = "";
		int stock = 0;
		double precio = 0;
		boolean valido = false;

		while (!valido) {
			try {
				System.out.print("\nIntroduce el codigo: ");
				codigo = sc.nextLine();
				if (productos.containsKey(codigo)) {
					System.out.println("Error: El producto ya existe.");
					return;
				}

				System.out.print("Introduce el nombre: ");
				nombre = sc.nextLine();

				System.out.print("Introduce el stock: ");
				stock = Integer.parseInt(sc.nextLine());
				if (stock < 0) {
					throw new DatoInvalidoException("Stock no puede ser negativo");
				}
				System.out.print("Introduce el precio: ");
				precio = Double.parseDouble(sc.nextLine());
				if (precio <= 0) {
					throw new DatoInvalidoException("Precio debe ser mayor a 0");
				}

				Producto p = new Producto(codigo, nombre, stock, precio);
				productos.put(codigo, p);
				valido = true;
				System.out.println("Producto añadido.");

			} catch (NumberFormatException e) {
				System.out.println("Error: Introduce un número válido (no letras).");
			} catch (DatoInvalidoException e) {
				System.out.println("Error: " + e.getMessage());
			}
		}
	}

	private static void cargarDatos() {

		Producto p1 = new Producto("A01", "Laptop Gaming", 10, 1200.50);
		Producto p2 = new Producto("A02", "Mouse Inalámbrico", 50, 25.99);
		Producto p3 = new Producto("A03", "Monitor 4K", 15, 350.00);
		Producto p4 = new Producto("A04", "Teclado Mecánico", 20, 85.00);
		Producto p5 = new Producto("A05", "Auriculares Bluetooth", 30, 59.90);
		Producto p6 = new Producto("A06", "Alfombrilla XL", 100, 15.25);

		productos.put("A01", p1);
		productos.put("A02", p2);
		productos.put("A03", p3);
		productos.put("A04", p4);
		productos.put("A05", p5);
		productos.put("A06", p6);
	}

}
