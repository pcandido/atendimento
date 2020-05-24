# Projeto Atendimento

Esse projeto é parte do material desenvolvido para o *Tutorial - API REST* disponível no YouTube. Visite a playlist para acompanhar o desenvolvimento desse projeto.

Todos os vídeos possuem uma tag criada no git para que seja possível acompanhar o progresso do desenvolvimento através do próprio histórico do repositório. As tags seguem o padrão `vXX` onde `XX` é o número do vídeo (a tag estará referenciada no título de cada vídeo). Para obter a lista de tags pelo git, utilize o comando `git tag`.

## Database

Durante o tutorial, estamos usando o banco de dados PostgreSQL, sendo executado por uma imagem docker. Para criar um container a partir da imagem do PostgreSQL de forma que possa ser utlizado nesse projeto, utilize o seguinte comando:

```
docker run --name postgres -p 5432:5432 -e POSTGRES_PASSWORD=secure_password -d postgres
```

Caso precise parar ou reiniciar o container (por exemplo depois que o sistema operacional for reiniciado), é possível usar os seguintes comandos:

```
docker stop postgres
docker start postgres
```

E para verificar se o container já está ou não em execução, basta usar o comando:

```
docker container ls -a
```

Caso tenha algum problema com o banco de dados, seja no próprio container ou seja pela execução de uma migration de forma incorreta, é possível usar o comando:

```
docker container rm -f postgres
```

para destruir o container, para então criar um novo container. É uma solução agressiva para maior parte dos problemas, mas caso ainda não tenha adquirido conhecimento para tratar cada erro de forma específica, essa é uma alternativa simples.