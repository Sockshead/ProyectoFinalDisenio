package test;

import static org.junit.Assert.*;

import org.junit.Test;

import com.example.echo.Efectivo;
import com.example.echo.Pago;

public class testIEfectivo {

	Pago pago = new Pago();
	Efectivo pagoE;

	public void setupEscenario1() {

		pago.setValores("5000,987654321,123456,987654,Multa");

		try {
			pagoE = new Efectivo(pago);
			pagoE.setValores("hoy");
		} catch (Exception e) {
			fail("No deberia generar excepcion. ");
		}
	}

	public void setupEscenario2() {

		pago.setValores("3000,123456789,987654,123456,Viaje");

		try {
			pagoE = new Efectivo(pago);
			pagoE.setValores("ayer");
		} catch (Exception e) {
			fail("No deberia generar excepcion. ");
		}
	}

	public void setupEscenario3() {

		pago.setValores("10000,456789123,789456,987654,Devolucion");

		try {
			pagoE = new Efectivo(pago);
			pagoE.setValores("mediodia");
		} catch (Exception e) {
			fail("No deberia generar excepcion. ");
		}
	}

	@Test
	public void testFechaPago1() {
		setupEscenario1();
		assertEquals("La fecha del sistema debe coincidir con la ingresada.", "hoy", pagoE.getFecha());
	}

	@Test
	public void testFechaPago2() {
		setupEscenario2();
		assertEquals("La fecha del sistema debe coincidir con la ingresada.", "ayer", pagoE.getFecha());
	}

	@Test
	public void testFechaPago3() {
		setupEscenario3();
		assertEquals("La fecha del sistema debe coincidir con la ingresada.", "mediodia", pagoE.getFecha());
	}
}
