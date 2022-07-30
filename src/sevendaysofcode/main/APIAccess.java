package sevendaysofcode.main;

import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse.BodyHandlers;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import sevendaysofcode.model.Movie;

public class APIAccess {

	public static void main(String[] args) {

		// Código refatorado para fazer com que a requisição Http fosse feita dentro de
		// um só método
		String json = apiRequest();

		// Criação da lista de filmes
		List<Movie> movies = new ArrayList<>();

		// Extraindo os filmes em uma lista de filmes que contem os atributos em forma
		// de lista
		List<List<String>> moviesAndAttributes = jsonParser(json);

		// Utilização de um for para adicionar os dados a uma lista
		for (List<String> attributes : moviesAndAttributes) {
			// Tittle, Url, Rating Year

			String title = attributesParser(attributes.get(2));
			String urlImage = attributesParser(attributes.get(5));
			Double rating = Double.parseDouble(attributesParser(attributes.get(7)));
			Integer year = Integer.parseInt(attributesParser(attributes.get(4)));

			movies.add(new Movie(title, urlImage, rating, year));
		}

		// Exibindo os itens da lista
		movies.forEach(System.out::println);

	}

	private static String apiRequest() {
		try {
			// Criação de variáveis para a key e para a url
			String key = "<Key>";
			String url = "https://imdb-api.com/en/API/Top250Movies/" + key;

			// Criação do HTTPClient que irá enviar a requisição, assim como da URI
			// necessária para o request e do próprio request
			HttpClient httpClient = HttpClient.newHttpClient();

			URI uri = new URI(url);
			HttpRequest request = HttpRequest.newBuilder(uri).GET().build();

			// Envio da requisição por parte do client e recebimento da resposta (refatorado
			// de body para json)
			String json = httpClient.send(request, BodyHandlers.ofString()).body();
			return json;
		} catch (URISyntaxException | InterruptedException | IOException e) {
			throw new RuntimeException(e);
		}
	}

	private static String attributesParser(String attribute) {
		// Método refatorado para extrair os caracteres especiais e apenas o valor do
		// atributo da variável de entrada:
		// Como existe uma chance do atributo ainda apresentar asterisco usei o replace
		// para garantir a "limpeza" dos valores
		// Também usei split para separar o código do cabeçalho do real valor
		// (id:tt0111161)
		String[] values = attribute.split(":\"");

		return values[1].replace("\"", "");

	}

	private static List<List<String>> jsonParser(String json) {
		// Criar o pattern para realizar o tratamento do JSON e utilizar o matcher para
		// receber o resultado
		// Vamos realizar esse procedimento mais uma vez mais abaixo, mas por hora vamos
		// começar retirando o começo do Json
		// que contém o título do array ("items") e a mensagem de erro ao alcançar os
		// 250 itens ("errorMessage...")
		Pattern pattern = Pattern.compile("\\[.*?\\]");
		Matcher matcher = pattern.matcher(json);

		// Caso o pattern não seja encontrado lançamos um erro e já paramos a execução
		if (!matcher.find()) {
			throw new IllegalArgumentException("Pattern not found");
		}

		// Agora que já retiramos o começo e o fim do Json só temos os filmes, então
		// vamos realizar o tratamento para
		// gerar um array com todos eles, um filme por item do array.
		String[] movies = matcher.group().split("\\},\\{");

		// Foi requisitado que cada item do array estivesse presente em uma lista, sendo
		// assim teremos várais listas,
		// uma para cada "atributo" do filme.

		// Para facilitar a iteração utilizei um recurso do Java 8 (salvo erro) para
		// transformar o array em uma lista
		List<String> moviesList = Arrays.asList(movies);

		// Agora iteramos na lista e pegamos filme a filme para criar as sublistas com
		// as informações dos "atributos"

		// Criação da variável fora do for para melhor performance
		List<List<String>> moviesAndAttributes = new ArrayList<>();

		// Iteração dentro da lista
		for (String movie : moviesList) {
			// Como o primeiro e o último filmes ainda apresentam os caracteres de objeto de
			// um json utilizei o replace para retirá-los
			movie = movie.replace("[", "");
			movie = movie.replace("{", "");
			movie = movie.replace("]", "");
			movie = movie.replace("}", "");

			// Utilizei o aplit para separar cada atributo, formar uma lista e adicionar
			// dentro da lista de Atributos de cada Filme
			moviesAndAttributes.add(Arrays.asList(movie.split("\",\"")));
		}

		return moviesAndAttributes;
	}
}
