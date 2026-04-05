package examen_7_04.sesion07_05_04.potitos;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.Scanner;

public class Problema185 {

    private static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        String[] elementos;
        String linea;
        
        int numPotitos = Integer.parseInt(sc.nextLine());

        while (numPotitos != 0) {
            HashSet<String> ingredientesSI = new HashSet<>();
            HashSet<String> ingredientesNO = new HashSet<>();

            for (int i = 0; i < numPotitos; i++) {
                linea = sc.nextLine();
                elementos = linea.split(" ");

                if (elementos[0].equals("SI:")) {
                    for (int j = 1; j < elementos.length; j++) {
                        if (!elementos[j].equals("FIN")) {
                            ingredientesSI.add(elementos[j]);
                        }
                    }
                } else if (elementos[0].equals("NO:")) {
                    for (int j = 1; j < elementos.length; j++) {
                        if (!elementos[j].equals("FIN")) {
                            ingredientesNO.add(elementos[j]);
                        }
                    }
                }
            }

            ingredientesNO.removeAll(ingredientesSI);
            
            ArrayList<String> resultado = new ArrayList<>(ingredientesNO);
            Collections.sort(resultado);

            for (int i = 0; i < resultado.size(); i++) {
                System.out.print(resultado.get(i));
                if (i < resultado.size() - 1) {
                    System.out.print(" ");
                }
            }
            System.out.println();

            numPotitos = Integer.parseInt(sc.nextLine());
        }
    }
}
