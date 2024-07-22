package autarquia;

import java.util.List;
import java.util.ArrayList;

public class Main {

	public static void main(String[] args) {
		
		Multa m1 = new Multa("Avanco de sinal", 293.47, "gravissima",7,"avançar o sinal vermelho do semáforo "
				+ "ou o de parada obrigatória, exceto onde houver sinalização que permita a livre conversão à direita");
		Multa m2 = new Multa("Parada na faixa sem presenca de semaforo", 88.38, "leve", 2, "Parar em cima da faixa de "
				+ "pedestres sem a presença do semáforo");
		
		Pessoa pessoa1 = new Pessoa("Marcos Antonio", 123, 124, "A", "25/01/2000");
		Pessoa pessoa2 = new Pessoa("Gleiberson", 234, 384, "B", "09/34/2004");
		
		Veiculo carro1 = new Veiculo(pessoa1, "AHL9472");
		Veiculo carro2 = new Veiculo("PHY0972", "Chevre", "Ch", 2018, "2192312op", pessoa2);
		
		Local lugar1 = new Local("Rua das Mangueiras");
		Local lugar2 = new Local("Av. Sao Miguel");
		
		List<Multa> multas = new ArrayList<Multa>();
		multas.add(m1);
		multas.add(m2);
		
		Autuador autuador = new Autuador();
		autuador.autuar(multas, carro1, lugar1);
		autuador.autuar(multas, carro2, lugar2);
		
		System.out.println("Autuacoes para a pessoa " + pessoa2.get_nome() + ":\n");
		
		for(int i=0; i<autuador.get_autuacao(pessoa2).size();i++)
		autuador.get_autuacao(pessoa2).get(i).imprimir();
	}
}
