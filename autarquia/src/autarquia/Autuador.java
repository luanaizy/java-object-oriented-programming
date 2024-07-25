package autarquia;
import java.util.List;
import java.util.ArrayList;

public class Autuador {
	public List<Autuacao> autuacoes;
	public Autuador() {
		autuacoes = new ArrayList<Autuacao>();
	}
	
	public void autuar(List<Multa> multas, Veiculo veiculo, Local local, String tipo_da_maquina) {
		Autuacao autuacao = new AutuacaoPorMaquina (multas, veiculo, local,tipo_da_maquina);
		autuacoes.add(autuacao);
	}
	
	public void autuar(List<Multa> multas, Veiculo veiculo, Local local, Agente agente) {
		Autuacao autuacao = new AutuacaoPorAgente (multas, veiculo, local,agente);
		autuacoes.add(autuacao);
	}
	

	
	public List<Autuacao> get_autuacoes(Pessoa p) {
		List<Autuacao> autuacoes_encontradas = new ArrayList<Autuacao>();
		for(int i=0; i<autuacoes.size();i++) {
			Autuacao autuacao_atual = autuacoes.get(i);
			if (autuacao_atual.get_veiculo().get_proprietario() == p) {
				autuacoes_encontradas.add(autuacao_atual);
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
}
