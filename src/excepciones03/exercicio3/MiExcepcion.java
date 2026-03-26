package excepciones03.exercicio3;

public class MiExcepcion extends Exception{

    String mensaxe;
    
    public MiExcepcion(String mensaxe) {
        super(mensaxe);
        this.mensaxe = mensaxe;
    }
    
    public String getMensaxe() {
        return this.mensaxe;
    }
}
