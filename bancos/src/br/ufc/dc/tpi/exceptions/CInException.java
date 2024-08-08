package br.ufc.dc.tpi.exceptions;


public class CInException extends Exception {
	private String numero; 
	
	public CInException(String numero) {
		super("Conta de tipo Inadequado!");
		this.numero = numero;
	}
	
	public String numeroConta() {
		return numero;
	}

}
