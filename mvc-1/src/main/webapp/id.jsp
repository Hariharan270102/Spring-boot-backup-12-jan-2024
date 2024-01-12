<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Search BY Id</title>
</head>
<body>
<%@ include file="search.jsp" %>
<form action="idsearch">
<input type="number" name="search_id" placeholder="Enter id to search">
<input type="submit" value="Search">
</form>
</body>
</html>