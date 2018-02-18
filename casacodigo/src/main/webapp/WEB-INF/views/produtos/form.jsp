<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
 <%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
 <%@ taglib uri="http://www.springframework.org/tags" prefix="s" %>
 
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Livro de Java, Android, PHP e muito mais - Casa do C�digo</title>
</head>
<body>

	<form:form action="${s:mvcUrl('PC#gravar').build()}" method="POST">		
		<div>
			<label>T�tulo</label>
			<form:errors path="titulo"/>
			
			<input type="text" name="titulo">
		</div>
		<div>
			<label>Descri��o</label>
			<form:errors path="descricao"/>
			<textarea rows="10" cols="20" name="descricao">
			</textarea>
		</div>
		<div>
			<label>P�ginas</label>
			<form:errors path="paginas"/>
			<input type="text" name="paginas">
		</div>
		
		<c:forEach items="${tipos}" var="tipoPreco" varStatus="status">
        	<div>
	            <label>${tipoPreco}</label>
	            <input type="text" name="precos[${status.index}].valor" />
	            <input type="hidden" name="precos[${status.index}].tipo" value="${tipoPreco}" />
        	</div>
    	</c:forEach>
		
		<button type="submit">Cadastrar</button>
	</form:form>
</body>
</html>