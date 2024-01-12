<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Homepage</title>
</head>
<body>
<center><h1>Employee Registration Page</h1></center>
<form action="add_employee">
<input type="number" name="eid" placeholder="Enter employee id">
<br><br>
<input type="text" name="ename" placeholder="Enter employee name">
<br><br>
<input type="number" name="salary" placeholder="Enter employee salary">
<br><br>
<input type="text" name="dept" placeholder="Enter employee department">
<br><br>
<input type="submit" value="Register">
<input type="reset" value="Clear">
<br><br>
</form>
<form action="view_emp">
<input type="submit" value="View Employees">
</form>
<br>
<form action="search_emp">
<input type="submit" value="Search Employee">
</form>
<br>
<form action="deleteEmployee.jsp">
<input type="submit" value="Delete Employee">
</form>
</body>
</html>