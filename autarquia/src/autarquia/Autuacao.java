package autarquia;
import java.util.List;
import java.util.Date;

public class Autuacao {
	
	private List<Multa> multas;
	private Veiculo veiculo;
	private Date data;
	private Local local;
	
	public Autuacao(List<Multa> multas, Veiculo veiculo, Local local) {
		super();
		this.multas = multas;
		this.veiculo = veiculo;
		this.data = new Date();
		this.local = local;
	}
	
	public void adicionar_multa(Multa multa) {
		multas.add(multa);
	}
	
	public Veiculo get_veiculo() {
		return veiculo;
	}
	
	public Local get_local() {
		return local;
	}
	
	public void imprimir() {
		System.out.println("Autuacao: \nMultas:");
		for(int i=0;i<multas.size();i++) {
			System.out.println(i +". " + multas.get(i).getNome());
		}
		System.out.println("Lugar: " + local.get_endereco() + "\nData: " + data + "\nVeiculo: " + veiculo.get_placa() +
				"\nProprietario: " + veiculo.get_proprietario().get_nome()+ "\n\n");
	}
}
