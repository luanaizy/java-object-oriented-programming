package br.ufc.dc.tpi.banco;

import br.ufc.dc.tpi.banco.contas.ContaAbstrata;
import br.ufc.dc.tpi.banco.contas.ContaEspecial;
import br.ufc.dc.tpi.banco.contas.ContaPoupanca;
import br.ufc.dc.tpi.exceptions.CIException;
import br.ufc.dc.tpi.exceptions.SIException;
import br.ufc.dc.tpi.repositorios.IRepositorioConta;

public class BancoIndependente implements IBanco {

	private IRepositorioConta contas;
	private double taxaJuros = 0.02;
	
	public BancoIndependente(IRepositorioConta contas) {
		this.contas = contas;
	}
	
	public double saldoTotal() {
		double saldoTotal=0;
		ContaAbstrata[] lista_contas = contas.listar();
		for(int i=0; i<contas.tamanho();i++) {
			if(lista_contas[i] != null)
			saldoTotal = saldoTotal + lista_contas[i].get_saldo();
		}
		return saldoTotal;
	}
	
	public int numeroContas() {
		return contas.tamanho();
	}
	
	public void cadastrar(ContaAbstrata conta) {
		contas.inserir(conta);
		System.out.println("Cadastrando conta " + conta.get_numero());
	}
	
	
	
	public ContaAbstrata procurar(String numero) {
		contas.procurar(numero);
		return null;
	}
	
	
	public void debitar(String numero, double valor) throws CIException, SIException {
		
		ContaAbstrata conta = procurar(numero);
		if(conta == null) {
			throw new CIException(numero);
		}
		
		if(conta.get_saldo() >= valor) {
				conta.debitar(valor);
				System.out.println("debitando " + valor + " da conta " + numero);
			}
			else throw new SIException(conta.get_saldo(), conta.get_numero());
		}
		
	
	
	
	public void creditar(String numero, double valor) throws CIException {
		ContaAbstrata conta = procurar(numero);
		if(conta == null) {
			throw new CIException(numero);
		}
		conta.creditar(valor);
		System.out.println("creditando " + valor + " na conta " + numero);
	}
	
	public double saldo(String numero) throws CIException {
		ContaAbstrata conta = procurar(numero);
		if(conta == null) {
			 throw new CIException(numero);
		}
		return conta.get_saldo();
	}
	
	public void transferir(String origem, String destino, double valor) throws CIException, SIException{
		ContaAbstrata contaOrigem = procurar(origem);
		ContaAbstrata contaDestino = procurar(destino);
		if(contaOrigem == null) {
			throw new CIException(origem);
		}
		if(contaDestino == null) {
			throw new CIException(destino);
		}
		
		if(contaOrigem.get_saldo() >= valor) {
			contaOrigem.creditar(valor);
			procurar(destino).creditar(valor);
			System.out.println("transferindo "+ valor + " da conta " + origem + " para a conta " + destino);
		}
		else throw new SIException(contaOrigem.get_saldo(),origem);
	}
	
	public void renderJuros(String numero) {
		ContaAbstrata conta = procurar(numero);
		if (conta instanceof ContaPoupanca && conta != null) {
			((ContaPoupanca) conta).renderJuros(taxaJuros);
			System.out.println("Rendendo juros - saldo atual de "+ conta.get_numero() + ": " + conta.get_saldo());
		} else {
			System.out.println("A conta "+ numero + " não é poupança ou não existe");
		}
	}
	public void render_bonus(String numero) {
		ContaAbstrata conta = procurar(numero);
		if (conta instanceof ContaEspecial && conta != null) {
			((ContaEspecial) conta).render_bonus();
			System.out.println("Rendendo bonus - saldo atual de "+ conta.get_numero() + ": " + conta.get_saldo());
		} else {
			System.out.println("A conta "+ conta.get_numero() + " não é especial ou não existe");
		}
	}
}