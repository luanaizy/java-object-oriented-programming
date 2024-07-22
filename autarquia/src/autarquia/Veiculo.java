package autarquia;

public class Veiculo {

	private String placa;
	private String modelo;
	private String marca;
	private int ano;
	private String chassi;
	private Pessoa proprietario;
	
	public String getPlaca() {
		return placa;
	}

	public void setPlaca(String placa) {
		this.placa = placa;
	}

	public Pessoa getProprietario() {
		return proprietario;
	}

	public void setProprietario(Pessoa proprietario) {
		this.proprietario = proprietario;
	}
	
	Veiculo(Pessoa proprietario, String placa){
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
}
