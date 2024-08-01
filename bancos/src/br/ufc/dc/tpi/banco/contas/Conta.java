package br.ufc.dc.tpi.banco.contas;

public class Conta extends ContaAbstrata {
	protected String numero;
	protected double saldo;
	
	public Conta (String numero)   {
		super(numero);
	}
	
	public void debitar (double valor) {
		saldo = saldo - valor;
	}
}
