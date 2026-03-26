package excepciones03.exercicio2;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Exercicio2 {
    
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int[] array = { 4, 2, 6, 7 };
        int n;
        boolean repetir = false;
        
        do {
            try {
                repetir = false;
                System.out.print("Introduce un número enteiro > 0 e <" + array.length + " ");
                n = sc.nextInt();
                System.out.println("Valor na posición " + n + ": " + array[n]);
            } catch (InputMismatchException e) {
                sc.nextLine();//Lectura falsa
                n = 0;
                System.out.println("Debe introducir un número enteiro ");
                repetir = true;
            } catch (IndexOutOfBoundsException e) {
                System.out.println("Debe ser número enteiro>0 e <" + array.length + " ");
                repetir = true;
            } catch (Exception e) { // resto de excepcións de tipo Exception e derivadas
                System.out.println("Erro inesperado " + e.toString());
                repetir = true;
            }
        } while (repetir);

    }

}
