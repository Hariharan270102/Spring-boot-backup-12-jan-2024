<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Delete Choices</title>
</head>
<body>

<center>
<h1>Delete Employees</h1>
<form action="deleteChoices">
<input type="radio"  name="del_choice" value="id" >Delete By Id <br>
<input type="radio"  name="del_choice" value="name" >Delete By Name<br>
<input type="radio"  name="del_choice" value="dept" >Delete By Department<br>
<input type="text" name="data" placeholder="Enter here">
<input type="submit" value="Submit">
</form>
</center>
</body>
</html>