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
		long sesion;
		for (IUsuario us : usuarios) {
			if (us.getCorreo().equals(user)&&us.getPass().equals(pass)) {
				Session session = new Session();
				sesion = ran.nextLong();
				if(sesion<=0) {
					sesion=sesion*(-1);
				}
				session.setSession(ran.nextLong());
				session.setId(us.getId());
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
	public void crearPasajero(String correo, String password, String nombre, String apellido, int edad, String id) {
		IUsuario user=new Pasajero();
		user.setCorreo(correo);
		user.setPass(password);
		user.setNombre(nombre);
		user.setApellido(apellido);
		user.setEdad(edad);
		user.setId(id);
		usuarios.add(user);
	}

	@Override
	public void crearConductor(String correo, String password, String nombre, String apellido, int edad, String id) {
		IUsuario user=new Conductor();
		user.setCorreo(correo);
		user.setPass(password);
		user.setNombre(nombre);
		user.setApellido(apellido);
		user.setEdad(edad);
		user.setId(id);
		usuarios.add(user);
	}
	
	
	
	

}
