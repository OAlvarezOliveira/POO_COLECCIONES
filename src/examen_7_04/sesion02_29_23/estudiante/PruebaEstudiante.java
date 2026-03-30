package examen_7_04.sesion02_29_23.estudiante;

import java.util.HashSet;

public class PruebaEstudiante {
    
    public static void main(String[] args) {
        HashSet<Estudiante> estudiantes = new HashSet<>();
        
        int añadidos = 0;
        int duplicados = 0;
        int edadInvalida = 0;
        
        System.out.println("Añadiendo estudiantes...");
        
        // Intentar añadir
        if (añadirEstudiante(estudiantes, "12345678A", "Ana García", 20)) añadidos++;
        if (añadirEstudiante(estudiantes, "87654321B", "Luis Pérez", 22)) añadidos++;
        
        if (!añadirEstudiante(estudiantes, "12345678A", "Ana López", 25)) duplicados++;
        if (!añadirEstudiante(estudiantes, "11111111C", "María Ruiz", 17)) edadInvalida++;
        if (!añadirEstudiante(estudiantes, "22222222D", "Pedro Sanz", 101)) edadInvalida++;
        
        if (añadirEstudiante(estudiantes, "33333333E", "Laura Díaz", 19)) añadidos++;
        
        // Resumen
        System.out.println("\nEstudiantes añadidos: " + añadidos);
        System.out.println("Rechazados (duplicados): " + duplicados);
        System.out.println("Rechazados (edad inválida): " + edadInvalida);
        
        // Lista completa
        System.out.println("\nLista de estudiantes:");
        for (Estudiante e : estudiantes) {
            System.out.println("- " + e);
        }
        
        // Buscar
        System.out.println("\nBuscando 12345678A: " + 
            (buscarPorDNI(estudiantes, "12345678A") ? "✅ Encontrado" : "❌ No encontrado"));
        System.out.println("Buscando 99999999Z: " + 
            (buscarPorDNI(estudiantes, "99999999Z") ? "✅ Encontrado" : "❌ No encontrado"));
    }
    
    private static boolean añadirEstudiante(HashSet<Estudiante> set, 
                                           String dni, String nombre, int edad) {
        // 1. Validar edad PRIMERO
        if (edad < 18 || edad > 100) {
            System.out.println("❌ Edad inválida (" + edad + "): " + dni);
            return false;
        }
        
        // 2. Crear estudiante
        Estudiante nuevo = new Estudiante(dni, nombre, edad);
        
        // 3. Intentar añadir (HashSet detecta duplicados automáticamente)
        if (set.add(nuevo)) {
            System.out.println("✅ Añadido: " + dni + " - " + nombre);
            return true;
        } else {
            System.out.println("❌ Duplicado: " + dni);
            return false;
        }
    }
    
    private static boolean buscarPorDNI(HashSet<Estudiante> set, String dni) {
        Estudiante temporal = new Estudiante(dni, "", 0);
        return set.contains(temporal);
    }
}