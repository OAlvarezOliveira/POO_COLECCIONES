package examen_7_04.simulacro3.cursos;

import java.util.ArrayList;

public class Curso {
	
	private String codigo;
	private String nombre ;	
	private ArrayList<Alumno> inscritos; //se inicializa  vacío
	
	public Curso(String codigo, String nombre) {
		
		super();
		this.codigo = codigo;
		this.nombre = nombre;
		this.inscritos = new ArrayList<>();
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

	public ArrayList<Alumno> getInscritos() {
		return inscritos;
	}

	public void setInscritos(ArrayList<Alumno> inscritos) {
		this.inscritos = inscritos;
	}

	@Override
	public String toString() {
		return String.format("== %s == %s \n", nombre, inscritos);
	}
	
	

}
