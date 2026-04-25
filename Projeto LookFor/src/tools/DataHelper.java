package tools;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.io.IOException;

public class DataHelper 
{
	public static String lerTextoDoArquivo(Path path) {
        try 
        {
            return Files.readString(path);
        } catch (IOException e) 
        {
            System.err.println("Erro ao ler o arquivo: " + e.getMessage());
            return "";
        }
    }
}
