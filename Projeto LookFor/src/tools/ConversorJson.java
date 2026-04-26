package tools;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.core.JsonProcessingException;

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
}