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
	
	
	public Session guardarSesion(Session session) {
		Sesiones.add(session.getSession());
		return session;
	}
	
	public IPago pagoEfectivo (long session,Pago pago,String date) throws Exception{
		Pago pag = (Pago) pago; 
		IPago com= new Efectivo(pago);
		com.setValores(date);
		for (long ses:Sesiones) {
			if(session==ses) {
				pagos.add(com);
				return com;
			}
		}
		throw new Exception("Error no se pudo realizar el pago en efectivo"); 
	}
	
	public IPago pagoDebito (long session,Pago pago,String datos) throws Exception {
		Pago pag = (Pago) pago; 
		IPago com= new Debito(pago);
		com.setValores(datos);
		for (long ses:Sesiones) {
			if(session==ses) {
				pagos.add(com);
				return com;
			}
		}
		throw new Exception("Error no se pudo realizar el pago por debito"); 
	}
	
	public IPago pagoCredito (long session,Pago pago,String datos) throws Exception {
		Pago pag = (Pago) pago; 
		IPago com= new Credito(pago);
		com.setValores(datos);
		for (long ses:Sesiones) {
			if(session==ses) {
				pagos.add(com);
				return com;
			}
		}
		throw new Exception("Error no se pudo realizar el pago por credito"); 
	}


	public ArrayList<IPago> listarPagos(long sesion) throws Exception {
		System.out.println("lista");
		ArrayList<IPago> lista = new ArrayList();
		for (long ses:Sesiones) {
			if(sesion==ses) {
				for(IPago pago:pagos) {
						lista.add(pago);
				}
				return lista;
			}
		}
		throw new Exception("Error no se pudo devolver la lista de pagos"); 
	}

}
