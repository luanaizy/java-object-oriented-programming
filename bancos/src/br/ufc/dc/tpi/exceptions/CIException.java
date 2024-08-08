package br.ufc.dc.tpi.exceptions;

public class CIException extends Exception {
	private String numero; 
	
	public CIException(String numero) {
		super("Conta Inexistente!");
		this.numero = numero;
	}
	
	public String numeroConta() {
		return numero;
	}

}
