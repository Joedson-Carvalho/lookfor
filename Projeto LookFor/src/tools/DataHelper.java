package tools;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.io.IOException;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.util.List;
import java.util.ArrayList;

public class DataHelper 
{	
	public static String pathProjeto = "Projeto LookFor/src/";
	
	public static String lerTextoDoArquivo(Path path) {
	    try {
	        if (Files.exists(path)) {
	            String conteudo = Files.readString(path);
	            return conteudo.isBlank() ? "[]" : conteudo;
	        } else {
	            System.err.println("Arquivo não encontrado: " + path.toAbsolutePath());
	            return "[]"; 
	        }
	    } catch (IOException e) {
	        System.err.println("Erro ao ler o arquivo: " + e.getMessage());
	        return "[]";
	    }
	}
	
	public static <T> void salvarArquivo(Path path, List<T> lista) {
	    try {
	        ObjectMapper mapper = new ObjectMapper();
	        String json = mapper.writerWithDefaultPrettyPrinter().writeValueAsString(lista);
	        
	        Files.writeString(path, json);
	        System.out.println("Arquivo salvo com sucesso!");
	    } catch (IOException e) {
	        System.err.println("Erro ao salvar o arquivo: " + e.getMessage());
	    }
	}
	
	public static <T> void adicionarItemAoJsonESalvar(Path path, T novoItem, Class<T> classeAlvo) {
	    String conteudoAtual = lerTextoDoArquivo(path);
	    
	    List<T> listaExistente;
	    if (conteudoAtual == null || conteudoAtual.isBlank()) {
	        listaExistente = new ArrayList<>();
	    } else {
	        listaExistente = ConversorJson.desserializarListaDaString(conteudoAtual, classeAlvo);
	    }

	    listaExistente.add(novoItem);

	    salvarArquivo(path, listaExistente);
	}
}
