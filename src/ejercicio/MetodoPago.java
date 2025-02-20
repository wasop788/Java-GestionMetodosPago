package ejercicio;

public abstract class MetodoPago implements Pago {
	protected double cantidadDinero;
	protected String titular;

	public MetodoPago() {
	}
	
	public MetodoPago(double cantidadDinero, String titular) {
		this.cantidadDinero = cantidadDinero;
		this.titular = titular;
	}

	public double getCantidadDinero() {
		return cantidadDinero;
	}

	public void setCantidadDinero(double cantidadDinero) {
		this.cantidadDinero = cantidadDinero;
	}

	public String getTitular() {
		return titular;
	}

	public void setTitular(String titular) {
		this.titular = titular;
	}

	@Override
	public String toString() {
		return "MetodoPago [cantidadDinero=" + cantidadDinero + ", titular=" + titular + "]";
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
