<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<%!int data=20;
int triangle(int l,int b,int h){
	return l*b*h;
}%>
<%= "Welcome To The World Of Happiness:"+data %>
<br></br>
<%="Area of the Triangle is:"+triangle(5,6,4) %>
<br></br>
<% String name=request.getParameter("uname");
out.print("Mr."+name); %>
<br></br>
<%="Your Password is:"+request.getParameter("pwd") %>
Welcome, ${param.name}
</body>
</html>