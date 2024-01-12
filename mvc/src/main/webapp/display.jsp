<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page import="java.util.ArrayList" %>

<%@ page import="edu.springboot.mvc.model.Employee" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>View Employees</title>
</head>
<body>
<center><h1>View Employees</h1></center>
<%-- ${vl } --%>
<table>
<tr>
<th>EID</th>
<th>ENAME</th>
<th>SALARY</th>
<th>DEPT</th>
</tr>
<tr>
<%
ArrayList<Employee> vl=(ArrayList<Employee>)request.getAttribute("vl");
for(Employee e:vl)
{	
%>
</tr>
<tr>
<td><%=e.getEid() %></td>
<td><%=e.getEname() %></td>
<td><%=e.getSalary() %></td>
<td><%=e.getDept()%></td>
</tr>
<%} %>
</table>
</body>
</html>