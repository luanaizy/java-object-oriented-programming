package br.ufc.dc.autarquia;
import java.util.List;

import br.ufc.dc.agentes.Agente;
import br.ufc.dc.agentes.AgenteGuarda;
import br.ufc.dc.agentes.AgenteMaquina;
import br.ufc.dc.autarquia.autuacoes.Autuacao;
import br.ufc.dc.autarquia.autuacoes.AutuacaoPorAgente;
import br.ufc.dc.autarquia.autuacoes.AutuacaoPorMaquina;
import br.ufc.dc.autarquia.pessoas.Condutor;
import br.ufc.dc.autarquia.pessoas.Pessoa;

import java.util.ArrayList;

public class Autuador {
	public List<Autuacao> autuacoes;
	public Autuador() {
		autuacoes = new ArrayList<Autuacao>();
	}
	
	public void autuar(List<Multa> multas, Veiculo veiculo, Local local, Agente agente) {
		if (agente instanceof AgenteMaquina){
			Autuacao autuacao = new AutuacaoPorMaquina (multas, veiculo, local,agente.getCodigo());
			autuacoes.add(autuacao);
		} else if (agente instanceof AgenteGuarda) {
			Autuacao autuacao = new AutuacaoPorAgente (multas, veiculo, local,agente.getCodigo());
			autuacoes.add(autuacao);
		}
		
	}
	
	

	
	public List<Autuacao> get_autuacoes(Pessoa p) {
		List<Autuacao> autuacoes_encontradas = new ArrayList<Autuacao>();
		
		if(p instanceof Condutor) {
			for(int i=0; i<autuacoes.size();i++) {
				Autuacao autuacao_atual = autuacoes.get(i);
				if (autuacao_atual.get_veiculo().get_proprietario() == p) {
					autuacoes_encontradas.add(autuacao_atual);
				}
			}
		} else {
			for(int i=0; i<autuacoes.size();i++) {
				Autuacao autuacao_atual = autuacoes.get(i);
				if(autuacao_atual instanceof AutuacaoPorAgente) {
					if(((AutuacaoPorAgente)autuacao_atual).get_agente() == p) {
					autuacoes_encontradas.add(autuacao_atual);
					}
				}
			}
		}
		return autuacoes_encontradas;
	}
	
	public List<Autuacao> get_autuacoes(Local l) {
		List<Autuacao> autuacoes_encontradas = new ArrayList<Autuacao>();
		for(int i=0; i<autuacoes.size();i++) {
			Autuacao autuacao_atual = autuacoes.get(i);
			if (autuacao_atual.get_local() == l) {
				autuacoes_encontradas.add(autuacao_atual);
			}
		}
		return autuacoes_encontradas;
	}
	public List<Autuacao> get_autuacoes(Veiculo v) {
		List<Autuacao> autuacoes_encontradas = new ArrayList<Autuacao>();
		for(int i=0; i<autuacoes.size();i++) {
			Autuacao autuacao_atual = autuacoes.get(i);
			if (autuacao_atual.get_veiculo() == v) {
				autuacoes_encontradas.add(autuacao_atual);
			}
		}
		return autuacoes_encontradas;
	}
	public List<Autuacao> get_autuacoes(Multa m){
		List<Autuacao> autuacoes_encontradas = new ArrayList<Autuacao>();
		for(int i=0; i<autuacoes.size();i++) {
			Autuacao autuacao_atual = autuacoes.get(i);
			for(int j=0;j<autuacao_atual.get_multas().size();j++) {
				if (autuacao_atual.get_multas().get(j) == m) {
				autuacoes_encontradas.add(autuacao_atual);
				}
			}
		}
		return autuacoes_encontradas;
	}
	public void imprimir_relatorio_de_multas() {
		for (int i=0;i<autuacoes.size();i++) {
			autuacoes.get(i).imprimir();
		}
	}
}
