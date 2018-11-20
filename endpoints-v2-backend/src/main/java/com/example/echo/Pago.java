package com.example.echo;

public class Pago implements IPago{
	
	private String Valor;
	private String referencia;
	private String UsuarioPaga;
	private String UsuarioPagado;
	private String concepto;
	@Override
	public void setValores(String infoPago) {
		 String[] para = infoPago.split(",");
		 this.setValor(para[0]);
		 this.setReferencia(para[1]);
	     this.setUsuarioPaga(para[2]);
	     this.setUsuarioPagado(para[3]);
	     this.setConcepto(para[4]);
	}

	public String getValor() {
		return Valor;
	}

	public void setValor(String valor) {
		Valor = valor;
	}

	public String getReferencia() {
		return referencia;
	}

	public void setReferencia(String referencia) {
		this.referencia = referencia;
	}

	public String getUsuarioPaga() {
		return UsuarioPaga;
	}

	public void setUsuarioPaga(String usuarioPaga) {
		UsuarioPaga = usuarioPaga;
	}

	public String getUsuarioPagado() {
		return UsuarioPagado;
	}

	public void setUsuarioPagado(String usuarioPagado) {
		UsuarioPagado = usuarioPagado;
	}

	public String getConcepto() {
		return concepto;
	}

	public void setConcepto(String concepto) {
		this.concepto = concepto;
	}
	

}
