package com.example.echo;

public class Credito extends MediosDePago {

	String fecha;
	String numTarjeta;
	String segucode;
	String cuotas;

	public Credito(IPago pMediosPago) {
		super(pMediosPago);
	}

	@Override
	public void setValores(String pPago) {
		String[] para = pPago.split(",");
		this.fecha = para[0];
		this.numTarjeta = para[1];
		this.segucode = para[2];
		this.cuotas = para[3];
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

	public String getNumTarjeta() {
		return numTarjeta;
	}

	public void setNumTarjeta(String numTarjeta) {
		this.numTarjeta = numTarjeta;
	}

	public String getFecha() {
		return fecha;
	}

	public String getCuotas() {
		return cuotas;
	}

	public void setCuotas(String cuotas) {
		this.cuotas = cuotas;
	}

	public void setFecha(String fecha) {
		this.fecha = fecha;
	}

	public String getSegucode() {
		return segucode;
	}

	public void setSegucode(String segucode) {
		this.segucode = segucode;
	}
	

}
