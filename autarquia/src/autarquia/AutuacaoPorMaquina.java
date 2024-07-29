package autarquia;

import java.util.List;

public class AutuacaoPorMaquina extends Autuacao{
	
	private String tipo_da_maquina;
	
	public AutuacaoPorMaquina(List<Multa> multas, Veiculo veiculo, 
			Local local, String tipo_da_maquina) {
		super(multas, veiculo, local);
		set_tipo_da_maquina(tipo_da_maquina);
	}
	
	public String get_tipo_da_maquina(){
		return tipo_da_maquina;
	}
	
	public void set_tipo_da_maquina(String tipo_da_maquina) {
		this.tipo_da_maquina = tipo_da_maquina;
	}
	
	public void imprimir() {
		System.out.println("Multas:");
		for(int i=0;i<multas.size();i++) {
			System.out.println(i +". " + multas.get(i).getNome());
		}
		System.out.println("Lugar: " + local.get_endereco() + "\nData: " + 
				data + "\nVeiculo: " + veiculo.get_placa() +
				"\nProprietario: " + veiculo.get_proprietario().get_nome()+ 
				"\nTipo de maquina: "+ tipo_da_maquina +"\n\n");
	}
}
