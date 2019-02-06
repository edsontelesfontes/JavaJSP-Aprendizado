<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<h1>Cadastro De Usuário</h1>
<form action="RegisterServlet" method="post">
Nome:
<input type= "text" id = "nome" name= "nome">
<br/>
Login:
<input type= "text" id = "login" name ="login">
<br/>
Senha:
<input type="password" id ="password" name ="password">
<br/>
<input type="submit" value = "Registrar">
</form>
<a href="index.jsp">Voltar</a>
</body>
</html>