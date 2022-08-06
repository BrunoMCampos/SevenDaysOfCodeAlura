package sevendaysofcode.resources;

import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse.BodyHandlers;

public class ImdbAPIClient {

	public static String apiRequest(String key) {

		try {

			// Criação de variável para a url
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

}
