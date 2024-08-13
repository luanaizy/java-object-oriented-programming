package br.ufc.dc.tpi.repositorios;

import br.ufc.dc.tpi.banco.contas.ContaAbstrata;
import java.io.*;

public class FileTextoContas implements IRepositorioConta {
	
	private File path_arquivo;
	private VectorContas contas;
	private FileReader arquivo_leitura;
	private FileWriter arquivo_escrita;

	
	public FileTextoContas(File diretorio, String nome_novo_arquivo) {
		if (!diretorio.isDirectory()) {
			diretorio.mkdir();
		}
		path_arquivo = new File(diretorio, nome_novo_arquivo);
		contas = new VectorContas();
		try {
			arquivo_escrita = new FileWriter(path_arquivo);
			arquivo_leitura = new FileReader(path_arquivo);
		} catch (IOException ioe) {
			ioe.printStackTrace();
		}
	}
	public void inserir(ContaAbstrata conta) { //baseada em caracteres (FileWriter)
		contas.inserir(conta);
		PrintWriter writer = new PrintWriter(arquivo_escrita);
		for (int i=1; i<=contas.tamanho();i++) {
			writer.println(i + ". [NUM DA CONTA] "+ contas.listar()[i-1].get_numero());
			writer.println("[SALDO DA CONTA] " +  contas.listar()[i-1].get_saldo());
			writer.println();
		}
		writer.close();
	}

	public void remover(String numero) {
		contas.remover(numero);
		PrintWriter writer = new PrintWriter(arquivo_escrita);
		for (int i=1; i<=contas.tamanho();i++) {
			writer.println(i + ". [NUM DA CONTA] "+ contas.listar()[i-1].get_numero());
			writer.println("[SALDO DA CONTA] " +  contas.listar()[i-1].get_saldo());
			writer.println();
		}
		writer.close();
	}
	
	public void ler_conta(String numero) {
		String conteudo;
		int index = contas.procurar_index(numero);
		try {
			BufferedReader reader = new BufferedReader(arquivo_leitura);
			for (int i=0; i<index;i++) {
				conteudo = reader.readLine();
				conteudo = reader.readLine();
			}
			conteudo  = reader.readLine();
			System.out.println(conteudo);
			conteudo  = reader.readLine();
			System.out.println(conteudo);
			reader.close();
		} catch (IOException ioe) {
			ioe.printStackTrace();
		}
	}
	
	public ContaAbstrata procurar(String numero) {
		return contas.procurar(numero);
	}
	public ContaAbstrata[] listar() {
		return contas.listar();
	}
	
	public int tamanho() {
			long tamanho = path_arquivo.length();
			return (int)tamanho;
	}	
}
