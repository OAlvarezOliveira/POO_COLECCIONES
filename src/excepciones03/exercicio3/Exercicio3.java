package excepciones03.exercicio3;

public class Exercicio3 {
    
    public static void main(String[] args) {
        
        try {
            throw new MiExcepcion("Fallo propio");
        } catch(MiExcepcion e) {
            System.out.println(e.getMensaxe() + " " +e.getMessage());
        }
        
    }

}
