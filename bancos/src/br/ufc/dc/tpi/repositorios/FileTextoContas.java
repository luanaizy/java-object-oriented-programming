package br.ufc.dc.tpi.repositorios;

import br.ufc.dc.tpi.banco.contas.ContaAbstrata;
import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class FileTextoContas implements IRepositorioConta {
	
	private File path_arquivo;
	private VectorContas contas;
	private int index_linha;
	private FileWriter arquivo;

	
	public FileTextoContas(File diretorio) {
		if (!diretorio.isDirectory()) {
			diretorio.mkdir();
		}
		path_arquivo = new File(diretorio, "conta.txt");
		contas = new VectorContas();
		index_linha = 0;
		try {
			arquivo = new FileWriter(path_arquivo);
		} catch (IOException ioe) {
			ioe.printStackTrace();
		}
	}
	public void inserir(ContaAbstrata conta) { //baseada em caracteres (FileWriter)
		
		
		try {
			List<String> lines = new ArrayList<>();
			BufferedReader reader = new BufferedReader(new FileReader(path_arquivo));
			String line;
			while ((line = reader.readLine())!= null) {lines.add(line);}
			reader.close();
			
			if(lineNumber > 0 && lineNumber <= lines.size()) {
				lines.set(lineNumber - 1, lineContent)
			} else {
				System.out.println("Linha fora do intervalo");
				return;
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		contas.inserir(conta);
		PrintWriter gravador = new PrintWriter(arquivo);
		gravador.println("Conta: " + conta.get_numero());
		gravador.println("Saldo: " + conta.get_saldo());
		gravador.println();
		index_linha = index_linha + 3;
		gravador.close();
	}

	public void remover(String numero) {
		int indice_conta = contas.procurar_index(numero);
		PrintWriter gravador = new PrintWriter(arquivo);
		
		gravador.close();
	}
	
	public ler_conta(String numero) {
		
	}
	
	public ContaAbstrata procurar(String numero) {
		
	}
	public ContaAbstrata[] listar() {
		return contas.listar();
	}
	
	public int tamanho() {
			long tamanho = path_arquivo.length();
			return (int)tamanho;
	}	
}
