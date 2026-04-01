package examen_7_04.sesion04_31_03.banco;

public class Cuenta {

	private String numeroCuenta;
	private String titular;
	private double saldo;

	public Cuenta(String numeroCuenta, String titular, double saldo) {
		this.numeroCuenta = numeroCuenta;
		this.titular = titular;
		this.saldo = saldo;
	}
	public String getNumeroCuenta() {
		return numeroCuenta;
	}
	public void setNumeroCuenta(String numeroCuenta) {
		this.numeroCuenta = numeroCuenta;
	}
	public String getTitular() {
		return titular;
	}
	public void setTitular(String titular) {
		this.titular = titular;
	}
	public double getSaldo() {
		return saldo;
	}
	public void setSaldo(double saldo) {
		this.saldo = saldo;
	}
	
	public void depositar(double cantidad) {
	    this.saldo += cantidad;  // SUMA
	}

	public void retirar(double cantidad) {
	    this.saldo -= cantidad;  // RESTA
	}
	
	
	@Override
	public String toString() {
		return String.format("Cuenta: %s === %s === %.2f", numeroCuenta, titular, saldo);
	}

}
