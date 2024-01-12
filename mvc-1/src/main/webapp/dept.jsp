<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Department Search</title>
</head>
<body>
<%@ include file="search.jsp" %>
<form action="deptsearch">
<input type="text" name="search_dept" placeholder="Enter department to search">
<input type="submit" value="Search">
</form>
</body>
</html>