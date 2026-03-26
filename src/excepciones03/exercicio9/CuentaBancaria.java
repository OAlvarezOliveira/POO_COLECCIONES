package excepciones03.exercicio9;
/**
 * Resolución de la tarea xx
 * 
 * Curso 2025-26
 * @author Julio Mosquera
 * @version 1.0
 */

public class CuentaBancaria {
    private String titular;
    private double saldo;

    public CuentaBancaria(String titular, double saldoInicial) {
        this.titular = titular;
        this.saldo = saldoInicial;
    }

    public void depositar(double cantidad) throws CantidadInvalidaException {
        if (cantidad <= 0) {
            throw new CantidadInvalidaException("La cantidad a depositar debe ser positiva.");
        }
        saldo += cantidad;
    }

    public void retirar(double cantidad) throws CantidadInvalidaException {
        if (cantidad <= 0) {
            throw new CantidadInvalidaException("La cantidad a retirar debe ser positiva.");
        }
        if (cantidad > saldo) {
            throw new SaldoInsuficienteException("Saldo insuficiente. Disponible: " + saldo);
        }
        saldo -= cantidad;
    }

    public void transferir(CuentaBancaria destino, double cantidad) throws CantidadInvalidaException {
        this.retirar(cantidad);   // puede lanzar CantidadInvalidaException o SaldoInsuficienteException
        destino.depositar(cantidad);
    }

    public double getSaldo() {
        return saldo;
    }

    @Override
    public String toString() {
        return "Cuenta de " + titular + " | Saldo: " + saldo;
    }
}