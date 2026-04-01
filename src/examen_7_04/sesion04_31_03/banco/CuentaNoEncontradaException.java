package examen_7_04.sesion04_31_03.banco;

public class CuentaNoEncontradaException extends Exception {
    public CuentaNoEncontradaException(String mensaje) {
        super(mensaje);
    }
}
