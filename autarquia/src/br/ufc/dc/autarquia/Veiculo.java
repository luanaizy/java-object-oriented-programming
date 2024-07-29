package br.ufc.dc.autarquia;

import br.ufc.dc.autarquia.pessoas.Pessoa;

public class Veiculo {

	private String placa;
	private String modelo;
	private String marca;
	private int ano;
	private String chassi;
	private Pessoa proprietario;
	
	public Veiculo(Pessoa proprietario, String placa){
		this.proprietario = proprietario;
		this.placa = placa;
	}
	
	public Veiculo(String placa, String modelo, String marca, 
			int ano, String chassi, Pessoa proprietario) {
		this.placa = placa;
		this.modelo = modelo;
		this.marca = marca;
		this.ano = ano;
		this.chassi = chassi;
		this.proprietario = proprietario;
	}
	
	public String get_modelo() {
		return modelo;
	}

	public void set_modelo(String modelo) {
		this.modelo = modelo;
	}

	public String get_marca() {
		return marca;
	}

	public void set_marca(String marca) {
		this.marca = marca;
	}

	public int get_ano() {
		return ano;
	}

	public void set_ano(int ano) {
		this.ano = ano;
	}

	public String get_chassi() {
		return chassi;
	}

	public void set_chassi(String chassi) {
		this.chassi = chassi;
	}
	
	public String get_placa() {
		return placa;
	}

	public void set_placa(String placa) {
		this.placa = placa;
	}

	public Pessoa get_proprietario() {
		return proprietario;
	}

	public void set_proprietario(Pessoa proprietario) {
		this.proprietario = proprietario;
	}
	
}
