<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<html>
    <head>
       <title>Upload a file please</title>
    </head>
    <body>
       <h1>Please upload a file 1</h1>
       <form method="post" action="/it/acceptfile" enctype="multipart/form-data">
           <input type="text" name="name"/>
           <input type="file" name="file"/>
           <input type="submit"/>
       </form>
    </body>
</html>