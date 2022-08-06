package sevendaysofcode.main;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.List;

import sevendaysofcode.html.HTMLGenerator;
import sevendaysofcode.model.Movie;
import sevendaysofcode.resources.ImdbAPIClient;
import sevendaysofcode.resources.ImdbMovieJsonParser;

public class APIAccess {

	public static void main(String[] args) {

		// Criação de variáveis para a key e para o json com consulta realizada pela classe de consulta a API
		String key = "<Key>";
		String json = ImdbAPIClient.apiRequest(key);

		
		// Criação da lista de filmes, que é parseada via classe própria
		List<Movie> movies = new ImdbMovieJsonParser(json).parse();

		try {
			// Crição do PrintWriter para gerar o HTML
			PrintWriter writer = new PrintWriter(new File("index.html"));
			HTMLGenerator generator = new HTMLGenerator(writer);
			boolean generated = generator.generate(movies);
			
			// Caso o HTML seja gerado retornamos uma mensagem de "OK"
			if (generated) {
				System.out.println("Arquivo HTML gerado com sucesso");
			}

			writer.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}

	}

}
