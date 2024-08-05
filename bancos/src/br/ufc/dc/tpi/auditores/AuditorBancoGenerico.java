package br.ufc.dc.tpi.auditores;

import br.ufc.dc.tpi.banco.IBanco;

public class AuditorBancoGenerico {
	public void auditar(IBanco banco) {
		if ((banco.saldoTotal() / banco.numeroContas()) > 500) {
			System.out.println("Banco Aprovado!");
		} else {
			System.out.println("Banco não aprovado.");
		}
	}
}
