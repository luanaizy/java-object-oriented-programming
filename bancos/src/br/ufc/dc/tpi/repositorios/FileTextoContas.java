package br.ufc.dc.tpi.repositorios;

import br.ufc.dc.tpi.banco.contas.ContaAbstrata;
import br.ufc.dc.tpi.exceptions.CIException;

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

	}
	public void inserir(ContaAbstrata conta) { //baseada em caracteres (FileWriter)
		contas.inserir(conta);
		try {
			arquivo_escrita = new FileWriter(path_arquivo);
			PrintWriter writer = new PrintWriter(arquivo_escrita);
			for (int i=1; i<=contas.tamanho();i++) {
				writer.println(i + ". [NUM DA CONTA] "+ contas.listar()[i-1].get_numero());
				writer.println("[SALDO DA CONTA] " +  contas.listar()[i-1].get_saldo());
				writer.println();	
			}
			writer.close();
			arquivo_escrita.close();
		} catch (IOException ioe) {
			ioe.printStackTrace();
		}	
	}

	public void remover(String numero) throws CIException {
		contas.remover(numero);
		try {
			arquivo_escrita = new FileWriter(path_arquivo);
			PrintWriter writer = new PrintWriter(arquivo_escrita);
			for (int i=1; i<=contas.tamanho();i++) {
				writer.println(i + ". [NUM DA CONTA] "+ contas.listar()[i-1].get_numero());
				writer.println("[SALDO DA CONTA] " +  contas.listar()[i-1].get_saldo());
				writer.println();	
			}
			writer.close();
			arquivo_escrita.close();
		} catch (IOException ioe) {
			ioe.printStackTrace();
		}	
	}
	
	public void ler_conta(String numero) throws CIException {
		String conteudo;
		int index = contas.procurar_index(numero);
		if (index==-1){
			throw new CIException(numero);
		}
		try {
			arquivo_leitura = new FileReader(path_arquivo);
			BufferedReader reader = new BufferedReader(arquivo_leitura);
			for (int i=0; i<index;i++) {
				conteudo = reader.readLine();
				conteudo = reader.readLine();
				conteudo = reader.readLine();
			}
			conteudo  = reader.readLine();
			System.out.println(conteudo);
			conteudo  = reader.readLine();
			System.out.println(conteudo);
			System.out.println();
			reader.close();
			arquivo_leitura.close();
		} catch (IOException ioe) {
			ioe.printStackTrace();
		}
	}
	
	public ContaAbstrata procurar(String numero) throws CIException {
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
