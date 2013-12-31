<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
<head>
<link rel="stylesheet" href="/coffee.css">
<title>Coffee Catalog</title>
</head>
<body>
	<p><font color='blue' size="14">Error Page </font></p>
	<p class="error">${exception} on page ${url}</p>	
</body>
</html>