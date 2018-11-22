package test;

import static org.junit.Assert.*;

import org.junit.Test;

import com.example.echo.Credito;
import com.example.echo.Pago;

public class testICredito {

	Pago pago = new Pago();
	Credito pagoC;

	public void setupEscenario1() {

		pago.setValores("5000,987654321,123456,987654,Multa");

		try {
			pagoC = new Credito(pago);
			pagoC.setValores("hoy,1234567898745632,753,6");
		} catch (Exception e) {
			fail("No deberia generar excepcion. ");
		}
	}

	public void setupEscenario2() {

		pago.setValores("3000,123456789,987654,123456,Viaje");

		try {
			pagoC = new Credito(pago);
			pagoC.setValores("ayer,9876543212365478,681,12");
		} catch (Exception e) {
			fail("No deberia generar excepcion. ");
		}
	}

	public void setupEscenario3() {

		pago.setValores("10000,456789123,789456,987654,Devolucion");

		try {
			pagoC = new Credito(pago);
			pagoC.setValores("mediodia,6547539512584560,431,1");
		} catch (Exception e) {
			fail("No deberia generar excepcion. ");
		}
	}

	@Test
	public void testFechaPago1() {
		setupEscenario1();
		assertEquals("La fecha del sistema debe coincidir con la ingresada.", "hoy", pagoC.getFecha());
	}

	@Test
	public void testFechaPago2() {
		setupEscenario2();
		assertEquals("La fecha del sistema debe coincidir con la ingresada.", "ayer", pagoC.getFecha());
	}

	@Test
	public void testFechaPago3() {
		setupEscenario3();
		assertEquals("La fecha del sistema debe coincidir con la ingresada.", "mediodia", pagoC.getFecha());
	}

	@Test
	public void testTarjetaPago1() {
		setupEscenario1();
		assertEquals("El numero de Tarjeta de credito debe coincidir con la ingresada.", "1234567898745632",
				pagoC.getNumTarjeta());
	}

	@Test
	public void testTarjetaPago2() {
		setupEscenario2();
		assertEquals("El numero de Tarjeta de credito debe coincidir con la ingresada.", "9876543212365478",
				pagoC.getNumTarjeta());
	}

	@Test
	public void testTarjetaPago3() {
		setupEscenario3();
		assertEquals("El numero de Tarjeta de credito debe coincidir con la ingresada.", "6547539512584560",
				pagoC.getNumTarjeta());
	}

	@Test
	public void testSeguCodPago1() {
		setupEscenario1();
		assertEquals("El codigo de seguridad debe coincidir con la ingresada.", "753", pagoC.getSegucode());
	}

	@Test
	public void testSeguCodPago2() {
		setupEscenario2();
		assertEquals("El codigo de seguridad debe coincidir con la ingresada.", "681", pagoC.getSegucode());
	}

	@Test
	public void testSeguCodPago3() {
		setupEscenario3();
		assertEquals("El codigo de seguridad debe coincidir con la ingresada.", "431", pagoC.getSegucode());
	}

	@Test
	public void testCuotasPago1() {
		setupEscenario1();
		assertEquals("La cantidad de cuotas debe coincidir con la ingresada.", "6", pagoC.getCuotas());
	}

	@Test
	public void testCuotasPago2() {
		setupEscenario2();
		assertEquals("La cantidad de cuotas debe coincidir con la ingresada.", "12", pagoC.getCuotas());
	}

	@Test
	public void testCuotasPago3() {
		setupEscenario3();
		assertEquals("La cantidad de cuotas debe coincidir con la ingresada.", "1", pagoC.getCuotas());
	}

}
