package br.ufc.dc.tpi.banco.contas;

public class ContaEspecial extends Conta {

	private double bonus; 
	
	public ContaEspecial(String numero) {
		super(numero);
		bonus = 0;
	}
	
	public void render_bonus() {
		saldo = saldo + bonus;
	}
	
	public void creditar(double valor) {
		super.creditar(valor);
		bonus = bonus + valor*(0.01);
	}
	
}
