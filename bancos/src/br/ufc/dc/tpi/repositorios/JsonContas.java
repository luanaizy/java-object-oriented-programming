package br.ufc.dc.tpi.repositorios;

import br.ufc.dc.tpi.banco.contas.ContaAbstrata;
import br.ufc.dc.tpi.exceptions.CIException;

import java.io.*;
import java.lang.reflect.Type;
import java.util.Map;
import java.util.Vector;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
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

	}
	
	
	public void inserir(ContaAbstrata conta) {
		contas.inserir(conta);
		try {
			arquivo_escrita = new FileWriter(path_arquivo);
			Gson gson = new GsonBuilder().setPrettyPrinting().create();
			gson.toJson(contas, arquivo_escrita);
			arquivo_escrita.close();
		} catch (IOException ioe) {
			ioe.printStackTrace();
		}
		
	}
	
	public void remover(String numero) throws CIException {
		contas.remover(numero);
		try {
			arquivo_escrita = new FileWriter(path_arquivo);
			Gson gson = new GsonBuilder().setPrettyPrinting().create();
			gson.toJson(contas, arquivo_escrita);
			arquivo_escrita.close();
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
	
	public void ler_conta(String numero) throws CIException {
	    boolean contaEncontrada = false;

	    try {
	        arquivo_leitura = new FileReader(path_arquivo);

	        Gson gson = new Gson();
	        JsonObject jsonObject = gson.fromJson(arquivo_leitura, JsonObject.class);
	        JsonArray jsonContas = jsonObject.getAsJsonArray("contas");

	        for (JsonElement element : jsonContas) {
	            JsonObject contaObj = element.getAsJsonObject();
	            String num = contaObj.get("numero").getAsString();
	            if (num.equals(numero)) {
	                double saldo = contaObj.get("saldo").getAsDouble();
	                System.out.println("Número da Conta: " + num);
	                System.out.println("Saldo da Conta: " + saldo);
	                contaEncontrada = true;
	                break;
	            }
	        }

	        arquivo_leitura.close();

	        if (!contaEncontrada) {
	            throw new CIException(numero);
	        }

	    } catch (IOException ioe) {
	        ioe.printStackTrace();
	    }
	}
}
