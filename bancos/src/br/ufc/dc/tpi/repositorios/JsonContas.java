package br.ufc.dc.tpi.repositorios;

import br.ufc.dc.tpi.banco.contas.ContaAbstrata;
import java.io.*;
import java.lang.reflect.Type;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;

public class JsonContas implements IRepositorioConta {
	private VectorContas contas;
	private File path_arquivo;
	private FileReader arquivo_leitura;
	private FileWriter arquivo_escrita;
	
	public JsonContas(File diretorio, String nome_novo_arquivo) {
		if (!diretorio.isDirectory()) {
			diretorio.mkdir();
		}
		contas = new VectorContas();
		path_arquivo = new File(diretorio, nome_novo_arquivo);
		try {
			arquivo_leitura = new FileReader(path_arquivo);
			arquivo_escrita = new FileWriter(path_arquivo);
		} catch (IOException ioe) {
			ioe.printStackTrace();
		}
	}
	
	
	public void inserir(ContaAbstrata conta) {
		contas.inserir(conta);
		Gson gson = new GsonBuilder().setPrettyPrinting().create();
		gson.toJson(contas, arquivo_escrita);
	}
	
	public void remover(String numero) {
		contas.remover(numero);
		Gson gson = new GsonBuilder().setPrettyPrinting().create();
		gson.toJson(contas, arquivo_escrita);
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
	
	public void ler_conta(String numero) {
		Gson gson = new Gson();		
		Type ContaArrayType = new TypeToken<ContaAbstrata[]>() {}.getType();
		ContaAbstrata[] buffer_contas = gson.fromJson(arquivo_leitura, ContaArrayType);
		int indice = contas.procurar_index(numero);
		if (buffer_contas != null && buffer_contas.length > indice) {
            ContaAbstrata conta = buffer_contas[indice];
            System.out.println(conta);
        }
	}
}