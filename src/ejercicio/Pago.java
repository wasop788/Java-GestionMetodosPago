package ejercicio;

public interface Pago {
	public boolean procesarPago(double cantidad);
	
	default void cancelarPago() {
		System.out.println("Se ha cancelado el pago");
	}
	
}
