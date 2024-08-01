package br.ufc.dc.tpi.banco.contas;

public class ContaPoupanca extends Conta {

	public ContaPoupanca(String numero) {
		super(numero);
	}
	
	public void renderJuros(double taxa) {
		creditar(get_saldo() * taxa);
	}
}
