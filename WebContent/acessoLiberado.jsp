<%@page import="java.io.PrintWriter"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Aprendizado JSP</title>
</head>
<body>
<h1>Bem vindo</h1> <%= session.getValue("nome") %>
</br>
<h3>Sistema de download e upload de imagens: </h3>
<a href="uploadIMG.jsp">Upload de imagens</a>
</br>
<a href="downloadIMG.jsp">Download de imagens</a>
</br>
</br>
<a href="index.jsp">Sair</a>
</body>
</html>