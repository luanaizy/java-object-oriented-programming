package br.ufc.dc.tpi.banco.contas;

public abstract class ContaAbstrata {
	protected String numero;
	protected double saldo;
	
	public ContaAbstrata (String numero)   {
		this.numero = numero;
		saldo = 0;
	}
	public void creditar (double valor) {
		saldo = saldo + valor;
    }
	public abstract void debitar (double valor);
	
	public String get_numero()  {
		return numero;
	}
	public double get_saldo() {
		return saldo;
	}

}
