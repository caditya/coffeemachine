<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags"%>
	
<head>
</head>
<link href="<c:url value="/resources/css/coffee.css" />"
	rel="stylesheet">
<script src="//code.jquery.com/jquery-1.10.2.js"></script>
<body>
<form:form action="/it/login" method="post" modelAttribute="loginForm" >
<label for="username">User Name </label>
<form:input path="j_username"/>
<form:errors path="j_username" ></form:errors>
<label for="password"> Password</label>
<form:input path="j_password"/>
<form:errors path="j_password" ></form:errors>
<input id="submit" name="submit"  type="submit"/>

</form:form>
</body>
