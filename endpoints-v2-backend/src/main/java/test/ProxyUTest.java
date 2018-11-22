package test;

import static org.junit.Assert.*;

import org.junit.Test;

import com.example.echo.Proxy;
import com.example.echo.Session;

public class ProxyUTest {
	Session ses = new Session();
	Proxy proxy;
	
	private void setupEscenario1() {
		proxy = Proxy.rConstructora();
		proxy.crearPasajero("mate.balles", "12345", "Julian", "Ballesteros", 21, "987654");
	}
	private void setupEscenario2() {
		proxy = Proxy.rConstructora();
		proxy.crearConductor("juancapoar", "54321", "Juan", "Posada", 21, "169701");
	}
	
	
	@Test
	public void crearPasajeroTest() {
		Proxy proxy = Proxy.rConstructora();
		boolean creado = proxy.crearPasajero("mate.balles", "12345", "Julian", "Ballesteros", 21, "987654");
		assertTrue("El usuario se debio crear",creado);
	}
	@Test
	public void crearConductorTest() {
		Proxy proxy = Proxy.rConstructora();
		boolean creado =proxy.crearConductor("juancapoar", "54321", "Juan", "Posada", 21, "169701");
		assertTrue("El usuario se debio crear",creado);
	}

	@Test
	public void authTest1() {
		setupEscenario1();
		try {
			ses = proxy.auth("mate", "12345");
		} catch (Exception e) {
			assertEquals(e.getMessage(),"Error sesion no encontrada");
		}
	}
	
	@Test
	public void authTest2() {	
		setupEscenario1();
		try {
			ses = proxy.auth("mate.balles", "12345");
			assertEquals(ses.getId(),"987654");
		} catch (Exception e) {
			fail("Debio encontrar la sesion");
		}
		
	}
	
	@Test
	public void authTest3() {
		setupEscenario2();
		try {
			ses = proxy.auth("juancapoar", "54321");
			assertEquals(ses.getId(),"169701");
		} catch (Exception e) {
			fail("Debio encontrar la sesion");
		}
		
	}

}
