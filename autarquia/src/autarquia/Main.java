package autarquia;

import java.util.Vector;

public class Main {

	public static void main(String[] args) {
		
		Multa m1 = new Multa("Avanco de sinal", 293.47, "gravissima",7,"avançar o sinal vermelho do semáforo "
				+ "ou o de parada obrigatória, exceto onde houver sinalização que permita a livre conversão à direita");
		Multa m2 = new Multa("Parada na faixa sem presenca de semaforo", 88.38, "leve", 2, "Parar em cima da faixa de "
				+ "pedestres sem a presença do semáforo");
		
		Pessoa pessoa1 = new Pessoa("Marcos Antonio", 123, 124, "A", "25/01/2000");
		Veiculo carro1 = new Veiculo(pessoa1, "AHL9472");
		
		Local lugar1 = new Local("Rua das Mangueiras");
		Vector<Multa> multas = new Vector<Multa>();
		multas.add(m1);
		multas.add(m2);
		Autuacao aut1 = new Autuacao(multas, carro1, lugar1);	
		
	}
}
