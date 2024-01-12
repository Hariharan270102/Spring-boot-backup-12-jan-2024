<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Search By Name</title>
</head>
<body>
<%@ include file="search.jsp" %>
<form action="namesearch">
<input type="text" name="search_name" placeholder="Enter name to search">
<input type="submit" value="Search">
</form>
</body>
</html>