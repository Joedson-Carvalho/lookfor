package entidade;

public class CadastrarLojista {
    
	private String nomeLojista;
    private int id;
    private String senha;
    private String email;
	private int empresaId;
	
    public CadastrarLojista() {}
    
    public CadastrarLojista(String nome, String email, String senha) {
        this.nomeLojista = nome;
        this.senha = senha;
        this.email = email;
    }
    
    public String getNomeLojista() {
		return nomeLojista;
	}

	public void setNomeLojista(String nomeLojista) {
		this.nomeLojista = nomeLojista;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public int getEmpresaId() {
		return empresaId;
	}

	public void setEmpresaId(int empresaId) {
		this.empresaId = empresaId;
	}
    
}