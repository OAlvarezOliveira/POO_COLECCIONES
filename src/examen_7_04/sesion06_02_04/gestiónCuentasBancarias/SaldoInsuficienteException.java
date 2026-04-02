package examen_7_04.sesion06_02_04.gestiónCuentasBancarias;

public class SaldoInsuficienteException extends Exception {
    public SaldoInsuficienteException(String mensaje) {
        super(mensaje);
    }
}
