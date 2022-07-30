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
