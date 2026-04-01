package examen_7_04.sesion04_31_03.restaurante;

import java.util.Objects;

class Plato {
    private String codigo;
    private String nombre;
    private double precio;
    private boolean disponible;
    
    
	public Plato(String codigo, String nombre, double precio) {

		this.codigo = codigo;
		this.nombre = nombre;
		this.precio = precio;
		this.disponible = true;
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


	public double getPrecio() {
		return precio;
	}


	public void setPrecio(double precio) {
		this.precio = precio;
	}


	public boolean isDisponible() {
		return disponible;
	}


	public void setDisponible(boolean disponible) {
		this.disponible = disponible;
	}


	@Override
	public String toString() {
		return String.format("Plato [%s = %s = %.2f ]", codigo, nombre, precio);
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
		if (!(obj instanceof Plato)) {
			return false;
		}
		Plato other = (Plato) obj;
		return Objects.equals(codigo, other.codigo);
	}
    
   
    
    
    
}
