package examen_7_04.sesion06_02_04.reservasHotel;

public class Reserva {
    private String codigoReserva;
    private String nombreCliente;
    private int numeroHabitacion;
    private int numNoches;
    private boolean pagado;
    
    
	public Reserva(String codigoReserva, String nombreCliente, int numeroHabitacion, int numNoches, boolean pagado) {
		super();
		this.codigoReserva = codigoReserva;
		this.nombreCliente = nombreCliente;
		this.numeroHabitacion = numeroHabitacion;
		this.numNoches = numNoches;
		this.pagado = pagado;
	}


	public String getCodigoReserva() {
		return codigoReserva;
	}


	public void setCodigoReserva(String codigoReserva) {
		this.codigoReserva = codigoReserva;
	}


	public String getNombreCliente() {
		return nombreCliente;
	}


	public void setNombreCliente(String nombreCliente) {
		this.nombreCliente = nombreCliente;
	}


	public int getNumeroHabitacion() {
		return numeroHabitacion;
	}


	public void setNumeroHabitacion(int numeroHabitacion) {
		this.numeroHabitacion = numeroHabitacion;
	}


	public int getNumNoches() {
		return numNoches;
	}


	public void setNumNoches(int numNoches) {
		this.numNoches = numNoches;
	}


	public boolean isPagado() {
		return pagado;
	}


	public void setPagado(boolean pagado) {
		this.pagado = pagado;
	}


	@Override
	public String toString() {
		return String.format(
				"Reserva: %s || %s || %d || %d || %b \n",
				codigoReserva, nombreCliente, numeroHabitacion, numNoches, pagado);
	}
 
    
    
    
    
    
}
