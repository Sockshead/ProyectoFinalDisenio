package com.example.echo;

abstract class MediosDePago implements IPago {
	
    protected IPago mediosPago;

	public MediosDePago(IPago pago) {
		mediosPago = pago;
	}

	
	
	public abstract void setValores(String pPago);
	public abstract String getValor();
	public abstract String getReferencia();
	public abstract String getUsuarioPagado();
	public abstract void setValor(String valor);
	public abstract void setReferencia(String referencia);
	public abstract void setUsuarioPaga(String usuarioPaga);
	public abstract void setUsuarioPagado(String usuarioPagado);
	public abstract void setConcepto(String concepto);
	public abstract String getConcepto();
	public abstract String getUsuarioPaga();
}
