<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Salary Search</title>
</head>
<body>
<%@ include file="search.jsp" %>
<form action="salarysearch">
<input type="number" name="search_salary" placeholder="Enter salary to search">
<input type="submit" value="Search">
</form>
</body>
</html>