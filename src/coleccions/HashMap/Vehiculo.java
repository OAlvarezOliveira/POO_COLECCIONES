package coleccions.HashMap;


/**
 * Resolucion de la tarea 
 * 
 * Curso 2025-26
 * 
 * @author O.Alvarez
 * @version 1.0
 *
 */

public class Vehiculo {
	
	private String marca;
	private String propietario;
	
	
	public Vehiculo(String marca, String propietario) {
		this.marca = marca;
		this.propietario = propietario;
	}
	
	public String getMarca() {
		return marca;
	}
	
	public void setMarca(String marca) {
		this.marca = marca;
	}
	
	public String getPropietario() {
		return propietario;
	}
	
	public void setPropietario(String propietario) {
		this.propietario = propietario;
	}

	@Override
	public String toString() {
		return String.format("Vehiculo || marca:%s || propietario:%s", marca, propietario);
	}
	
	

}
