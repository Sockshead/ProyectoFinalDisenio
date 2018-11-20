package com.example.echo;

import com.google.api.server.spi.config.Named;

public interface IProxy {
	
	public Session auth(String user,String pass);
	public Session test(long sesion);
	 public void crearPasajero(String correo, String password, String nombre, String apellido, int edad,String id);
     public void crearConductor(String correo, String password, String nombre, String apellido, int edad,String id);
     //public void crearPasajero(String correo, String password, String nombre, String apellido, int edad);

}
