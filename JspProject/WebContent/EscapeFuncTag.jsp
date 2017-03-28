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
<p>with EscapeXml </p>
<c:set var="string1" value="This is First String"/>
<c:set var="string2" value="This is<abc> Second String<abc>" />
String1:${fn:escapeXml(string1)}<br/>
String2:${fn:escapeXml(string2)}
<p>Without EscapeXml </p>
String1: ${string1}<br/>
String2: ${string2}<br/>
<c:set var="place" value="It is first String."/> 
Index:${fn:indexOf(place,"first")}
</body>
</html>