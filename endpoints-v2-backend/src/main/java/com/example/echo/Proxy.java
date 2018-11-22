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
	public Session auth(String user, String pass) throws Exception {
		Random ran = new Random();
		long sesion,sess;
		for (IUsuario us : usuarios) {
			if (us.getCorreo().equals(user)&&us.getPass().equals(pass)) {
				Session session = new Session();
				sesion = ran.nextLong();
				if(sesion<0) {
					sesion=sesion*(-1);
				}
				session.setSession(sesion);
				session.setId(us.getId());
				
				return facade.guardarSesion(session);
			}

		}

		throw new Exception("Error sesion no encontrada"); 
	}

	@Override
	public boolean crearPasajero(String correo, String password, String nombre, String apellido, int edad, String id) {
		IUsuario user=new Pasajero();
		user.setCorreo(correo);
		user.setPass(password);
		user.setNombre(nombre);
		user.setApellido(apellido);
		user.setEdad(edad);
		user.setId(id);
		return usuarios.add(user);
	}

	@Override
	public boolean crearConductor(String correo, String password, String nombre, String apellido, int edad, String id) {
		IUsuario user=new Conductor();
		user.setCorreo(correo);
		user.setPass(password);
		user.setNombre(nombre);
		user.setApellido(apellido);
		user.setEdad(edad);
		user.setId(id);
		return usuarios.add(user);
	}
	
	
	
	

}
