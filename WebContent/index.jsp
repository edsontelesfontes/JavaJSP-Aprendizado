<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Aprendizado JSP</title>
</head>
<body>
<h1>Bem vindo !</h1>

<%= "Foco que o objetivo sai!" %>

<form action="loginServlet" method="post">
Login: 
<input type = "text" id ="login" name="login">
<br/>
Senha: 
<input type = "password" id = "senha" name= "senha">
<br/>
<input type = "submit" value = "Logar">
</form>
<a href="registro.jsp">Registrar-se</a>
</body>
</html>