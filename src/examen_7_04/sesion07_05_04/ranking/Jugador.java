package examen_7_04.sesion07_05_04.ranking;

public class Jugador {
	
	private String nombre; 
	private int puntuacion ;
	
	public Jugador(String nombre, int puntuacion) {
		super();
		this.nombre = nombre;
		this.puntuacion = puntuacion;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public int getPuntuacion() {
		return puntuacion;
	}
	public void setPuntuacion(int puntuacion) {
		this.puntuacion = puntuacion;
	}
	@Override
	public String toString() {
		return String.format("\nJugador :%s === %d \n", nombre, puntuacion);
	}
	
	

}
