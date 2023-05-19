# BlackJack - Desafio Alt. Bank
### Descrição:
O BlackJack é uma implementação simples do jogo de cartas 21, utilizando rest API's.

Esse projeto foi desenvolvido para solucionar o desafio proposto pela equipe técnica do Alt. Bank. 

Ele leva em conta as seguintes regras:

![image](https://github.com/mmattei45/BlackJack/assets/36969485/f61bfa78-f448-48b8-ad44-09a219b52aea)



### Compilando e rodando:
Devido a dependencia do Spring Boot, **o projeto exige o Java 17** instalado na sua máquina.

Para rodar o jogo pelo terminal rode:
```./gradlew bootRun```


### Como jogar:

Importe a coleção *BlackJack.postman_collection* no Postman.

**1 - Para criar um jogo envie uma requsição na rota "Create Game":**
![image](https://github.com/mmattei45/BlackJack/assets/36969485/f3d75b93-88d0-45c5-9d94-7ec1557d8dbc)

O parametro "userId" é utilizado para identificar um jogador.
Cada jogador jogará contra a mesa, e poderá possuir vários jogos simultaneos.
Um jogador só poderá manipular os seus próprios jogos.

Caso um jogador tente manipular um jogo que não pertence a ele, a api respondera com o status 404 - Not Found.

*Obs: esse mecanismo para identificar um usuário é uma simplificação, em uma aplicação em produção ele deveria ser substituido por um outro mecanismo de autenticação como os tokens por exemplo*


**2 - Para avançar uma rodada do jogo utilize a rota "Next Round:**
![image](https://github.com/mmattei45/BlackJack/assets/36969485/bbadca3f-01ed-429b-abb9-eecd1c9d84fc)

Informe o id do jogo e o id do usuário, a api responderá o atual estado do jogo.

**3 - Para consultar o estado de um jogo utilize a rota "Game Status":**
![image](https://github.com/mmattei45/BlackJack/assets/36969485/f34872f8-aa38-484b-8b69-e9c8d7436de4)

Novamente, informe o id do jogo e o id do usuário, a api responderá o atual estado do jogo.
