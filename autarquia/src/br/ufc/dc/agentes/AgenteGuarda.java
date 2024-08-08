package br.ufc.dc.agentes;

public class AgenteGuarda implements Agente{

	private String nome;
	private int cpf;
	private String codigo;
	
	public AgenteGuarda(String codigo) {
		this.codigo = codigo;
	}
	public String getCodigo() {
		return codigo;
	}
}
