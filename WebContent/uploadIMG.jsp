<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Upload de imagens</title>
<script type="text/javascript" src="https://code.jquery.com/jquery-3.3.1.min.js"></script>
</head>
<body>
<input type="file" id="file" name="file" onchange="uploadfile();">
<img alt="imagem" src="" id="imagemUP" width="800" height="600">

</body>
<script type="text/javascript">
function uploadfile() {
	
var imagemUP = document.querySelector("img");
var file = document.querySelector("input[type=file]").files[0];
var reader = new FileReader();

	reader.onloadend = function (){
		imagemUP.src = reader.result;
	////-----Upload Ajax
		$.ajax({
		method : "POST",
		url : "fileUpload",
		data : {fileUpload : reader.result}
		
		}).done(function(response){
			alert("Upload da imagem foi feito com sucesso !"+ response);
		}).fail(function (xhr, status, errorThrown) {
			alert("Erro na hora de fazer upload de imagem.");
		});
		///---------------
	};
	
	if(file){
		reader.readAsDataURL(file);
		
	}
	else {
	imagemUP.src="";
	};
}
	
</script> 
</html>