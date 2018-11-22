package test;

import static org.junit.Assert.*;

import org.junit.Test;

import com.example.echo.Debito;
import com.example.echo.Pago;

public class testIDebito {

	Pago pago = new Pago();
	Debito pagoD;

	public void setupEscenario1() {

		pago.setValores("5000,987654321,123456,987654,Multa");

		try {
			pagoD = new Debito(pago);
			pagoD.setValores("hoy,1234567898745632,753,6");
		} catch (Exception e) {
			fail("No deberia generar excepcion. ");
		}
	}

	public void setupEscenario2() {

		pago.setValores("3000,123456789,987654,123456,Viaje");

		try {
			pagoD = new Debito(pago);
			pagoD.setValores("ayer,9876543212365478,681,12");
		} catch (Exception e) {
			fail("No deberia generar excepcion. ");
		}
	}

	public void setupEscenario3() {

		pago.setValores("10000,456789123,789456,987654,Devolucion");

		try {
			pagoD = new Debito(pago);
			pagoD.setValores("mediodia,6547539512584560,431,1");
		} catch (Exception e) {
			fail("No deberia generar excepcion. ");
		}
	}

	@Test
	public void testFechaPago1() {
		setupEscenario1();
		assertEquals("La fecha del sistema debe coincidir con la ingresada.", "hoy", pagoD.getFecha());
	}

	@Test
	public void testFechaPago2() {
		setupEscenario2();
		assertEquals("La fecha del sistema debe coincidir con la ingresada.", "ayer", pagoD.getFecha());
	}

	@Test
	public void testFechaPago3() {
		setupEscenario3();
		assertEquals("La fecha del sistema debe coincidir con la ingresada.", "mediodia", pagoD.getFecha());
	}

	@Test
	public void testCuentaPago1() {
		setupEscenario1();
		assertEquals("El numero de cuenta debe coincidir con la ingresada.", "1234567898745632", pagoD.getNumCuenta());
	}

	@Test
	public void testCuentaPago2() {
		setupEscenario2();
		assertEquals("El numero de cuenta debe coincidir con la ingresada.", "9876543212365478", pagoD.getNumCuenta());
	}

	@Test
	public void testCuentaPago3() {
		setupEscenario3();
		assertEquals("El numero de cuenta debe coincidir con la ingresada.", "6547539512584560", pagoD.getNumCuenta());
	}

}
