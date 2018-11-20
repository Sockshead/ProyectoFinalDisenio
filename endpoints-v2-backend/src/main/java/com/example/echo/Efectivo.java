 package com.example.echo;

public class Efectivo extends MediosDePago {

	String fecha;

	public Efectivo(IPago pMediosPago) {
		super(pMediosPago);
	}

	@Override
	public void setValores(String pPago) {
		this.fecha = pPago;
	}

	@Override
	public String getValor() {
		// TODO Auto-generated method stub
		return super.mediosPago.getValor();
	}

	@Override
	public String getReferencia() {
		// TODO Auto-generated method stub
		return super.mediosPago.getReferencia();
	}

	@Override
	public String getUsuarioPagado() {
		// TODO Auto-generated method stub
		return super.mediosPago.getUsuarioPagado();
	}

	@Override
	public void setValor(String valor) {
		// TODO Auto-generated method stub
		super.mediosPago.setValor(valor);
	}

	@Override
	public void setReferencia(String referencia) {
		// TODO Auto-generated method stub
		super.mediosPago.setReferencia(referencia);
	}

	@Override
	public void setUsuarioPaga(String usuarioPaga) {
		// TODO Auto-generated method stub
		super.mediosPago.setUsuarioPaga(usuarioPaga);
	}

	@Override
	public void setUsuarioPagado(String usuarioPagado) {
		// TODO Auto-generated method stub
		super.mediosPago.setUsuarioPagado(usuarioPagado);
	}

	@Override
	public void setConcepto(String concepto) {
		// TODO Auto-generated method stub
		super.mediosPago.setConcepto(concepto);
	}

	@Override
	public String getConcepto() {
		// TODO Auto-generated method stub
		return super.mediosPago.getConcepto();
	}

	@Override
	public String getUsuarioPaga() {
		// TODO Auto-generated method stub
		return super.mediosPago.getUsuarioPaga();
	}

	public String getFecha() {
		return fecha;
	}

	public void setFecha(String fecha) {
		this.fecha = fecha;
	}
	

}
