package excepciones03.exercicio1;

public class Exercicio1 {
    
    public static void main(String[] args) {
        
        try {
            throw new Exception("Vas cascar");
            
        }catch (NullPointerException e) {
            
        } catch(Exception e) {
            System.out.println("Temos unha excepción: " + e.getMessage());
        } finally {
            System.out.println("Esto execútase si ou si");
        }
        
    }

}
