package br.ufc.dc.tpi.repositorios;

import br.ufc.dc.tpi.banco.contas.ContaAbstrata;

public class JsonContas implements IRepositorioConta {
	private VectorContas contas;
	
	public JsonContas() {
		contas = new VectorContas();
	}
	public void inserir(ContaAbstrata conta);
	public void remover(String numero);
	public ContaAbstrata procurar(String numero);
	public ContaAbstrata[] listar();
	public int tamanho();
	public void ler_conta(String numero);
}
