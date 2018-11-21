package test;

import static org.junit.Assert.*;

import org.junit.Test;

import com.example.echo.Proxy;
import com.example.echo.Session;

public class testUProxy {

	@Test
	public void authTest1() {
		Proxy proxy = Proxy.rConstructora();
		proxy.crearPasajero("mate.balles", "12345", "Julian", "Ballesteros", 21, "987654");
		Session ses = proxy.auth("mate", "1");
		System.out.println("Hola");
		assertNull("La sesion deberia ser nula",ses);
	}
	
	@Test
	public void authTest2() {
		Proxy proxy = Proxy.rConstructora();
		proxy.crearPasajero("mate.balles", "12345", "Julian", "Ballesteros", 21, "987654");
		Session ses = proxy.auth("mate.balles", "12345");
		assertNotNull("La sesion no deberia ser nula",ses);
		assertEquals(ses.getId(),"9876543");
	}
	
	@Test
	public void authTest3() {
		Proxy proxy = Proxy.rConstructora();
		proxy.crearConductor("juancapoar", "54321", "Juan", "Posada", 21, "169701");
		Session ses = proxy.auth("juancapoar", "54321");
		assertNotNull("La sesion no deberia ser nula",ses);
	}

}
