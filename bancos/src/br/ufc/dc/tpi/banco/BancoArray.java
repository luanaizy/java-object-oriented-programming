package br.ufc.dc.tpi.banco;

import br.ufc.dc.tpi.banco.contas.ContaAbstrata;

import br.ufc.dc.tpi.banco.contas.Conta;
import br.ufc.dc.tpi.banco.contas.ContaEspecial;
import br.ufc.dc.tpi.banco.contas.ContaPoupanca;


public class BancoArray{
	private Conta[] contas;
	private int indice = 0;
	private double taxaJuros = 0.02;
	
	public BancoArray() {
		contas = new Conta[100];
	}
	
	public void cadastrar(Conta conta) {
		contas[indice] = conta;
		indice++;
		System.out.println("Cadastrando conta " + conta.get_numero());
	}
	
	
	
	private Conta procurar(String numero) {
		for (int i=0; i<contas.length ;i++) {
			if (contas[i] != null && contas[i].get_numero() == numero){
				return contas[i];
			}
		}
		return null;
	}
	
	
	public void debitar(String numero, double valor) {
		
		Conta conta = procurar(numero);
		if(conta == null) {
			System.out.println("a conta " + numero + " não existe");
			return;
		}
		
		if(conta.get_saldo() >= valor) {
				procurar(numero).debitar(valor);
				System.out.println("debitando " + valor + " da conta " + numero);
			}
			else System.out.println("a conta " + numero + " tem saldo insuficiente para o debito");
		}
		
	
	
	
	public void creditar(String numero, double valor) {
		Conta conta = procurar(numero);
		if(conta == null) {
			System.out.println("a conta " + numero + " não existe");
			return;
		}
		conta.creditar(valor);
		System.out.println("creditando " + valor + " na conta " + numero);
	}
	
	public double saldo(String numero) {
		Conta conta = procurar(numero);
		if(conta == null) {
			System.out.println("a conta " + numero + " não existe");
			return -1;
		}
		return conta.get_saldo();
	}
	
	public void transferir(String origem, String destino, double valor) {
		Conta contaOrigem = procurar(origem);
		Conta contaDestino = procurar(destino);
		if(contaOrigem == null) {
			System.out.println("a conta " + origem + " não existe");
			return;
		}
		if(contaDestino == null) {
			System.out.println("a conta " + destino + " não existe");
			return;
		}
		
		if(contaOrigem.get_saldo() >= valor) {
			contaOrigem.creditar(valor);
			procurar(destino).creditar(valor);
			System.out.println("transferindo "+ valor + " da conta " + origem + " para a conta " + destino);
		}
		else System.out.println("A conta " + origem + " não tem saldo suficiente para transferência");
	}
	
	public void renderJuros(String numero) {
		Conta conta = procurar(numero);
		if (conta instanceof ContaPoupanca && conta != null) {
			((ContaPoupanca) conta).renderJuros(taxaJuros);
			System.out.println("Rendendo juros - saldo atual de "+ conta.get_numero() + ": " + conta.get_saldo());
		} else {
			System.out.println("A conta "+ conta.get_numero() + " não é poupança ou não existe");
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