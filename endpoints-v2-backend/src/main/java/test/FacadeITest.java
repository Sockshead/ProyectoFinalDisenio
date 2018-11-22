package test;

import static org.junit.Assert.*;

import org.junit.Test;

import com.example.echo.Facade;
import com.example.echo.IPago;
import com.example.echo.Pago;
import com.example.echo.Proxy;
import com.example.echo.Session;

public class FacadeITest {
	Facade facade;
	Session ses;
	Session prueba;
	IPago pago;
	
	private void setupEscenario1() {
		facade = Facade.rConstructora();
		ses = new Session();
		ses.setSession(38712555);
		ses.setId("1015678");
		prueba = facade.guardarSesion(ses);
		pago = new Pago();
		pago.setValores("3000,4567655,"+prueba.getId()+",123456,Multa");
		
	}
	private void setupEscenario2() {
		facade = Facade.rConstructora();
		ses = new Session();
		ses.setSession(38712566);
		ses.setId("1015678");
		prueba = facade.guardarSesion(ses);
		pago = new Pago();
		pago.setValores("3000,4567655,"+prueba.getId()+",123456,Viaje");
	}


	@Test
	public void pagoEfectivoTest() {
		setupEscenario1();
		IPago respuesta;
		try {
			respuesta = facade.pagoEfectivo(prueba.getSession(),(Pago) pago, "12-12-12");
			assertEquals("El numero de referencia deberia ser el mismo",pago.getReferencia(),respuesta.getReferencia());
		} catch (Exception e) {
			fail("Se debio realizar el pago en Efectivo");
		}
		
		
	}
	@Test
	public void pagoEfectivoTest2() {
		setupEscenario2();
		IPago respuesta;
		try {
			respuesta = facade.pagoEfectivo(prueba.getSession(),(Pago) pago, "12-12-12");
			assertEquals("El numero de ID del usuario pagado deberia ser el mismo",pago.getUsuarioPagado(),respuesta.getUsuarioPagado());
		} catch (Exception e) {
			fail("Se debio realizar el pago en Efectivo");
		}
	}
	
	@Test
	public void pagoEfectivoTest3() {
		setupEscenario1();
		IPago respuesta;
		try {
			respuesta = facade.pagoEfectivo(38712111,(Pago) pago, "12-12-12");
		} catch (Exception e) {
			assertEquals("Error no se pudo realizar el pago en efectivo",e.getMessage());
		}
	}
	@Test
	public void pagoDebitoTest() {
		setupEscenario1();
		IPago respuesta;
		try {
			respuesta = facade.pagoDebito(prueba.getSession(),(Pago) pago, "12-12-12,455556543");
			assertEquals("El numero de referencia deberia ser el mismo",pago.getReferencia(),respuesta.getReferencia());
			
		} catch (Exception e) {
			fail("Se debio realizar el pago por Debito");
		}
		
	}
	@Test
	public void pagoDebitoTest2() {
		setupEscenario2();
		IPago respuesta;
		try {
			respuesta = facade.pagoDebito(prueba.getSession(),(Pago) pago, "12-12-12,455556543");
			assertEquals("El numero de ID del usuario que paga deberia ser el mismo",pago.getUsuarioPaga(),respuesta.getUsuarioPaga());
			
		} catch (Exception e) {
			fail("Se debio realizar el pago por Debito");
		}
		
	}
	@Test
	public void pagoDebitoTest3() {
		setupEscenario1();
		IPago respuesta;
		try {
			respuesta = facade.pagoDebito(38712111,(Pago) pago, "12-12-12,455556543");
		} catch (Exception e) {
			assertEquals("Error no se pudo realizar el pago por debito",e.getMessage());
		}
	}
	@Test
	public void pagoCreditoTest() {
		setupEscenario1();
		IPago respuesta;
		try {
			respuesta = facade.pagoCredito(prueba.getSession(),(Pago) pago, "12-12-12,455556543123,433,2");
			assertEquals("El numero de referencia deberia ser el mismo",pago.getReferencia(),respuesta.getReferencia());
		} catch (Exception e) {
			fail("Se debio realizar el pago por Credito");
		}
	}
	@Test
	public void pagoCreditoTest2() {
		setupEscenario2();
		IPago respuesta;
		try {
			respuesta = facade.pagoCredito(prueba.getSession(),(Pago) pago, "12-12-12,455556543123,433,2");
			assertEquals("El numero de ID del usuario pagado deberia ser el mismo",pago.getUsuarioPaga(),respuesta.getUsuarioPaga());
		} catch (Exception e) {
			fail("Se debio realizar el pago por Credito");
		}
	}
	@Test
	public void pagoCreditoTest3() {
		setupEscenario1();
		IPago respuesta;
		try {
			respuesta = facade.pagoCredito(38712111,(Pago) pago, "12-12-12,455556543123,433,2");
		} catch (Exception e) {
			assertEquals("Error no se pudo realizar el pago por credito",e.getMessage());
		}
	}

}
