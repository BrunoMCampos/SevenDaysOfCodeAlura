package sevendaysofcode.html;

import java.io.PrintWriter;
import java.util.List;

import sevendaysofcode.model.Movie;

public class HTMLGenerator {
	
	// Criando o atributo writer para receber o writer do main
	private PrintWriter writer;

	// Utilizando o construtor para receber o atributo
	public HTMLGenerator(PrintWriter writer) {
		this.writer = writer;
	}
	
	// Classe para gerar o html e grava-lo como arquivo
	public boolean generate(List<Movie> movies){
		// Começando a construção do HTML
		String html = "<!DOCTYPE html>\r\n"
				+ "<html lang=\"pt\">";
		
		// Adicionando o Header
		html += "<head>\r\n"
				+ "    <meta charset=\"UTF-8\" />\r\n"
				+ "    <meta http-equiv=\"X-UA-Compatible\" content=\"IE=edge\" />\r\n"
				+ "    <meta name=\"viewport\" content=\"width=device-width, initial-scale=1.0\" />\r\n"
				+ "    <title>TOP 250 Filmes</title>\r\n"
				+ "    <link\r\n"
				+ "      href=\"https://cdn.jsdelivr.net/npm/bootstrap@5.2.0/dist/css/bootstrap.min.css\"\r\n"
				+ "      rel=\"stylesheet\"\r\n"
				+ "      integrity=\"sha384-gH2yIJqKdNHPEq0n4Mqa/HGKIhSkIHeL5AyhkYV8i59U5AR6csBvApHHNl/vI1Bx\"\r\n"
				+ "      crossorigin=\"anonymous\"\r\n"
				+ "    />\r\n"
				+ "  </head>";
		
		// Adicioinando o começo do body
		html += "<body>\r\n"
				+ "    <div class=\"container\">\r\n"
				+ "      <div class=\"row\">\r\n"
				+ "        <div class=\"alert alert-dark mt-2 bg-dark\">\r\n"
				+ "          <h1 class=\"text-light bg-dark\">TOP 250 FILMES - IMDB</h1>\r\n"
				+ "        </div>\r\n"
				+ "      </div>\r\n";
		
		// Para melhor visualização coloquei 3 posters por div, sendo assim utilizei o bootstrap com a classe row
		// ou seja, vou precisar criar uma linha a cada 3 posters
		String linha = "<div class=\"row justify-content-evenly\">";
		
		// Adicionando linha inicial
		html += linha;
		
		// Criando uma variável para verificar sempre que 3 filmes forem adiciionados
		int iteration = 0; 
		
		// Realizando o laço
		for(Movie movie : movies) {
			// Sempre que for adicionar um card de filme vou seguir o mesmo padrão substituindo as variáveis referentes ao filme
			String divMovie = "<div class=\"card col-3 text-bg-dark mb-3 mt-2\">\r\n"
					+ "          <div class=\"card-header\">\r\n"
					+ 			movie.getTitle() + "\r\n"
					+ "          </div>\r\n"
					+ "          <img\r\n"
					+ "            class=\"img-thumbnail\"\r\n"
					+ "            src=\"" + movie.getUrlImage() + "\"\r\n"
					+ "            alt=\""+ "Poster do filme: " + movie.getTitle() +"\"\r\n"
					+ "          />\r\n"
					+ "          <div class=\"card-body\">Nota: " + movie.getRating() + " - Ano: " + movie.getYear() + "</div>\r\n"
					+ "        </div>";
			
			// Adicionando ao html
			html += divMovie;
			
			// Somando o iteration
			iteration++;
			
			// Caso 3 posters tenham sido adicionados encerro a linha e começo outra
			if(iteration % 3 == 0) {
				iteration = 0;
				html += "</div>\r\n";
				html += linha;
			}
		}
		
		// Fechando a última linha, body e html
		html += "</div>\r\n"
				+ "    </div>\r\n"
				+ "  </body>\r\n"
				+ "</html>";
		
		// Gravando o arquivo html
		writer.write(html);
		
		// Retornando true caso tenha gerado o arquivo
		return true;
	}
	
}
