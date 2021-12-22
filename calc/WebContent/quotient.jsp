<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Quotient</title>
</head>
<body>
	<h1>Calculation Complete!</h1>
	<p>I have successfully run your calculation!</p>
	<h4>The quotient = <%out.print(request.getAttribute("quotient")); %></h4>
</body>
</html>