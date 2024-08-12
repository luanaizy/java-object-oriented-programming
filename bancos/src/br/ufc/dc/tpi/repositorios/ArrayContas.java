package br.ufc.dc.tpi.repositorios;

import br.ufc.dc.tpi.banco.contas.ContaAbstrata;

public class ArrayContas implements IRepositorioConta {
	private ContaAbstrata[] contas;
	int indice;
	
	public ArrayContas(){
		contas = new ContaAbstrata[100];
		indice = 0;
	}
	
	public void inserir(ContaAbstrata conta) {
		contas[indice]=conta;
		indice++;
	}
	
	public void remover(String numero) {
		int local = -1;
		for (int i=0; i<contas.length ;i++) {
			if (contas[i] != null && contas[i].get_numero() == numero){
				local = i;
				break;
			}
		}
		if (local == -1) return;
		for(int i = local; i <contas.length; i++) {
			contas[i]=contas[i+1];
		}
		indice--;
	}
	public ContaAbstrata procurar(String numero) {
		int i = this.procurar_index(numero);
		if (i == -1) return null;
		else return contas[i];
	}
	
	public int procurar_index(String numero) {
		for(int i=0; i<contas.length; i++) {
			if(contas[i] != null && contas[i].get_numero()==numero) {
				return i;
			}
		}
		return -1;
	}
	public ContaAbstrata[] listar() {
		return contas;
	}
	public int tamanho() {
		return contas.length;
	}
}
