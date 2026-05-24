package entidade;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import enums.TipoItemsEnum;

@JsonIgnoreProperties(ignoreUnknown = true)
public class CadastrarItem {
	
	protected String nome;
	protected double preco;
	protected String codItem;
	protected int id;
	protected String descricaoItem;
	protected int empresaId;
	protected TipoItemsEnum tipo;

	public CadastrarItem(){}
	
	public CadastrarItem(String nome, double preco, String codItem, String 
			descricaoItem, int empresaId) 
	{
		this.nome = nome;
		this.preco = preco;
		this.codItem = codItem;
		this.descricaoItem = descricaoItem; 
		this.empresaId = empresaId;
	}
	
	public String showInfo() 
	{
		return "ID: " + id + "\n" +
		           "Nome: " + nome + "\n" +
		           "Código: " + codItem + "\n" +
		           "Preço: R$ " + String.format("%.2f", preco) + "\n" +
		           "Descrição: " + descricaoItem;
	}
	
	public TipoItemsEnum getTipo() {
		return tipo;
	}

	public void setTipo(TipoItemsEnum t) {
		this.tipo = t;
	}
	
	public String getCodItem() {
		return codItem;
	}

	public void setCodItem(String codItem) {
		this.codItem = codItem;
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
	
	public int getEmpresaId() {
		return empresaId;
	}

	public void setEmpresaId(int empresaId) {
		this.empresaId = empresaId;
	}

	@Override
	public String toString() {
		return "CadastrarItem [nome=" + nome + ", preco=" + preco + ", codItem=" + codItem + ", descricaoItem="
				+ descricaoItem + "]";
	}

	
	
	

}
