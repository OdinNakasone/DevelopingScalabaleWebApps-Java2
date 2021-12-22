<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Calculator</title>
</head>
<body>
<h1 style="text-align:center;">Welcome to my Calculator</h1>
	<p >Add numbers here: 
	<form method = "GET" action = "/calc/add">
	<input type = "text" name = "augend"/>
	+
	<input type = "text" name = "addend"/>
	<input type = "submit" value = "Add"/>
	</form>
	</p>
	
	<p>Subtract numbers here:
	<form method = "GET" action = "/calc/subtract">
	<input type = "text" name = "minuend"/>
	-
	<input type = "text" name = "subtrahend"/>
	<input type = "submit" value = "Subtract"/>
	</form>
	</p>
	
	<p>Multiply numbers here:
	<form method = "GET" action = "/calc/multiply">
	<input type = "text" name = "multiplicand"/>
	*
	<input type = "text" name = "multiplier"/>
	<input type = "submit" value = "Multiply"/>
	</form>
	</p>
	
	<p>Divide numbers here:
	<form method = "GET" action = "/calc/divide">
	<input type = "text" name = "dividend"/>
	/
	<input type = "text" name = "divisor"/>
	<input type = "submit" value = "Divide"/>
	</form>
	</p>
	
</body>
</html>