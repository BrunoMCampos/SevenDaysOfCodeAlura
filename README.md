# SevenDaysOfCodeAlura
Repositório dedicado ao programa Seven Days of Code da Alura, o qual é focado em aprender Java através de um projeto com uma API.

**_IDE utilizada: Eclipse_**  
**_Linguagem utilizada: Java_**

## Dia 1 - Acesso a API
No primeiro dia fomos apresentados a API do IMDB e a utilizamos para criar nosso primeiro código, onde utilizamos o pacote java.net.http para criar um HttpClient, HttpRequest e uma URI e com isso acessar os dados dos 250 filmes com as maiores notas no IMDB.
O primeiro objetivo foi o de acesar a API e exibir os dados no console.

![image](https://user-images.githubusercontent.com/100006703/181919617-1cf4d51b-6a50-45e2-b0cf-4e8f70463057.png)

**Tarefas do dia 1**
- [x] Criar uma classe com um método Main e utilizar apenas ela e o pacote java.net.http para acessar os dados da API e exibir no console 
---------------------------------------------------------------------------------------------------------------------------------------------------
## Dia 2 - Tratando o json e criando as listas de atributos
No segundo dia tivemos a tarefa de parsear a lista que nos foi dada no formato json, criando várias listas, uma para cada "atributo" de um filme (ids, rankings, titles, fullTitles, years, images, crews, imDbRatings, imDbRatingCounts). Por fim exibi a lista no console para poder estar verificando se estava tudo correto, e aparentemente tudo correu bem. Não é o código que mais me orgulho de ter escrito, mas por hora cumpriu a missão. 
Próximo passo: Refatorar!

![image](https://user-images.githubusercontent.com/100006703/181933463-57f6cae0-1296-49c6-8d0b-8dcc161d8c13.png)

**Tarefas do dia 2**
- [x] Parsear a resposta do json para criar listas de cada "atributo" de um filme 
