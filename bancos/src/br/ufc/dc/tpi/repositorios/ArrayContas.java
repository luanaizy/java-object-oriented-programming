package br.ufc.dc.tpi.repositorios;

import br.ufc.dc.tpi.banco.contas.ContaAbstrata;

public class ArrayContas implements IRepositorioConta {
	private ContaAbstrata[] contas;
	int indice;
	
	public ArrayContas(){
		ContaAbstrata[] contas = new ContaAbstrata[100];
		indice = 0;
	}
	
	public void inserir(ContaAbstrata conta) {
		contas[indice]=conta;
		indice++;
	}
	
	public void remover(String numero) {
		int local;
		for (int i=0; i<contas.length ;i++) {
			if (contas[i] != null && contas[i].get_numero() == numero){
				int local = 1;
				break;
			}
		}
		for(int i = local; i <contas.length; i++) {
			contas[i]=contas[i+1];
		}
		indice--;
		
	}
	public ContaAbstrata procurar(String numero) {
		
	}
	public ContaAbstrata[] listar() {
		
	}
	public int tamanho() {
		return contas.length;
	}
}
