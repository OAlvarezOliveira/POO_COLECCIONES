package examen_7_04.sesion06_02_04.gestiónCuentasBancarias;

public class Cuenta {
	
	private String numeroCuenta;
	private String titular;
	private double saldo;
	
	
	public Cuenta(String numeroCuenta, String titular, double saldo) {
		super();
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
		
		this.saldo += cantidad;
	}
	
	public void retirar(double cantidad) {
		try {
			if (this.saldo < cantidad) {
				throw new SaldoInsuficienteException("Saldo insuficiente. Disponible: " + this.saldo);
			}

			this.saldo -= cantidad;
			System.out.println("Retiro exitoso. Saldo restante: " + this.saldo);

		} catch (SaldoInsuficienteException e) {
			System.out.println("Operacion Cancelada");

		}
	}


	@Override
	public String toString() {
		return String.format("Cuenta: %s || %s || %.2f ", numeroCuenta, titular, saldo);
	}
	
	

}
