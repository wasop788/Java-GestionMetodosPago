package ejercicio;

public class PayPal extends MetodoPago {
	private String email;

	public PayPal() {
	}

	public PayPal(double cantidadDinero, String titular, String email) {
		super(cantidadDinero, titular);
		this.email = email;
	}
	
	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}
	
	@Override
	public String toString() {
		return "PayPal [email=" + email + ", cantidadDinero=" + cantidadDinero + ", titular=" + titular + "]";
	}

}
