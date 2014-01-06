<!-- Login.jsp used to login to coffee-machine - uses Spring Security Filters (Except for /login mapping) 
Spring Security filer listens and responds to j_spring_security_check
-->
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
<head>
<link href="<c:url value="/resources/css/coffee.css" />"
	rel="stylesheet">
<title>Coffee Machine Login</title>
</head>
<body onload='document.f.j_username.focus();'>

	<%@ include file="CoffeeHeader.jsp"%>
	<c:if test="${param.error!=null}">

		<c:if test="${not empty SPRING_SECURITY_LAST_EXCEPTION}">

			<div class="errorblock">
				Your login attempt was not successful, try again.<br /> Caused by:
				${sessionScope["SPRING_SECURITY_LAST_EXCEPTION"].message}
				${sessionScope["SPRING_SECURITY_LAST_EXCEPTION"]}
			</div>
		</c:if>
	</c:if>

	<form name='f' method='POST'
		action="<c:url value='j_spring_security_check' />">


		<table>
			<tr>
				<td class='font'>User:</td>
				<td><input type='text' name='j_username' value=''></td>
			</tr>
			<tr>
				<td class='font'>Password:</td>
				<td><input type='password' name='j_password' /></td>
			</tr>
			<tr>
				<td colspan='2'><input name="submit" type="submit"
					value="submit" /></td>
			</tr>
			<tr>
				<td colspan='2'><input name="reset" type="reset" /></td>
			</tr>
		</table>

	</form>


	<%@ include file="CoffeeFooter.jsp"%>

</body>
</html>