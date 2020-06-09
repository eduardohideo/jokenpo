# Jokenpo game
Jokenpo game em Spring Boot 2 com Java 11
Endpoints   
`GET /players` lista os jogadores e suas jogadas em json  
exemplo:  `curl http://localhost:8080/player/1`  
  
`GET /player/{nome}` retorna o jogador cadastrado baseado no seu nome e sua jogada  
exemplo:  `curl http://localhost:8080/players ` 
  
`POST /playerMove {{"name":"{nome_do_jogador}","jokenMove":"movimento"}}`  cadastra o lance do jokenpo para um determinado jogador  
exemplo:  `curl -v -XPUT http://localhost:8080/playerMove -d '{"name":1,"jokenMove":"TESOURA"}' -H "Content-Type: application/json"`  
  
`DELETE /player/{nome}` deleta o jogador cadastrado  
exemplo:  `curl -XDELETE http://localhost:8080/player/1`

`GET /game` joga o jogo e retorna a lista de vencedores  
exemplo:  `curl http://localhost:8080/game`  
