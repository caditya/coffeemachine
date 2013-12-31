<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
<head>
<title>Coffee Catalog</title>
</head>
<body>
	<p style="font: caption; color: blue; size: 12">Current Coffee
		Catalog</p>

	<table>
		<tr>
			<td style="font: caption;">
				<p>Coffee Name</p>
			</td>
			<td style="font: caption;" align='center'>
				<p>Quantity</p>
			</td>
		</tr>
		<c:forEach items="${coffeecatalog}" var="coffee">
			<tr>
				<td style="font: caption;color: blue">
					<p>${coffee.name }</p>
				</td>
				<td style="font: caption;color: blue">
					<p>${coffee.quantity}</p>
				</td>
				 
				
			</tr>
		</c:forEach>
	</table>

</body>
</html>