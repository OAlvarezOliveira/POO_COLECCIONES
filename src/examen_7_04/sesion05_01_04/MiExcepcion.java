package examen_7_04.sesion05_01_04;

public class MiExcepcion extends Exception {
	
    private String mensajeAlmacenado;
    
    public MiExcepcion(String mensaje) {
        super(mensaje);
        this.mensajeAlmacenado = mensaje;
    }
    
    public String obtenerMensaje() {
        return mensajeAlmacenado;
    }
}
