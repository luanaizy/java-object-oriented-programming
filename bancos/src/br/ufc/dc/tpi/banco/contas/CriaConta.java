package br.ufc.dc.tpi.banco.contas;

import br.ufc.dc.tpi.banco.BancoVector;

public class CriaConta {
	public static void main(String[] args) {
		Conta conta1;
		conta1 = new Conta("21.342-7");
		conta1.creditar(500.87);
		conta1.debitar(45.00);
		
		Conta conta2 = new Conta("00002");
		Conta conta3 = new Conta("00003");
		Conta conta4 = new Conta("00004");
		Conta conta5 = new Conta("00005");
		Conta contapoupanca1 = new ContaPoupanca("00006");
		
		BancoVector bb = new BancoVector();
		bb.cadastrar(conta1);
		bb.cadastrar(conta2);
		bb.cadastrar(conta3);
		bb.cadastrar(conta4);
		bb.cadastrar(conta5);
		bb.cadastrar(contapoupanca1);
		
		bb.creditar(conta1.numero(), 50);
		bb.creditar(conta2.numero(), 100);
		bb.creditar(conta3.numero(), 50);
		bb.creditar(conta4.numero(), 50);
		bb.creditar(conta5.numero(), 50);
		bb.creditar(contapoupanca1.numero(), 50);
		
		System.out.println("o saldo da conta 00002 é " + bb.saldo("00002"));
		
		bb.transferir(conta1.numero(), conta2.numero(), 90.12);
		bb.transferir(conta4.numero(), conta5.numero(), 100);
		bb.transferir("12345", conta5.numero(), 100);
		
		bb.renderJuros("00006");
		bb.renderJuros("00005");
	}

}
