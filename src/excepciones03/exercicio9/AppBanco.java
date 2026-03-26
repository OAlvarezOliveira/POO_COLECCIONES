package excepciones03.exercicio9;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.InputMismatchException;
import java.util.Scanner;

/**
 * Resolución de la tarea xx
 * 
 * Curso 2025-26
 * @author Julio Mosquera
 * @version 1.0
 */

public class AppBanco {
	public static void recursionInfinita() {
        recursionInfinita();
    }

    public static void main(String[] args) {
    	Scanner sc = new Scanner(System.in);
        CuentaBancaria contaXulio = new CuentaBancaria("Xulio", 1000);
        CuentaBancaria contaAnxela = new CuentaBancaria("Ánxela", 500);

        try {
            System.out.println("Estado inicial:");
            System.out.println(contaXulio);
            System.out.println(contaAnxela);

            System.out.print("\nIntroduce cantidad a transferir de Xulio a Ánxela: ");
            double cantidad = sc.nextDouble();

            contaXulio.transferir(contaAnxela, cantidad);

            System.out.println("\n✅ Transferencia realizada con éxito.");
            System.out.println(contaXulio);
            System.out.println(contaAnxela);

        } catch (CantidadInvalidaException e) {
            System.out.println("❌ Error de validación: " + e.getMessage());
        } catch (SaldoInsuficienteException e) {
            System.out.println("❌ Error de operación: " + e.getMessage());
        } catch (InputMismatchException e) {
            System.out.println("❌ Error: Debes introducir un número válido.");
        } finally {
            sc.close();
            System.out.println("\nPrograma finalizado.");
        }    
    }
}

