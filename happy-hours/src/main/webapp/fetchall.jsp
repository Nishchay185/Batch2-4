<%@page import="java.util.List" %>
<%@page import="dto.Sign_in_dto" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<table border="1" style="border-color:red;">
<tr>
<th>First_name</th>
<th>Last_name</th>
<th>Email</th>
<th>Contact_no</th>
<th>password1</th>
<th>conform_password</th>
<th>Above_18</th>
<th>Action</th>
</tr>
<%List<Sign_in_dto>pist=(List<Sign_in_dto>)request.getAttribute("data"); %>
<%for(Sign_in_dto mind:pist){ %>
<tr>
<td><%=mind.getFirst_name()%></td>
<td><%=mind.getLast_name() %></td>
<td ><%=mind.getEmail() %></td>
<td><%=mind.getContact_no()%></td>
<td><%=mind.getPassword1()%></td>
<td><%=mind.getconform_password()%></td>
<td><%=mind.getAbove_18()%></td>
<td><pre> <a href="selectUpdate.jsp?Email=<%=mind.getEmail() %>"><button type="button" class="button1">Update</button></a>
  <a href="delete?Email=<%=mind.getEmail() %>">Delete</a></pre></td>
  

</tr>
<% }%>


</table>
</body>
</html>