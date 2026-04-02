package examen_7_04.sistemaBiblioteca.excepcionesPersonalizadas;

public class PrestamoNoEncontradoException extends Exception{
	
	public PrestamoNoEncontradoException(String mensaje) {
		super(mensaje);
	}

}
