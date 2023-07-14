# API
## Setup do banco de dados
### Inicializando Docker Compose
primeiro precisamos ter o Docker baixado
depois ter o Docker Compose baixado
verificar instalação do docker compose usando o comando `docker-compose --version`
dentro da pasta `/accessing-data-mysql/mysql`
rode o comando `docker-compose up -d` para inicializar o Container
para remover o Container use o comando `docker-compose down` também dentro da pasta
### Criando banco e usuário
após inicializar o Container execute os seguintes comandos no terminal interno do próprio Container
``````
mysql --password

mysql> create database db_example; -- Criar uma nova database
mysql> create user 'springuser'@'%' identified by '654321'; -- Cria o usuário
mysql> grant all on db_example.* to 'springuser'@'%'; -- dá todos os privilégios ao novo usuário
``````
## Inicializando o servidor Spring
dentro da pasta `/accessing-data-mysql` execute os comandos

    ./gradlew build
    ./gradlew bootRun
## Testar API
### Adicionar usuário
faça uma requisição POST no caminho

    http://localhost:8080/demo/add 

passando como argumento `name = Algum Nome` e `email = user@email.com`
se a requisição for um sucesso você deve esperar um resultado igual a
```
saved
```
### Listando usuários
faça uma requisição GET no caminho
 ```
 http://localhost:8080/demo/all
 ```
você deve esperar um resultado parecido com
```
[{
	"id":  1,
	"name":  "Algum Nome",
	"email":  "user@email.com"
}]
```