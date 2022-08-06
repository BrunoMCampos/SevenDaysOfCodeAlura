# SevenDaysOfCodeAlura
Repositório dedicado ao programa Seven Days of Code da Alura, o qual é focado em aprender Java através de um projeto com uma API.

**_IDE utilizada: Eclipse_**  
**_Linguagens utilizadas: Java, HTML_**
**_Bibliotecas de mercado: Bootstrap_**

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
---
## Dia 3 - Refatorando o código e criando a classe Movie
No terceiro dia tivemos a orientação a objetos entrando em cena com a criação da classe "Movie" para repesentar um filme, esta contendo os atributos "title", "urlImage", "rating" e "year" para podermos manusear os dados.
Com a classe criada partimos para a utilização de uma lista de filmes (List<Movie>) facilitando muito em comparação com a lista usada anteriormente.

Neste ponto fiz alguns refatoramentos principais, como:

1. Extração do contato com a API via Http para um novo método chamado "apiRequest"
![image](https://user-images.githubusercontent.com/100006703/181936805-a1551654-77e0-427c-b732-324717350c12.png)

2. Alteração do método "attributesParser" para receber apenas uma String "attribute" e não retornar mais uma lista de Strings, mas sim apenas uma String  
![image](https://user-images.githubusercontent.com/100006703/181936836-2f6d4ed7-e00f-4ec9-977d-e33263103d25.png)

3. Organização do método "main" para poder utilizar os métodos refatorados anteriormente e carregar a lista com os filmes conforme orientado  
![image](https://user-images.githubusercontent.com/100006703/181936868-9a0941cf-f321-4887-bfcc-7eb306690372.png)

### Foram deixadas pela equipe da Alura algumas questões a serem respondidas:
 
 **1. Você acha que faz sentido ter setters ou um construtor padrão?**  
 Resp.: Acredito que faz sentido um construtor padrão para esta classe, pois ela é utilizada apenas para a interpretação de uma API que já nos entrega todos os dados de uma só vez, sendo assim não faz sentido adicionarmos dado a dado e não se mostra necessária uma alteração de um único dado, não sendo necessário um setter atualmente.
 
 **2. Um filme deve ser interfaceado?**  
 Resp.: No momento não vejo essa necessidade, pois temos apenas poucos dados sendo utilizados e poucas funcionalidades, além de apenas duas classes presentes no nosso projeto. Talvez futuramente essa possa vir a ser uma opção, mas não é o caso agora.
 
 **3. Um filme deve ser imutável?**  
 Resp.: Me apoio na resposta da questão 1 ao dizer que sim. Por hora não temos necessidade de alterar um filme, por esse mesmo motivo não utilizamos setters, mas como já foi dito, é um caso a ser pensado conforme forem realizadas as aulas e expandido o projeto.
 
 **4. Para quem usa uma versão mais recente do Java, faz sentido usar Records aqui?**  
 Resp.: Considerando a própria descrição da Oracle (https://docs.oracle.com/en/java/javase/17/language/records.html) em que ela diz que um Record é uma classe simples que deve ser utilizada como um "carregador de dados" acredito que possamos utiliza Records neste momento sim! Ainda não vi muito sobre a classe e não tive tempo de realizar a implementação, mas pretendo refatorar o código e efeturar um novo commit assim que possível.
 
 **Tarefas do dia 3**
- [x] Criar a classe "Movie" para representar um filme
- [x] Refatorar o código conforme a necessidade para utilziar a classe "Movie" criada
- [x] Responder as questões realizadas pela a Alura
- [ ] Caso julgar necessário e adequado utilizar a classe Records
---
## Dia 4 - Criando a classe HTMLGenerator e criando o HTML com os posters dos filmes
No quarto dia utilizamos a classe que criamos no dia anterior e os dados que tratamos e recebemos nos demais dias para gerar uma página HTML com os posters dos filmes, suas notas e anos de lançamento. Não realizei os refatoramentos que havia deixado pendente, mas pretendo faze-los assim que possível.

**HTML gerado pelo código:**
![image](https://user-images.githubusercontent.com/100006703/182255455-ca850e36-74af-4f55-aed6-25eb9f630709.png)

 **Tarefas do dia 4**
- [x] Criar a classe "HTMLGenerator" para criar o arquivo HTML via código Java.
- [x] Refatorar o código conforme a necessidade para utilziar a classe "HTMLGenerator" criada.
- [x] Elaborar o HTML com a utilização de Bootstrap
---
## Dia 5 - Refatorando o código e criando novas classes
No quinto dia melhoramos todo o código, utilizando a criação de mais classes para podermos deixar nosso método main mais "enxuto" e legível.
Sendo assim foram criadas as seguintes classes:

1. ImdbAPIClient: Esta classe está responsável pelo acesso a API, com a criação do HttpClient e demais componentes necessários para realizar a requisição, tendo apenas um método estático para retornar para a main os dados em formato JSON.  
![image](https://user-images.githubusercontent.com/100006703/183262084-763de79e-2073-4594-9586-64ce40941742.png)

2. ImdbMovieJsonParser: Esta classe é responsável por converter o JSON recebido para a nossa classe "Movie", sendo assim ele contém três métodos, que seriam os já utilizados anteriormente para esta conversão. 
![image](https://user-images.githubusercontent.com/100006703/183262394-2e250661-1494-4094-b017-f51a8a3284e8.png)

  - jsonParser: Método responsável por quebrar o JSON gerando uma lista em que cada um de seus items é uma lista de atributos do filme em questão.  
![image](https://user-images.githubusercontent.com/100006703/183262415-b5ed7da8-0283-4979-8f9f-c24bf254e109.png)

  - attributesParser: Método responsável por retornar apenas um dos atributos do filme, sem o nome do tipo de atributo ou caracteres especiais indesejados.  
![image](https://user-images.githubusercontent.com/100006703/183262492-ae54722a-631f-4281-b1e1-850218f5469d.png)

  - parse: O único método publico da classe, este responsável por fazer a chamada dos demais métodos e transformar nosso json em um List<Movie> e retorna-lo ao método que o chamou.  
![image](https://user-images.githubusercontent.com/100006703/183262572-d0919a66-fce2-437d-93ab-95fef54a545a.png)

 **Tarefas do dia 5**
- [x] Criar a classe "ImdbAPIClient" para realizar o acesso a API e retornar os dados do JSON.
- [x] Criar a classe "ImbdMovieJsonParser" para transformar o JSON retornado em uma lista de "Movie" para melhor manuseio de dados.
- [x] Refatorar o código da classe com o método "main" para permitir a utilização das demais classes conforme necessidade.
---
