<%@page import="com.Employee.entity.EmployeeDetails"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<center>
<h1>All Employee Details</h1>
<%
List<EmployeeDetails> list=(List<EmployeeDetails>)request.getAttribute("listofemployeedetails");
%>
		<table>
		<tr>
				<th>Name</th>&nbsp;
				<th>Emailid</th>&nbsp;
				<th>salary</th>&nbsp;
				<th>Deptno</th>&nbsp;
		</tr>		
		<% for(EmployeeDetails details:list){ %>
				<tr style="justify-content: space-between;">
                <td><%=details.getName()%></td>&nbsp;&nbsp;
                <td><%=details.getEmailid()%></td>&nbsp;&nbsp;
                <td><%=details.getSalary()%></td>&nbsp;&nbsp;
                <td><%=details.getDeptno()%></td>&nbsp;&nbsp;
                <td>
                <form action="deletebyid">
                <td><input type="text" value=<%=details.getId() %> name="empid"></td>
                <td><input type="submit" value="DELETE" ></td>
                </form></td>
                <td><input type="submit"  value="UPDATE"></td>
            </tr>
            <%
                }
            %>
				
		<% %>
		</table>
</center>
</body>
</html>