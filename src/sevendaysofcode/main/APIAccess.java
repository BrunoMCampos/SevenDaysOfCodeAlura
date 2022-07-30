package sevendaysofcode.main;

import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse.BodyHandlers;

public class APIAccess {

	public static void main(String[] args) {

		// Criação de variáveis para a key e para a url
		String key = "<Key>";
		String url = "https://imdb-api.com/en/API/Top250Movies/" + key;

		try {
			
			// Criação do HTTPClient que irá enviar a requisição, assim como da URI necessária para o request e do próprio request
			HttpClient httpClient = HttpClient.newHttpClient();
			
			URI uri = new URI(url);
			HttpRequest request = HttpRequest.newBuilder(uri).GET().build();
			
			// Envio da requisição por parte do client e recebimento da resposta
			String body = httpClient.send(request, BodyHandlers.ofString()).body();
			
			// Exibição da resposta no console
			System.out.println(body);
			
		} catch (URISyntaxException | InterruptedException | IOException e) {
			throw new RuntimeException(e);
		}
	}
}
