<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Serviço de Utilidade</title>
</head>
<body>
<h1>File index.jsp ok!</h1>
<br/>
<h2>Serviço disponível:</h2>
<br/>
POST: <a href="http://localhost:8080/EmailDM112/api/sendMail/">Envio de email</a>
<br/>
O corpo do request deve possuir um JSON
<br/>
{
<br/>
	"from": "robertorr9@gmail.com",
<br/>
	"password": "robertodm112",
<br/>
	"to": "higor.asilverio_eng@hotmail.com",
<br/>
	"message": "Pedido entregue com sucesso!"
<br/>
}
<br>
</body>
</html>
