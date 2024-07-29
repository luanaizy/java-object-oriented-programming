package autarquia;

public abstract class Pessoa {
	protected String nome;
	protected int cpf;
	protected int cnh;
	protected String tipo_habilitacao;
	protected String data_nasc;
	
	public String get_nome() {
		return nome;
	}

	public void set_nome(String nome) {
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
