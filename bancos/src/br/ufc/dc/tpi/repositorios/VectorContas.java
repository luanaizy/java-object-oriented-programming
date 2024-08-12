package br.ufc.dc.tpi.repositorios;

import br.ufc.dc.tpi.banco.contas.ContaAbstrata;
import java.util.Vector;

public class VectorContas implements IRepositorioConta{

	private Vector<ContaAbstrata> contas;
	
	public VectorContas(){
		contas = new Vector<ContaAbstrata>();
	}
	
	public void inserir(ContaAbstrata conta) {
		contas.add(conta);
	}
	
	public void remover(String numero) {
		ContaAbstrata conta = procurar(numero);
		contas.remove(conta);
	}
	
	public int procurar_index(String numero) {
		for(int i=0; i<contas.size(); i++) {
			if(contas.get(i) != null && contas.get(i).get_numero()==numero) {
				return i;
			}
		}
		return -1;
	}
	
	public ContaAbstrata procurar(String numero) {
		int i = this.procurar_index(numero);
		if (i == -1) return null;
		else return contas.get(i);
	}
	
	
	
	public ContaAbstrata[] listar() {
		ContaAbstrata[] lista_contas = new ContaAbstrata[contas.size()];
		for(int i=0; i<lista_contas.length;i++) {
			lista_contas[i]=contas.get(i);
		}
		return lista_contas;
	}
	public int tamanho() {
		return contas.size();
	}
}
