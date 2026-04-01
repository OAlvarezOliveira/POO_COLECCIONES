package examen_7_04.sesion05_01_04;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Ejercicio02 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int[] array = {10, 20, 30, 40};
        
       
        try {
        	
        	 System.out.println("Introduce posición (0-3):");
             int posicion = sc.nextInt();
             int valor = array[posicion];
             System.out.println("El valor en la posición " + posicion + " es: " + valor);

        } catch (InputMismatchException e) {
        	
            System.out.println("Error: Debes introducir un número entero");

		} catch (ArrayIndexOutOfBoundsException e) {
			
            System.out.println("Error: Posición fuera de rango (0-3)");
			
        } catch (Exception e) {
            System.out.println("Error inesperado: " + e.getMessage());
            
        } finally {
            sc.close();
        }

 }
    
    
}
