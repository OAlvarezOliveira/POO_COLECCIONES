package examen_7_04.sesion05_01_04;

public class Ejercicio01 {

	public static void main(String[] args) {

		try {
            // LANZAR la excepción con un mensaje
            throw new Exception("Isto é unha Excepción");
            
        } catch (Exception e) {
            // Capturar e imprimir el mensaje de la excepción
            System.out.println("Produciuse unha excepción: " + e.getMessage());
            
        } finally {
            // SIEMPRE se ejecuta (haya o no excepción)
            System.out.println("Isto execútase sen importar se se presentan erros");
        }

	}

}
