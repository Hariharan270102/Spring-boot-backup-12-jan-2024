<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Employee Registration</title>
</head>
<body>
<center><h1>Welcome to Employee Registration page</h1></center>

<form action="employee">
<input type="number" name="eid" placeholder="Enter your employee id">
<br><br>
<input type="text" name="ename" placeholder="Enter employee name">
<br><br>
<input type="number" name="salary" placeholder="Enter your salary">
<br><br>
<input type="text" name="dept" placeholder="Enter your department">
<br><br>
<input type="submit" value="submit">
<input type="reset" value="clear">
<br>

</form>
<form action="view">
<input type="submit" name="view" value="View Employees">
</form>


</body>
</html>