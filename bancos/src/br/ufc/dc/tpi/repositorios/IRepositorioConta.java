package br.ufc.dc.tpi.repositorios;

import br.ufc.dc.tpi.banco.contas.ContaAbstrata;
import br.ufc.dc.tpi.exceptions.CIException;

public interface IRepositorioConta {
	public void inserir(ContaAbstrata conta);
	public void remover(String numero) throws CIException;
	public ContaAbstrata procurar(String numero) throws CIException;
	public ContaAbstrata[] listar();
	public int tamanho();
}
