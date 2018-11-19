package com.example.echo;

import java.util.ArrayList;

public class Facade {

	
	private ArrayList<Long> Sesiones = new ArrayList();
	private ArrayList<IPago> pagos = new ArrayList();
	
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
	
	public IPago pagoEfectivo (long session,Pago pago) {
		Pago pag = (Pago) pago; 
		for (long ses:Sesiones) {
			if(session==ses) {
				pagos.add(pago);
				return pago;
			}
		}
		return null;
	}


	public ArrayList<IPago> listarPagos(String id,long sesion) {
		System.out.println("lista");
		ArrayList<IPago> lista = new ArrayList();
		for (long ses:Sesiones) {
			if(sesion==ses) {
				for(IPago pago:pagos) {
					if(pago.getUsuarioPaga().equals(id)) {
						lista.add(pago);
					}
				}
				return lista;
			}
		}
		return null;
	}


	public ArrayList<IPago> listarTPagos(long sesion) {
		for (long ses:Sesiones) {
			if(sesion==ses) {
				return pagos;
			}
		}
		return null;
	}
}
