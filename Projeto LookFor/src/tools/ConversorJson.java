package tools;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.core.JsonProcessingException;
import java.util.List;
import java.util.ArrayList;

public class ConversorJson {

    private static final ObjectMapper mapper = new ObjectMapper();


    public static String serializarParaString(Object objeto) {
        try {

            return mapper.writerWithDefaultPrettyPrinter().writeValueAsString(objeto);
        } catch (JsonProcessingException e) {
            System.err.println("Erro ao converter objeto para String JSON: " + e.getMessage());
            return "{}";
        }
    }


    public static <T> T desserializarDaString(String json, Class<T> classeAlvo) {
        try {
            return mapper.readValue(json, classeAlvo);
        } catch (JsonProcessingException e) {
            System.err.println("Erro ao ler Objeto da String JSON: " + e.getMessage());
            return null;
        }
    }
    
    public static <T> List<T> desserializarListaDaString(String json, Class<T> classeAlvo) {
        try {

            return mapper.readValue(json, 
                mapper.getTypeFactory().constructCollectionType(List.class, classeAlvo));
        } catch (JsonProcessingException e) {
            System.err.println("Erro ao ler Lista da String JSON: " + e.getMessage());
            return new ArrayList<>();
        }
    }
}