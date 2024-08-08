package br.ufc.dc.autarquia.autuacoes;

import java.util.List;

import br.ufc.dc.agentes.AgenteMaquina;
import br.ufc.dc.autarquia.Local;
import br.ufc.dc.autarquia.Multa;
import br.ufc.dc.autarquia.Veiculo;

public class AutuacaoPorMaquina extends Autuacao{
	
	private AgenteMaquina agente;
	
	public AutuacaoPorMaquina(List<Multa> multas, Veiculo veiculo, 
			Local local, String codigo) {
		super(multas, veiculo, local);
		agente = new AgenteMaquina(codigo);
	}
	
	public String get_maquina(){
		return agente.getCodigo();
	}
	
	public void set_maquina(AgenteMaquina agente) {
		this.agente = agente;
	}
	
	public void imprimir() {
		System.out.println("Multas:");
		for(int i=0;i<multas.size();i++) {
			System.out.println(i +". " + multas.get(i).getNome());
		}
		System.out.println("Lugar: " + local.get_endereco() + "\nData: " + 
				data + "\nVeiculo: " + veiculo.get_placa() +
				"\nProprietario: " + veiculo.get_proprietario().get_nome()+ 
				"\nMaquina: "+ agente.getCodigo() + "\n\n");
	}
}
