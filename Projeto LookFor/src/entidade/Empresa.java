package entidade;

public class Empresa {
		
		private int id;
	    private String nome;
	    private String email;
	    private String telefone;
	    private String cnpj;
		
		public Empresa() {}
		
		public Empresa(String nomeEmpresa, String email, String telefone, String cnpj) 
		{
			this.nome = nomeEmpresa;
			this.email = email;
			this.telefone = telefone;
			this.cnpj = cnpj;
		}

		public int getId() { return id; }
	    public void setId(int id) { this.id = id; }

	    public String getNome() { return nome; }
	    public void setNome(String nome) { this.nome = nome; }

	    public String getEmail() { return email; }
	    public void setEmail(String email) { this.email = email; }

	    public String getTelefone() { return telefone; }
	    public void setTelefone(String telefone) { this.telefone = telefone; }

	    public String getCnpj() { return cnpj; }
	    public void setCnpj(String cnpj) { this.cnpj = cnpj; }
}
