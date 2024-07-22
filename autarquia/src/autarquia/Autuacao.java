package autarquia;
import java.util.Vector;
import java.util.Date;

public class Autuacao {
	
	private Vector<Multa> multas;
	private Veiculo veiculo;
	private Date data;
	private Local local;
	
	public Autuacao(Vector<Multa> multas, Veiculo veiculo, Local local) {
		super();
		this.multas = multas;
		this.veiculo = veiculo;
		this.data = new Date();
		this.local = local;
		
		System.out.println("Nova autuacao: \nMultas:");
		for(int i=0;i<multas.size();i++) {
			System.out.println(i +". " + multas.get(i).getNome());
		}
		System.out.println("Lugar: " + local.getEndereco() + "\nData: " + data + "\nVeiculo: " + veiculo.getPlaca() + "\nProprietario: " + veiculo.getProprietario().getNome());
	}
}
