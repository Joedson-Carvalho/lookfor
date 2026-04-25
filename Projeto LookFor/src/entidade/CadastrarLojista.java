package entidade;

public class CadastrarLojista {
    
	private String nomeLojista;
    private int id;
    private String senha;
    private String email;

    public CadastrarLojista(String nome, int id, String senha, String email) {
        this.nomeLojista = nome;
        this.id = id;
        this.senha = senha;
        this.email = email;
    }
    
}