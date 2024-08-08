package br.ufc.dc.agentes;

public class AgenteMaquina implements Agente{

	private String codigo;
	
	public AgenteMaquina(String codigo) {
		this.codigo = codigo;
	}
	public String getCodigo() {
		return codigo;
	}
}

