<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
<head>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<link href="<c:url value="/resources/css/coffee.css" />"
	rel="stylesheet">
<title>Company Coffee Catalog</title>
<head>
<script src="//code.jquery.com/jquery-1.10.2.js"></script>
<script>
	$(document).ready(
		function() {
		$("#check").click(function() {
			checkAvailability();
		});
		$("#updatecoffee").click(function() {
			updateCoffee();
		});
		
	});
	function checkAvailability(){
		alert('checkavailability');
		$.getJSON("/it/checkInventory", { name: $('#name').val() }, function(availability) {
			if (availability.available== 'false') {
	        	$("#result").html("Coffee not in stock: " + availability.suggestions);
	            
	        } else if (availability.available=='true'){
	        	$("#result").html("Coffee in stock");
	        }
	    });
	}
	function updateCoffee(){
		var url1 = "/it/performcatalogupdate/" + $('#updateme').val() +"/"+ $('#newname').val();
		$.ajax({
			  type: "PUT",
			  url:url1, 
			 })
			  .done(function( msg ) {
				  $("#updateresult").html(msg);
			  });
	}
	
	
</script>

</head>
<body style="background-color: gray">
	<jsp:include page="CoffeeHeader.jsp" />
	<table>
		<tr>
			<td class='font'>Enter a coffee</td>
			<td><input type='text' name='name' id='name'></td>
			<td><input type='button' id='check' name='check'
				value='Check if already present' /></td>
			<td><p  class='font' id="result"></p></td>
		</tr>
		
		<tr>
			<table>  <!-- inner table -->
			<tr>
			<td class='font' ><b>Update coffee</b></td>
			</tr>
			<tr>
			<td class='font'>Coffee Name: <input type='text' name='updateme' id='updateme'></td>
			<td class='font'>Coffee new name: <input type='text' name='newname' id='newname'></td>
			<td class='font'><input type='button' id='updatecoffee' name='updatecoffee' value='Update coffee' /></td>
			<td class='font'>( ADMIN access required.)</td>
			<td class='font'><p  class='font' id="updateresult"></p></td>
			</tr>
			</table>			
		</tr>
		<tr>
		<td><a href="/it/" class='font'>Back to main page</a></td>
		</tr>
	</table>

</body>
</html>