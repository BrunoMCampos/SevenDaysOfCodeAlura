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

public class APIAccess {

	public static void main(String[] args) {

		// Criação de variáveis para a key e para a url
		String key = "<Key>";
		String url = "https://imdb-api.com/en/API/Top250Movies/" + key;

		try {

			// Criação do HTTPClient que irá enviar a requisição, assim como da URI
			// necessária para o request e do próprio request
			HttpClient httpClient = HttpClient.newHttpClient();

			URI uri = new URI(url);
			HttpRequest request = HttpRequest.newBuilder(uri).GET().build();

			// Envio da requisição por parte do client e recebimento da resposta (refatorado
			// de body para json)
			String json = httpClient.send(request, BodyHandlers.ofString()).body();

			// Extraindo os filmes em uma lista de filmes que contem os atributos em forma
			// de lista
			List<List<String>> moviesAndAttributes = jsonParser(json);

			// Criação das listas de atributos
			List<String> ids, rankings, titles, fullTitles, years, images, crews, imDbRating,
					imDbRatingCount = new ArrayList<>();

			// Atribuição dos valores a cada lista
			ids = attributesParser(moviesAndAttributes, 0);
			rankings = attributesParser(moviesAndAttributes, 1);
			titles = attributesParser(moviesAndAttributes, 2);
			fullTitles = attributesParser(moviesAndAttributes, 3);
			years = attributesParser(moviesAndAttributes, 4);
			images = attributesParser(moviesAndAttributes, 5);
			crews = attributesParser(moviesAndAttributes, 6);
			imDbRating = attributesParser(moviesAndAttributes, 7);
			imDbRatingCount = attributesParser(moviesAndAttributes, 8);

			// Exibição das listas no console
			System.out.println(ids);
			System.out.println(rankings);
			System.out.println(titles);
			System.out.println(fullTitles);
			System.out.println(years);
			System.out.println(images);
			System.out.println(crews);
			System.out.println(imDbRating);
			System.out.println(imDbRatingCount);

		} catch (URISyntaxException | InterruptedException | IOException e) {
			throw new RuntimeException(e);
		}
	}

	private static List<String> attributesParser(List<List<String>> moviesAndAttributes, int listIndex) {

		// Criar a variável que será devolvida pelo método, já que é uma lista na qual
		// adicionarei os dados
		List<String> generatedList = new ArrayList<>();

		// Para carregar a lista que será devolvida utilizarei um for para passar pos
		// todos os filmes e pegar apenas o atributo necessário por meio da variável
		// listIndex
		// Como existe uma chance do atributo ainda apresentar asterisco usei o replace
		// para garantir a "limpeza" dos valores
		// Também usei split para separar o código do cabeçalho do real valor
		// (id:tt0111161)
		for (List<String> movie : moviesAndAttributes) {
			String attribute = movie.get(listIndex);

			String[] values = attribute.split(":\"");

			generatedList.add(values[1].replace("\"", ""));
		}

		// Por fim retorno a lista gerada
		return generatedList;
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
