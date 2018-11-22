package test;

import static org.junit.Assert.*;

import org.junit.Test;

import com.example.echo.Pago;

public class testUPago {

	Pago pago = new Pago();
	
	public void setupEscenario1() {
		try {
			pago.setValores("5000,987654321,123456,987654,Multa");
		} catch (Exception e) {
			fail("No deberia generar excepcion. ");
		}
	}

	public void setupEscenario2() {
		try {
			pago.setValores("3000,123456789,987654,123456,Viaje");
		} catch (Exception e) {
			fail("No deberia generar excepcion. ");
		}
	}

	public void setupEscenario3() {
		try {
			pago.setValores("10000,456789123,789456,987654,Devolucion");
		} catch (Exception e) {
			fail("No deberia generar excepcion. ");
		}
	}
	
	@Test
	public void testValorPago1() {
		setupEscenario1();
		assertEquals("El Valor del pago deberia ser igual.","5000", pago.getValor());
	}
	
	@Test
	public void testValorPago2() {
		setupEscenario2();
		assertEquals("El Valor del pago deberia ser igual.","3000", pago.getValor());
	}
	
	@Test
	public void testValorPago3() {
		setupEscenario3();
		assertEquals("El Valor del pago deberia ser igual.","10000", pago.getValor());
	}
	
	@Test
	public void testRefPago1() {
		setupEscenario1();
		assertEquals("La referencia del pago deberia ser igual.","987654321", pago.getReferencia());
	}
	
	@Test
	public void testRefPago2() {
		setupEscenario2();
		assertEquals("La referencia del pago deberia ser igual.","123456789", pago.getReferencia());
	}
	
	@Test
	public void testRefPago3() {
		setupEscenario3();
		assertEquals("La referencia del pago deberia ser igual.","456789123", pago.getReferencia());
	}
	
	@Test
	public void testUsuarioPaga1() {
		setupEscenario1();
		assertEquals("El id de Usuario que paga deberia ser igual.","123456", pago.getUsuarioPaga());
	}
	
	@Test
	public void testUsuarioPaga2() {
		setupEscenario2();
		assertEquals("El id de Usuario que paga deberia ser igual.","987654", pago.getUsuarioPaga());
	}
	
	@Test
	public void testUsuarioPaga3() {
		setupEscenario3();
		assertEquals("El id de Usuario que paga deberia ser igual.","789456", pago.getUsuarioPaga());
	}
	
	@Test
	public void testUsuarioPagado1() {
		setupEscenario1();
		assertEquals("El id de Usuario que recibe el pago deberia ser igual.","987654", pago.getUsuarioPagado());
	}
	
	@Test
	public void testUsuarioPagado2() {
		setupEscenario2();
		assertEquals("El id de Usuario que recibe el pago deberia ser igual.","123456", pago.getUsuarioPagado());
	}
	
	@Test
	public void testUsuarioPagado3() {
		setupEscenario3();
		assertEquals("El id de Usuario que recibe el pago deberia ser igual.","987654", pago.getUsuarioPagado());
	}

	@Test
	public void testConceptoPago1() {
		setupEscenario1();
		assertEquals("El concepto del pago deberia ser igual.","Multa", pago.getConcepto());
	}
	
	@Test
	public void testConceptoPago2() {
		setupEscenario2();
		assertEquals("El concepto del pago deberia ser igual.","Viaje", pago.getConcepto());
	}
	
	@Test
	public void testConceptoPago3() {
		setupEscenario3();
		assertEquals("El concepto del pago deberia ser igual.","Devolucion", pago.getConcepto());
	}
}
