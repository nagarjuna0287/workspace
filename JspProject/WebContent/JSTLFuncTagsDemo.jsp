<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>  
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>  
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<c:set var="name" value="Welcome to JAVATPOINT Programming"/>
<c:if test="${fn:contains(name,'point')}">
Found JavaTpoint<br/>
</c:if>
<c:if test="${fn:contains(name,'JAVATPOINT') }">
FOUND JAVATPOINT<br/>
</c:if>
<c:if test="${fn:endsWith(name,'Programming') }">
	Ends With Programing
</c:if>

</body>
</html>