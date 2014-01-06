<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<html>
<head>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<link href="<c:url value="/resources/css/coffee.css" />"
	rel="stylesheet">

<script src="//code.jquery.com/jquery-1.10.2.js"></script>
<script>
	$(document).ready(function() {
		$("#submit-button").click(function() {
			$("#addcoffeeform").attr("action", "/it/addcoffee");
			$("#addcoffeeform").attr("method", "post");
			alert($("#addcoffeeform").attr('action'));
			$("#addcoffeeform").submit();
		});
	});
</script>
<title>Welcome to Coffee Machine</title>
</head>
<body>
	<%@ include file="CoffeeHeader.jsp"%>
	<form id="addcoffeeform">
		<table>
			<tr>
				<td style="font: caption;">Good Technical Links</td>
			</tr>
			<tr>
				<td style="font: caption;"><a href='http://www.vogella.com/articles/JAXB/article.html'>JAXB</a></td>
			<tr>
						
		</table>
	</form>
</body>
</html>