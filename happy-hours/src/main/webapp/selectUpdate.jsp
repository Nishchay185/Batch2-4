<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Update Email</title>
</head>
<body>
<form action="UpdateData" method="post">
<table border="1px">
<tr>
<%
/* String Email = request.getParameter("Email");
out.println("Present ID: " + Email); */
String email = request.getParameter("Email");
out.println("ID: " + email);
session.setAttribute("Email", email);
%>
<td><input type="text" name="Fname" ></td>
<%-- <td><a href="UpdateData?Email=<%=Email%>&newEmail=<%=request.getParameter("newEmail")%>" method="post">Update email Id</a></td> --%>
</tr>
<tr>
<td><button type="submit">Submit</button></td>
</tr>
</table>
</form>
</body>
</html>
