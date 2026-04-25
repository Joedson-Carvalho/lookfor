package tools;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.util.List;
import java.util.ArrayList;

public class ConversorJson 
{
	private static final ObjectMapper mapper = new ObjectMapper();

    /**
     * Converte um JSON String para uma LISTA de objetos da classe informada.
     */
    public static <T> List<T> desserializarLista(String json, Class<T> classeAlvo) {
        try {
            // Cria um tipo de lista dinâmico para o Jackson entender
            return mapper.readValue(json, mapper.getTypeFactory().constructCollectionType(List.class, classeAlvo));
        } catch (Exception e) {
            System.err.println("Erro ao converter JSON: " + e.getMessage());
            return new ArrayList<>();
        }
    }	
}
