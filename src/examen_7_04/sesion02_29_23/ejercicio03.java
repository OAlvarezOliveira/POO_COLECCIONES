package examen_7_04.sesion02_29_23;

import java.util.HashSet;
import java.util.Objects;

class Producto {
	private String codigo;
	private String nombre;
	private Double precio;

	public Producto(String codigo, String nombre, Double precio) {
		this.codigo = codigo;
		this.nombre = nombre;
		this.precio = precio;
	}

	public String getCodigo() {
		return codigo;
	}

	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public Double getPrecio() {
		return precio;
	}

	public void setPrecio(Double precio) {
		this.precio = precio;
	}

	@Override
	public String toString() {
		return String.format("Producto [ codigo:%s || nombre:%s || precio:%.2f ]", codigo, nombre, precio);

	}

	@Override
	public int hashCode() {
		return Objects.hash(codigo);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}
		if (!(obj instanceof Producto)) {
			return false;
		}
		Producto other = (Producto) obj;
		return Objects.equals(codigo, other.codigo);
	}

}

public class ejercicio03 {
	public static void main(String[] args) {
		HashSet<Producto> productos = new HashSet<>();

		Producto p1 = new Producto("P001", "Ratón", 15.50);
		Producto p2 = new Producto("P002", "Teclado", 45.00);
		Producto p3 = new Producto("P001", "Ratón", 25.00); // Mismo código
		Producto p4 = new Producto("P003", "Monitor ", 199.00);
		Producto p5 = new Producto("P002", "Teclado RGB", 55.00); // Mismo código

		productos.add(p1);
		productos.add(p2);
		productos.add(p3);
		productos.add(p4);
		productos.add(p5);

		System.out.println("Tamaño: " + productos.size()); // ✅ 2

		// Buscar por código

		System.out.println("Buscando P001: " + buscarPorCodigo(productos, "P001"));
		System.out.println("Buscando P999: " + buscarPorCodigo(productos, "P999"));

	}

	public static boolean buscarPorCodigo(HashSet<Producto> set, String codigo) {
		
		// Crear producto temporal con ese código
		Producto temporal = new Producto(codigo, "", 0.0);

		// HashSet usará equals() para comparar
		return set.contains(temporal);
	}

}