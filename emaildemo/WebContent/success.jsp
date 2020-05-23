<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
       <%@ page import="com.student" %>
        <%@ page import="java.util.List" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
<script type="text/javascript">
function del()
{
	alert("Hii");
	document.myform.action="delete";
	document.myform.submit();
	
	}
	
function edit()
{
	alert("Hii");
	document.myform.action="edit";
	document.myform.submit();
	
	}


</script>

</head>
<body>
<form name="myform">
<table border="2">
<tr>
<th>select</th>

<th>name</th>
<th>email</th>
<th>uname</th>
<th>pass</th>
</tr>
   <% List <student> l=(List <student>)request.getAttribute("data");%>
<% for(student s:l) {%>
<tr>
<td><input type="radio" name="rno" value="<%=s.getRno() %>"></td>

<td><%=s.getName() %></td>
<td><%=s.getEmail() %></td>
<td><%=s.getUname() %></td>
<td><%=s.getPass() %></td>
<% }%>
</tr>
</table>
<input type="button" value="delete" onclick="del()">
<input type="button" value="edit" onclick="edit()">
</body>
</html>
 