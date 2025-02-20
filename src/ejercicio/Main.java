package ejercicio;

import java.util.Scanner;

public class Main {
	
	private static Scanner numeros = new Scanner(System.in);
	private static Scanner letras = new Scanner(System.in);
	private static MetodoPago[] pagos = new MetodoPago[10];

	public static void main(String[] args) {
		int opcion;
		
		generarValores();
		bienvenida();
		
		do {
			
			menuInicio();
			opcion = numeros.nextInt();
			tratarMenuInicio(opcion);
			
		} while (opcion != 6);
		
		numeros.close();
		letras.close();

	}
	
	public static void generarValores() {
		pagos[0] = new TarjetaCredito(10000, "Snoopy", 3456789);
		pagos[1] = new PayPal(10000, "Carlitos", "charliebrown@gmail.com");
		pagos[2] = new Bizum(2000, "Eduardo", 123456789);
		
	}
	
	public static void bienvenida() {
		System.out.println("🦧🦧🦧 Bienvenid@ al programa de gestion de pagos de snoopyimpuestos 🦧🦧🦧");
		
	}
	
	public static void menuInicio() {
		System.out.println("\n🦧 Por favor escoja una de las opciones disponibles: 🦧");
		System.out.println("1) Añadir nuevo tipo de pago");
		System.out.println("2) Eliminar tipo de pago");
		System.out.println("3) Consultar tipos de pagos asociados a la cuenta");
		System.out.println("4) Filtrar por tipos de pagos asociados a la cuenta");
		System.out.println("5) Pagar snoopyimpuestos");
		System.out.println("6) Salir");
		
	}
	
	public static void tratarMenuInicio(int opcion) {
		switch (opcion) {
		case 1:
			anadirPago();
			break;
		case 2:
			eliminarPago();
			break;
		case 3:
			consultarPagos();
			break;
		case 4:
			filtrarPagos();
			break;
		case 5:
			pagar();
			break;
		case 6:
			salir();
			break;
		default:
			error();
		}
		
	}
	
	public static void anadirPago() {
		int opcion;
		
		System.out.println("\n🦧 Por favor indique el tipo de nuevo tipo de pago: 🦧");
		System.out.println("1) Tarjeta de Credito");
		System.out.println("2) PayPal");
		System.out.println("3) Bizum");
		opcion = numeros.nextInt();
		tratarAnadirPago(opcion);
		
	}
	
	public static void tratarAnadirPago(int opcion) {
		switch (opcion) {
		case 1:
			if (anadirTarjeta()) {
				System.out.println("\nLa tarjeta ha sido añadida");
			} else {
				System.out.println("\nLa tarjeta no ha podido ser añadida");
			}
			break;
		case 2:
			if (anadirPaypal()) {
				System.out.println("\nLa cuenta de PayPal ha sido añadida");
			} else {
				System.out.println("\nLa cuenta de PayPal no ha podido ser añadida");
			}
			break;
		case 3:
			if (anadirBizum()) {
				System.out.println("\nLa cuenta de Bizum ha sido añadida");
			} else {
				System.out.println("\nLa cuenta de Bizum no ha podido ser añadida");
			}
			break;
		default:
			error();
		}
		
	}
	
	public static boolean anadirTarjeta() {
		String nombre;
		int numeroTarjeta;
		double cantidad;
		boolean comprobar = false;
		
		System.out.println("\nPor favor introduzca el nombre del titular de la tarjeta:");
		nombre = letras.nextLine();
		System.out.println("La cantidad de dinero en la tarjeta:");
		cantidad = numeros.nextDouble();
		System.out.println("Y el numero de tarjeta:");
		numeroTarjeta = numeros.nextInt();
		for (int i = 0; i < pagos.length; i++) {
			if (pagos[i] == null) {
				pagos[i] = new TarjetaCredito(cantidad, nombre, numeroTarjeta);
				i = pagos.length;
				comprobar = true;
			}
			
		}
		
		return comprobar;
		
	}
	
	public static boolean anadirPaypal() {
		String nombre, email;
		double cantidad;
		boolean comprobar = false;
		
		System.out.println("\nPor favor introduzca el nombre del titular de la cuenta de PayPal:");
		nombre = letras.nextLine();
		System.out.println("La cantidad de dinero en la cuenta:");
		cantidad = numeros.nextDouble();
		System.out.println("Y el email asociado a la cuenta:");
		email = letras.next();
		for (int i = 0; i < pagos.length; i++) {
			if (pagos[i] == null) {
				pagos[i] = new PayPal(cantidad, nombre, email);
				i = pagos.length;
				comprobar = true;
			}
			
		}
		
		return comprobar;
		
	}

	public static boolean anadirBizum() {
		String nombre;
		int numeroTelefono;
		double cantidad;
		boolean comprobar = false;
	
		System.out.println("\nPor favor introduzca el nombre del titular de la cuenta de Bizum:");
		nombre = letras.nextLine();
		System.out.println("La cantidad de dinero en la cuenta:");
		cantidad = numeros.nextDouble();
		System.out.println("Y el numero de telefono asociado a esa cuenta:");
		numeroTelefono = numeros.nextInt();
		for (int i = 0; i < pagos.length; i++) {
			if (pagos[i] == null) {
				pagos[i] = new Bizum(cantidad, nombre, numeroTelefono);
				i = pagos.length;
				comprobar = true;
			}
			
		}
		
		return comprobar;
		
	}

	public static void eliminarPago() {
		int opcion, numeroPago;
		
		System.out.println("\n🦧 Por favor indique el tipo de pago a eliminar de la cuenta: 🦧");
		System.out.println("1) Tarjeta de Credito");
		System.out.println("2) PayPal");
		System.out.println("3) Bizum");
		opcion = numeros.nextInt();
		System.out.println("Y el numero de pago a eliminar:");
		numeroPago = numeros.nextInt();
		if (numeroPago >= 1 && numeroPago <= 10) {
			tratarEliminarPago(opcion, numeroPago);
		} else {
			error();
		}
		
	}
	
	public static void tratarEliminarPago(int opcion, int numeroPago) {
		switch (opcion) {
		case 1:
			if (eliminarTarjeta(numeroPago)) {
				System.out.println("\nLa tarjeta se ha eliminado correctamente");
			} else {
				System.out.println("\nError, esa tarjeta no existe");
			}
			break;
		case 2:
			if (eliminarPaypal(numeroPago)) {
				System.out.println("\nLa cuenta de Paypal se ha eliminado correctamente");
			} else {
				System.out.println("\nError, esa cuenta no existe");
			}
			break;
		case 3:
			if (eliminarBizum(numeroPago)) {
				System.out.println("\nLa cuenta de Bizum se ha eliminado correctamente");
			} else {
				System.out.println("\nError, esa cuenta no existe");
			}
			break;
		default:
			error();
		}
	}
	
	public static boolean eliminarTarjeta(int numeroPago) {
		boolean comprobar = false;
		
		if (pagos[numeroPago - 1] != null) {
			pagos[numeroPago - 1] = null;
			comprobar = true;
		} 
		
		return comprobar;
		
	}
	
	public static boolean eliminarPaypal(int numeroPago) {
		boolean comprobar = false;
		
		if (pagos[numeroPago - 1] != null) {
			pagos[numeroPago - 1] = null;
			comprobar = true;
		}
		
		return comprobar;
		
	}
	
	public static boolean eliminarBizum(int numeroPago) {
		boolean comprobar = false;
		
		if (pagos[numeroPago - 1] != null) {
			pagos[numeroPago - 1] = null;
			comprobar = true;
		} 
		
		return comprobar;
		
	}

	public static void consultarPagos() {
		System.out.println("\n🦧 Pagos asociados a su cuenta: 🦧");
		for (int i = 0; i < pagos.length; i++) {
			if (pagos[i] != null) {
				System.out.println(pagos[i]);
			}
			
		}
		
	}

	public static void filtrarPagos() {
		int opcion;
		
		System.out.println("\n🦧 Por favor indique el tipo de pago a filtrar: 🦧");
		opcion = numeros.nextInt();
		tratarFiltrarPagos(opcion);
		
	}
	
	public static void tratarFiltrarPagos(int opcion) {
		switch(opcion) {
		case 1:
			filtrarTarjeta();
			break;
		case 2:
			filtrarPaypal();
			break;
		case 3:
			filtrarBizum();
			break;
		default:
			error();
		}
		
	}
	
	public static void filtrarTarjeta() {
		System.out.println("\nTarjetas de credito registradas:");
		for (int i = 0; i < pagos.length; i++) {
			if (pagos[i] != null) {
				if (pagos[i] instanceof TarjetaCredito) {
					System.out.println(pagos[i]);
				}
				
			}
			
		}
		
	}
	
	public static void filtrarPaypal() {
		System.out.println("\nCuentas de PayPal registradas:");
		for (int i = 0; i < pagos.length; i++) {
			if (pagos[i] != null) {
				if (pagos[i] instanceof PayPal) {
					System.out.println(pagos[i]);
				}
				
			}
			
		}
		
	}

	public static void filtrarBizum() {
		System.out.println("\nCuentas de Bizum registradas:");
		for (int i = 0; i < pagos.length; i++) {
			if (pagos[i] != null) {
				if (pagos[i] instanceof Bizum) {
					System.out.println(pagos[i]);
				}
				
			}
			
		}
	
	}

	public static void pagar() {
		int numeroPago;
		double cantidad;
		
		System.out.println("\n🦧 Por favor introduzca la cantidad que desea pagar: 🦧");
		cantidad = numeros.nextDouble();
		System.out.println("Y el numero de pago que desea usar:");
		numeroPago = numeros.nextInt();
		if (numeroPago >= 1 && numeroPago <= 10) {
			if (pagos[numeroPago - 1] != null) {
				if (pagos[numeroPago - 1].procesarPago(cantidad)) {
					System.out.println("La cantidad se ha pagado correctamente");
				} else {
					System.out.println("Error, no dispone de suficiente saldo para pagar la cantidad deseada");
					pagos[numeroPago - 1].cancelarPago();
				}
				
			} else {
				System.out.println("Error, ese numero de pago no existe");
			}
			
		} else {
			error();
		}
		
	}
	
	public static void salir() {
		System.out.println("\n🦧 Saliendo del programa... 🦧");
		System.out.println("🦧🦧🦧 ¡Nos vemos! 🦧🦧🦧");
		
	}
	
	public static void error() {
		System.out.println("\n🦧 Error, opcion no disponible 🦧");
		
	}

}
