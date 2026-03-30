package examen_7_04.sesion02_29_23.estudiante;

import java.util.Objects;

public class Estudiante {
	
	private String dni; // ID unico
	private String nombre;
	private int edad;
	
	
	public Estudiante(String dni, String nombre, int edad) {
		this.dni = dni;
		this.nombre = nombre;
		this.edad = edad;
	}
	
	//DNI
	public String getDni() {return dni;}
	public void setDni(String dni) {this.dni = dni;}
	//NOMBRE
	public String getNombre() {return nombre;}
	public void setNombre(String nombre) {this.nombre = nombre;	}
	//EDAD
	public int getEdad() {return edad;}
    public void setEdad(int edad) {this.edad = edad;}

	@Override
	public String toString() {
		return String.format("Estudiante [%s - %s - %d años]", dni, nombre, edad);
	}

	@Override
	public int hashCode() {
		return Objects.hash(dni);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}
		if (!(obj instanceof Estudiante)) {
			return false;
		}
		Estudiante other = (Estudiante) obj;
		return Objects.equals(dni, other.dni);
	}
	
	
    
	
	
	

}
