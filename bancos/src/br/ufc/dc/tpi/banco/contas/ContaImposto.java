package br.ufc.dc.tpi.banco.contas;

public class ContaImposto extends ContaAbstrata{
	
	public ContaImposto(String numero) {
		super(numero);
	}
	
	public void debitar(double valor) {
		double imposto = valor*0.001;
		saldo = saldo + valor + imposto;
	}
}
