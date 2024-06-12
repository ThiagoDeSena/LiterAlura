# Projeto LiterAlura: Mergulhando no Mundo dos Livros com Java, Spring, Postgres e Gutendex
![Projeto LiterAlura](https://github.com/ThiagoDeSena/LiterAlura/assets/110785400/dd1e5ef9-ae36-4014-bc6e-fe40084720fc)

![Badge Concluído](http://img.shields.io/static/v1?label=STATUS&message=CONCLUÍDO&color=GREEN&style=for-the-badge)
![Badge Linguagem](http://img.shields.io/static/v1?label=LINGUAGEM&message=JAVA&color=orange&style=for-the-badge)
![Badge Linguagem](http://img.shields.io/static/v1?label=API&message=gutendex&color=blue&style=for-the-badge)

## Descrição do projeto 

<p align="justify">
Prepare-se para embarcar em uma jornada literária emocionante com o projeto LiterAlura, onde construiremos nosso próprio catálogo de livros
utilizando as ferramentas Java, Spring, Postgres e a API https://gutendex.com/. Através deste desafio, dominaremos o consumo de APIs e aprimoraremos nossas 
habilidades na persistência de dados em um banco de dados relacional utilizando o Postgres.

- API utilizada:

  ![image](https://github.com/ThiagoDeSena/LiterAlura/assets/110785400/8021229b-0ad0-4e9c-b413-93a69063e3a7)

- Dados retornados da API usando o link https://gutendex.com/books/.

  ![image](https://github.com/ThiagoDeSena/LiterAlura/assets/110785400/86f841c2-43ae-4418-bbee-9a0a87f49237)


- Exemplo do Programa sendo executado no console:

  ![image](https://github.com/ThiagoDeSena/LiterAlura/assets/110785400/f75fa61c-0c8a-49ae-a17a-89cb9905180d)

</p>


## Mergulhando no Código

Com o console do IDE IntelliJ como nosso guia, acessaremos o terminal e desvendaremos um universo de 5 opções de interação:

:heavy_check_mark: `Buscar livro pelo título:` Uma aventura pela API Gutendex em busca de um tesouro literário. Encontraremos o 
livro dos nossos sonhos e o armazenaremos em nosso banco de dados para consultas futuras. 

:heavy_check_mark: `Listar livros registrados:`  Uma estante virtual à nossa disposição. Todos os livros que coletamos ao longo 
da jornada estarão listados aqui para nossa apreciação.

:heavy_check_mark: `Listar autores:`  Um encontro com os mestres das palavras. Descobriremos os autores que deram vida às histórias 
que tanto amamos, incluindo seus anos de nascimento e falecimento.

:heavy_check_mark: `Listar autores em determinado ano:` Uma viagem no tempo através da literatura. Desvendaremos quais autores 
agraciaram o mundo com suas obras em um ano específico.

:heavy_check_mark: `Listar livros em determinado idioma:` Explorando a riqueza cultural da literatura. Encontraremos livros em diversos 
idiomas, expandindo nossos horizontes literários.

## Como usar

https://github.com/ThiagoDeSena/Tabela-Fipe/assets/110785400/545df798-0790-4d08-9d8b-8c738afe4a33


## Benefícios

- Praticidade: Consulta rápida e fácil dos valores FIPE.
- Precisão: Informações atualizadas e confiáveis da Tabela FIPE.
- Organização: Permite aos colecionadores gerenciar sua coleção de forma organizada, com acesso aos valores dos seus veículos.
- Decisão informada: Auxilia na tomada de decisões sobre compra, venda ou avaliação de carros, motos e caminhões.

 ## Observações

 - Para realização do desafio faremos o consumo de uma API, documentada nesse link https://deividfortuna.github.io/fipe/.

- De acordo com o escolhido (carro, moto, ou caminhão) vamos fazer uma chamada a um dos endpoints abaixo para buscar as marcas:

https://parallelum.com.br/fipe/api/v1/carros/marcas

https://parallelum.com.br/fipe/api/v1/motos/marcas

https://parallelum.com.br/fipe/api/v1/caminhoes/marcas

- O retorno dessa requisição será uma lista com código e marca desejada. Caso o usuário queira por exemplo fazer uma consulta a modelos de carros da Fiat, que possui o código 21, terá que fazer uma nova requisição para o endpoint:
  
https://parallelum.com.br/fipe/api/v1/carros/marcas/21/modelos

- Feito isso, irá escolher um código de modelo, por exemplo esse Palio Weekend Stile 1.6 mpi 16V 4p, representado pelo código 560. Então deverá fazer uma terceira requisição para o endpoint:

https://parallelum.com.br/fipe/api/v1/carros/marcas/21/modelos/560/anos

- Para saber a avaliação para cada ano disponível, teremos que fazer requisições pelo código por ano, onde obteremos um retorno similar ao que é mostrado abaixo:
  
https://parallelum.com.br/fipe/api/v1/carros/marcas/21/modelos/560/anos/2003-1

![image](https://github.com/ThiagoDeSena/Tabela-Fipe/assets/110785400/882957d0-045a-42cf-a0b8-26c26447c1da)

- Para podermos exibir em nossa aplicação as avaliações de todos os anos para esse modelo, será necessário trabalhar com as coleções e estruturas de repetição para poder exibir já todos as avaliações de todos os anos para o nosso usuário.
- Utilize a biblioteca Jackson para a desserialização dos dados.
- Modele as classes de acordo com o necessário para representar as marcas, modelos e dados dos veículos.
- Relembre os conceitos vistos no curso para filtrar os modelos por um trecho do nome.


## Desenvolvedores

[<img src="https://avatars.githubusercontent.com/u/110785400?v=4" width=115><br><sub>Thiago De Sena</sub>](https://www.linkedin.com/in/thiago-de-sena-ab5b09179/)


