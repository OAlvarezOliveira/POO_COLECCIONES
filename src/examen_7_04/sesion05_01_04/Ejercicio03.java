package examen_7_04.sesion05_01_04;


public class Ejercicio03 {
	
	public static void main(String[] args) {
		
		try {
			throw new MiExcepcion("mi propia exception");
		} catch (MiExcepcion e) {
            System.out.println("Excepción xerada: " + e.getMessage());
		}
	}

}
