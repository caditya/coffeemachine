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
				<td style="font: caption;">Designed to track coffee inventory</td>
			</tr>
			<tr>
				<td style="font: caption;">View store Coffee catalog</td>
				<td style="font: caption;"><a href=#>jsp</a></td>
				<td style="font: caption;"><a href=#>xml</a></td>
				<td style="font: caption;"><a href=#>json</a></td>
				<td style="font: caption;"><a href=#>excel</a></td>
			</tr>
			<tr>
				<td style="font: caption;"><a href=#> View Company
						Coffee catalog (Web Service call) </a></td>
			</tr>
			<tr>
				<td style="font: caption;">Search Coffee Catalog</td>
			</tr>
			<tr>
				<td style="font: caption;">Add Coffee to store catalog</td>
			</tr>
			<tr>
				<td style="font: caption;"><a href="/it/companycatalog">company Coffee catalog (Web Service)</a></td>
				<td style="font: caption;">View All</td>
				<td style="font: caption;">View One</td>
				<td style="font: caption;">Add</td>
				<td style="font: caption;">Delete</td>
				<td style="font: caption;">Update</td>
			</tr>
						
			<tr>
				<td><input type='button' id="submit-button"
					value="Proceed to add coffee" id="button" /></td>
			</tr>
			<tr>
			<td>
			<a  class='font' href = "/it/fbwebservice" > Invoke Face Book Rest-web service </a>
			<td>
			</tr>
			
		</table>
	</form>
</body>
</html>