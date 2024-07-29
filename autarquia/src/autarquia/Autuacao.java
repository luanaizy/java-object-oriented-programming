package autarquia;
import java.util.List;
import java.util.Date;

public abstract class Autuacao {
	
	protected List<Multa> multas;
	protected Veiculo veiculo;
	protected Date data;
	protected Local local;
	
	public Autuacao(List<Multa> multas, Veiculo veiculo, Local local) {
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
		System.out.println("Multas:");
		for(int i=0;i<multas.size();i++) {
			System.out.println(i +". " + multas.get(i).getNome());
		}
		System.out.println("Lugar: " + local.get_endereco() + "\nData: " + data + "\nVeiculo: " + veiculo.get_placa() +
				"\nProprietario: " + veiculo.get_proprietario().get_nome()+ "\n\n");
	}
}
