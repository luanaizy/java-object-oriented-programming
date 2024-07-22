package autarquia;
import java.util.List;
import java.util.ArrayList;

public class Autuador {
	public List<Autuacao> autuacoes;
	public Autuador() {
		autuacoes = new ArrayList<Autuacao>();
	}
	public void autuar(List<Multa> multas, Veiculo veiculo, Local local) {
		Autuacao autuacao = new Autuacao (multas, veiculo, local);
		autuacoes.add(autuacao);
	}
	public List<Autuacao> get_autuacao(Pessoa p) {
		List<Autuacao> autuacoes_encontradas = new ArrayList<Autuacao>();
		for(int i=0; i<autuacoes.size();i++) {
			Autuacao autuacao_atual = autuacoes.get(i);
			if (autuacao_atual.get_veiculo().get_proprietario() == p) {
				autuacoes_encontradas.add(autuacao_atual);
			}
		}
		return autuacoes_encontradas;
	}
	
	public List<Autuacao> get_autuacao(Local l) {
		List<Autuacao> autuacoes_encontradas = new ArrayList<Autuacao>();
		for(int i=0; i<autuacoes.size();i++) {
			Autuacao autuacao_atual = autuacoes.get(i);
			if (autuacao_atual.get_local() == l) {
				autuacoes_encontradas.add(autuacao_atual);
			}
		}
		return autuacoes_encontradas;
	}
	public List<Autuacao> get_autuacao(Veiculo v) {
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
