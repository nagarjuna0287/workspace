<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ page import="java.io.*,java.util.*,java.sql.*"%>  
<%@ page import="javax.servlet.http.*,javax.servlet.*" %>  
 <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %> 
 <%@ taglib uri="http://java.sun.com/jsp/jstl/sql" prefix="sql" %>  
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<sql:setDataSource var="db" driver="oracle.jdbc.driver.OracleDriver"
url="jdbc:oracle:thin:@localhost:1521:xe" user="system" password="system"/>

<sql:query  dataSource="${db}" var="rs">
select * from student
</sql:query>
<table border="2" width="100">
<tr>
<th>Name</th>
<th>Sid</th>
<th>Marks</th>
<th>Attendence</th>
</tr>
<c:forEach var="table" items="${rs.rows}">
<tr>
<td><c:out value="${table.name}"/></td>
<td><c:out value="${table.sid}"></c:out></td>
<td><c:out value="${table.marks}"></c:out></td>
<td><c:out value="${table.attendence}"></c:out></td>
</tr>
</c:forEach>
</table>
</body>
</html>