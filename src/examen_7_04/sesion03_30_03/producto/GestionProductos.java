package examen_7_04.sesion03_30_03.producto;

import java.util.HashMap;
import java.util.Scanner;
import java.util.Map.Entry;

public class GestionProductos {

	private static HashMap<String, Producto> catalogo = new HashMap<>();
//Clave: código producto (String)
//Valor: objeto Producto completo

	static Scanner teclado = new Scanner(System.in);

	public static void main(String[] args) {

		int opcion;
		String codigo = "";
		String nombre;
		double precio;
		double nuevoPrecio;

		// menu

		cargarDatosPruebas();

		do {

			System.out.println("Menu de Opciones \n");
			System.out.println("1. añadirProducto(codigo, nombre, precio) \n");
			System.out.println("2. buscarProducto(codigo) \n");
			System.out.println("3. modificarPrecio(codigo, nuevoPrecio)\n");
			System.out.println("4. eliminarProducto(codigo) \n");
			System.out.println("5. listarCatalogo \n");
			System.out.println("6. productoMasCaro \n");
			System.out.println("7. Salir\n");
			System.out.println("Selecciona una Opcion\n");
			opcion = teclado.nextInt();

			switch (opcion) {
			case 1:
				System.out.println("Introduce el codigo\n");
				codigo = teclado.next();
				System.out.println("Introduce el nombre\n");
				nombre = teclado.next();
				System.out.println("Introduce el precio\n");
				precio = teclado.nextDouble();
				teclado.nextLine();
				añadirProducto(codigo, nombre, precio);
				break;

			case 2:
				System.out.println("Introduce el codigo a buscar:\n");
				codigo = teclado.next();
				buscarProducto(codigo);
				break;
			case 3:
				System.out.println("Introduce el codigo a buscar:\n");
				codigo = teclado.next();
				System.out.println("Introduce el nuevo precio\n");
				nuevoPrecio = teclado.nextDouble();
				teclado.nextLine();
				modificarPrecio(codigo, nuevoPrecio);
				break;

			case 4:
				System.out.println("Introduce el codigo a eliminar:\n");
				codigo = teclado.next();
				eliminarProducto(codigo);
				break;
			case 5:
				System.out.println("CATALOGO DE PRODUCTOS:\n");
				listarCatalogo();
				break;

			case 6:
				System.out.println("PRODUCTO MAS CARO:\n");
				productoMasCaro();
				break;
			case 7:
				System.out.println("Saliendo de la App\n");
				break;

			}

		} while (opcion != 7);

	}

	private static void productoMasCaro() {
		
		double mayor = Double.MIN_VALUE;
		Producto pMayor = null;
		
		for (Entry<String, Producto> entry : catalogo.entrySet()) {
			
			if (entry.getValue().getPrecio() > mayor ) {
				
				mayor = entry.getValue().getPrecio() ;
				pMayor = entry.getValue();
			}

		}
		System.out.printf("productoMasCaro : %s \n",pMayor);

	}

	private static void listarCatalogo() {
		
		System.out.printf("Imprimiendo Catalogo \n");

		for (Entry<String, Producto> entry : catalogo.entrySet()) {
			
			System.out.printf(" %s === %s  \n",entry.getKey(),entry.getValue());
			
			

			}

		}


	private static void eliminarProducto(String codigo) {

		if (catalogo.containsKey(codigo)) {

			catalogo.remove(codigo);
			System.out.println("Eliminado");


		} else {
			System.out.println("Imposible eliminar , producto no encontrado");

		}

	}

	private static void modificarPrecio(String codigo, double nuevoPrecio) {

		if (catalogo.containsKey(codigo)) {

			Producto p2 = catalogo.get(codigo);
			p2.setPrecio(nuevoPrecio);
			System.out.println("Nuevo precio fijado ");

		} else {
			System.out.println("Imposible modificar , producto no encontrado");

		}

	}

	private static void buscarProducto(String codigo) {

		if (catalogo.containsKey(codigo)) {

			Producto p2 = catalogo.get(codigo);
			System.out.println(p2);

		} else {
			System.out.println("No encontrado");

		}

	}

	private static void cargarDatosPruebas() {
		// Añadir
		añadirProducto("P001", "Ratón Logitech", 25.99);
		añadirProducto("P002", "Teclado mecánico", 89.99);
		añadirProducto("P003", "Monitor 24''", 199.99);
		añadirProducto("P004", "Webcam HD", 45.50);
		añadirProducto("P005", "Auriculares", 35.00);

	}

	private static void añadirProducto(String codigo, String nombre, double precio) {
		
		
		if (catalogo.containsKey(codigo)) {
		    System.out.println("Error: El código ya existe.");
		} else {
			Producto p1 = new Producto(codigo, nombre, precio);
			catalogo.put(codigo, p1);
			System.out.printf("Se ha añadido el producto: %s \n", p1);
		}
	}

}
