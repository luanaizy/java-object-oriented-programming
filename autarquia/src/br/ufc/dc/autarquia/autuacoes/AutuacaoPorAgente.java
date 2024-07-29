package br.ufc.dc.autarquia.autuacoes;

import java.util.List;

import br.ufc.dc.autarquia.Local;
import br.ufc.dc.autarquia.Multa;
import br.ufc.dc.autarquia.Veiculo;
import br.ufc.dc.autarquia.pessoas.Agente;

public class AutuacaoPorAgente extends Autuacao {
	
	private Agente agente;
	
	public AutuacaoPorAgente(List<Multa> multas, Veiculo veiculo, Local local, Agente agente) {
		super(multas, veiculo, local);
		this.agente = agente;
	}
	
	public Agente get_agente(){
		return agente;
	}
	
	public void set_agente(Agente agente) {
		this.agente = agente;
	}
	
	public void imprimir() {
		System.out.println("Multas:");
		for(int i=0;i<multas.size();i++) {
			System.out.println(i +". " + multas.get(i).getNome());
		}
		System.out.println("Lugar: " + local.get_endereco() + "\nData: " + data + "\nVeiculo: " + veiculo.get_placa() +
				"\nProprietario: " + veiculo.get_proprietario().get_nome()+ "\nAgente: "+ agente.get_nome() +"\n\n");
	}
}
