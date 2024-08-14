package br.ufc.dc.tpi;

import java.io.File;
import java.io.IOException;

import br.ufc.dc.tpi.auditores.AuditorBancoGenerico;
import br.ufc.dc.tpi.banco.BancoIndependente;
import br.ufc.dc.tpi.banco.contas.Conta;
import br.ufc.dc.tpi.banco.contas.ContaAbstrata;
import br.ufc.dc.tpi.banco.contas.ContaEspecial;
import br.ufc.dc.tpi.banco.contas.ContaPoupanca;
import br.ufc.dc.tpi.exceptions.CIException;
import br.ufc.dc.tpi.exceptions.CInException;
import br.ufc.dc.tpi.exceptions.SIException;
import br.ufc.dc.tpi.repositorios.*;

public class Auditoria {

	public static void main(String[] args) {

		//try {
			Conta conta1 = new Conta("00001");
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
			
			//VectorContas repositorio = new VectorContas();
			
			//BancoIndependente bb = new BancoIndependente(repositorio);
			//bb.cadastrar(conta1);
			//bb.cadastrar(conta2);
			//bb.cadastrar(conta3);
			//bb.cadastrar(conta4);
			//bb.cadastrar(conta5);
			//bb.cadastrar(contapoupanca1);
			//bb.cadastrar(contaespecial1);
			
			//bb.cadastrar(conta8);
			//bb.cadastrar(conta9);
			//bb.cadastrar(conta10);
			//bb.cadastrar(conta11);
			//bb.cadastrar(contapoupanca2);
			//bb.cadastrar(contaespecial2);
			
			//bb.creditar(conta1.get_numero(), 50);
			//bb.creditar(conta2.get_numero(), 100);
			//bb.creditar(conta3.get_numero(), 67);
			//bb.creditar(conta4.get_numero(), 345);
			//bb.creditar(conta5.get_numero(), 34);
			//bb.creditar(contapoupanca1.get_numero(), 97);
			//bb.creditar(contaespecial1.get_numero(), 270);
			
			//System.out.println("o saldo da conta 00002 é " + bb.saldo("00002"));
			
			//bb.transferir(conta1.get_numero(), conta2.get_numero(), 90.12);
			//bb.transferir(conta4.get_numero(), conta5.get_numero(), 100);
			//bb.transferir(contaespecial1.get_numero(), contapoupanca1.get_numero(), 10);
			//bb.transferir("12345", conta5.get_numero(), 100);
			
			//bb.renderJuros("00006");
			//bb.renderJuros("00005");
			//bb.render_bonus(contaespecial1.get_numero());
	
			//AuditorBancoGenerico auditor = new AuditorBancoGenerico();
			//auditor.auditar(bb);
			//auditor.auditar(bb);
			
			File diretorio = new File("C:\\Users\\luana.tavares\\Desktop");
			
			FileTextoContas rep_txt = new FileTextoContas(diretorio, "contas.txt");
			rep_txt.inserir(conta10);
			rep_txt.inserir(contaespecial1);
			rep_txt.ler_conta(conta10.get_numero());
			//rep_txt.ler_conta(contaespecial1.get_numero());
			
	//	} catch (CIException cie) {
	//		System.out.println(cie.getMessage());
		//	System.out.println("Conta: " + cie.numeroConta());
	//	} catch (SIException sie) {
		//	System.out.println(sie.getMessage());
		//	System.out.println("Conta/Saldo:");
		//	System.out.println(sie.numeroConta() + "/" + sie.saldoConta());
		//}catch (CInException cine) {
		//	System.out.println(cine.getMessage());
		//	System.out.println("Conta: " + cine.numeroConta());
		//} finally {
		//	System.out.println("Unknown error");
		//}
		
		
		
	}

}
