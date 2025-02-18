package ejercicio;

public class TarjetaCredito extends MetodoPago implements Pago {
	private int NumeroTarjeta;
	
	public TarjetaCredito() {
	}

	public TarjetaCredito(double cantidadDinero, String titular, int numeroTarjeta) {
		super(cantidadDinero, titular);
		NumeroTarjeta = numeroTarjeta;
	}

	public int getNumeroTarjeta() {
		return NumeroTarjeta;
	}

	public void setNumeroTarjeta(int numeroTarjeta) {
		NumeroTarjeta = numeroTarjeta;
	}

	@Override
	public String toString() {
		return "TarjetaCredito [NumeroTarjeta=" + NumeroTarjeta + ", cantidadDinero=" + cantidadDinero + ", titular=" + titular + "]";
	}
	
	public boolean procesarPago(double cantidad) {
		boolean comprobar = false;
		
		if (cantidadDinero > cantidad) {
			cantidadDinero -= cantidad;
			comprobar = true;
		}
		
		return comprobar;
	}
	
}
