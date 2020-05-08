# Serviço de logística

Projetos utilizados na disciplina DM112. Projeto final.

Instruções para teste dos projetos, seguindo os passos apresentados na aula:

1 - Importar os projetos ComunsDM112 e PedidoDM112.
Devemos configurar o atributo DB_FILE_NAME e o arqvuio META-INF/persistence.xml.
Estes devem conter o caminho do banco de dados SQLite bem como a hibernate.connection.url que leva a este arquivo.
Deve ser executado o main da classe SQLiteUtil para criá-lo.

2 - Executar o servidor Tomcat com a inclusão do projeto PedidoDM112.
Neste ponto, caso sejam buscadas as URLs, nenhum pedido será retornado pois o banco ainda está vazio.
Assim, junto ao Postman, dever ser incluido o arquivo no formato JSON para adicionar um pedido ao banco:

{
"number": 123,
"deliverymanCpf": "111.111.111-11",
"status": 0,
"orderCreationDate": 1587158424651,
"receiverCpf": "111.111.111-11",
"orderDeliveredDate": 1587158424652
}

(*Not fixed*) Neste ponto, incluimos também ao banco o CPF da pessoa que recebe o pedido e o local.

Acessaando a URL: http://localhost:8080/PedidoDM112/api/orders, temos a resposta do pedido criado.

3 - Importar o projeto EntregaDM112 ao eclipse, bem como este ao servidor Tomcat, reiniciando-o.

4 - Podemos executar o main das classes OrderRestClientCreate, OrderRestClientRetrieve e OrderRestClientUpdate.
Com estas execuções nos criamos um pedido ou o atualizamos, caso ele tenha sido criado anteriormente.

5 - Importar o projeto EmailDM112 ao eclipse, bem como este ao servidor Tomcat, reiniciando-o.

6 - Podemos verificar o conteúdo default desta no endereço http://localhost:8080/EmailDM112/.

7 - Executando a main da classe EmailClient, verificamos que é enviado um e-mail ao endereço configurado.
A mesma função pode ser realizada através do Postman:

• URL: http://localhost:8080/EmailDM112/api/sendMail
• Method: POST
• Body type: raw
• Body media type: JSON
• Body content:
{
"from": "robertorr9@gmail.com",
"password": "robertodm112",
"to": "higor.asilverio_eng@hotmail.com",
"message": "Confirmação de entrega do pedido"
}

(*Not fixed*) Neste ponto, deveria ser passado como envio ao cliente o codigo de rastreio, bem como os dados da entrega.

8 - Por fim, podemos executar a main das classes DeliveryClient do projeto EntregaDM112.
Neste podemos verificar a chamada dos métodos trackNumber e deliveryStatus da classe DeliveryServices.
Um e-mail de confirmação da entrega é enviado.
Os mesmo passos podem ser realizados através do Postman:
http://localhost:8080/EntregaDM112/api/trackNumber/111.111.111-11/123
http://localhost:8080/EntregaDM112/api/deliveryStatus/111.111.111-11/123

