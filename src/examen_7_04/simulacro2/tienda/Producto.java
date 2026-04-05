package examen_7_04.simulacro2.tienda;

public class Producto {
	private String codigo; 
	private String nombre;
	private int stock ;
	private double precio;
	
	
	public Producto(String codigo, String nombre, int stock, double precio) {
		super();
		this.codigo = codigo;
		this.nombre = nombre;
		this.stock = stock;
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


	public int getStock() {
		return stock;
	}


	public void setStock(int stock) {
		this.stock = stock;
	}


	public double getPrecio() {
		return precio;
	}


	public void setPrecio(double precio) {
		this.precio = precio;
	}


	@Override
	public String toString() {
		return String.format("\nProducto :%s || %s || %d || %.2f", codigo, nombre, stock, precio);
	}
	
	
	
}
