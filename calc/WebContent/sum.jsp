<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Summation</title>
</head>
<body>
	<h1>Calculation Complete!</h1>
	<p>I have successfully run your calculation!</p>
	<h4>The sum = <%out.print(request.getAttribute("sum")); %></h4>
</body>
</html>