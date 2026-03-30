package examen_7_04.sesion01_28_03;

import java.util.HashSet;
import java.util.Random;

public class ejercicio02 {
    public static void main(String[] args) {
        HashSet<Integer> numeros = new HashSet<>();
        Random rand = new Random();
        
        // 1. Añadir 10 números aleatorios 1-20
        int intentos = 0;
        while (numeros.size() < 10) {
            int num = rand.nextInt(1,21);
            numeros.add(num);
            intentos++;
        }
        
        System.out.println("Intentos: " + intentos);
        System.out.println("Únicos añadidos: " + numeros.size());
        System.out.println("Duplicados rechazados: " + (intentos - numeros.size()));
        
        System.out.println("\nNúmeros originales:");
        for (Integer n : numeros) {
            System.out.print(n + " ");
        }
        
        // 2. Eliminar pares (crear nuevo set con impares)
        HashSet<Integer> impares = new HashSet<>();
        for (Integer num : numeros) {
            if (num % 2 != 0) {  // Impar
                impares.add(num);
            }
        }
        
        // 3. Reemplazar
        numeros = impares;
        
        System.out.println("\n\nSolo impares:");
        for (Integer n : numeros) {
            System.out.print(n + " ");
        }
        
        System.out.println("\n\nTotal impares: " + numeros.size());
    }
}