package test;

import static org.junit.Assert.*;

import org.junit.Test;

import com.example.echo.Debito;
import com.example.echo.Efectivo;
import com.example.echo.Facade;
import com.example.echo.IPago;
import com.example.echo.Pago;
import com.example.echo.Session;

public class FacadeUTest {

	@Test
	public void guardarSesionesTest() {
		Facade facade = Facade.rConstructora();
		Session ses = new Session();
		ses.setSession(38712555);
		ses.setId("1015678");
		Session prueba = facade.guardarSesion(ses);
		assertEquals("El numero de sesion deberia ser el mismo",ses.getSession(),prueba.getSession());
		assertEquals("El ID deberia ser el mismo",ses.getId(),prueba.getId());	
	}
}
