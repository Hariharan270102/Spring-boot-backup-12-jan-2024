<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Person Hobby Homepage</title>
</head>
<body>
<center><h1>Welcome to Spring Boot DB H2 CONNECTION</h1></center>
<form action="/create">
<input type="text" name="name" placeholder="Enter person name"><br><br>

<input type="text" name="hobby" placeholder="Enter your hobby"><br><br>

<input type="submit" value="submit">

</form>
<br><br>
<form action="view">
<input type="submit" value="view persons">
</form>
</body>
</html>