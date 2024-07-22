package autarquia;

public class Pessoa {
	private String nome;
	private int cpf;
	private int cnh;
	private String tipo_habilitacao;
	private String data_nasc;
	
	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public Pessoa(String nome, int cpf, int cnh, String tipo_habilitacao, String data_nasc){
		this.nome = nome;
		this.cpf = cpf;
		this.cnh = cnh;
		this.tipo_habilitacao = tipo_habilitacao;
		this.data_nasc = data_nasc;
	}
}
