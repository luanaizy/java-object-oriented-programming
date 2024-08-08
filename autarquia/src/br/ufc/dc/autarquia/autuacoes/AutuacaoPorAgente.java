package br.ufc.dc.autarquia.autuacoes;

import java.util.List;

import br.ufc.dc.agentes.Agente;
import br.ufc.dc.agentes.AgenteGuarda;
import br.ufc.dc.autarquia.Local;
import br.ufc.dc.autarquia.Multa;
import br.ufc.dc.autarquia.Veiculo;

public class AutuacaoPorAgente extends Autuacao {
	
	private AgenteGuarda agente;
	
	public AutuacaoPorAgente(List<Multa> multas, Veiculo veiculo, Local local, String codigo) {
		super(multas, veiculo, local);
		agente = new AgenteGuarda(codigo);
	}
	
	public Agente get_agente(){
		return agente;
	}
	
	public void imprimir() {
		System.out.println("Multas:");
		for(int i=0;i<multas.size();i++) {
			System.out.println(i +". " + multas.get(i).getNome());
		}
		System.out.println("Lugar: " + local.get_endereco() + "\nData: " + data + "\nVeiculo: " + veiculo.get_placa() +
				"\nProprietario: " + veiculo.get_proprietario().get_nome()+ "\nAgente: "+ agente.getCodigo() +"\n\n");
	}
}
