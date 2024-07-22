package autarquia;

public class Multa {
	private double valor;
	private String gravidade;
	private String nome;
	private int pontos;
	private String descricao;
	
	public Multa(String nome, double valor, String gravidade, int pontos, String descricao) {
		this.nome = nome;
		this.valor = valor;
		setGravidade(gravidade);
		this.pontos = pontos;
		this.descricao = descricao;
	}
	
	public double getValor() {
		return valor;
	}
	public void setValor(double novoValor) {
		valor = novoValor;
	}
	public void setGravidade(String novaGravidade) {
		gravidade = novaGravidade;
	}
	public String getGravidade() {
		return gravidade;
	}
	public String getNome() {
		return nome;
	}
	public int getPontos() {
		return pontos;
	}
	public String getDescricao() {
		return descricao;
	}
}
