package com.example.echo;

import java.util.ArrayList;

public class Facade {

	
	private ArrayList<Long> Sesiones = new ArrayList();
	
	private static Facade instanciaUnica = null;
	
	
	public static Facade rConstructora() {
        if (instanciaUnica == null) {
            instanciaUnica = new Facade();
        }
        return instanciaUnica;
    }
	
	
	public void guardarSesion(Session session) {
		Sesiones.add(session.getSession());
	}
	
	public Session test (Session session) {
		for (long ses:Sesiones) {
			if(session.getSession()==ses) {
				return session;
			}
		}
		return null;
	}
	
}
