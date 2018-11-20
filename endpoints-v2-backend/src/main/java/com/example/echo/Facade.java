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
	
	public IPago pagoEfectivo (long session,Pago pago,String date) {
		Pago pag = (Pago) pago; 
		IPago com= new Efectivo(pago);
		com.setValores(date);
		for (long ses:Sesiones) {
			if(session==ses) {
				pagos.add(com);
				return com;
			}
		}
		return null;
	}
	
	public IPago pagoDebito (long session,Pago pago,String datos) {
		Pago pag = (Pago) pago; 
		IPago com= new Debito(pago);
		com.setValores(datos);
		for (long ses:Sesiones) {
			if(session==ses) {
				pagos.add(com);
				return com;
			}
		}
		return null;
	}
	
	public IPago pagoCredito (long session,Pago pago,String datos) {
		Pago pag = (Pago) pago; 
		IPago com= new Credito(pago);
		com.setValores(datos);
		for (long ses:Sesiones) {
			if(session==ses) {
				pagos.add(com);
				return com;
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
