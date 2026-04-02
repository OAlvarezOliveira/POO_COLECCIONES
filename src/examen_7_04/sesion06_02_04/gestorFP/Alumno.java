package examen_7_04.sesion06_02_04.gestorFP;

import java.util.Objects;

public class Alumno {
	
	private String nombreCompleto;
    private String dni;
    private String ciclo;
    private int anhoNacimiento;
    private boolean pendientes;
    
    
	public Alumno(String nombreCompleto, String dni, String ciclo, int anhoNacimiento, boolean pendientes) {
		super();
		this.nombreCompleto = nombreCompleto;
		this.dni = dni;
		this.ciclo = ciclo;
		this.anhoNacimiento = anhoNacimiento;
		this.pendientes = pendientes;
	}


	public String getNombreCompleto() {
		return nombreCompleto;
	}

	public void setNombreCompleto(String nombreCompleto) {
		this.nombreCompleto = nombreCompleto;
	}

	public String getDni() {
		return dni;
	}

	public void setDni(String dni) {
		this.dni = dni;
	}

	public String getCiclo() {
		return ciclo;
	}

	public void setCiclo(String ciclo) {
		this.ciclo = ciclo;
	}

	public int getAnhoNacimiento() {
		return anhoNacimiento;
	}

	public void setAnhoNacimiento(int anhoNacimiento) {
		this.anhoNacimiento = anhoNacimiento;
	}

	public boolean isPendientes() {
		return pendientes;
	}

	public void setPendientes(boolean pendientes) {
		this.pendientes = pendientes;
	}


	@Override
	public String toString() {
		return String.format("Alumno: %s | %s | %s | %d | Pendientes: %b",
			    nombreCompleto, dni, ciclo, anhoNacimiento, pendientes);
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
		if (!(obj instanceof Alumno)) {
			return false;
		}
		Alumno other = (Alumno) obj;
		return Objects.equals(dni, other.dni);
	}
	
	
    
    
    

}

