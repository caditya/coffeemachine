<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page session="false" %>
<html>
<head>
	<title>Home</title>
</head>
<body>
<p><font color="blue" size="8">Add new coffee</font></p>

<form action="/it/addcoffee" method="post">
<input type="text" name="name" />
<input type="text" name="quantity">

<input type="submit" />
</form>

</body>
</html>
