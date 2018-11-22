package test;

import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.Test;

import com.example.echo.Facade;
import com.example.echo.IPago;
import com.example.echo.Pago;
import com.example.echo.Proxy;
import com.example.echo.Session;

public class PruebasSistema {
	Proxy proxy;
	Facade facade;
	Session ses;
	IPago pago = new Pago();
	IPago epago;

	public void setupEscenario1() {
		proxy = Proxy.rConstructora();
		facade = Facade.rConstructora();
		proxy.crearPasajero("mate.balles", "12345", "Julian", "Ballesteros", 21, "987654");
		try {
			ses = proxy.auth("mate.balles", "12345");
		} catch (Exception e) {
			fail("Debio encontrar la sesion");
		}
		pago.setValores("3000,4567655," + ses.getId() + ",12345,Multa");
	}

	public void setupEscenario2() {
		proxy = Proxy.rConstructora();
		facade = Facade.rConstructora();
		proxy.crearPasajero("mate.balles", "12345", "Julian", "Ballesteros", 21, "987654");
	}

	@Test
	public void pagoSEfectivo() {
		setupEscenario2();
		try {
			ses = proxy.auth("mate.balles", "12345");
		} catch (Exception e) {
			fail("Debio encontrar la sesion");
		}
		try {
			IPago result;
			pago.setValores("3000,4567655," + ses.getId() + ",12345,Viaje");
			result = facade.pagoEfectivo(ses.getSession(), (Pago) pago, "11-19-18");
			assertEquals("La referencia debe ser la misma", pago.getReferencia(), result.getReferencia());
		} catch (Exception e) {
			fail("Se debio realizar el pago efectivo");
		}

	}

	@Test
	public void pagoSEfectivo2() {
		setupEscenario2();
		try {
			ses = proxy.auth("mate.balles", "12345");
		} catch (Exception e) {
			fail("Debio encontrar la sesion");
		}
		try {
			IPago result;
			pago.setValores("3000,4567655," + ses.getId() + ",12345,Viaje");
			result = facade.pagoEfectivo(ses.getSession()+1 , (Pago) pago, "11-19-18");
		} catch (Exception e) {
			assertEquals("Error no se pudo realizar el pago en efectivo", e.getMessage());
		}

	}

	@Test
	public void pagoSDebito() {
		setupEscenario2();
		try {
			ses = proxy.auth("mate.balles", "12345");
		} catch (Exception e) {
			fail("Debio encontrar la sesion");
		}
		try {
			IPago result;
			pago.setValores("3000,4567655," + ses.getId() + ",12345,Viaje");
			result = facade.pagoDebito(ses.getSession(), (Pago) pago, "11-19-18,89327548");
			assertEquals("El usuario que paga debe ser el mismo", pago.getUsuarioPaga(), result.getUsuarioPaga());
		} catch (Exception e) {
			fail("Se debio realizar el pago debito");
		}

	}

	@Test
	public void pagoSDebito2() {
		setupEscenario2();
		try {
			ses = proxy.auth("mate.balles", "12345");
		} catch (Exception e) {
			fail("Debio encontrar la sesion");
		}
		try {
			IPago result;
			pago.setValores("3000,4567655," + ses.getId() + ",12345,Viaje");
			result = facade.pagoDebito(ses.getSession() + 1, (Pago) pago, "11-19-18,89327548");
		} catch (Exception e) {
			assertEquals("Error no se pudo realizar el pago por debito", e.getMessage());
		}

	}

	@Test
	public void pagoSCredito() {
		setupEscenario2();
		try {
			ses = proxy.auth("mate.balles", "12345");
		} catch (Exception e) {
			fail("Debio encontrar la sesion");
		}
		try {
			IPago result;
			pago.setValores("3000,4567655," + ses.getId() + ",12345,Viaje");
			result = facade.pagoCredito(ses.getSession(), (Pago) pago, "11-19-18,456788834032,555,2");
			assertEquals("El usuario pagado debe ser el mismo", pago.getUsuarioPagado(), result.getUsuarioPagado());
		} catch (Exception e) {
			fail("Se debio realizar el pago credito");
		}

	}

	@Test
	public void pagoSCredito2() {
		setupEscenario2();
		try {
			ses = proxy.auth("mate.balles", "12345");
		} catch (Exception e) {
			fail("Debio encontrar la sesion");
		}
		try {
			IPago result;
			pago.setValores("3000,4567655," + ses.getId() + ",12345,Viaje");
			result = facade.pagoCredito(ses.getSession() + 1, (Pago) pago, "11-19-18,456788834032,555,2");
		} catch (Exception e) {
			assertEquals("Error no se pudo realizar el pago por credito", e.getMessage());
		}

	}

	@Test
	public void listarPagosTest() {
		setupEscenario1();
		try {
			pago = facade.pagoEfectivo(ses.getSession(), (Pago) pago, "12-11-19");
			ArrayList<IPago> list = facade.listarPagos(ses.getSession());
			assertEquals("La referencia de los pagos deberia ser la misma", pago.getReferencia(),
					list.get(0).getReferencia());
		} catch (Exception e) {
			fail("Se debio realizar el pago");
		}
	}

}
