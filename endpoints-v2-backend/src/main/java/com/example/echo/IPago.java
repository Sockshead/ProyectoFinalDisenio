package com.example.echo;

public interface IPago {
	
	public void setValores(String infoPago);
	public String getValor();
	public String getReferencia();
	public String getUsuarioPagado();
	public void setValor(String valor);
	public void setReferencia(String referencia);
	public void setUsuarioPaga(String usuarioPaga);
	public void setUsuarioPagado(String usuarioPagado);
	public void setConcepto(String concepto);
	public String getConcepto();
	public String getUsuarioPaga();

}
