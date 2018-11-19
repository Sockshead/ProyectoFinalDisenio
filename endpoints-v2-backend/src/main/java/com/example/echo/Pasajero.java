package com.example.echo;

public class Pasajero extends Usuario {

	 public Pasajero() {
	        super();
	    }

	    public void adicionar(String correo, String password, String nombre, String apellido, int edad, String id) {
	        super.setCorreo(correo);
	        super.setPass(password);
	        super.setNombre(nombre);
	        super.setApellido(apellido);
	        super.setEdad(edad);
	        super.setId(id);
	    }

	    public void modificar(String password, String nombre, String apellido, int edad) {
	        super.setPass(password);
	        super.setNombre(nombre);
	        super.setApellido(apellido);
	        super.setEdad(edad);
	    }
}
