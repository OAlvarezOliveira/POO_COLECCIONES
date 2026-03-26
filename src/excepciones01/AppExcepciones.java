package excepciones01;


/**
 * Resolucion de la tarea 
 * Curso 2025-26
 * @author O.Alvarez
 * @version 1.0
 *
 */

public class AppExcepciones {

	public static void main(String[] args) {
		
		int numerador = 5;
		int denominador = 0;
		double res;
		int [] vector = new int[10];
		String s = null;
		
		try {
		
	//java.lang.NullPointerException	
	s.length();
		
	//java.lang.ArrayIndexOutOfBoundsException:	
	vector[11]=3;

		
		
	//	java.lang.ArithmeticException: / by zero		
	res = numerador/denominador;
			System.out.println("Esto no se ejecuta");

		}catch(Exception e){
			
			System.out.println("Produciuse una excepción" +e.getMessage());
			System.out.println("mal programado");
		}
		System.out.println("Aqui sigue el codigo");
		
		

	}

}
