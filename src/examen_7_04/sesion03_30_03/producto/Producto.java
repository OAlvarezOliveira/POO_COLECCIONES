package examen_7_04.sesion03_30_03.producto;

import java.util.Objects;

class Producto {
	
    private String codigo;
    private String nombre;
    private double precio;

    
	public Producto(String codigo, String nombre, double precio) {
		this.codigo = codigo;
		this.nombre = nombre;
		this.precio = precio;
		
	}

	public String getCodigo() {return codigo;}
	public void setCodigo(String codigo) {this.codigo = codigo;}
	public String getNombre() {return nombre;}
	public void setNombre(String nombre) {this.nombre = nombre;}
	public double getPrecio() {return precio;}
	public void setPrecio(double precio) {this.precio = precio;}

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

	@Override
	public String toString() {
		return String.format("Producto : [ %s || %s || %.2f ] \n", codigo, nombre, precio);
	}
	
	
    

    
    
    
}
