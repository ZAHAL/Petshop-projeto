# Petshop-projeto
Esta aplicação tem como objetivo simular um sistema de pethop.


### Requirements
* JDK 8+
* Maven
* NodeJs
* MySQL Server
### Configuração do Frontend

O frontend trabalha com o gerenciado de dependências 'npm'. Para configurar e iniciar o front, basta executar os comandos abaixo dentro da pasta petshop-frontend-master:

$ npm install
Depois da instalação das dependências é necessário iniciar a aplicação frontend:

$ npm start
O comando acima irá iniciar o servidor node na porta 4200. Para acessar a aplicação, basta acessar a url baixo:

http://localhost:4200

### Configuração do Backend
Este módulo faz a ponte entre o frontend e backend.

Para instalar as dependências use o comando:

$ mvn clean install -DskipTests

Para iniciar basta executar o comando abaixo dentro da pasta visionarios:

./mvnw

### Configuração do Banco

Para o banco de dados será necessário ter um servidor MySQL rodando. E executar o script SCRIPT_INICIAL.sql que se encontra no caminho /petshop-backend-master/src/config para criar a database e suas tabelas.

Feito isso, altere no arquivo application.properties no caminho /petshop-backend-master/src/main/resources o usuário e senha do seu servidor.


