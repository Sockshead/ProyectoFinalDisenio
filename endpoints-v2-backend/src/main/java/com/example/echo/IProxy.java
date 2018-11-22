package com.example.echo;

import com.google.api.server.spi.config.Named;

public interface IProxy {
	
	public Session auth(String user,String pass)  throws Exception;
    public boolean crearPasajero(String correo, String password, String nombre, String apellido, int edad,String id);
    public boolean crearConductor(String correo, String password, String nombre, String apellido, int edad,String id);

}
