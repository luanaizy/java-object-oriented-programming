package br.ufc.dc.tpi;

import br.ufc.dc.tpi.banco.BancoVector;
import br.ufc.dc.tpi.auditores.AuditorBancoGenerico;
import br.ufc.dc.tpi.banco.BancoArray;
import br.ufc.dc.tpi.banco.BancoIndependente;
import br.ufc.dc.tpi.banco.contas.Conta;
import br.ufc.dc.tpi.banco.contas.ContaAbstrata;
import br.ufc.dc.tpi.banco.contas.ContaEspecial;
import br.ufc.dc.tpi.banco.contas.ContaPoupanca;

public class Auditoria {

	public static void main(String[] args) {

		Conta conta1;
		conta1 = new Conta("00001");
		conta1.creditar(500.87);
		conta1.debitar(45.00);
		
		ContaAbstrata conta2 = new Conta("00002");
		ContaAbstrata conta3 = new Conta("00003");
		ContaAbstrata conta4 = new Conta("00004");
		ContaAbstrata conta5 = new Conta("00005");
		ContaAbstrata contapoupanca1 = new ContaPoupanca("00006");
		ContaAbstrata contaespecial1 = new ContaEspecial("00007");
		
		ContaAbstrata conta8 = new Conta("00008");
		ContaAbstrata conta9 = new Conta("00009");
		ContaAbstrata conta10 = new Conta("00010");
		ContaAbstrata conta11= new Conta("00011");
		ContaAbstrata contapoupanca2 = new ContaPoupanca("00012");
		ContaAbstrata contaespecial2 = new ContaEspecial("00013");
		
		
		
		BancoIndependente bb = new BancoIndependente();
		bb.cadastrar(conta1);
		bb.cadastrar(conta2);
		bb.cadastrar(conta3);
		bb.cadastrar(conta4);
		bb.cadastrar(conta5);
		bb.cadastrar(contapoupanca1);
		bb.cadastrar(contaespecial1);
		
		bb.cadastrar(conta8);
		bb.cadastrar(conta9);
		bb.cadastrar(conta10);
		bb.cadastrar(conta11);
		bb.cadastrar(contapoupanca2);
		bb.cadastrar(contaespecial2);
		
		bb.creditar(conta1.get_numero(), 50);
		bb.creditar(conta2.get_numero(), 100);
		bb.creditar(conta3.get_numero(), 67);
		bb.creditar(conta4.get_numero(), 345);
		bb.creditar(conta5.get_numero(), 34);
		bb.creditar(contapoupanca1.get_numero(), 97);
		bb.creditar(contaespecial1.get_numero(), 270);
		
		System.out.println("o saldo da conta 00002 é " + bb.saldo("00002"));
		
		bb.transferir(conta1.get_numero(), conta2.get_numero(), 90.12);
		bb.transferir(conta4.get_numero(), conta5.get_numero(), 100);
		bb.transferir(contaespecial1.get_numero(), contapoupanca1.get_numero(), 10);
		bb.transferir("12345", conta5.get_numero(), 100);
		
		bb.renderJuros("00006");
		bb.renderJuros("00005");
		bb.render_bonus(contaespecial1.get_numero());

		AuditorBancoGenerico auditor = new AuditorBancoGenerico();
		auditor.auditar(bb);
		auditor.auditar(bb);
	}

}
