<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
<head>
<title>Coffee Catalog</title>
</head>
<body>
	<p><font color='blue' size="14">Current Coffee Catalog </font></p>
	<p> COFFEE   QUANTITY </p>
	
	<c:forEach items="${coffeecatalog}" var="coffee">
		
		<p>${coffee.name }   ${coffee.quantity} </p>
	</c:forEach>	
</body>
</html>