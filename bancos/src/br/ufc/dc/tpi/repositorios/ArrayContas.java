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
		for(int i=0; i<contas.length; i++) {
			if(contas[i] != null && contas[i].get_numero()==numero) {
				return contas[i];
			}
		}
		return null;
	}
	public ContaAbstrata[] listar() {
		return contas;
	}
	public int tamanho() {
		return contas.length;
	}
}
