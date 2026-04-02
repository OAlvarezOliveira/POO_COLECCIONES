package examen_7_04.sistemaBiblioteca;

public class Prestamo {
	
	
	private String codigoPrestamo;
	private Libro libro ;
	private String nombreUsuario;
	private int diasPrestamo;
	
	public Prestamo(String codigoPrestamo, Libro libro, String nombreUsuario, int diasPrestamo) {
		super();
		this.codigoPrestamo = codigoPrestamo;
		this.libro = libro;
		this.nombreUsuario = nombreUsuario;
		this.diasPrestamo = diasPrestamo;
	}

	public String getCodigoPrestamo() {
		return codigoPrestamo;
	}

	public void setCodigoPrestamo(String codigoPrestamo) {
		this.codigoPrestamo = codigoPrestamo;
	}

	public Libro getLibro() {
		return libro;
	}

	public void setLibro(Libro libro) {
		this.libro = libro;
	}

	public String getNombreUsuario() {
		return nombreUsuario;
	}

	public void setNombreUsuario(String nombreUsuario) {
		this.nombreUsuario = nombreUsuario;
	}

	public int getDiasPrestamo() {
		return diasPrestamo;
	}

	public void setDiasPrestamo(int diasPrestamo) {
		this.diasPrestamo = diasPrestamo;
	}

	@Override
	public String toString() {
		return String.format("Prestamo: %s || %s || %s || %d \n",
				codigoPrestamo, libro, nombreUsuario, diasPrestamo);
	}
	
	
	

}
