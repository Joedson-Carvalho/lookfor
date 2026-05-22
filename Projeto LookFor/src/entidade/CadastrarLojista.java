package entidade;

import tools.DataHelper;

import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

import tools.ConversorJson;


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
        
        DefinirId();
    }
    
    public void DefinirId()
    {
        Path path = Paths.get(DataHelper.pathProjeto + "data/lojista.json");
        var texto = DataHelper.lerTextoDoArquivo(path);

        var lojistas = ConversorJson.desserializarListaDaString(texto, CadastrarLojista.class);
        
        if (lojistas.isEmpty()) {
        	this.id = 0;
        } else {
        	 var ultimoLojista = lojistas.getLast();

             this.id = ++ultimoLojista.id; 
        }
       
    }
    
    public boolean verificaDuplicata(List<CadastrarLojista> duplicata) 
    {
    	if(duplicata == null || duplicata.isEmpty() || this.email == null || this.email.isEmpty()) 
    	{ 
    		return false;
    	}
    	boolean retorno = duplicata.stream()
    			.noneMatch(lojista -> lojista.email.equals(this.email));
    
    	return retorno;
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