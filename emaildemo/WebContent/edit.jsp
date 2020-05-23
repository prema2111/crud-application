<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ page import="com.student" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<form action="update">
<pre>

<% student s=(student)request.getAttribute("student");%>
<input type="hidden" name="rno" value="<%=s.getRno() %>">
Name<input type="text" name="name" value="<%=s.getName() %>">

email<input type="text" name="email" value="<%=s.getEmail() %>">

Username<input type="text" name="uname" value="<%=s.getUname() %>">

Password:-<input type="text" name="pass" value="<%=s.getPass() %>">

<input type="submit" value="update" >
</pre>
</form>
</body>
</html>