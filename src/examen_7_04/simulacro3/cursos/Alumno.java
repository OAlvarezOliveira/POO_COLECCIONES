package examen_7_04.simulacro3.cursos;

public class Alumno {
	
	private String dni ;
	private String nombre; 
	private String email ;
	
	public Alumno(String dni, String nombre, String email) {
		super();
		this.dni = dni;
		this.nombre = nombre;
		this.email = email;
	}

	public String getDni() {
		return dni;
	}

	public void setDni(String dni) {
		this.dni = dni;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	@Override
	public String toString() {
		return String.format("\nAlumno: %s *** %s *** %s \n", dni, nombre, email);
	}
	
	

}
