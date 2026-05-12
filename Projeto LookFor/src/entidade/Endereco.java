package entidade;

public class Endereco {
	
	private int id;
	private String rua;
	private String numero;
	private int cep;
	private int empresaId;
	private int distancia;
	//double longitude;
	//double latitude;
	
	public Endereco (String rua, String numero, int cep, int distancia, int empresaId){
		this.rua = rua;
		this.numero = numero;
		this.cep = cep;
		this.empresaId = empresaId;
		this.distancia = distancia;
	}
	
	public Endereco() {}

	public int getId() {
		return id;
	}
	
	public String getRua() {
		return rua;
	}

	public void setRua(String rua) {
		this.rua = rua;
	}

	public String getNumero() {
		return numero;
	}

	public void setNumero(String numero) {
		this.numero = numero;
	}

	public int getCep() {
		return cep;
	}

	public void setCep(int cep) {
		this.cep = cep;
	}

	public int getEmpresaId() {
		return empresaId;
	}

	public int getDistancia() {
		return distancia;
	}

		public void setDistancia(int distancia) {
			this.distancia = distancia;
		}
	
}
