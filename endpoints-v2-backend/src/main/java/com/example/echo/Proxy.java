package com.example.echo;

import java.util.ArrayList;
import java.util.Random;

public class Proxy implements IProxy {

	private Facade facade = Facade.rConstructora();
	private static Proxy instanciaUnica = null;

	private ArrayList<IUsuario> usuarios = new ArrayList();

	public static Proxy rConstructora() {
		if (instanciaUnica == null) {
			instanciaUnica = new Proxy();
		}
		return instanciaUnica;
	}

	@Override
	public Session auth(String user, String pass) {
		Random ran = new Random();
		for (IUsuario us : usuarios) {
			if (us.getCorreo().equals(user)&&us.getPass().equals(pass)) {
				Session session = new Session();
				session.setSession(ran.nextLong());
				facade.guardarSesion(session);
				return session;
			}

		}

		return null;
	}

	@Override
	public Session test(long sesion) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void crearPasajero(String correo, String password, String nombre, String apellido, int edad) {
		IUsuario user=new Pasajero();
		user.setCorreo(correo);
		user.setPass(password);
		user.setNombre(nombre);
		user.setApellido(apellido);
		user.setEdad(edad);
		usuarios.add(user);
	}

	@Override
	public void crearConductor(String correo, String password, String nombre, String apellido, int edad) {
		// TODO Auto-generated method stub
		
	}
	
	
	
	

}
