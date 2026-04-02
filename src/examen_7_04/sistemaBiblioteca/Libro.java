package examen_7_04.sistemaBiblioteca;

import java.util.Objects;

public class Libro {
	
	private String isbn;
	private String titulo;
	private String autor;
	private boolean prestado;
	
	public Libro(String isbn, String titulo, String autor, boolean prestado) {
		super();
		this.isbn = isbn;
		this.titulo = titulo;
		this.autor = autor;
		this.prestado = false;
	}

	public String getIsbn() {
		return isbn;
	}

	public void setIsbn(String isbn) {
		this.isbn = isbn;
	}

	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public String getAutor() {
		return autor;
	}

	public void setAutor(String autor) {
		this.autor = autor;
	}

	public boolean isPrestado() {
		return prestado;
	}

	public void setPrestado(boolean prestado) {
		this.prestado = prestado;
	}

	@Override
	public int hashCode() {
		return Objects.hash(isbn);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}
		if (!(obj instanceof Libro)) {
			return false;
		}
		Libro other = (Libro) obj;
		return Objects.equals(isbn, other.isbn);
	}

	@Override
	public String toString() {
		return String.format("Libro : %s || %s || %s || %b \n", isbn, titulo, autor, prestado);
	}
	
	
	

}
