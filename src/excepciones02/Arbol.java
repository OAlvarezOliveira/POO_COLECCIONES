package excepciones02;


public class Arbol {
	
	private int altura;
	private String nombre;
	
	public Arbol(int altura, String nombre) throws ArbolException {
		
		this.setAltura(altura);
		this.nombre = nombre;
	}


	public int getAltura() {
		return altura;
	}


	public void setAltura(int altura) throws ArbolException {
		if(altura <0) {
			throw new ArbolException("La altura no puede ser inferior a 0");
		}
		
		this.altura = altura;
	}


	public String getNombre() {
		return nombre;
	}


	public void setNombre(String nombre) {
		this.nombre = nombre;
	}


	@Override
	public String toString() {
		return String.format("Arbol [altura=%s, nombre=%s]", altura, nombre);
	}
	
}

