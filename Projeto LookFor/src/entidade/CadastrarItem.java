package entidade;

public class CadastrarItem {
	
	String nome;
	double preco;
	String codItem;
	int id;
	String descricaoItem;
	
	public CadastrarItem()
	{}
	
	public CadastrarItem(String nome, double preco, String codItem, String 
			descricaoItem) 
	{
		
		this.nome = nome;
		this.preco = preco;
		this.codItem = codItem;
		this.descricaoItem = descricaoItem; 
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public double getPreco() {
		return preco;
	}

	public void setPreco(double preco) {
		this.preco = preco;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getDescricaoItem() {
		return descricaoItem;
	}

	public void setDescricaoItem(String descricaoItem) {
		this.descricaoItem = descricaoItem;
	}

	@Override
	public String toString() {
		return "CadastrarItem [nome=" + nome + ", preco=" + preco + ", codItem=" + codItem + ", descricaoItem="
				+ descricaoItem + "]";
	}

	
	
	

}
