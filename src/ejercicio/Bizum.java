package ejercicio;

public class Bizum extends MetodoPago {
	private int numeroTelefono;
	
	public Bizum() {
	}

	public Bizum(double cantidadDinero, String titular, int numeroTelefono) {
		super(cantidadDinero, titular);
		this.numeroTelefono = numeroTelefono;
	}

	public int getNumeroTelefono() {
		return numeroTelefono;
	}

	public void setNumeroTelefono(int numeroTelefono) {
		this.numeroTelefono = numeroTelefono;
	}

	@Override
	public String toString() {
		return "Bizum [numeroTelefono=" + numeroTelefono + ", cantidadDinero=" + cantidadDinero + ", titular=" + titular + "]";
	}

}
